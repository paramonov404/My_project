package PR_3_Java;

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