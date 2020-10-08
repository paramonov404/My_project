import java.util.ArrayList;
import java.util.List;

public class Company {
    ArrayList<Employee> employees = new ArrayList<Employee>();

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hairAll(Employee... args) {
        for (int i = 0; i < args.length; i++) {
            hire(args[i]);
        }
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public void fireOnPercent(int percent) {

        int fireCount = (employees.size() * percent) / 100;

        for (int i = 0; i < fireCount; i++) {
            this.fire(employees.get(0));
        }
        System.out.println("Уволено " + percent + " % сотрудников.");
    }

    public void doSomethingWithEmployee(EmployeeSelector selector , EmployeeHandler handler){
        int count = 0;
        for (Employee employee : employees){
            if (selector.selectEmployee(employee)){
                handler.handleEmployees(employee, count);
                count++;
            }
        }
        System.out.println(count);
        System.out.println();
    }

    @Override
    public String toString() {
        return "Company{" +
                "employees=" + employees +
                '}';
    }
}

