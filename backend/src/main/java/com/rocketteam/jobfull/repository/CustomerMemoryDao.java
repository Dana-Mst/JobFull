package com.rocketteam.jobfull.repository;

import com.rocketteam.jobfull.model.Customer;
import com.rocketteam.jobfull.model.users.CurriculumVitae;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.Instant;
import java.util.*;

@Repository("CustomerMemoryDao")
@CrossOrigin(origins = "http://localhost:3000, http://localhost:8080")
public class CustomerMemoryDao implements CustomerDao {
    private static List<Customer> customers = new ArrayList<>();

    @Override
    public Customer addCustomer(Customer customer) {
        customer.setId(UUID.randomUUID());
        customers.add(customer);
        return customer;
    }

    @Override
    public boolean deleteCustomer( UUID id) {
        return customers.removeIf(customer -> customer.getId().equals(id));
    }

    @Override
    public Optional<Customer> getCustomerById( UUID id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean updateCustomerById( UUID id, Customer customerToUpdate) {
        return getCustomerById(id)
                .map(customer -> {
                    int indexOfJobToUpdate = customers.indexOf(customer);
                    if (indexOfJobToUpdate >= 0) {
                        customers.set(indexOfJobToUpdate, customerToUpdate);
                        return true;
                    }
                    return false;
                }).orElse(false);
    }


    public List<Customer> getAllCustomers() {
        if (customers.isEmpty()) {
            customers.add(new Customer(UUID.randomUUID(),
                            new CurriculumVitae(),
                            "Yusef",
                            "Maximilianus",
                            "1724059385",
                            "Yusef@email.com",
                            Date.from(Instant.now())
                    )
            );
            customers.add(new Customer(UUID.randomUUID(),
                            new CurriculumVitae(),
                            "Romina",
                            "Lux",
                            "1749462746",
                            "Romina@email.com",
                            Date.from(Instant.now())
                    )
            );
            customers.add(new Customer(UUID.randomUUID(),
                            new CurriculumVitae(),
                            "Darko",
                            "Jonas",
                            "1749234857",
                            "Darko@email.com",
                            Date.from(Instant.now())
                    )
            );
            customers.add(new Customer(UUID.randomUUID(),
                            new CurriculumVitae(),
                            "Comfort",
                            "George",
                            "1749435857",
                            "Comfort@email.com",
                            Date.from(Instant.now())
                    )
            );
            customers.add(new Customer(UUID.randomUUID(),
                            new CurriculumVitae(),
                            "Diana",
                            "Samuel",
                            "1744955857",
                            "Diana@email.com",
                            Date.from(Instant.now())
                    )
            );
            customers.add(new Customer(UUID.randomUUID(),
                            new CurriculumVitae(),
                            "Fausta",
                            "Mateo",
                            "1744954057",
                            "Fausta@email.com",
                            Date.from(Instant.now())
                    )
            );
            customers.add(new Customer(UUID.randomUUID(),
                            new CurriculumVitae(),
                            "Oscar",
                            "Polina",
                            "1744406857",
                            "Oscar@email.com",
                            Date.from(Instant.now())
                    )
            );
            customers.add(new Customer(UUID.randomUUID(),
                            new CurriculumVitae(),
                            "Rakesh",
                            "Wolf",
                            "1744953947",
                            "Rakesh@email.com",
                            Date.from(Instant.now())
                    )
            );
            customers.add(new Customer(UUID.randomUUID(),
                            new CurriculumVitae(),
                            "Sebastiano",
                            "Lena",
                            "1749995857",
                            "Sebastiano@email.com",
                            Date.from(Instant.now())
                    )
            );
            customers.add(new Customer(UUID.randomUUID(),
                            new CurriculumVitae(),
                            "Vitomir",
                            "Gaius",
                            "1744503857",
                            "Vitomir@email.com",
                            Date.from(Instant.now())
                    )
            );
        }
        return customers;
    }


}






