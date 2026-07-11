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

        List<CareerRole> roles =
                careerRoleRepository.getRoles();

        List<Map<String, Object>> careerMatches =
                new ArrayList<>();

        for (CareerRole role : roles) {

            int matchedSkills = 0;

            for (String skill : role.getRequiredSkills()) {

                if (foundSkills.contains(skill.toLowerCase())) {
                    matchedSkills++;
                }
            }

            int score =
                    (matchedSkills * 100)
                            / role.getRequiredSkills().size();

            if (score > 0) {

                Map<String, Object> match =
                        new HashMap<>();

                match.put(
                        "role",
                        role.getRole()
                );

                match.put(
                        "category",
                        role.getCategory()
                );

                match.put(
                        "salaryRange",
                        role.getSalaryRange()
                );

                match.put(
                        "matchScore",
                        score
                );

                careerMatches.add(match);
            }
        }

        careerMatches.sort(
                (a, b) -> Integer.compare(
                        (Integer) b.get("matchScore"),
                        (Integer) a.get("matchScore")
                )
        );

        return careerMatches;
    }
}