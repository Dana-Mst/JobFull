package com.rocketteam.jobfull.repository;

import com.rocketteam.jobfull.model.Company;
import com.rocketteam.jobfull.model.Job;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CompanyDao {
    Company addCompany(Company company);
    boolean deleteCompany(UUID id);
    List<Company> getAllCompanies();
    Optional<Company> getCompanyById(UUID id);
    boolean updateCompanyById(UUID id, Company company);
    List<Job> getAllJobsFromCompanyList();
    Job getJobForCompanyById(UUID companyId, UUID jobId);
}
