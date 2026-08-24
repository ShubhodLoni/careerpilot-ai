package com.careerpilot.backend.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

@Service
public class AIAnalysisService {

        @Value("${groq.api.key}")
        private String apiKey;

        public String analyzeResume(String resumeText) {

                try {
                        System.out.println("Groq Key Loaded: " + (apiKey != null));

                        WebClient webClient = WebClient.builder()
                                        .baseUrl("https://api.groq.com/openai/v1")
                                        .build();

                        String prompt = """
                                        You are CareerPilot AI, an expert career coach.

                                        Analyze the resume and provide a detailed report.

                                        Use emojis in section titles.

                                        Return plain text only.

                                        📌 CAREER SNAPSHOT

                                        💪 STRENGTHS

                                        ⚠️ AREAS FOR IMPROVEMENT

                                        📈 ATS OPTIMIZATION TIPS

                                        🎯 CAREER MATCH ANALYSIS

                                        For each role provide:
                                        • Match %
                                        • Why it fits

                                        🚀 RESUME IMPROVEMENTS

                                        Provide 5 highly personalized suggestions.

                                        🛠 CAREER ROADMAP

                                        📅 Next 30 Days

                                        📅 Next 90 Days

                                        📅 Next 6 Months

                                        📅 Next 1 Year

                                        Include:
                                        • Skills to learn
                                        • Projects to build
                                        • Certifications
                                        • Internship preparation
                                        • Interview preparation

                                        💰 SALARY OUTLOOK

                                        🌟 FINAL CAREERPILOT INSIGHT

                                        Important:
                                        - Be specific to the resume.
                                        - Do NOT use markdown symbols like **, ##, or *.
                                        - Use emojis and clean formatting.
                                        - Make suggestions actionable.

                                        Resume:
                                        """ + resumeText;

                        Map<String, Object> request = Map.of(
                                        "model", "llama-3.1-8b-instant",
                                        "messages", new Object[] {
                                                        Map.of(
                                                                        "role", "user",
                                                                        "content", prompt)
                                        });

                        String response = webClient.post()
                                        .uri("/chat/completions")
                                        .header("Authorization", "Bearer " + apiKey)
                                        .bodyValue(request)
                                        .retrieve()
                                        .bodyToMono(String.class)
                                        .block();
                                        System.out.println("Groq Response: " + response);

                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode root = mapper.readTree(response);

                        return root.path("choices")
                                        .get(0)
                                        .path("message")
                                        .path("content")
                                        .asText();

                } catch (Exception e) {
    e.printStackTrace();
    return "AI Analysis Error: " + e.getMessage();
}
        }
}