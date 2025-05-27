package com.vishal.model;

import java.util.Date;

public class JobApplication {
    private int id;  // optional, if you use DB auto-generated ID
    private String position;
    private String company;
    private String status;
    private Date dateApplied;

    // Constructor without id (for new jobs before DB assign id)
    public JobApplication(String position, String company, String status, Date dateApplied) {
        this.position = position;
        this.company = company;
        this.status = status;
        this.dateApplied = dateApplied;
    }

    // Constructor with id (optional, if needed)
    public JobApplication(int id, String position, String company, String status, Date dateApplied) {
        this.id = id;
        this.position = position;
        this.company = company;
        this.status = status;
        this.dateApplied = dateApplied;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public String getCompany() {
        return company;
    }

    public String getStatus() {
        return status;
    }

    public Date getDateApplied() {
        return dateApplied;
    }

    // Setters (optional, add if needed for other operations)
    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDateApplied(Date dateApplied) {
        this.dateApplied = dateApplied;
    }
}
