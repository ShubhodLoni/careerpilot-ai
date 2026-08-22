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

        // =========================
        // DATA & ANALYTICS
        // =========================

        roles.add(new CareerRole(
                "Data Analyst",
                "Data & Analytics",
                "₹4-12 LPA",
                Arrays.asList(
                        "sql",
                        "excel",
                        "power bi",
                        "python"
                ),
                Arrays.asList(
                        "Advanced SQL",
                        "Power BI Masterclass",
                        "Excel for Data Analytics"
                ),
                Arrays.asList(
                        "tableau",
                        "statistics",
                        "etl",
                        "data modeling",
                        "business intelligence"
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
                ),
                Arrays.asList(
                        "Business Analysis Fundamentals",
                        "Power BI Dashboarding",
                        "Advanced Excel"
                ),
                Arrays.asList(
                        "stakeholder management",
                        "agile",
                        "jira",
                        "requirement gathering",
                        "product analytics"
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
                ),
                Arrays.asList(
                        "Machine Learning Specialization",
                        "Data Science with Python",
                        "Advanced SQL"
                ),
                Arrays.asList(
                        "tensorflow",
                        "pytorch",
                        "aws",
                        "docker",
                        "mlops"
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
                ),
                Arrays.asList(
                        "AWS Cloud Practitioner",
                        "Apache Spark Fundamentals",
                        "Apache Airflow Essentials"
                ),
                Arrays.asList(
                        "kafka",
                        "snowflake",
                        "databricks",
                        "terraform",
                        "azure"
                )
        ));

        roles.add(new CareerRole(
                "Analytics Engineer",
                "Data & Analytics",
                "₹8-18 LPA",
                Arrays.asList(
                        "sql",
                        "python",
                        "power bi"
                ),
                Arrays.asList(
                        "Analytics Engineering",
                        "Data Modeling",
                        "Advanced SQL"
                ),
                Arrays.asList(
                        "dbt",
                        "snowflake",
                        "bigquery",
                        "airflow",
                        "data warehousing"
                )
        ));

        // =========================
        // SOFTWARE DEVELOPMENT
        // =========================

        roles.add(new CareerRole(
                "Java Developer",
                "Software Development",
                "₹5-18 LPA",
                Arrays.asList(
                        "java",
                        "spring boot",
                        "sql"
                ),
                Arrays.asList(
                        "Spring Boot Masterclass",
                        "REST API Development",
                        "Advanced SQL"
                ),
                Arrays.asList(
                        "microservices",
                        "docker",
                        "redis",
                        "aws",
                        "system design"
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
                ),
                Arrays.asList(
                        "Spring Boot Masterclass",
                        "Docker Essentials",
                        "MySQL Advanced"
                ),
                Arrays.asList(
                        "microservices",
                        "redis",
                        "kubernetes",
                        "aws",
                        "system design"
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
                ),
                Arrays.asList(
                        "React Complete Guide",
                        "JavaScript Advanced",
                        "Node.js Bootcamp"
                ),
                Arrays.asList(
                        "next.js",
                        "typescript",
                        "mongodb",
                        "aws",
                        "system design"
                )
        ));

        roles.add(new CareerRole(
                "Software Engineer",
                "Software Development",
                "₹6-20 LPA",
                Arrays.asList(
                        "java",
                        "python",
                        "git"
                ),
                Arrays.asList(
                        "DSA Masterclass",
                        "System Design Basics",
                        "Git & GitHub"
                ),
                Arrays.asList(
                        "microservices",
                        "cloud computing",
                        "docker",
                        "kubernetes",
                        "design patterns"
                )
        ));

        // =========================
        // AI & MACHINE LEARNING
        // =========================

        roles.add(new CareerRole(
                "AI Engineer",
                "Artificial Intelligence",
                "₹8-25 LPA",
                Arrays.asList(
                        "python",
                        "machine learning",
                        "tensorflow",
                        "pytorch"
                ),
                Arrays.asList(
                        "Deep Learning Specialization",
                        "TensorFlow Developer Course",
                        "PyTorch Fundamentals"
                ),
                Arrays.asList(
                        "rag",
                        "langchain",
                        "vector databases",
                        "llms",
                        "mlops"
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
                ),
                Arrays.asList(
                        "Machine Learning Specialization",
                        "AWS ML Foundations",
                        "Docker Essentials"
                ),
                Arrays.asList(
                        "tensorflow",
                        "pytorch",
                        "kubernetes",
                        "mlops",
                        "feature engineering"
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
                ),
                Arrays.asList(
                        "LangChain Masterclass",
                        "Vector Databases",
                        "Generative AI Engineering"
                ),
                Arrays.asList(
                        "rag",
                        "agents",
                        "llmops",
                        "prompt engineering",
                        "fine tuning"
                )
        ));

        roles.add(new CareerRole(
                "Cloud Engineer",
                "Cloud & DevOps",
                "₹7-20 LPA",
                Arrays.asList(
                        "aws",
                        "azure",
                        "docker",
                        "kubernetes"
                ),
                Arrays.asList(
                        "AWS Cloud Practitioner",
                        "Azure Fundamentals",
                        "Kubernetes for Beginners"
                ),
                Arrays.asList(
                        "terraform",
                        "jenkins",
                        "linux",
                        "monitoring",
                        "gcp"
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
                ),
                Arrays.asList(
                        "Docker Essentials",
                        "Linux Administration",
                        "Git & GitHub Mastery"
                ),
                Arrays.asList(
                        "kubernetes",
                        "terraform",
                        "jenkins",
                        "prometheus",
                        "grafana"
                )
        ));

        // =========================
        // CYBER SECURITY
        // =========================

        roles.add(new CareerRole(
                "Cyber Security Analyst",
                "Cyber Security",
                "₹6-18 LPA",
                Arrays.asList(
                        "networking",
                        "security",
                        "linux"
                ),
                Arrays.asList(
                        "Ethical Hacking",
                        "Network Security Fundamentals",
                        "Linux Security"
                ),
                Arrays.asList(
                        "penetration testing",
                        "siem",
                        "cloud security",
                        "incident response",
                        "soc operations"
                )
        ));

        return roles;
    }
}