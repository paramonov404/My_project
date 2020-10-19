public class Main {
    public static void main(String[] args) throws Exception{

Employee employee1 = new Employee();
Employee employee2 = new Employee();
try{
    employee1.addSalary(50_000);
    //employee1.addAge(-100);
    //employee2.addSalary(-50_000);
    employee2.addAge(40);

}
catch (IncorrectAgeException Ex){
    System.out.println("Too young :)");
}
catch (Exception Ex){
    System.out.println("Work for free :)");
}
finally {
    System.out.println(employee1);
    System.out.println(employee2);
}
    employee1.addWorkExperience(-10);
    }
}