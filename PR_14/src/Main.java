import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static ArrayList<Matcher> matchers = new ArrayList<>();
    private static int N;
    private static String oldStr;
    private static String newStr = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?<old>\\w+) (?<new>\\w+)");
        N = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < N; i++) {
            matchers.add(pattern.matcher(scanner.nextLine()));
        }
        oldStr = scanner.nextLine();
        handle(oldStr);
        System.out.println(newStr);
    }

    private static void handle(String str) {
        boolean bool = true;
        for (int i = 0; i < N; i++) {
            matchers.get(i).find();
        }

        while (bool) {
            boolean rep = true;
            for (int i = 0; i < N; i++) {
                boolean eq = oldStr.startsWith(matchers.get(i).group("old"));
                if (eq) {
                    newStr = newStr + matchers.get(i).group("new");
                    oldStr = oldStr.replaceFirst(matchers.get(i).group("old"), "");
                    rep = false;
                }
            }
            if (rep && !oldStr.isEmpty()) {
                newStr = newStr + oldStr.charAt(0);
                oldStr = oldStr.replaceFirst(Character.toString(oldStr.charAt(0)), "");
            }
            if (oldStr.isEmpty()) {
                bool = false;
            }
        }
    }
}