package com.subhani.hibernate.demo;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.subhani.hibernate.demo.entity.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    { 
        System.out.println( "Hello World!" );
        //CustomerDao dao = new CustomerDao();
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("classicmodels");
        
        EntityManager selectManager = factory.createEntityManager(); // Like a Connection
        //List<Customer> customerList = selectManager.createQuery("select c from Customer c").getResultList();
        List<Customer> customerList = selectManager.createNamedQuery("selectall").getResultList();
        
        customerList
        	.stream()
        	.forEach(r -> System.out.println(r.getCustomerNumber() + ", " + r.getCustomerName() + ", " + r.getContactFirstName() + ", " + r.getContactLastName() + ", " + r.getPhone()));
        
        
        EntityManager insertManager = factory.createEntityManager(); // Like a Connection
        insertManager.getTransaction().begin();
        
        Customer customer = new Customer();
        customer.setContactFirstName("Subhani");
        customer.setContactLastName("Shaik");
        customer.setCustomerName("Subhani Shaik");
        customer.setCustomerNumber(1801);
        customer.setPhone("3232323232");
        customer.setAddressLine1("Juanita Ave");
        customer.setCity("Los Angeles");
        customer.setCountry("USA");
        
        //insertManager.persist(customer);
        
        insertManager.getTransaction().commit();
        System.out.println("Customer inserted successfully. Customer Number: " + customer.getCustomerNumber());
        
        
        // Using find method on table's primary key
        EntityManager entityManager = factory.createEntityManager();
        try {
	        Customer customerData = entityManager.find(Customer.class, customer.getCustomerNumber());
	        System.out.println("Customer data received from database for id " + customer.getCustomerNumber() + ": " +  customerData.toString());
	        
	        // Now remove the customer
	        entityManager.remove(customerData);
	        System.out.println("Customer data with id  " + customer.getCustomerNumber() + " removed from the database");
	        
	        System.out.println("Trying to retrieve after deleting the customer ...");
	        customerData = entityManager.find(Customer.class, 1801);
	        System.out.println("Customer data received from database for id  " + customer.getCustomerNumber() + ":  " + customerData.toString());
	        
        } catch(NullPointerException  e) {
        	System.out.println("The customer with ID 1801 not found in the database." + e);
        } finally {
        	insertManager.close();
        }
        System.out.println("All done.. Godobye.");
        
        
    }
}