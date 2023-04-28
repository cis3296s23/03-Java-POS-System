package src;
/**
Holds account information pertaining the user.
 name: stores the name of the user in a String format
 pass: stores the pasword of the user in a String format
 empNum: stores the user's employee number for clocking in
 empID: stores the user's employee ID
 */
public class Account {
    private String name;
    private String pass;
    private String empNum;
    private Employees empID;


public Account(){}

public Account(String name, String pass, String empNum, Employees empID){
    this.name =name;
    this.pass = pass;
    this.empNum = empNum;
    this.empID = empID;
}

    /**
     * gets the property: "name" from the object
     * @return the name property
     */
    public String getName(){
    return name;
}

    /**
     * sets the property: "name" to the parameter
     * @param name name to be stored
     */
    public void setName(String name){
    this.name = name;
}

    /**
     * gets the property: "pass" from the object
     * @return the pass property
     */
    public String getPass(){
    return pass;
}

    /**
     * sets the property: "pass" to the parameter
     * @param pass password to be stored
     */
    public void setPass(String pass){
    this.pass = pass;
}

    /**
     * gets the property: "empNum" from the object
     * @return empNum
     */
    public String getEmpNum(){
    return empNum;
}

    /**
     * sets the property: "name" to the parameter
     * @param empNum employee number to be stored
     */
    public void setEmpNum(String empNum){
    this.empNum =empNum;
}

    /**
     * gets the property: "empID" from the object
     * @return empID
     */
    public Employees getEmpID(){
    return empID;
}

    /**
     * creates a new empID for a user when needed
     */
    public void createEmpID(){

}
}