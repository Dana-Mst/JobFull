package com.rocketteam.jobfull.model;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Job {
    private UUID id;
    private int openPositions;
    private String logo; //aici trebuie sa fie poza
    private boolean isNew;
    private boolean featured;
    private String position;
    private String role;
    private String level;
    private Date postedAt;  // Ex: "Posted 1 day ago"
    private String contract;
    private String location;
    private List<String> languages;
    private List<String> tools;
    private String description;
    private String company;
    private UUID companyId;
}