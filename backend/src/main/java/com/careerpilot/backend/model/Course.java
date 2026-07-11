package com.careerpilot.backend.model;

public class Course {

    private String title;
    private String provider;
    private String reason;

    public Course(
            String title,
            String provider,
            String reason) {

        this.title = title;
        this.provider = provider;
        this.reason = reason;
    }

    public String getTitle() {
        return title;
    }

    public String getProvider() {
        return provider;
    }

    public String getReason() {
        return reason;
    }
}