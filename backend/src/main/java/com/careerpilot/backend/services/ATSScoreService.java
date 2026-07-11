package com.careerpilot.backend.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ATSScoreService {

    public int calculateATSScore(
            String resumeText,
            List<String> foundSkills) {

        int score = 0;

        // ========================
        // Skills (40 Marks)
        // ========================

        score += Math.min(foundSkills.size() * 3, 40);

        // ========================
        // Education (10 Marks)
        // ========================

        if (resumeText.contains("bachelor")
                || resumeText.contains("b.tech")
                || resumeText.contains("b.e")
                || resumeText.contains("engineering")) {

            score += 10;
        }

        // ========================
        // Projects (20 Marks)
        // ========================

        if (resumeText.contains("project")
                || resumeText.contains("projects")) {

            score += 20;
        }

        // ========================
        // Certifications (10 Marks)
        // ========================

        if (resumeText.contains("certification")
                || resumeText.contains("certifications")
                || resumeText.contains("certified")) {

            score += 10;
        }

        // ========================
        // GitHub / LinkedIn (10 Marks)
        // ========================

        if (resumeText.contains("github")) {
            score += 5;
        }

        if (resumeText.contains("linkedin")) {
            score += 5;
        }

        // ========================
        // Resume Length (10 Marks)
        // ========================

        int length = resumeText.length();

        if (length > 2000) {
            score += 10;
        } else if (length > 1200) {
            score += 8;
        } else if (length > 800) {
            score += 5;
        }

        return Math.min(score, 100);
    }
}