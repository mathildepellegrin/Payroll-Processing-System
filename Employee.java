public class Employee {

    //attributes
    private long employeeNumber;
    private String employeeFirstName;
    private String employeeLastName;
    private double hoursWorked;
    private double hourlyWage;
    private double grossSalary;

    //parametrized constructor
    public Employee(long employeeNumber, String employeeFirstName, String employeeLastName, double hoursWorked, double hourlyWage){
        this.employeeNumber=employeeNumber;
        this.employeeFirstName=employeeFirstName;
        this.employeeLastName=employeeLastName;
        this.hoursWorked=hoursWorked;
        this.hourlyWage=hourlyWage;
        this.grossSalary=hoursWorked*hourlyWage*52;
    }

    //default constructor
    public Employee(){
        this(0, null, null, 0.0, 0.0);
    }

    //copy constructor
    public Employee(Employee other){
        this(other.employeeNumber, other.employeeFirstName, other.employeeLastName, other.hoursWorked, other.hourlyWage);
    }

    //getters
    public long getEmployeeNumber(){
        return employeeNumber;
    }
    public String getEmployeeFirstName(){
        return employeeFirstName;
    }
    public String getEmployeeLastName(){
        return employeeLastName;
    }
    public double getHoursWorked(){
        return hoursWorked;
    }
    public double getHourlyWage(){
        return hourlyWage;
    }
    public double getGrossSalary(){
        return grossSalary;
    }

    //setters
    public void setEmployeeNumber(long employeeNumber){
        this.employeeNumber=employeeNumber;
    }
    public void setEmployeeFirstName(String employeeFirstName){
        this.employeeFirstName=employeeFirstName;
    }
    public void setEmployeeLastName(String employeeLastName){
        this.employeeLastName=employeeLastName;
    }
    public void setHoursWorked(double hoursWorked){
        this.hoursWorked=hoursWorked;
    }
    public void setHourlyWage(double hourlyWage){
        this.hourlyWage=hourlyWage;
    }
    public void setGrossSalary(double grossSalary){
        this.grossSalary=grossSalary;
    }



}
