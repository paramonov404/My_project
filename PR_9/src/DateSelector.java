import java.time.LocalDate;

public class DateSelector implements EmployeeSelector {

    LocalDate startDate;
    LocalDate endDate;

    public DateSelector(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean selectEmployee(Employee employee){
        return (employee.getDate().isAfter(startDate) && employee.getDate().isBefore(endDate));
    }
}
