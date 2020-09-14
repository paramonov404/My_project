package PR_2_Java;

public class Dog {
    private String name;
    private int age;

public Dog(String name,int age){
    this.name = name;
    this.age = age;
}

public int toHumanAge(){
    return this.age * 7;
}

public String toString(){
    return "Dog name is " + getName() + " and It's " + getAge() + " years old (" + toHumanAge() + " human years).";
}

public void setName(){
    this.name = name;
}

public void setAge(){
    this.age = age;
}

public String getName() {
    return name;
}

public int getAge() {
    return age;
}

    public static void main(String[] args) {

    }
}
