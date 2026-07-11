package com.careerpilot.backend.services;

import com.careerpilot.backend.model.CareerRole;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseRecommendationService {

    public List<Map<String, Object>> recommendCourses(
            CareerRole role,
            List<String> missingSkills) {

        List<Map<String, Object>> recommendations =
                new ArrayList<>();

        for (int i = 0;
             i < missingSkills.size()
             && i < role.getRecommendedCourses().size();
             i++) {

            Map<String, Object> course =
                    new HashMap<>();

            course.put(
                    "course",
                    role.getRecommendedCourses().get(i)
            );

            course.put(
                    "missingSkill",
                    missingSkills.get(i)
            );

            recommendations.add(course);
        }

        return recommendations;
    }
}