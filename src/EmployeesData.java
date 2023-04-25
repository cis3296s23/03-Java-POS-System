package src;

import java.sql.Date;

public class EmployeesData {
    private String ID;
    private String Name;
    private String phone;
    private Double salary;
    private String position;

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


