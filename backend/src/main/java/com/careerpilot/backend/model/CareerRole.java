package com.careerpilot.backend.model;

import java.util.List;

public class CareerRole {

    private String role;
    private String category;
    private String salaryRange;
    private List<String> requiredSkills;

    public CareerRole(
            String role,
            String category,
            String salaryRange,
            List<String> requiredSkills) {

        this.role = role;
        this.category = category;
        this.salaryRange = salaryRange;
        this.requiredSkills = requiredSkills;
    }

    public String getRole() {
        return role;
    }

    public String getCategory() {
        return category;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }
}