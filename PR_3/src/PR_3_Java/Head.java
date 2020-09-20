package PR_3_Java;

public class Head {

    String hairColor;

    Head (String color){
        this.hairColor = color;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHairColor() {
        return hairColor;
    }
    public String toString(){
        return "Hair color is " + getHairColor();
    }
}
