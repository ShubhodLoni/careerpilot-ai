package com.careerpilot.backend.repository;

import com.careerpilot.backend.model.CareerRole;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CareerRoleRepository {

    public List<CareerRole> getRoles() {

        List<CareerRole> roles = new ArrayList<>();

        // DATA

        roles.add(new CareerRole(
                "Data Analyst",
                "Data & Analytics",
                "₹4-12 LPA",
                Arrays.asList(
                        "sql",
                        "excel",
                        "power bi",
                        "python"
                )
        ));

        roles.add(new CareerRole(
                "Business Analyst",
                "Data & Analytics",
                "₹5-14 LPA",
                Arrays.asList(
                        "sql",
                        "excel",
                        "power bi"
                )
        ));

        roles.add(new CareerRole(
                "Data Scientist",
                "Data & Analytics",
                "₹6-20 LPA",
                Arrays.asList(
                        "python",
                        "machine learning",
                        "pandas",
                        "numpy",
                        "sql"
                )
        ));

        roles.add(new CareerRole(
                "Data Engineer",
                "Data & Analytics",
                "₹7-22 LPA",
                Arrays.asList(
                        "python",
                        "sql",
                        "spark",
                        "airflow",
                        "aws"
                )
        ));

        // SOFTWARE

        roles.add(new CareerRole(
                "Java Developer",
                "Software Development",
                "₹5-18 LPA",
                Arrays.asList(
                        "java",
                        "spring boot",
                        "sql"
                )
        ));

        roles.add(new CareerRole(
                "Backend Developer",
                "Software Development",
                "₹6-20 LPA",
                Arrays.asList(
                        "java",
                        "spring boot",
                        "mysql",
                        "docker"
                )
        ));

        roles.add(new CareerRole(
                "Full Stack Developer",
                "Software Development",
                "₹6-22 LPA",
                Arrays.asList(
                        "react",
                        "javascript",
                        "html",
                        "css",
                        "node.js"
                )
        ));

        // AI

        roles.add(new CareerRole(
                "AI Engineer",
                "Artificial Intelligence",
                "₹8-25 LPA",
                Arrays.asList(
                        "python",
                        "machine learning",
                        "tensorflow",
                        "pytorch"
                )
        ));

        roles.add(new CareerRole(
                "ML Engineer",
                "Artificial Intelligence",
                "₹8-22 LPA",
                Arrays.asList(
                        "python",
                        "machine learning",
                        "aws",
                        "docker"
                )
        ));

        roles.add(new CareerRole(
                "LLM Engineer",
                "Artificial Intelligence",
                "₹10-30 LPA",
                Arrays.asList(
                        "python",
                        "langchain",
                        "vector database",
                        "llms"
                )
        ));

        // CLOUD

        roles.add(new CareerRole(
                "Cloud Engineer",
                "Cloud & DevOps",
                "₹7-20 LPA",
                Arrays.asList(
                        "aws",
                        "azure",
                        "docker",
                        "kubernetes"
                )
        ));

        roles.add(new CareerRole(
                "DevOps Engineer",
                "Cloud & DevOps",
                "₹8-24 LPA",
                Arrays.asList(
                        "docker",
                        "aws",
                        "linux",
                        "git"
                )
        ));

        // CYBER

        roles.add(new CareerRole(
                "Cyber Security Analyst",
                "Cyber Security",
                "₹6-18 LPA",
                Arrays.asList(
                        "networking",
                        "security",
                        "linux"
                )
        ));

        return roles;
    }
}