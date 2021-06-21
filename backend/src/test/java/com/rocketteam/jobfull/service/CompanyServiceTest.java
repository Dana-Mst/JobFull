package com.rocketteam.jobfull.service;

import com.rocketteam.jobfull.model.Company;
import com.rocketteam.jobfull.repository.CompanyMemoryDao;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceTest {

    @Spy
    private CompanyMemoryDao mockCompanyMemoryDao;
    @InjectMocks
    private CompanyService companyService;

    public List<Company> generateCompanies() {
        List<Company> companyList = new ArrayList<>();
        companyList.add(new Company(UUID.fromString("1c64545b-3d69-4167-9215-c95f3cb26f05"),
                        "Photosnap",
                        "The street",
                        "New York",
                        "173945034",
                        "www.photosnap.com",
                        "photosnap@email.com",
                        "Hell of a company",
                        "logo",
                        "CUI",
                        "J/40/23343",
                        new ArrayList<>(),
                        new ArrayList<>()
                )
        );
        companyList.add(new Company(UUID.fromString("4b4e2510-6ab2-4d64-9d28-66bec2500c5f"),
                        "Photosnap",
                        "The street",
                        "New York",
                        "173945034",
                        "www.photosnap.com",
                        "photosnap@email.com",
                        "Hell of a company",
                        "logo",
                        "CUI",
                        "J/40/23343",
                        new ArrayList<>(),
                        new ArrayList<>()
                )
        );
        return companyList;
    }

    @Test
    void getAllCompanies() {
        CompanyMemoryDao mockCompanyMemoryDao = Mockito.mock(CompanyMemoryDao.class);
        CompanyService companyService = Mockito.mock(CompanyService.class);
        Mockito.when(mockCompanyMemoryDao.getAllCompanies()).thenReturn(generateCompanies());
        Mockito.when(companyService.getAllCompanies()).thenReturn(generateCompanies());
        List<Company> result = companyService.getAllCompanies();
        assertEquals(result.size(), generateCompanies().size());
        assertNotNull(result);
    }

    @Test
    void getCompanyById() {
        CompanyMemoryDao mockCompanyMemoryDao = Mockito.mock(CompanyMemoryDao.class);
        CompanyService companyService = Mockito.mock(CompanyService.class);
        Mockito.when(mockCompanyMemoryDao.getAllCompanies()).thenReturn(generateCompanies());
        Mockito.when(companyService.getCompanyById(UUID.fromString("1c64545b-3d69-4167-9215-c95f3cb26f05"))).thenReturn(java.util.Optional.ofNullable(generateCompanies().get(0)));
        Company result = companyService.getCompanyById(UUID.fromString("1c64545b-3d69-4167-9215-c95f3cb26f05")).get();
        assertEquals(result, generateCompanies().get(0));
    }

    @Test
    void deleteCompany(){
        CompanyService companyService = Mockito.mock(CompanyService.class);
        Mockito.when(companyService.deleteCompany(UUID.fromString("4b4e2510-6ab2-4d64-9d28-66bec2500c5f"))).thenReturn(true);
        boolean result = companyService.deleteCompany(UUID.fromString("4b4e2510-6ab2-4d64-9d28-66bec2500c5f"));
        assertEquals(result,true);

    }

    @Test
    void updateCompanyById(){
        Company newCompany = new Company(UUID.randomUUID(),
                "Photosnap",
                "The street",
                "New York",
                "173945034",
                "www.photosnap.com",
                "photosnap@email.com",
                "Hell of a company",
                "logo",
                "CUI",
                "J/40/23343",
                new ArrayList<>(),
                new ArrayList<>()
        );

        CompanyMemoryDao mockCompanyMemoryDao = Mockito.mock(CompanyMemoryDao.class);
        CompanyService companyService = Mockito.mock(CompanyService.class);
        Mockito.when(mockCompanyMemoryDao.getCompanyById(UUID.fromString("4b4e2510-6ab2-4d64-9d28-66bec2500c5f"))).thenReturn(java.util.Optional.ofNullable(generateCompanies().get(1)));
        Mockito.when(companyService.updateCompanyById(UUID.fromString("4b4e2510-6ab2-4d64-9d28-66bec2500c5f"), newCompany)).thenReturn(true);
        boolean result = companyService.updateCompanyById(UUID.fromString("4b4e2510-6ab2-4d64-9d28-66bec2500c5f"), newCompany);

        assertEquals(result, true);


    }

}