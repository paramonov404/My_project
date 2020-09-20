package PR_3_Java;

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