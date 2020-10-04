
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Company {

    double companyIncome;
    ArrayList<Employee> managers = new ArrayList<Employee>(80);
    ArrayList<Employee> topManagers = new ArrayList<Employee>(10);
    ArrayList<Employee> operators = new ArrayList<Employee>(180);
    ArrayList<Employee> employees = new ArrayList<Employee>(270);

    public double getIncome() {
        return companyIncome;
    }

    public void hire(Employee employee) {
        switch (employee.getPosition().getJobTitle()) {
            case "Operator":
                operators.add(employee);
                employees.add(employee);
                employee.setFullSalary(employee.getPosition().calcSalary(employee.getBaseSalary()));
                break;
            case "Manager":
                managers.add(employee);
                employees.add(employee);
                employee.setFullSalary(employee.getPosition().calcSalary(employee.getBaseSalary()));
                companyIncome += (employee.getFullSalary()-employee.getBaseSalary()) * 20;
                break;
            case "TopManager":
                topManagers.add(employee);
                employees.add(employee);
                employee.setFullSalary(employee.getPosition().calcSalary(employee.getBaseSalary()));
                break;
        }
    }

    public void hairAll(Employee... args) {
        for (int i = 0; i < args.length; i++) {
            hire(args[i]);
        }
    }

    public void fire(Employee employee) {
        switch (employee.getPosition().getJobTitle()) {
            case "Operator":
                operators.remove(employee);
                employees.remove(employee);
                break;
            case "Manager":
                managers.remove(employee);
                employees.remove(employee);
                break;
            case "TopManager":
                topManagers.remove(employee);
                employees.remove(employee);
                companyIncome -= employee.getFullSalary();
                break;
        }
    }

    public void fireOnPercent(int percent) {

        int fireCount = (operators.size() * percent) / 100;
        for (int i = 0; i < fireCount; i++) {
            this.fire(operators.get(0));
        }

        fireCount = (managers.size() * percent) / 100;
        for (int i = 0; i < fireCount; i++) {
            this.fire(managers.get(0));
        }

        fireCount = (topManagers.size() * percent) / 100;
        for (int i = 0; i < fireCount; i++) {
            this.fire(topManagers.get(0));
        }
        System.out.println("Уволено " + percent + " % сотрудников.");
    }

    public List<Employee> getTopSalaryStaff(int count) {
        if (count > 0 && count <= employees.size()) {
            employees.sort(Comparator.comparing(Employee::getFullSalary).reversed());
            return employees.subList(0, count);
        }
        else return null;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        if (count > 0 && count <= employees.size()) {
            employees.sort(Comparator.comparing(Employee::getFullSalary));
            return employees.subList(0, count);
        }
        else return null;
    }
}
