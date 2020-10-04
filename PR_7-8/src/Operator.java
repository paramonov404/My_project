public class Operator implements EmployeePosition {

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary;
    }

    @Override
    public String getJobTitle() {
        return "Operator";
    }
}
