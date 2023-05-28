import bank.customer.*;
import bank.db.*;

import java.sql.*;
import java.util.List;

public class Main {
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/bank";
            String user = "root";
            String password = "proiectpao";

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    public static void main(String[] args) {
        CustomerDb customerDb = new CustomerDb(getConnection());
        Customer customer = new Customer(
                "Ion",
                "Popescu",
                "5000609463053",
                new Date(2000, 6, 9),
                "ion@popescu.ro",
                "0712345678",
                "Str. Popescu nr. 1"
        );
        customerDb.create(customer);
        List<Customer> customers = customerDb.read();
        for (Customer c : customers) {
            System.out.println(c);
        }
        customer.setFirstName("Gheorghe");
        customerDb.update(customer);
        customers = customerDb.read();
        for (Customer c : customers) {
            System.out.println(c);
        }
    }
}
