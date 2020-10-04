public class Employee {
    String surname;
    String name;
    double baseSalary;
    double fullSalary;
    EmployeePosition position;

    public Employee(String surname, String name, double baseSalary, EmployeePosition position) {
        this.surname = surname;
        this.name = name;
        this.baseSalary = baseSalary;
        this.position = position;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getFullSalary() {
        return fullSalary;
    }

    public void setFullSalary(double fullSalary) {
        this.fullSalary = fullSalary;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }

}