package src;

import java.sql.Date;

/**
 * holds data pertaining to employees
 */
public class EmployeesData {
    private String ID;
    private String Name;
    private String phone;
    private Double salary;
    private String position;

    /**
     * constructor for EmployeesData
     * @param ID ID of the employee
     * @param Name name of the employee
     * @param phone phone number of the employee
     * @param salary salary of the employee
     * @param position position of the employee
     */
    public EmployeesData(String ID, String Name, String phone, Double salary, String position) {
        this.ID = ID;
        this.Name = Name;
        this.phone = phone;
        this.salary = salary;
        this.position = position;
    }

    public String getId() {
        return ID;
    }

    public String getEmpName() {
        return Name;
    }

    public String getPhone() {
        return phone;
    }

    public Double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }
}


