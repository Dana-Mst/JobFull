package com.rocketteam.jobfull.controller;


import com.rocketteam.jobfull.service.CompanyService;
import com.rocketteam.jobfull.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(path = "/api/jobs")
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {
    private final CompanyService companyService;


    @Autowired
    public JobController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping
    public ResponseEntity<List<Job>> getJobs() {
        return new ResponseEntity<>(companyService.getAllJobsFromCompanyList(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/{companyId}/{jobId}")
    public ResponseEntity<Job> getJobByCompanyIdAndJobId(@PathVariable("companyId") UUID companyId, @PathVariable("jobId") UUID jobId) {
        if (companyId == null || jobId == null) {
            return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(companyService.getJobForCompanyById(companyId, jobId), new HttpHeaders(), HttpStatus.OK);
    }

}