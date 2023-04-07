public class Account {
    private String name;
    private String pass;
    private String empNum;
    private int empID;
}

public Account(){}

public Account(String name, String pass, String empNum, int empID){
    this.name =name;
    this.pass = pass;
    this.empNum = empNum;
    this.empID = empID;
}

public String getName(){
    return name;
}

public void setName(String name){
    this.name = name;
}

public String getPass(){
    return pass;
}

public void setPass(String pass){
    this.pass = pass;
}

public String getEmpNum(){
    return empNum;
}

public void setEmpNum(String empNum){
    this.empNum =empNum;
}

public int getEmpID(){
    return empID;
}

public void createEmpID(){

}