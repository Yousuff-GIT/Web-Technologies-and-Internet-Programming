package edu.cahcet.implementation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import edu.cahcet.application.Employee;

/**
 * Main class that initializes Spring context and demonstrates object injection.
 */
public class Implementation {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        System.out.println("Implementation of Spring Framework\n");
        System.out.println("Demonstration of Object Injection\n");

        Employee emp = (Employee) context.getBean("employees");
        emp.display();
    }
}
