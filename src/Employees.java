package src;

abstract class Employees {
    private int empID;
    private String empName;
    private double empSal;
    private double empHour;
    private String empRole;
}

public Employees(){
}

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