package com.bank.services;

import com.bank.Customer;

public class CustomersService extends BaseService<Customer>{
    private static CustomersService instance = null;

    private CustomersService() {}

    public static CustomersService getInstance() {
        if (instance == null) {
            instance = new CustomersService();
        }
        return instance;
    }
}
