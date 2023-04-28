package src;

/**
 * holds employee data
 */
abstract class Employees {
    private int empID;
    private String empName;
    private double empSal;
    private double empHour;
    private String empRole;


public Employees(){
}

    /**
     * constructor for Employees
     * @param empID holds the employee's ID
     * @param empName holds the employee's name
     * @param empSal holds the employee's salary
     * @param empHour holds the employee's working hours
     * @param empRole holds the employee's role
     */
    public Employees(int empID, String empName, double empSal, double empHour, String empRole){
    this.empID =empID;
    this.empName = empName;
    this.empSal = empSal;
    this.empHour = empHour;
    this.empRole = empRole;
}

public int getEmpID(){
    return empID;
}

public String getEmpName(){
    return empName;
}

public double getEmpSal(){
    return empSal;
}

public double getEmpHour(){
    return empHour;
}

public String  getEmpRole(){
    return empRole;
}
}