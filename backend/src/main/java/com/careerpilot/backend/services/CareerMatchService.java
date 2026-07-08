package com.careerpilot.backend.services;

import org.springframework.stereotype.Service;
import com.careerpilot.backend.repository.CareerRoleRepository;
import com.careerpilot.backend.model.CareerRole;

import java.util.*;

@Service
public class CareerMatchService {

    private final CareerRoleRepository careerRoleRepository;

    public CareerMatchService(CareerRoleRepository careerRoleRepository) {
        this.careerRoleRepository = careerRoleRepository;
    }

    public List<Map<String, Object>> getCareerMatches(List<String> foundSkills) {

        Map<String, List<String>> careerRoles = new HashMap<>();

        careerRoles.put("Data Analyst",
                Arrays.asList("sql", "power bi", "excel", "python", "data analysis"));

        careerRoles.put("Data Scientist",
                Arrays.asList("python", "machine learning", "pandas", "numpy"));

        careerRoles.put("Data Engineer",
                Arrays.asList("sql", "python", "aws", "spark"));

        careerRoles.put("AI Engineer",
                Arrays.asList("python", "machine learning", "deep learning"));

        careerRoles.put("ML Engineer",
                Arrays.asList("python", "machine learning", "docker"));

        careerRoles.put("Backend Developer",
                Arrays.asList("java", "spring boot", "sql"));

        careerRoles.put("Full Stack Developer",
                Arrays.asList("java", "react", "javascript", "html", "css"));

        careerRoles.put("Software Engineer",
                Arrays.asList("java", "python", "git", "github"));

        careerRoles.put("Cloud Engineer",
                Arrays.asList("aws", "azure", "docker"));

        careerRoles.put("DevOps Engineer",
                Arrays.asList("docker", "aws", "git"));

        careerRoles.put("Business Analyst",
                Arrays.asList("sql", "excel", "power bi"));

        careerRoles.put("BI Analyst",
                Arrays.asList("power bi", "sql"));

        careerRoles.put("Analytics Engineer",
                Arrays.asList("sql", "python", "data analysis"));

        careerRoles.put("Product Analyst",
                Arrays.asList("sql", "analytics"));

        careerRoles.put("Cybersecurity Analyst",
                Arrays.asList("security", "networking"));

        List<Map<String, Object>> careerMatches = new ArrayList<>();

        for (Map.Entry<String, List<String>> role : careerRoles.entrySet()) {

            int matchedSkills = 0;

            for (String skill : role.getValue()) {

                if (foundSkills.contains(skill.toLowerCase())) {
                    matchedSkills++;
                }
            }

            int score =
                    (matchedSkills * 100) / role.getValue().size();

            if (score >= 25) {

                Map<String, Object> match = new HashMap<>();

                match.put("role", role.getKey());
                match.put("matchScore", score);

                careerMatches.add(match);
            }
        }

        careerMatches.sort((a, b) ->
                Integer.compare(
                        (Integer) b.get("matchScore"),
                        (Integer) a.get("matchScore")
                ));

        return careerMatches;
    }
}