package com.rocketteam.jobfull.service;

import com.rocketteam.jobfull.model.Customer;
import com.rocketteam.jobfull.model.users.CurriculumVitae;
import com.rocketteam.jobfull.repository.CustomerMemoryDao;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.BeforeMethod;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    @Spy
    private CustomerMemoryDao mockCustomerMemoryDao;
    @InjectMocks
    private CustomerService customerService;


    public List<Customer> generateCustomers() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(UUID.fromString("463a4d11-4fc0-4ac1-b0f5-3d759b4a3e5e"),
                        new CurriculumVitae(),
                        "Yusef",
                        "Maximilianus",
                        "1724059385",
                        "Yusef@email.com",
                        Date.from(Instant.now())
                )
        );
            customerList.add(new Customer(UUID.fromString("abd9facb-3c4b-4792-b93a-1ed67b92c896"),
                        new CurriculumVitae(),
                        "Romina",
                        "Lux",
                        "1749462746",
                        "Romina@email.com",
                        Date.from(Instant.now())
                )
        );

        return customerList;
    }

    @BeforeMethod
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllCustomers() {
        CustomerMemoryDao mockCustomerMemoryDao = Mockito.mock(CustomerMemoryDao.class);
        CustomerService customerService = Mockito.mock(CustomerService.class);
        Mockito.when(mockCustomerMemoryDao.getAllCustomers()).thenReturn(generateCustomers());
        Mockito.when(customerService.getAllCustomers()).thenReturn(generateCustomers());
        List<Customer> result = customerService.getAllCustomers();
        assertEquals(result.size(), generateCustomers().size());
        assertNotNull(result);
    }

    @Test
    void getCustomerById() {
        CustomerMemoryDao mockCustomerMemoryDao = Mockito.mock(CustomerMemoryDao.class);
        CustomerService customerService = Mockito.mock(CustomerService.class);
        Mockito.when(mockCustomerMemoryDao.getAllCustomers()).thenReturn(generateCustomers());
        Mockito.when(customerService.getCustomerById(UUID.fromString("463a4d11-4fc0-4ac1-b0f5-3d759b4a3e5e"))).thenReturn(java.util.Optional.ofNullable(generateCustomers().get(0)));
        Customer result = customerService.getCustomerById(UUID.fromString("463a4d11-4fc0-4ac1-b0f5-3d759b4a3e5e")).get();
        assertEquals(result.getFirstName(), generateCustomers().get(0).getFirstName());
        assertEquals(result.getLastName(), generateCustomers().get(0).getLastName());

    }

    @Test
    void deleteCustomer() {
        CustomerMemoryDao mockCustomerMemoryDao = Mockito.mock(CustomerMemoryDao.class);
        CustomerService customerService = Mockito.mock(CustomerService.class);
        Mockito.when(mockCustomerMemoryDao.deleteCustomer(UUID.fromString("abd9facb-3c4b-4792-b93a-1ed67b92c896"))).thenReturn(true);
        Mockito.when(customerService.deleteCustomer(UUID.fromString("abd9facb-3c4b-4792-b93a-1ed67b92c896"))).thenReturn(true);
        boolean result = customerService.deleteCustomer(UUID.fromString("abd9facb-3c4b-4792-b93a-1ed67b92c896"));
        assertEquals(result, true);
    }

    @Test
    void updateCustomerById() {
        Customer newCustomer = new Customer(UUID.randomUUID(),
                new CurriculumVitae(),
                "Darko",
                "Jonas",
                "1749234857",
                "Darko@email.com",
                Date.from(Instant.now())
        );

        CustomerMemoryDao mockCustomerMemoryDao = Mockito.mock(CustomerMemoryDao.class);
        CustomerService customerService = Mockito.mock(CustomerService.class);
        Mockito.when(mockCustomerMemoryDao.getCustomerById(UUID.fromString("abd9facb-3c4b-4792-b93a-1ed67b92c896"))).thenReturn(java.util.Optional.ofNullable(generateCustomers().get(1)));
        Mockito.when(customerService.updateCustomerById(UUID.fromString("abd9facb-3c4b-4792-b93a-1ed67b92c896"), newCustomer)).thenReturn(true);
        boolean result = customerService.updateCustomerById(UUID.fromString("abd9facb-3c4b-4792-b93a-1ed67b92c896"), newCustomer);
        assertEquals(result, true);
    }
}