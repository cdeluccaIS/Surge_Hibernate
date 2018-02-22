package com.employee.hibernate;
import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mchange.v1.util.CollectionUtils;


public class ManageEmployee {
    private static SessionFactory factory;
    public static void main(String[] args) {

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        ManageEmployee ME = new ManageEmployee();

        /* Add few employee records in database */
        /*Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
        Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
        Integer empID3 = ME.addEmployee("John", "Paul", 10000);
        */

        /* Delete an employee from the database */
        /*ME.deleteEmployee(empID2);
        ME.deleteEmployee(empID1);
        ME.deleteEmployee(empID3);
        */
        
        /* List down all the employees */
        //ME.listEmployees();
        //ME.checkEmployee("Zara", "Ali");
        ME.existsEmployee("John", "Ali");

        /* Update employee's records */
        //ME.updateEmployee(empID1, 5000);

        /* List down new list of the employees */
        //ME.listEmployees();
    }

    /* Method to Check the database for an employee and print their info */
    public void checkEmployee(String fname, String lname) {
    		Session session = factory.openSession();
    		Transaction tx = null;
    		
    		try {
    			tx = session.beginTransaction();
    			Query inData = session.createQuery("From Employee where last_name LIKE :last_name AND first_name LIKE :first_name");
    			inData.setParameter("last_name", lname);
    			inData.setParameter("first_name", fname);
    			List employees = inData.list();
    			for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                    Employee employee = (Employee) iterator.next();
                    System.out.print("First Name: " + employee.getFirstName());
                    System.out.print("  Last Name: " + employee.getLastName());
                    System.out.println("  Salary: " + employee.getSalary());
                    System.out.println("  ID: " + employee.getId());
                }
    		} catch (HibernateException e) {
    			if (tx!=null) tx.rollback();
    			e.printStackTrace();
    		} finally {
    			session.close();
    		}
    }
    
    /* Method to check if an employee exists and returns boolean */
    public boolean existsEmployee(String fname, String lname) {
    		Session session = factory.openSession();
    		Transaction tx = null;
    		
    		try {
    			tx = session.beginTransaction();
    			Query exists = session.createQuery("From Employee where last_name LIKE :last_name AND first_name LIKE :first_name");
    			exists.setParameter("last_name", lname);
    			exists.setParameter("first_name", fname);
    			List employees = exists.list();
    			if (employees != null && employees.isEmpty()) {
    				System.out.println("False");
        			return false;
        		} else {
        			System.out.println("True");
        			return true;
        		}
    		} catch (HibernateException e) {
    			if (tx!=null) tx.rollback();
    			e.printStackTrace();
    		} finally {
    			session.close();
    		}
    		return existsEmployee(fname, lname);
    }
    
    /* Method to CREATE an employee in the database */
    public Integer addEmployee(String fname, String lname, int salary){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    /* Method to  READ all the employees */
    public void listEmployees( ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext();){
                Employee employee = (Employee) iterator.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print("  Last Name: " + employee.getLastName());
                System.out.println("  Salary: " + employee.getSalary());
                System.out.println("  ID: " + employee.getId());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to UPDATE salary for an employee */
    public void updateEmployee(Integer EmployeeID, int salary ){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, EmployeeID);
            employee.setSalary( salary );
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an employee from the records */
    public void deleteEmployee(Integer EmployeeID){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
