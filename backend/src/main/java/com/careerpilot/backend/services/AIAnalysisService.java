package com.careerpilot.backend.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class AIAnalysisService {

    @Value("${groq.api.key}")
    private String apiKey;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String analyzeResume(String resumeText) {

        try {

            WebClient webClient = WebClient.builder()
                    .baseUrl("https://api.groq.com")
                    .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .build();

            String prompt = """
                    You are CareerPilot AI, an expert career coach.

                    Analyze this resume and provide:

                    📌 CAREER SNAPSHOT

                    💪 STRENGTHS

                    ⚠️ AREAS FOR IMPROVEMENT

                    📈 ATS OPTIMIZATION TIPS

                    🎯 CAREER MATCH ANALYSIS

                    🚀 RESUME IMPROVEMENTS

                    🛠 CAREER ROADMAP

                    💰 SALARY OUTLOOK

                    🌟 FINAL CAREER INSIGHT

                    Resume:
                    """ + resumeText;

            Map<String, Object> requestBody = Map.of(
                    "model", "llama-3.3-70b-versatile",
                    "messages", List.of(
                            Map.of(
                                    "role", "user",
                                    "content", prompt
                            )
                    ),
                    "temperature", 0.7,
                    "max_tokens", 2000
            );

            String response = webClient.post()
                    .uri("/openai/v1/chat/completions")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            System.out.println("Groq Response: " + response);

            JsonNode root = objectMapper.readTree(response);

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