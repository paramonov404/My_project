package PR_5_Java;

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
