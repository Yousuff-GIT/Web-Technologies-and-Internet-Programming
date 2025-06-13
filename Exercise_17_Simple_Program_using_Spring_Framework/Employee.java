package edu.cahcet.application;

public class Employee {
    private Details title;
    private Details emp1;
    private Details emp2;

    public Details getTitle() { return title; }
    public void setTitle(Details title) { this.title = title; }

    public Details getEmp1() { return emp1; }
    public void setEmp1(Details emp1) { this.emp1 = emp1; }

    public Details getEmp2() { return emp2; }
    public void setEmp2(Details emp2) { this.emp2 = emp2; }

    public void display() {
        System.out.println(getTitle().getEmpid() + "\t" + getTitle().getName() + "\t\t" +
                           getTitle().getDesignation() + "\t" + getTitle().getSalary());
        System.out.println(getEmp1().getEmpid() + "\t" + getEmp1().getName() + "\t" +
                           getEmp1().getDesignation() + "\t" + getEmp1().getSalary());
        System.out.println(getEmp2().getEmpid() + "\t" + getEmp2().getName() + "\t" +
                           getEmp2().getDesignation() + "\t\t" + getEmp2().getSalary());
    }
}
