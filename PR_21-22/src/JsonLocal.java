import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonLocal implements ItemsStore{

    static File file = new File("D:\\IJ проекты\\PR_21-22\\src\\data.json");
    static FileWriter fw;
    static JsonWriter jw;
    static Gson gson = new Gson();

    @Override
    public List<Item> getAll() {
        Type type = new TypeToken<ArrayList<Item>>(){}.getType();
        List<Item> items = null;
        try(FileReader fr = new FileReader(file)) {
            items = gson.fromJson(fr,type);
        } catch (Exception e) {

        }
        return items;
    }

    @Override
    public Item get(int id)  {
        List<Item> items = getAll();
        for (Item i:items) {
            if(i.getId()==id){
                return i;
            }
        }
        return null;
    }

    @Override
    public Item addItem(Item item) {
            try
            {
                FileWriter writer = new FileWriter(file, true);
                if(item.getId() != 1) {
                    writer.write(",");
                }
                writer.write("\n"+gson.toJson(item).replace(",", ",\n    ").replace("{", "{\n    ").replace("}", "\n}"));
                writer.close();

            }
            catch (Exception e)
            {

            }
            return item;
    }


    @Override
    public Item editItem(int id, Item item) {
        if(checkId(id)&&item.getId()==id){
            deleteItem(id);
            addItem(item);
            return item;
        }
        return null;
    }

    @Override
    public void deleteItem(int id) {
        StringBuilder sb = new StringBuilder();
        int index = getAll().size();
        int count = 0;
        String line;
        Item item;
        if (checkId(id)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                line = reader.readLine();
                sb.append("[\n");
                while (line != null) {
                    if (isCorrect(line) || line.endsWith("},")) {
                        item = gson.fromJson(line.substring(line.indexOf("{"), line.indexOf("}") + 1), Item.class);
                        if (item.getId() != id) {
                            sb.append(line.substring(line.indexOf("{"), line.indexOf("}") + 1));
                            if(count<index-2){
                                sb.append(",");
                            }
                            sb.append("\n");
                            count++;
                        }
                    }
                    line = reader.readLine();
                }
                sb.append("]");
                try (PrintWriter writer = new PrintWriter(file)) {
                    writer.write(sb.toString());
                }
            } catch (Exception e) {

            }
        }
    }

    private boolean checkId(int id) {
        if (get(id) != null) {
            return true;
        }
        return false;
    }

    public boolean isCorrect(String js) {
        try {
            gson.fromJson(js, Object.class);
            return true;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }
}

