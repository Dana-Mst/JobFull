package com.rocketteam.jobfull.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.rocketteam.jobfull.model.Customer;
import com.rocketteam.jobfull.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCompanies() {
        return new ResponseEntity<>(customerService.getAllCustomers(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") UUID id) {
        if (id == null || customerService.getCustomerById(id).isEmpty()) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerService.getCustomerById(id).get(), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/addCustomer")
    public void addACustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<UUID> deleteCustomer(@PathVariable UUID id) {
        var isRemoved = customerService.deleteCustomer(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    private Customer applyPatchToCustomer(JsonPatch patch, Customer customer)
            throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = patch.apply(objectMapper.convertValue(customer, JsonNode.class));
        return objectMapper.treeToValue(patched, Customer.class);
    }

    @PatchMapping(path = "/update/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<Customer> updateCustomer(@PathVariable UUID id, @RequestBody JsonPatch patch) {
        try {
            Customer customer = customerService.getCustomerById(id).orElseThrow(IllegalAccessError::new);
            Customer customerPatched = applyPatchToCustomer(patch, customer);
            customerService.updateCustomerById(id, customerPatched);
            return ResponseEntity.ok(customerPatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (IllegalAccessError e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}