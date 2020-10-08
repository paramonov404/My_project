import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Company company = new Company();
        Random r = new Random();

        for (int i = 0; i < 30; i++) {
            company.hire(new Employee(
                    Integer.toString(i) + "_Jhon",
                    "Snow",
                    "BlackCastle",
                    "8910" + Integer.toString(1000000 + r.nextInt(8999999)),
                    LocalDate.of(2020 - r.nextInt(50),
                            12 - r.nextInt(11), 28 - r.nextInt(27)),
                    30_000 + r.nextInt(30_000)));
        }

        for (int i = 0; i < 30; i++) {
            System.out.println(company.employees.get(i).toString());
        }

        System.out.println();

        company.doSomethingWithEmployee(
                new DateSelector(LocalDate.of(1990, 01, 01),
                        LocalDate.of(2000, 12, 30)),
                (employee, index) -> System.out.println(employee.toString()));


        double salary = 40000;
        company.doSomethingWithEmployee(new EmployeeSelector() {
            @Override
            public boolean selectEmployee(Employee employee) {
                return employee.getSalary() > salary;
            }
        }, new EmployeeHandler() {
            @Override
            public void handleEmployees(Employee employee, int index) {
                System.out.println(employee.toString());
            }
        });

        ArrayList<Employee> selectedDate = new ArrayList<>();
        company.doSomethingWithEmployee(
                employee -> employee.getDate().getMonthValue() == 7,
                ((employee, index) -> selectedDate.add(employee))
        );
        System.out.println(selectedDate);
    }
}