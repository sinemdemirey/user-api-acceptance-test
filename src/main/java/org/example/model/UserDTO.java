package org.example.model;

public class UserDTO {
    private String name;
    private String job;

    public String getName() {
        return name;
    }

    public UserDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getJob() {
        return job;
    }

    public UserDTO setJob(String job) {
        this.job = job;
        return this;
    }
}
