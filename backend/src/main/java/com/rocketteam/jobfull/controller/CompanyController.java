package com.rocketteam.jobfull.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.rocketteam.jobfull.model.Company;
import com.rocketteam.jobfull.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/company")
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getCompanies() {
        return new ResponseEntity<>(companyService.getAllCompanies(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id")  UUID id) {
        if (id == null || companyService.getCompanyById(id).isEmpty()) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(companyService.getCompanyById(id).get(), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/addCompany")
    public void addACompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity< UUID> deleteCompany(@PathVariable  UUID id) {
        var isRemoved = companyService.deleteCompany(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    private Company applyPatchToCompany(JsonPatch patch, Company company)
            throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = patch.apply(objectMapper.convertValue(company, JsonNode.class));
        return objectMapper.treeToValue(patched, Company.class);
    }

    @PatchMapping(path = "/update/{id}", consumes = "application/json-patch+json")
    public ResponseEntity<Company> updateCompany(@PathVariable UUID id, @RequestBody JsonPatch patch) {
        try {
            Company company = companyService.getCompanyById(id).orElseThrow(IllegalAccessError::new);
            Company companyPatched = applyPatchToCompany(patch, company);
            companyService.updateCompanyById(id, companyPatched);
            return ResponseEntity.ok(companyPatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (IllegalAccessError e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}