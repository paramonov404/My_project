package PR_5_Java;

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