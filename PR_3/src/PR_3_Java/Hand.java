package PR_3_Java;

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
