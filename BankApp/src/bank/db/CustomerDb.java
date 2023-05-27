package bank.db;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import bank.customer.*;

public class CustomerDb{
    Connection connection;
    public CustomerDb(Connection connection) {
        this.connection = connection;
    }
    public void create(Customer customer) {
        try{
            String query = "INSERT INTO Customers (firstName, lastName, CNP, birthDate, email, phone, address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, customer.getFirstName());
            preparedStmt.setString(2, customer.getLastName());
            preparedStmt.setString(3, customer.getCNP());
            preparedStmt.setString(4, (new SimpleDateFormat("yyyy-MM-dd")).format(customer.getBirthDate()));
            preparedStmt.setString(5, customer.getEmail());
            preparedStmt.setString(6, customer.getPhone());
            preparedStmt.setString(7, customer.getAddress());
            preparedStmt.execute();
            preparedStmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public List<Customer> read(){
        List<Customer> customers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Customers");
            while(result.next()) {
                Customer newCustomer = new Customer(result);
                customers.add(newCustomer);
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return customers;
    }

    public void update(Customer newCustomer) {
        try {
            String query = "UPDATE Customers SET firstName = ?, lastName = ?, CNP = ?, birthDate = ?, email = ?, phone = ?, address = ? WHERE CNP = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, newCustomer.getFirstName());
            preparedStmt.setString(2, newCustomer.getLastName());
            preparedStmt.setString(3, newCustomer.getCNP());
            preparedStmt.setString(4, (new SimpleDateFormat("yyyy-MM-dd")).format(newCustomer.getBirthDate()));
            preparedStmt.setString(5, newCustomer.getEmail());
            preparedStmt.setString(6, newCustomer.getPhone());
            preparedStmt.setString(7, newCustomer.getAddress());
            preparedStmt.setString(8, newCustomer.getCNP());
            preparedStmt.executeUpdate();
            preparedStmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void delete(Customer customer) {
        try {
            String query = "DELETE FROM Customers WHERE CNP = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, customer.getCNP());
            preparedStmt.execute();
            preparedStmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
