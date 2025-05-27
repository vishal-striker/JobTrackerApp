package com.vishal;
import com.vishal.dao.JobDAO;
import com.vishal.model.JobApplication;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JobDAO dao = new JobDAO();
        List<JobApplication> jobs = dao.getAllJobs();

        if (jobs.isEmpty()) {
            System.out.println("No jobs found.");
        } else {
            for (JobApplication job : jobs) {
                System.out.println("ID: " + job.getId() +
                        ", Company: " + job.getCompany() +
                        ", Position: " + job.getPosition() +
                        ", Applied: " + job.getDateApplied() +
                        ", Status: " + job.getStatus());
            }
        }
    }
}
