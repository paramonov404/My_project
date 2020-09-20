package PR_3_Java;

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
