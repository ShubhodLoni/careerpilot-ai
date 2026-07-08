package com.careerpilot.backend.controller;

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

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins = "http://localhost:3000")
public class ResumeController {

    private final AIAnalysisService aiService;
    private final CareerMatchService careerMatchService;

    public ResumeController(
            AIAnalysisService aiService,
            CareerMatchService careerMatchService) {

        this.aiService = aiService;
        this.careerMatchService = careerMatchService;
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
                    "mongodb"
            };

            List<String> foundSkills = new ArrayList<>();

            for (String skill : skillDatabase) {
                if (resumeText.contains(skill)) {
                    foundSkills.add(skill);
                }
            }
            List<Map<String, Object>> careerMatches =
        careerMatchService.getCareerMatches(foundSkills);

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

for (Map<String, Object> career : careerMatches) {

    int score = (Integer) career.get("matchScore");

    if (score >= 50) {
        recommendedRoles.add(
                career.get("role").toString()
        );
    }
}

         

           

            String aiFeedback = aiService.analyzeResume(
                    text.substring(
                            0,
                            Math.min(text.length(), 4000)));

            Map<String, Object> response = new HashMap<>();

            response.put("fileName",
                    file.getOriginalFilename());

            response.put("fileSize",
                    file.getSize());

            response.put("status",
                    "Analysis Completed");

            response.put("atsScore",
                    atsScore);

            response.put("skillsFound",
                    foundSkills);

            response.put("missingSkills",
                    missingSkills);

           

            response.put("careerMatches",
                    careerMatches);

           
            

            response.put("aiFeedback",
                    aiFeedback);

            response.put(
                    "resumePreview",
                    text.substring(
                            0,
                            Math.min(text.length(), 500)));

            return ResponseEntity.ok(response);

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