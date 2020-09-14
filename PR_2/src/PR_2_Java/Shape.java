package PR_2_Java;

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
