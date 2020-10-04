public class TopManager implements EmployeePosition {

    Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public double calcSalary(double baseSalary) {
        if (company.getIncome() > 10000000)
            return baseSalary * 2.5;
        else
            return baseSalary;
    }

    @Override
    public String getJobTitle() {
        return "TopManager";
    }
}
