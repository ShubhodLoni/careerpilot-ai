package com.careerpilot.backend.controller;

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

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins = "http://localhost:3000")
public class ResumeController {

    @PostMapping("/upload")
    public ResponseEntity<?> uploadResume(
            @RequestParam("file") MultipartFile file
    ) {

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
                    "mongodb"
            };

            List<String> foundSkills = new ArrayList<>();

            for (String skill : skillDatabase) {
                if (resumeText.contains(skill.toLowerCase())) {
                    foundSkills.add(skill);
                }
            }

            int atsScore = Math.min(foundSkills.size() * 5, 100);

            List<String> missingSkills = new ArrayList<>();

            String[] importantSkills = {
                    "docker",
                    "aws",
                    "azure",
                    "spring boot",
                    "react",
                    "git"
            };

            for (String skill : importantSkills) {
                if (!foundSkills.contains(skill)) {
                    missingSkills.add(skill);
                }
            }

            List<String> recommendedRoles = new ArrayList<>();

            if (foundSkills.contains("java")
                    && foundSkills.contains("spring boot")) {

                recommendedRoles.add("Backend Developer");
                recommendedRoles.add("Java Developer");
            }

            if (foundSkills.contains("sql")
                    || foundSkills.contains("power bi")
                    || foundSkills.contains("data analysis")) {

                recommendedRoles.add("Data Analyst");
                recommendedRoles.add("Data Engineer");
            }

            if (foundSkills.contains("python")
                    || foundSkills.contains("machine learning")) {

                recommendedRoles.add("Data Scientist");
                recommendedRoles.add("ML Engineer");
            }

            List<String> careerRoadmap = new ArrayList<>();

            for (String skill : missingSkills) {

                switch (skill.toLowerCase()) {

                    case "docker":
                        careerRoadmap.add(
                                "Learn Docker and containerization basics"
                        );
                        break;

                    case "aws":
                        careerRoadmap.add(
                                "Learn AWS Cloud fundamentals"
                        );
                        break;

                    case "azure":
                        careerRoadmap.add(
                                "Learn Microsoft Azure services"
                        );
                        break;

                    case "spring boot":
                        careerRoadmap.add(
                                "Build a REST API using Spring Boot"
                        );
                        break;

                    case "react":
                        careerRoadmap.add(
                                "Build a frontend project using React"
                        );
                        break;
                }
            }

            careerRoadmap.add(
                    "Build at least 2 portfolio projects"
            );

            careerRoadmap.add(
                    "Apply for internships and entry-level roles"
            );

            Map<String, Object> response = new HashMap<>();

            response.put("fileName", file.getOriginalFilename());
            response.put("fileSize", file.getSize());
            response.put("status", "Analysis Completed");
            response.put("atsScore", atsScore);
            response.put("skillsFound", foundSkills);
            response.put("missingSkills", missingSkills);
            response.put("recommendedRoles", recommendedRoles);
            response.put("careerRoadmap", careerRoadmap);

            response.put(
                    "resumePreview",
                    text.substring(
                            0,
                            Math.min(text.length(), 500)
                    )
            );

            return ResponseEntity.ok(response);

        } catch (Exception e) {

            Map<String, String> error = new HashMap<>();

            error.put("error", e.getMessage());

            return ResponseEntity.badRequest().body(error);
        }
    }
}