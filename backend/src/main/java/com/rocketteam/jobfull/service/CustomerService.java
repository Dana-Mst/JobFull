package com.rocketteam.jobfull.service;

import com.rocketteam.jobfull.model.Customer;
import com.rocketteam.jobfull.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(@Qualifier("CustomerMemoryDao") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Optional<Customer> getCustomerById( UUID id) {
        return customerDao.getCustomerById(id);
    }

    public Customer addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
        return customer;
    }

    public boolean deleteCustomer( UUID id) {
        return customerDao.deleteCustomer(id);
    }

    public boolean updateCustomerById( UUID id, Customer customer) {
        return customerDao.updateCustomerById(id, customer);
    }

}
