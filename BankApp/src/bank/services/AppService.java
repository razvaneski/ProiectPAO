package bank.services;

import java.io.Reader;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import bank.audit.AuditService;
import bank.customer.*;

public class AppService {
    private static AppService instance = null;
    private DataService dataService = DataService.getInstance();
    private AuditService auditService = null;

    private Scanner in = new Scanner(System.in);
    private AppService() {
        try {
            auditService = new AuditService();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static AppService getInstance() {
        if (instance == null) {
            instance = new AppService();
        }
        return instance;
    }

    // Customer actions:
    public void createCustomer() {
        try {
            Customer customer = new Customer(in);
            dataService.addCustomer(customer);
            auditService.logAction("createCustomer");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void getCustomer() {
        try {
            System.out.println("CNP: ");
            String CNP = in.nextLine();
            auditService.logAction("getCustomer");
            List<Customer> customers = dataService.getCustomers();
            for (Customer customer : customers) {
                if (customer.getCNP().equals(CNP)) {
                    System.out.println(customer);
                    return;
                }
            }
            System.out.println("Customer not found!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updateCustomer() {
        try {
            auditService.logAction("updateCustomer");
            System.out.println("CNP: ");
            String CNP = in.nextLine();
            List<Customer> customers = dataService.getCustomers();
            for (Customer customer : customers) {
                if (customer.getCNP().equals(CNP)) {
                    System.out.println("First name: ");
                    customer.setFirstName(in.nextLine());
                    System.out.println("Last name: ");
                    customer.setLastName(in.nextLine());
                    System.out.println("CNP: ");
                    customer.setCNP(in.nextLine());
                    System.out.println("Birth Date (yyyy-MM-dd): ");
                    customer.setBirthDate(new java.text.SimpleDateFormat("yyyy-MM-dd").parse(in.nextLine()));
                    System.out.println("Email: ");
                    customer.setEmail(in.nextLine());
                    System.out.println("Phone: ");
                    customer.setPhone(in.nextLine());
                    System.out.println("Address: ");
                    customer.setAddress(in.nextLine());
                    dataService.updateCustomer(customer);
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteCustomer() {
        try {
            auditService.logAction("deleteCustomer");
            System.out.println("CNP: ");
            String CNP = in.nextLine();
            List<Customer> customers = dataService.getCustomers();
            for (Customer customer : customers) {
                if (customer.getCNP().equals(CNP)) {
                    dataService.deleteCustomer(customer);
                    return;
                }
            }
            System.out.println("Customer not found!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
