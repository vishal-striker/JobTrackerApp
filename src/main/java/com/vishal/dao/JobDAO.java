package com.vishal.dao;

import com.vishal.model.JobApplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/job_tracker";
    private String jdbcUsername = "root";
    private String jdbcPassword = "vishA@123";

    private static final String SELECT_ALL_JOBS = "SELECT id, position, company, status, date_applied FROM job_applications";
    private static final String INSERT_JOB = "INSERT INTO job_applications (position, company, status, date_applied) VALUES (?, ?, ?, ?)";

    // Insert a new job application into the database
    public void insertJob(JobApplication job) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_JOB)) {

            preparedStatement.setString(1, job.getPosition());
            preparedStatement.setString(2, job.getCompany());
            preparedStatement.setString(3, job.getStatus());

            // Convert java.util.Date to java.sql.Date for SQL insert
            if (job.getDateApplied() != null) {
                java.sql.Date sqlDate = new java.sql.Date(job.getDateApplied().getTime());
                preparedStatement.setDate(4, sqlDate);
            } else {
                preparedStatement.setDate(4, null);
            }

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("❌ SQL Error while inserting job:");
            e.printStackTrace();
        }
    }

    // Get all job applications from the database
    public List<JobApplication> getAllJobs() {
        List<JobApplication> jobs = new ArrayList<>();

        System.out.println("📦 [DEBUG] Fetching jobs from database...");

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_JOBS)) {

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String position = rs.getString("position");
                String company = rs.getString("company");
                String status = rs.getString("status");
                Date dateApplied = rs.getDate("date_applied"); // java.sql.Date from DB

                // Convert java.sql.Date to java.util.Date
                java.util.Date utilDateApplied = null;
                if (dateApplied != null) {
                    utilDateApplied = new java.util.Date(dateApplied.getTime());
                }

                JobApplication job = new JobApplication(id, position, company, status, utilDateApplied);
                jobs.add(job);
            }

        } catch (SQLException e) {
            System.out.println("❌ SQL Error while fetching jobs:");
            e.printStackTrace();
        }

        System.out.println("📋 Number of jobs fetched: " + jobs.size());

        return jobs;
    }
}
