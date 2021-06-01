package main.java.topcodingquestion.arraysandstrings;

public class EmployeeInterval {

    public Interval interval;// interval representing employee's working hours
    public int employeeIndex;// index of the list containing working hours of this employee
    public int intervalIndex;// index of the interval in the employee list

    public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
        this.interval = interval;
        this.employeeIndex = employeeIndex;
        this.intervalIndex = intervalIndex;
    }
}
