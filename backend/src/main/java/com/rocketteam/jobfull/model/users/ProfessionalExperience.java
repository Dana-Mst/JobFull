package com.rocketteam.jobfull.model.users;

import java.util.List;


public class ProfessionalExperience {
    private List<String> exCompanyName;
    private String totalTime;
    private List<String> workedAs;

    public ProfessionalExperience(List<String> exCompanyName, String totalTime, List<String> workedAs) {
        this.exCompanyName = exCompanyName;
        this.totalTime = totalTime;
        this.workedAs = workedAs;
    }

    public List<String> getExCompanyName() {
        return exCompanyName;
    }

    public void setExCompanyName(List<String> exCompanyName) {
        this.exCompanyName = exCompanyName;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public List<String> getWorkedAs() {
        return workedAs;
    }

    public void setWorkedAs(List<String> workedAs) {
        this.workedAs = workedAs;
    }
}
