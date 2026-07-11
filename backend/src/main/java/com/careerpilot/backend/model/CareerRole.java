package com.careerpilot.backend.model;

import java.util.List;

public class CareerRole {

    private String role;
    private String category;
    private String salaryRange;
    private List<String> requiredSkills;
    private List<String> recommendedCourses;
    private List<String> advancedSkills;

    public CareerRole(
        String role,
        String category,
        String salaryRange,
        List<String> requiredSkills,
        List<String> recommendedCourses,
        List<String> advancedSkills) {

    this.role = role;
    this.category = category;
    this.salaryRange = salaryRange;
    this.requiredSkills = requiredSkills;
    this.recommendedCourses = recommendedCourses;
    this.advancedSkills = advancedSkills;
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

    public List<String> getRecommendedCourses() {
        return recommendedCourses;
    }
    public List<String> getAdvancedSkills() {
    return advancedSkills;
}
}