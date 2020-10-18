public class Main {
    public static void main(String[] args) {
        printWithColor("I am white", Colors.BLACK);
        printWithColor("I am black", Colors.WHITE);
        printWithColor("I am yellow", Colors.RED);
        printWithColor("I am red", Colors.YELLOW);
        printWithColor("I",Colors.WHITE);
        printWithColor("Am", Colors.BLUE);
        printWithColor("Russian", Colors.RED);
    }

    public static void printWithColor(String line, Colors color) {
        System.out.println(color.getColor() + line);
    }
}