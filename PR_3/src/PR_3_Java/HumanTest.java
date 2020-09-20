package PR_3_Java;

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