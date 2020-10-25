import java.util.ArrayList;
import java.util.Scanner;

public class Replace {
    private static ArrayList<Rule> rules = new ArrayList<>();
    private static int N;
    private static String oldStr;
    private static String newStr = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.nextLine());

        for (int i=0; i<N; i++){
            rules.add(readRule(scanner));
        }
        oldStr = scanner.nextLine();
        handle(oldStr);
        System.out.println(newStr);
    }

    private static Rule readRule(Scanner scanner){
        String line = scanner.nextLine();
        String[] strings = line.split(" ",2);
        return new Rule(strings[0],strings[1]);
    }

    private static void handle(String str){
        boolean bool = true;
        while(bool){
            boolean rep = true;
            for (int i=0; i<N; i++){
               boolean eq = oldStr.startsWith(rules.get(i).getReplaceableStr());
                if (eq){
                    newStr = newStr + rules.get(i).getReplacedStr();
                    oldStr = oldStr.replaceFirst(rules.get(i).getReplaceableStr(),"");
                    rep = false;
                }
            }
            if (rep && !oldStr.isEmpty()){
                newStr = newStr + oldStr.charAt(0);
                oldStr = oldStr.replaceFirst(Character.toString(oldStr.charAt(0)),"");
            }
            if(oldStr.isEmpty()){
                bool = false;
            }
        }
    }
}