package com.careerpilot.backend.controller;

import com.careerpilot.backend.services.ATSScoreService;
import com.careerpilot.backend.repository.CareerRoleRepository;
import com.careerpilot.backend.model.CareerRole;
import com.careerpilot.backend.services.SkillGapService;
import com.careerpilot.backend.services.CourseRecommendationService;
import com.careerpilot.backend.model.Course;
import com.careerpilot.backend.services.CareerMatchService;
import com.careerpilot.backend.services.AIAnalysisService;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

import com.careerpilot.backend.model.CareerRole;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins = "https://careerpilot-ai-ynes-git-main-shubhod626s-projects.vercel.app/")
public class ResumeController {

        private final AIAnalysisService aiService;
        private final CareerMatchService careerMatchService;
        private final CourseRecommendationService courseRecommendationService;
        private final CareerRoleRepository careerRoleRepository;
        private final SkillGapService skillGapService;
        private final ATSScoreService atsScoreService;

        public ResumeController(
                        AIAnalysisService aiService,
                        CareerMatchService careerMatchService,
                        CourseRecommendationService courseRecommendationService,
                        CareerRoleRepository careerRoleRepository,
                        SkillGapService skillGapService,
                        ATSScoreService atsScoreService) {

                this.aiService = aiService;
                this.careerMatchService = careerMatchService;
                this.courseRecommendationService = courseRecommendationService;
                this.careerRoleRepository = careerRoleRepository;
                this.skillGapService = skillGapService;
                this.atsScoreService = atsScoreService;
        }

        @PostMapping("/upload")
        public ResponseEntity<?> uploadResume(
                        @RequestParam("file") MultipartFile file) {

                try {

                        PDDocument document = Loader.loadPDF(file.getBytes());

                        PDFTextStripper stripper = new PDFTextStripper();

                        String text = stripper.getText(document);

                        document.close();

                        String resumeText = text.toLowerCase();

                        String[] skillDatabase = {
                                        "java",
                                        "python",
                                        "sql",
                                        "spring boot",
                                        "react",
                                        "javascript",
                                        "html",
                                        "css",
                                        "git",
                                        "github",
                                        "docker",
                                        "aws",
                                        "azure",
                                        "power bi",
                                        "machine learning",
                                        "data analysis",
                                        "pandas",
                                        "numpy",
                                        "mysql",
                                        "mongodb",
                                        "spark",
                                        "airflow",
                                        "tensorflow",
                                        "pytorch",
                                        "langchain",
                                        "vector database",
                                        "kubernetes",
                                        "linux",
                                        "excel",
                                        "node.js",
                                        "security",
                                        "networking"
                        };

                        List<String> foundSkills = new ArrayList<>();

                        for (String skill : skillDatabase) {

                                if (resumeText.contains(skill)) {

                                        foundSkills.add(skill);
                                }
                        }

                        int atsScore = atsScoreService.calculateATSScore(
                                        resumeText,
                                        foundSkills);

                        List<Map<String, Object>> careerMatches = careerMatchService.getCareerMatches(
                                        foundSkills);

                        List<String> recommendedRoles = new ArrayList<>();

                        for (Map<String, Object> career : careerMatches) {

                                int score = (Integer) career.get(
                                                "matchScore");

                                if (score >= 50) {

                                        recommendedRoles.add(
                                                        career.get("role")
                                                                        .toString());
                                }
                        }

                        // TOP 3 ROLE SKILL GAP ANALYSIS

                        Set<String> requiredSkills = new HashSet<>();

                        List<String> missingSkills = new ArrayList<>();

                        List<Map<String, Object>> recommendedCourses = new ArrayList<>();

                        for (int i = 0; i < Math.min(
                                        3,
                                        careerMatches.size()); i++) {

                                String roleName = careerMatches.get(i)
                                                .get("role")
                                                .toString();

                                CareerRole role = careerRoleRepository.getRoles()
                                                .stream()
                                                .filter(r -> r.getRole()
                                                                .equals(roleName))
                                                .findFirst()
                                                .orElse(null);

                                if (role != null) {

                                        requiredSkills.addAll(
                                                        role.getRequiredSkills());
                                        System.out.println("Required Skills: " + requiredSkills);
                                        System.out.println("Found Skills: " + foundSkills);

                                        List<String> skillGaps = skillGapService.findMissingSkills(
                                                        foundSkills,
                                                        role);

                                        if (skillGaps.isEmpty()) {

                                                for (String courseName : role.getRecommendedCourses()) {

                                                        Map<String, Object> course = new HashMap<>();

                                                        course.put(
                                                                        "course",
                                                                        courseName);

                                                        course.put(
                                                                        "missingSkill",
                                                                        "Advanced Learning");

                                                        recommendedCourses.add(
                                                                        course);
                                                }

                                        } else {

                                                recommendedCourses.addAll(
                                                                courseRecommendationService
                                                                                .recommendCourses(
                                                                                                role,
                                                                                                skillGaps));
                                        }
                                }
                        }

                        for (String skill : requiredSkills) {

                                boolean found = foundSkills.stream()
                                                .anyMatch(s -> s.equalsIgnoreCase(skill));

                                if (!found) {
                                        missingSkills.add(skill);
                                }
                        }
                        if (missingSkills.isEmpty()) {

                                Set<String> nextLevelSkills = new HashSet<>();

                                for (int i = 0; i < Math.min(3, careerMatches.size()); i++) {

                                        String roleName = careerMatches.get(i)
                                                        .get("role")
                                                        .toString();

                                        CareerRole role = careerRoleRepository.getRoles()
                                                        .stream()
                                                        .filter(r -> r.getRole()
                                                                        .equals(roleName))
                                                        .findFirst()
                                                        .orElse(null);

                                        if (role != null) {

                                                nextLevelSkills.addAll(
                                                                role.getAdvancedSkills());
                                        }
                                }

                                nextLevelSkills.removeIf(
                                                skill -> foundSkills.stream()
                                                                .anyMatch(s -> s.equalsIgnoreCase(skill)));

                                missingSkills.addAll(nextLevelSkills);
                        }

                        String aiFeedback = aiService.analyzeResume(
                                        text.substring(
                                                        0,
                                                        Math.min(
                                                                        text.length(),
                                                                        4000)));

                        Map<String, Object> response = new HashMap<>();

                        response.put(
                                        "fileName",
                                        file.getOriginalFilename());

                        response.put(
                                        "fileSize",
                                        file.getSize());

                        response.put(
                                        "status",
                                        "Analysis Completed");
                        System.out.println("ATS Score = " + atsScore);

                        response.put(
                                        "atsScore",
                                        atsScore);

                        response.put(
                                        "skillsFound",
                                        foundSkills);

                        response.put(
                                        "missingSkills",
                                        missingSkills);
                        System.out.println("Missing Skills: " + missingSkills);
                        response.put(
                                        "recommendedRoles",
                                        recommendedRoles);

                        response.put(
                                        "careerMatches",
                                        careerMatches);

                        response.put(
                                        "recommendedCourses",
                                        recommendedCourses);

                        response.put(
                                        "aiFeedback",
                                        aiFeedback);

                        response.put(
                                        "resumePreview",
                                        text.substring(
                                                        0,
                                                        Math.min(
                                                                        text.length(),
                                                                        500)));
                        System.out.println("Missing Skills: " + missingSkills);
                        return ResponseEntity.ok(
                                        response);

                } catch (Exception e) {

                        Map<String, String> error = new HashMap<>();

                        error.put(
                                        "error",
                                        e.getMessage());

                        return ResponseEntity
                                        .badRequest()
                                        .body(error);
                }
        }
}