import java.io.IOException;
import java.util.List;

public interface ItemsStore {
    List<Item> getAll();
    Item get(int id);
    Item addItem(Item item);
    Item editItem(int id,Item item);
    void deleteItem(int id);
}
