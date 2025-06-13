package org.hibernate.implementation;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.pojo.content.EmployeeDetails;

/**
 * This class demonstrates the use of Hibernate to persist and retrieve
 * employee details from a MySQL database.
 */
public class EmployeeDemo {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            // Initialize SessionFactory using Hibernate configuration
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.err.println("\nFailed to create sessionFactory object.\n");
            e.printStackTrace();
        }

        EmployeeDemo demo = new EmployeeDemo();
        demo.addEmployee(1001, "Abcdefg", "Developer", 30000);
        demo.addEmployee(1002, "Qwertyy", "Analyst", 40000);
        demo.addEmployee(1003, "Poiuytr", "Manager", 50000);
        demo.listEmployees();
    }

    // Method to add employee records into the database
    private void addEmployee(int eid, String ename, String epost, int esalary) {
        Session session = factory.openSession();
        try {
            EmployeeDetails employeedetails = new EmployeeDetails(eid, ename, epost, esalary);
            session.beginTransaction();
            session.save(employeedetails);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("\nFailed to add employee in Database.\n");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Method to fetch and display all employee records from the database
    private void listEmployees() {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            List employees = session.createQuery("FROM EmployeeDetails").list();
            System.out.println("\nList of Company Employees");
            System.out.println("\nEmployee Name\tDesignation\tSalary\n");
            for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
                EmployeeDetails employee = (EmployeeDetails) iterator.next();
                System.out.print(employee.getEmpname() + "\t\t");
                System.out.print(employee.getDesignation() + "\t\t");
                System.out.println(employee.getSalary());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("\nFailed to List employees in Database.\n");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
