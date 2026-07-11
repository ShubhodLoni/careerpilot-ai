package com.careerpilot.backend.services;

import com.careerpilot.backend.model.CareerRole;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillGapService {

    public List<String> findMissingSkills(
            List<String> foundSkills,
            CareerRole role) {

        List<String> missingSkills =
                new ArrayList<>();

        for (String skill : role.getRequiredSkills()) {

            if (!foundSkills.contains(
                    skill.toLowerCase())) {

                missingSkills.add(skill);
            }
        }

        return missingSkills;
    }
}