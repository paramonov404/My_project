public class Employee {
    private int salary;
    private int age;
    private int workExperience; // in years

    public void addSalary(int salary) throws Exception{
        if (salary <= 0){
            throw new Exception();
        }
        this.salary += salary;
    }

    public void addAge(int age) throws IncorrectAgeException{
        if (age < 0){
            throw new IncorrectAgeException();
        }
        this.age += age;
    }

    public void addWorkExperience(int workExperience) {
        if (workExperience < 0){
            throw new NewRuntimeException();
        }
        this.workExperience += workExperience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", age=" + age +
                ", workExperience=" + workExperience +
                '}';
    }
}
