package com.rocketteam.jobfull.model;

import com.rocketteam.jobfull.model.users.CurriculumVitae;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {
    private UUID id;
    private CurriculumVitae curriculumVitae;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;
    private Date dateOfBirth;
}