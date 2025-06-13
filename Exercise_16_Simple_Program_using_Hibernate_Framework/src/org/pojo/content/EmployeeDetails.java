package org.pojo.content;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This is a POJO class representing employee details.
 * It uses Hibernate annotations to map the class to a database table.
 */
@Entity
public class EmployeeDetails {
    @Id
    private int empid;
    private String empname;
    private String designation;
    private int salary;

    // Parameterized constructor
    public EmployeeDetails(int empid, String empname, String designation, int salary) {
        this.empid = empid;
        this.empname = empname;
        this.designation = designation;
        this.salary = salary;
    }

    // Default constructor
    public EmployeeDetails() {}

    // Getters and Setters
    public int getEmpid() { return empid; }
    public void setEmpid(int empid) { this.empid = empid; }

    public String getEmpname() { return empname; }
    public void setEmpname(String empname) { this.empname = empname; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }
}
