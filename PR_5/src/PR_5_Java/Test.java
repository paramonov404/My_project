package PR_5_Java;

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
