package com.rocketteam.jobfull.model;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Company {

    private UUID id = UUID.randomUUID();
    private String name;
    private String adress;
    private String city;
    private String phoneNumber;
    private String website;
    private String email;
    private String description;
    private String logo;
    private String uniqueRegistrationCode;
    private String tradeRegisterSerialNumber;
    private List<Job> jobs;
    private List<Customer> applicants;
}