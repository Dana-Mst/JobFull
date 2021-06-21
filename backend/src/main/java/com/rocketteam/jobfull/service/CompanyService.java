package com.rocketteam.jobfull.service;

import com.rocketteam.jobfull.model.Company;
import com.rocketteam.jobfull.model.Job;
import com.rocketteam.jobfull.repository.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyService {

    private final CompanyDao companyDao;

    @Autowired
    public CompanyService(@Qualifier("CompanyMemoryDao") CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public List<Company> getAllCompanies() {
        return companyDao.getAllCompanies();
    }

    public Optional<Company> getCompanyById( UUID id) {
        return companyDao.getCompanyById(id);
    }

    public Company addCompany(Company company) {
        companyDao.addCompany(company);
        return company;
    }

    public boolean deleteCompany( UUID id) {
        return companyDao.deleteCompany(id);
    }

    public boolean updateCompanyById(UUID id, Company company) {
        return companyDao.updateCompanyById(id, company);
    }

    public List<Job> getAllJobsFromCompanyList() { return companyDao.getAllJobsFromCompanyList(); }

    public Job getJobForCompanyById(UUID companyId, UUID jobId) {
        return companyDao.getJobForCompanyById(companyId, jobId);
    }

}
