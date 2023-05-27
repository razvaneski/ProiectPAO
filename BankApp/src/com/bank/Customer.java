package com.bank;

public final class Customer {
    private static int idCount = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String cnp;
    private String address;
    private String phoneNumber;
    private String email;

    public Customer(String firstName, String lastName, String cnp, String address, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cnp = cnp;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.id = idCount++;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCnp() {
        return cnp;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
