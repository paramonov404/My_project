#DOP_1
###Change.java
```java
public class Change {
    public int search(int x, int y) {
        if (x == 0)
            return 1;
        if (x < 0)
            return 0;
        if (y == 5)
            return search(x - 5, 5) + search(x - 3, 3) + search(x - 1, 1);
        if (y == 3)
            return search(x - 3, 3) + search(x - 1, 1);
        if (y == 1)
            return search(x - 1, 1);
        return 0;
    }

    public static void main(String[] args) {
        Change change = new Change();
        System.out.println(change.search(4, 5));
    }
}
```
#PR_1
###PR_1_3.java
```java
public class PR_1_3 {
    public static void main(String[] args) {
        int [] mass = new int[] {1,2,3,4,5,6,7,8,9};
        int sum_1 = 0, sum_2 = 0, sum_3 = 0;

        for (int i=0;i<mass.length;i++){
            sum_1 += mass[i];
        }
        System.out.println(sum_1);

        int count = 0;
        while (count < mass.length){
            sum_2+=mass[count];
            count += 1;
        }
        System.out.println(sum_2);

        count = 0;
        do{
            sum_3 += mass[count];
            count += 1;

        } while (count < mass.length);
        System.out.println(sum_3);
    }
}

```
###PR_1_4.java
```java
public class PR_1_4 {
    public static void main(String[] args) {
    for (int i=0;i< args.length;i++){
        System.out.println(args[i]);
    }
    }
}
```
###PR_1_5.java
```java
public class PR_1_5 {
    public static void main(String[] args) {
    for (float i=1;i<11;i++) {
        System.out.printf("%f \n", 1 / i);
    }
    }
}
```
###PR_1_6.java
```java
import java.util.Random;
import java.util.Arrays;

public class PR_1_6 {

    public static void main(String[] args) {
    int mass[] = new int[8];

    for(int i=0;i<4;i++){
        mass[i]= (int) (Math.random()*10);
        System.out.print(mass[i]);
    }

    for(int i=4;i<8;i++){
            Random r = new Random();
            mass[i]= r.nextInt(11);
            System.out.print(mass[i]);
    }
        System.out.println();
    Arrays.sort(mass);
        for(int i=0;i<8;i++){
            System.out.print(mass[i]);
        }
    }

}
```
###PR_1_7.java
```java
public class PR_1_7 {

    public static void main(String[] args) {
        fact(4);
    }
    public static void fact(int x){
        long sum = 1;
        for (int i=1;i<=x;i++){
            sum *= i;
        }
        System.out.println(sum);
    }
}
```
#PR_10
###Main.java
```java
public class Main {
    public static void main(String[] args) {
        new SwingApp();
    }
}
```
###SwingApp.java
```java
import javax.swing.*;
import java.awt.*;

public class SwingApp extends JFrame {
    double value1;
    double value2;
    double result;

    public SwingApp() {
        setTitle("The best calculator ever!");

        JLabel resOut = new JLabel();

        JPanel p2 = new JPanel(new GridLayout(3, 2));
        p2.setBounds(85, 40, 260, 110);
        p2.setPreferredSize(new Dimension(150, 60));

        JTextField tf1 = new JTextField("");
        tf1.addCaretListener(action -> {
            try {
                value1 = Double.parseDouble(tf1.getText());
            } catch (Exception ex) {
                resOut.setText(ex.getMessage());
            }
        });
        tf1.setPreferredSize(new Dimension(150, 30));

        JTextField tf2 = new JTextField("");
        tf2.addCaretListener(action -> {;
        try {
            value2 = Double.parseDouble(tf2.getText());
        } catch (Exception ex) {
            resOut.setText(ex.getMessage());
        }
    });
        tf2.setPreferredSize(new Dimension(150, 30));

        p2.add(new JLabel("1-е число")); p2.add(tf1);
        p2.add(new JLabel("2-е число")); p2.add(tf2);
        p2.add(new JLabel("Результат")); p2.add(resOut);
        add(p2);

        JPanel p1 = new JPanel(new FlowLayout());
        p1.setBounds(-6, 200, 440, 110);
        p1.setPreferredSize(new Dimension(440, 110));
        JButton b1 = new JButton("+");
        b1.addActionListener(action -> {
           result = value1 + value2;
           resOut.setText(String.format("%.4f",result));
        });
        b1.setPreferredSize(new Dimension(100, 100));
        JButton b2 = new JButton("-");
        b2.addActionListener(action -> {
            result = value1 - value2;
            resOut.setText(String.format("%.4f",result));
        });
        b2.setPreferredSize(new Dimension(100, 100));
        JButton b3 = new JButton("/");
        b3.addActionListener(action -> {
            result = value1 / value2;
            resOut.setText(String.format("%.4f",result));
        });
        b3.setPreferredSize(new Dimension(100, 100));
        JButton b4 = new JButton("*");
        b4.addActionListener(action -> {
            result = value1 * value2;
            resOut.setText(String.format("%.4f",result));
        });
        b4.setPreferredSize(new Dimension(100, 100));
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        add(p1);

        setSize(440, 350);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
```
#PR_11
###Flow.java
```java
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Flow {
    static AtomicInteger totalSum = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        long startTime1 = System.currentTimeMillis();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i=0;i<10;i++){
            work(i);
        }

        long endTime1 = System.currentTimeMillis();
        System.out.println("total time: " + (endTime1 - startTime1));
        System.out.println("total sum: " + totalSum.get());

        ///////////////////////////////////////////////////////////////////////////////////////////

        long startTime2 = System.currentTimeMillis();

        for (int i = 0; i < 10; i++){
            final int localI = i;
            Thread thread = new Thread(() -> work(localI));
            thread.start();
            threads.add(thread);
        }

        for (Thread t : threads) {
            t.join();
        }

        long endTime2 = System.currentTimeMillis();
        System.out.println("total time: " + (endTime2 - startTime2));
        System.out.println("total sum: " + totalSum.get());
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

    private static void work(int i) {
        long startTime = System.currentTimeMillis();
        long result = doHardWork(i * 1000, 100_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ": " + result + " | " + (endTime-startTime));
    }

    private static long doHardWork(int start, int count) {
        long a = 0;
        for (int i = 0; i < count; i++) {
            a += (start + i) * (start + i) * Math.sqrt(start + i);
            totalSum.getAndIncrement();
        }
        return a;
    }
}
```
#PR_12
###Colors.java
```java
public enum Colors {
    BLUE("\u001B[34m"),
    WHITE("\u001B[30m"),
    YELLOW("\u001B[33m"),
    BLACK("\u001B[37m"),
    RED("\u001B[31m");

    private final String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
```
###Main.java
```java
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
```
#PR_13
###Employee.java
```java
public class Employee {
    private int salary;
    private int age;
    private int workExperience; // in years

    public void addSalary(int salary) throws Exception{
        if (salary <= 0){
            throw new Exception();
        }
        this.salary += salary;
    }

    public void addAge(int age) throws IncorrectAgeException{
        if (age < 0){
            throw new IncorrectAgeException();
        }
        this.age += age;
    }

    public void addWorkExperience(int workExperience) {
        if (workExperience < 0){
            throw new NewRuntimeException();
        }
        this.workExperience += workExperience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", age=" + age +
                ", workExperience=" + workExperience +
                '}';
    }
}
```
###IncorrectAgeException.java
```java
public class IncorrectAgeException extends IllegalArgumentException {

}
```
###Main.java
```java
public class Main {
    public static void main(String[] args) throws Exception{

Employee employee1 = new Employee();
Employee employee2 = new Employee();
try{
    employee1.addSalary(50_000);
    //employee1.addAge(-100);
    //employee2.addSalary(-50_000);
    employee2.addAge(40);

}
catch (IncorrectAgeException Ex){
    System.out.println("Too young :)");
}
catch (Exception Ex){
    System.out.println("Work for free :)");
}
finally {
    System.out.println(employee1);
    System.out.println(employee2);
}
    employee1.addWorkExperience(-10);
    }
}
```
###NewRuntimeException.java
```java
public class NewRuntimeException extends RuntimeException {
}
```
#PR_14
###Main.java
```java
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
```
###Replace.java
```java
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
```
###Rule.java
```java
public class Rule {
    private String replaceableStr;
    private String replacedStr;

    public Rule(String replaceableStr, String replacedStr) {
        this.replaceableStr = replaceableStr;
        this.replacedStr = replacedStr;
    }

    public String getReplaceableStr() {
        return replaceableStr;
    }

    public void setReplaceableStr(String replaceableStr) {
        this.replaceableStr = replaceableStr;
    }

    public String getReplacedStr() {
        return replacedStr;
    }

    public void setReplacedStr(String replacedStr) {
        this.replacedStr = replacedStr;
    }
}
```
#PR_15-16
###Main.java
```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList <Main> Nodes = new ArrayList<>(5);
    String name;
    ArrayList <Object[]> Commands = new ArrayList<>();

    public Main(String name) {
        this.name = name;
    }

    public void setCommand(Object[] command) {
        this.Commands.add(command);
    }

    public static void main(String[] args) {

    Main S1 = new Main("S1");
    S1.setCommand(S1.createCommand("create_project",0,2));
    S1.setCommand(S1.createCommand("add_library",1,5));
    Nodes.add(S1);

    Main S2 = new Main("S2");
    S2.setCommand(S2.createCommand("test",0,3));
    S2.setCommand(S2.createCommand("drop_db",1,4));
    Nodes.add(S2);

    Main S3 = new Main("S3");
    S3.setCommand(S3.createCommand("drop_db",0,4));
    S3.setCommand(S3.createCommand("add_library",1,5));
    Nodes.add(S3);

    Main S4 = new Main("S4");
    S4.setCommand(S4.createCommand("restart",0,3));
    S4.setCommand(S4.createCommand("deploy",1,5));
    Nodes.add(S4);

    Main S5 = new Main("S5");
    S5.setCommand(S5.createCommand("deploy",0,1));
    S5.setCommand(S5.createCommand("restart",1,3));
    Nodes.add(S5);

    S1.makeCommand();
    }

    public Object[] createCommand(String commandName,int rule,int index){
    Object[] command = new Object[3];
    command[0] = commandName;
    command[1] = rule;
    command[2] = index;
    return command;
    }

    public void makeCommand(){
        Scanner scan = new Scanner(System.in);
        int rule = scan.nextInt();
        if (rule == 0 || rule == 1){
            System.out.println((String) this.Commands.get(rule)[0]);
            Nodes.get((Integer) this.Commands.get(rule)[2]-1).makeCommand();
        }
    }
}
```
#PR_17-18
###MyFileVisitor.java
```java
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class MyFileVisitor extends SimpleFileVisitor<Path> {
    PrintWriter writer;

    public MyFileVisitor(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (dir.getFileName().equals(Paths.get("D:\\IJ проекты").relativize(dir))) {
            writer.write("#" + dir.getFileName() + "\n");
        }
        return super.preVisitDirectory(dir, attrs);
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(file.toString().endsWith(".java")){
            writer.write("###" + file.getFileName() + "\n");
            writer.write("```java\n");
            List<String> lines = Files.readAllLines(file);
            for (String s : lines){
            writer.write(s);
            writer.write("\n");
            writer.flush();
            }
            writer.write("```\n");
        }
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("D:\\IJ проекты"),
                new MyFileVisitor(new PrintWriter("D:\\IJ проекты\\PR_17-18\\result.md")));
    }
}
```
#PR_2
###Ball.java
```java
public class Ball {
    private float weight = 5;
}
```
###Book.java
```java
public class Book {
    private int pages = 228;
}
```
###Dog.java
```java
public class Dog {
    private String name;
    private int age;

public Dog(String name,int age){
    this.name = name;
    this.age = age;
}

public int toHumanAge(){
    return this.age * 7;
}

public String toString(){
    return "Dog name is " + getName() + " and It's " + getAge() + " years old (" + toHumanAge() + " human years).";
}

public void setName(){
    this.name = name;
}

public void setAge(){
    this.age = age;
}

public String getName() {
    return name;
}

public int getAge() {
    return age;
}

    public static void main(String[] args) {

    }
}
```
###KennelDogs.java
```java
public class KennelDogs {
 private Dog mass[] = new Dog[10];

public void addDog(Dog ... args){
    for (int i=0;i < args.length;i++){
        mass[i] = args[i];
    }
}

    public static void main(String[] args) {
KennelDogs kennel = new KennelDogs();
Dog dog_1 = new Dog("Vasya",5);
Dog dog_2 = new Dog("Petya",4);
Dog dog_3 = new Dog("Vova",7);

kennel.addDog(dog_1,dog_2,dog_3);

    }
}
```
###Shape.java
```java
public class Shape {
private String type;
private int corners;

public String toString(){
    return "Shape type is " + getType() + " and It's have " + getCorners() + " corners." ;
}

public void setType(String type){
    this.type = type;
}

public void setCorners(int corners){
    this.corners = corners;
}

public String getType() {
    return type;
}

public int getCorners(){
    return corners;
}

    public static void main(String[] args) {

    }
}
```
###ShapeTest.java
```java
public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.setType("Triangle");
        shape.setCorners(3);
        System.out.println(shape.toString()); ;
    }
}
```
#PR_3
###Book.java
```java
public class Book {
    private String author;
    private String name;
    private int yearOfWriting;

    public String toString(){
        return "Book " + getName() + " was writing by "
                + getAuthor() + " in " + getYearOfWriting() + " year.";

    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfWriting(int yearOfWriting) {
        this.yearOfWriting = yearOfWriting;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getYearOfWriting() {
        return yearOfWriting;
    }
}
```
###BookTest.java
```java
public class BookTest {
    public static void main(String[] args) {
        Book book = new Book();
        book.setName("What");
        book.setAuthor("Who");
        book.setYearOfWriting(2020);
        System.out.println(book.toString());
    }
}
```
###Circle.java
```java
public class Circle {
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public String toString(){
        return "This circle radius is " + getRadius();
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

}
```
###CircleTest.java
```java
public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle(3.14);
        System.out.println(circle.toString());
    }
}
```
###Hand.java
```java
public class Hand {
    int fingers;
    double length;

    public Hand(int fingers, double length) {
        this.fingers = fingers;
        this.length = length;
    }

    public int getFingers() {
        return fingers;
    }

    public void setFingers(int fingers) {
        this.fingers = fingers;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String toString(){
        return "This hand has " + getFingers() + " fingers and this length is " + getLength();
    }
}
```
###Head.java
```java
public class Head {

    String hairColor;

    Head (String color){
        this.hairColor = color;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHairColor() {
        return hairColor;
    }
    public String toString(){
        return "Hair color is " + getHairColor();
    }
}
```
###Human.java
```java
public class Human {
    String name;
    Head head;
    Hand rightHand;
    Hand leftHand;
    Leg rightLeg;
    Leg leftLeg;

    public Human(String name, Hand leftHand, Hand rightHand, Head head, Leg leftLeg, Leg rightLeg) {
        this.name = name;
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.head = head;
        this.leftLeg = leftLeg;
        this.rightLeg = rightLeg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(Hand leftHand) {
        this.leftHand = leftHand;
    }

    public Hand getRightHand() {
        return rightHand;
    }

    public void setRightHand(Hand rightHand) {
        this.rightHand = rightHand;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Leg getLeftLeg() {
        return leftLeg;
    }

    public void setLeftLeg(Leg leftLeg) {
        this.leftLeg = leftLeg;
    }

    public Leg getRightLeg() {
        return rightLeg;
    }

    public void setRightL(Leg rightLeg) {
        this.rightLeg = rightLeg;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", head=" + head +
                ", rightHand=" + rightHand +
                ", leftHand=" + leftHand +
                ", rightLeg=" + rightLeg +
                ", leftLeg=" + leftLeg +
                '}';
    }
}
```
###HumanTest.java
```java
public class HumanTest {
    public static void main(String[] args) {
        Hand leftHand = new Hand(5,2);
        Hand rightHand = new Hand(6,3);
        Head head = new Head("Blue");
        Leg leftLeg = new Leg(8,1);
        Leg rightLeg = new Leg(10,3);
        Human oleg = new Human("Oleg", leftHand, rightHand, head, leftLeg, rightLeg);
        System.out.println(oleg.toString());
    }
}
```
###Leg.java
```java
public class Leg {
    int fingers;
    double length;

    public Leg(int fingers, double length) {
        this.length = length;
        this.fingers = fingers;
    }

    public int getFingers() {
        return fingers;
    }

    public void setFingers(int fingers) {
        this.fingers = fingers;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String toString(){
        return "This leg has " + getFingers() + " fingers and this length is " + getLength();
    }
}
```
#PR_4
###Circle.java
```java
public class Circle extends Shape {
    protected double radius;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
###Rectangle.java
```java
public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle() {

    }

    public Rectangle(double width, double length) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
###Shape.java
```java
public abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {

    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    abstract public double getArea();
    abstract public double getPerimeter();
    abstract public String toString();
}
```
###ShapeTest.java
```java
public class ShapeTest {
    public static void main(String[] args) {
        Shape s1 = new Circle(7.4, "Blue", true);
        System.out.println(s1);
        System.out.println(s1.getArea());
        System.out.println(s1.getPerimeter());
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());

        Shape s3 = new Rectangle(2.0, 4.0, "GREEN", false);
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());

        Shape s4 = new Square(8.3);
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        
    }
}
```
###Square.java
```java
public class Square extends Rectangle {

    public Square() {

    }

    public Square(double side) {
        super(side,side);
    }

    public Square(double side, String color, boolean filled) {
        super(side,side,color,filled);
    }

    public double getSide() {
        return width;
    }

    public void setSide(double side) {
        width = side;
        length = side;
    }

    public void setWidth(double side) {
        this.width = side;
    }

    public void setLength(double side) {
        this.length = side;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
```
#PR_5
###Circle.java
```java
public class Circle extends Shape {
    protected double radius;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
###Movable.java
```java
public interface Movable {
    public void moveUp();
    public void moveDown();
    public void moveLeft();
    public void moveRight();
}
```
###MovableCircle.java
```java
public class MovableCircle extends Circle implements Movable {

    int radius;
    MovablePoint center;

    public MovableCircle(int radius, MovablePoint center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }

    @Override
    public void moveDown() {
        this.center.moveDown();
    }

    @Override
    public void moveUp() {
        this.center.moveUp();
    }

    @Override
    public void moveLeft() {
        this.center.moveLeft();
    }

    @Override
    public void moveRight() {
        this.center.moveRight();
    }
}
```
###MovablePoint.java
```java
public class MovablePoint {
    int x;
    int y;
    int x_speed;
    int y_speed;

    public MovablePoint(int x, int y, int x_speed, int y_speed) {
        this.x = x;
        this.y = y;
        this.x_speed = x_speed;
        this.y_speed = y_speed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + x +
                ", y=" + y +
                ", x_speed=" + x_speed +
                ", y_speed=" + y_speed +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX_speed() {
        return x_speed;
    }

    public void setX_speed(int x_speed) {
        this.x_speed = x_speed;
    }

    public int getY_speed() {
        return y_speed;
    }

    public void setY_speed(int y_speed) {
        this.y_speed = y_speed;
    }

    public void moveUp() {
        this.y += this.y_speed;
    }

    public void moveDown() {
        this.y -= this.y_speed;
    }

    public void moveLeft() {
        this.x -= this.x_speed;
    }

    public void moveRight() {
        this.x += this.x_speed;
    }
}
```
###MovableRectangle.java
```java
public class MovableRectangle extends Rectangle implements Movable {
    MovablePoint leftUp;
    MovablePoint rightDown;

    public MovableRectangle(int x_1, int y_1, int x_2, int y_2, int x_speed, int y_speed) {
        this.leftUp = new MovablePoint(x_1, y_1, x_speed,y_speed);
        this.rightDown = new MovablePoint(x_2, y_2,x_speed, y_speed);
    }

    @Override
    public String toString() {
        return "MovableRectangle{" +
                "leftUp=" + leftUp +
                ", rightDown=" + rightDown +
                ", width=" + getWidth() +
                ", length=" + getLength() +
                ", color='" + getColor() + '\'' +
                ", filled=" + isFilled() +
                '}';
    }

    private boolean speedTest() {
        return ((leftUp.getX_speed() == rightDown.getX_speed()) && (leftUp.getY_speed() == rightDown.getY_speed()));
    }

    public void moveUp() {
        if (speedTest()) {
            leftUp.moveUp();
            rightDown.moveUp();
        }
    }

    public void moveDown() {
        if (speedTest()) {
            leftUp.moveDown();
            rightDown.moveDown();
        }
    }

    public void moveLeft() {
        if (speedTest()) {
            leftUp.moveLeft();
            rightDown.moveLeft();
        }
    }

    public void moveRight() {
        if (speedTest()) {
            leftUp.moveRight();
            rightDown.moveRight();
        }
    }
}
```
###Rectangle.java
```java
public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle() {

    }

    public Rectangle(double width, double length) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
```
###Shape.java
```java
public abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {

    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    abstract public double getArea();
    abstract public double getPerimeter();
    abstract public String toString();
}
```
###ShapeTest.java
```java
public class ShapeTest {
    public static void main(String[] args) {
        Shape s1 = new Circle(7.4, "Blue", true);
        System.out.println(s1);
        System.out.println(s1.getArea());
        System.out.println(s1.getPerimeter());
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());

        Shape s3 = new Rectangle(2.0, 4.0, "GREEN", false);
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());

        Shape s4 = new Square(8.3);
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        
    }
}
```
###Square.java
```java
public class Square extends Rectangle {

    public Square() {

    }

    public Square(double side) {
        super(side,side);
    }

    public Square(double side, String color, boolean filled) {
        super(side,side,color,filled);
    }

    public double getSide() {
        return width;
    }

    public void setSide(double side) {
        width = side;
        length = side;
    }

    public void setWidth(double side) {
        this.width = side;
    }

    public void setLength(double side) {
        this.length = side;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
```
###Test.java
```java
public class Test {
    public static void main(String[] args) {
        MovableRectangle rec = new MovableRectangle(0,0,4,8,2,2);
        System.out.println(rec);
        rec.moveUp();
        rec.moveRight();
        rec.moveRight();
        System.out.println(rec);
    }
}
```
#PR_6
###Matrix.java
```java

public class Matrix {
    int size;
    int[][] matrix;
    int[][] sumMatrix;

    Matrix(int size) {
        this.size = size;
        this.matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = -10 + ((int) (Math.random() * 20));
            }
        }
    }

    public void matrixOutput(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
                if (j == size-1){
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

    public void sum() {
        sumMatrix = new int[size][size];
        sumMatrix[0][0] = matrix[0][0];

        for (int j = 1; j < size; j++) {
            sumMatrix[0][j] = sumMatrix[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < size; i++) {
            sumMatrix[i][0] = sumMatrix[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                sumMatrix[i][j] = Math.max(sumMatrix[i - 1][j], sumMatrix[i][j - 1]) + matrix[i][j];
            }
        }
    }

    public void matrixSumOutput(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(sumMatrix[i][j]);
                System.out.print(" ");
                if (j == size-1){
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

    public void Result() {
        System.out.println(sumMatrix[size-1][size-1]);
    }
}
```
###Test.java
```java
public class Test {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(3);
        matrix.matrixOutput();
        matrix.sum();
        matrix.matrixSumOutput();
        matrix.Result();
    }
}
```
#PR_7-8
###Company.java
```java

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Company {

    double companyIncome;
    ArrayList<Employee> managers = new ArrayList<Employee>(80);
    ArrayList<Employee> topManagers = new ArrayList<Employee>(10);
    ArrayList<Employee> operators = new ArrayList<Employee>(180);
    ArrayList<Employee> employees = new ArrayList<Employee>(270);

    public double getIncome() {
        return companyIncome;
    }

    public void hire(Employee employee) {
        switch (employee.getPosition().getJobTitle()) {
            case "Operator":
                operators.add(employee);
                employees.add(employee);
                employee.setFullSalary(employee.getPosition().calcSalary(employee.getBaseSalary()));
                break;
            case "Manager":
                managers.add(employee);
                employees.add(employee);
                employee.setFullSalary(employee.getPosition().calcSalary(employee.getBaseSalary()));
                companyIncome += (employee.getFullSalary()-employee.getBaseSalary()) * 20;
                break;
            case "TopManager":
                topManagers.add(employee);
                employees.add(employee);
                employee.setFullSalary(employee.getPosition().calcSalary(employee.getBaseSalary()));
                break;
        }
    }

    public void hairAll(Employee... args) {
        for (int i = 0; i < args.length; i++) {
            hire(args[i]);
        }
    }

    public void fire(Employee employee) {
        switch (employee.getPosition().getJobTitle()) {
            case "Operator":
                operators.remove(employee);
                employees.remove(employee);
                break;
            case "Manager":
                managers.remove(employee);
                employees.remove(employee);
                break;
            case "TopManager":
                topManagers.remove(employee);
                employees.remove(employee);
                companyIncome -= employee.getFullSalary();
                break;
        }
    }

    public void fireOnPercent(int percent) {

        int fireCount = (operators.size() * percent) / 100;
        for (int i = 0; i < fireCount; i++) {
            this.fire(operators.get(0));
        }

        fireCount = (managers.size() * percent) / 100;
        for (int i = 0; i < fireCount; i++) {
            this.fire(managers.get(0));
        }

        fireCount = (topManagers.size() * percent) / 100;
        for (int i = 0; i < fireCount; i++) {
            this.fire(topManagers.get(0));
        }
        System.out.println("Уволено " + percent + " % сотрудников.");
    }

    public List<Employee> getTopSalaryStaff(int count) {
        if (count > 0 && count <= employees.size()) {
            employees.sort(Comparator.comparing(Employee::getFullSalary).reversed());
            return employees.subList(0, count);
        }
        else return null;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        if (count > 0 && count <= employees.size()) {
            employees.sort(Comparator.comparing(Employee::getFullSalary));
            return employees.subList(0, count);
        }
        else return null;
    }
}
```
###Employee.java
```java
public class Employee {
    String surname;
    String name;
    double baseSalary;
    double fullSalary;
    EmployeePosition position;

    public Employee(String surname, String name, double baseSalary, EmployeePosition position) {
        this.surname = surname;
        this.name = name;
        this.baseSalary = baseSalary;
        this.position = position;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getFullSalary() {
        return fullSalary;
    }

    public void setFullSalary(double fullSalary) {
        this.fullSalary = fullSalary;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }

}
```
###EmployeePosition.java
```java
public interface EmployeePosition {

public String getJobTitle();

public double calcSalary(double baseSalary);

}
```
###Manager.java
```java
public class Manager implements EmployeePosition {

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary + (0.05 * (115000 + Math.random() * 25000));
    }

    @Override
    public String getJobTitle() {
        return "Manager";
    }
}
```
###Operator.java
```java
public class Operator implements EmployeePosition {

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary;
    }

    @Override
    public String getJobTitle() {
        return "Operator";
    }
}
```
###Test.java
```java
public class Test {

    public static void main(String[] args) {

        Company company = new Company();

        for (int i = 0; i < 180; i++) {
            company.hire(new Employee("rator", "Ope", ((int) (30000 + Math.random() * 10000)), new Operator()));
            if (i < 80) {
                company.hire(new Employee("ager", "Man", ((int) (50000 + Math.random() * 15000)), new Manager()));
            }
            if (i > 169) {
                company.hire(new Employee("manager", "Top", ((int) (60000 + Math.random() * 20000)), new TopManager(company)));
            }
        }
        System.out.println("Выручка компании составила: " + (int) company.getIncome() + " рублей.");

        System.out.println("\nСамые высокие зарплаты компании: ");
        for (Employee employee : company.getTopSalaryStaff(15)) {
            System.out.println((int) employee.getFullSalary() + " руб");
        }

        System.out.println("\nСамые низкие зарплаты компании: ");
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println((int) employee.getFullSalary() + " руб");
        }

        System.out.println();
        company.fireOnPercent(50);

        System.out.println("\nСамые высокие зарплаты компании: ");
        for (Employee employee : company.getTopSalaryStaff(15)) {
            System.out.println((int) employee.getFullSalary() + " руб");
        }

        System.out.println("\nСамые низкие зарплаты компании: ");
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println((int) employee.getFullSalary() + " руб");
        }
    }
}
```
###TopManager.java
```java
public class TopManager implements EmployeePosition {

    Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public double calcSalary(double baseSalary) {
        if (company.getIncome() > 10000000)
            return baseSalary * 2.5;
        else
            return baseSalary;
    }

    @Override
    public String getJobTitle() {
        return "TopManager";
    }
}
```
#PR_9
###Company.java
```java
import java.util.ArrayList;
import java.util.List;

public class Company {
    ArrayList<Employee> employees = new ArrayList<Employee>();

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hairAll(Employee... args) {
        for (int i = 0; i < args.length; i++) {
            hire(args[i]);
        }
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public void fireOnPercent(int percent) {

        int fireCount = (employees.size() * percent) / 100;

        for (int i = 0; i < fireCount; i++) {
            this.fire(employees.get(0));
        }
        System.out.println("Уволено " + percent + " % сотрудников.");
    }

    public void doSomethingWithEmployee(EmployeeSelector selector , EmployeeHandler handler){
        int count = 0;
        for (Employee employee : employees){
            if (selector.selectEmployee(employee)){
                handler.handleEmployees(employee, count);
                count++;
            }
        }
        System.out.println(count);
        System.out.println();
    }

    @Override
    public String toString() {
        return "Company{" +
                "employees=" + employees +
                '}';
    }
}

```
###DateSelector.java
```java
import java.time.LocalDate;

public class DateSelector implements EmployeeSelector {

    LocalDate startDate;
    LocalDate endDate;

    public DateSelector(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean selectEmployee(Employee employee){
        return (employee.getDate().isAfter(startDate) && employee.getDate().isBefore(endDate));
    }
}
```
###Employee.java
```java
import java.time.LocalDate;

public class Employee {
    String name,surname,address,telephoneNumber;
    final LocalDate dateOfBirth;
    double salary;

    public Employee(String name, String surname, String address, String telephoneNumber, LocalDate year, double salary) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.dateOfBirth = year;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public LocalDate getDate() {
        return dateOfBirth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", salary=" + salary +
                '}';
    }
}
```
###EmployeeHandler.java
```java
public interface EmployeeHandler {
   void handleEmployees(Employee employee,int index);
}
```
###EmployeeSelector.java
```java
public interface EmployeeSelector {
    boolean selectEmployee(Employee employee);
}
```
###Test.java
```java
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Company company = new Company();
        Random r = new Random();

        for (int i = 0; i < 30; i++) {
            company.hire(new Employee(
                    Integer.toString(i) + "_Jhon",
                    "Snow",
                    "BlackCastle",
                    "8910" + Integer.toString(1000000 + r.nextInt(8999999)),
                    LocalDate.of(2020 - r.nextInt(50),
                            12 - r.nextInt(11), 28 - r.nextInt(27)),
                    30_000 + r.nextInt(30_000)));
        }

        for (int i = 0; i < 30; i++) {
            System.out.println(company.employees.get(i).toString());
        }

        System.out.println();

        company.doSomethingWithEmployee(
                new DateSelector(LocalDate.of(1990, 01, 01),
                        LocalDate.of(2000, 12, 30)),
                (employee, index) -> System.out.println(employee.toString()));


        double salary = 40000;
        company.doSomethingWithEmployee(new EmployeeSelector() {
            @Override
            public boolean selectEmployee(Employee employee) {
                return employee.getSalary() > salary;
            }
        }, new EmployeeHandler() {
            @Override
            public void handleEmployees(Employee employee, int index) {
                System.out.println(employee.toString());
            }
        });

        ArrayList<Employee> selectedDate = new ArrayList<>();
        company.doSomethingWithEmployee(
                employee -> employee.getDate().getMonthValue() == 7,
                ((employee, index) -> selectedDate.add(employee))
        );
        System.out.println(selectedDate);
    }
}
