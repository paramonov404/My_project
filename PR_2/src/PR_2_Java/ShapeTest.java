package PR_2_Java;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.setType("Triangle");
        shape.setCorners(3);
        System.out.println(shape.toString()); ;
    }
}
