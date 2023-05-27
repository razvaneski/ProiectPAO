package bank.factories;

import java.util.*;
import bank.customer.*;

public final class CustomerFactory {
    private static int id = 0;
    public Customer createCustomer(
            String firstName,
            String lastName,
            String CNP,
            Date birthDate,
            String email,
            String phone,
            String address
    ) {
        return new Customer(id++, firstName, lastName, CNP, birthDate, email, phone, address);
    }
}
