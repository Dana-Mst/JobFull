package com.rocketteam.jobfull.model.users;

import java.util.List;

public class CurriculumVitae {
    private String aboutMe;
    private ProfessionalExperience professionalExperience;
    private String education;
    private List<String> foreignLanguage;
    private List<String> skills;
    private String otherInfo;

    public CurriculumVitae(String aboutMe,
                           ProfessionalExperience professionalExperience,
                           String education,
                           List<String> foreignLanguage,
                           List<String> skills,
                           String otherInfo) {
        this.aboutMe = aboutMe;
        this.professionalExperience = professionalExperience;
        this.education = education;
        this.foreignLanguage = foreignLanguage;
        this.skills = skills;
        this.otherInfo = otherInfo;
    }

    public CurriculumVitae() {}
    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public ProfessionalExperience getProfessionalExperience() {
        return professionalExperience;
    }

    public void setProfessionalExperience(ProfessionalExperience professionalExperience) {
        this.professionalExperience = professionalExperience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public List<String> getForeignLanguage() {
        return foreignLanguage;
    }

    public void setForeignLanguage(List<String> foreignLanguage) {
        this.foreignLanguage = foreignLanguage;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }
}
