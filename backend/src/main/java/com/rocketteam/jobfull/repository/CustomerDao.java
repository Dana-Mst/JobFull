package com.rocketteam.jobfull.repository;

import com.rocketteam.jobfull.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerDao {
    Customer addCustomer(Customer customer);
    boolean deleteCustomer( UUID id);
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById( UUID id);
    boolean updateCustomerById( UUID id, Customer customer);
}
