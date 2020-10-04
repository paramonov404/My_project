public class Test {

    public static void main(String[] args) {

        Company company = new Company();

        for (int i = 0; i < 180; i++) {
            company.hire(new Employee("rator", "Ope", ((int) (30000 + Math.random() * 10000)), new Operator()));
            if (i < 80) {
                company.hire(new Employee("ager", "Man", ((int) (50000 + Math.random() * 15000)), new Manager()));
            }
            if (i > 169) {
                company.hire(new Employee("manager", "Top", ((int) (60000 + Math.random() * 20000)), new TopManager(company)));
            }
        }
        System.out.println("Выручка компании составила: " + (int) company.getIncome() + " рублей.");

        System.out.println("\nСамые высокие зарплаты компании: ");
        for (Employee employee : company.getTopSalaryStaff(15)) {
            System.out.println((int) employee.getFullSalary() + " руб");
        }

        System.out.println("\nСамые низкие зарплаты компании: ");
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println((int) employee.getFullSalary() + " руб");
        }

        System.out.println();
        company.fireOnPercent(50);

        System.out.println("\nСамые высокие зарплаты компании: ");
        for (Employee employee : company.getTopSalaryStaff(15)) {
            System.out.println((int) employee.getFullSalary() + " руб");
        }

        System.out.println("\nСамые низкие зарплаты компании: ");
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println((int) employee.getFullSalary() + " руб");
        }
    }
}
