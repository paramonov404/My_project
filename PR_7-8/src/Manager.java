public class Manager implements EmployeePosition {

    @Override
    public double calcSalary(double baseSalary) {
        return baseSalary + (0.05 * (115000 + Math.random() * 25000));
    }

    @Override
    public String getJobTitle() {
        return "Manager";
    }
}
