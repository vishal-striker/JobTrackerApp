package com.vishal.servlet;

import com.vishal.dao.JobDAO;
import com.vishal.model.JobApplication;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/jobs")  // Servlet mapped to handle /jobs URL
public class JobServlet extends HttpServlet {
    private JobDAO jobDAO;

    @Override
    public void init() throws ServletException {
        jobDAO = new JobDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get filter parameters from request
        String positionFilter = request.getParameter("position");
        String companyFilter = request.getParameter("company");
        String statusFilter = request.getParameter("status");

        // Get sorting parameters from request
        String sortField = request.getParameter("sort");
        String sortOrder = request.getParameter("order");

        // Set default sorting if not provided
        if (sortField == null || sortField.isEmpty()) {
            sortField = "id";
        }
        if (sortOrder == null || sortOrder.isEmpty()) {
            sortOrder = "asc";
        }

        // Fetch filtered and sorted jobs from DAO
        List<JobApplication> jobs = jobDAO.getJobsFilteredSorted(positionFilter, companyFilter, statusFilter, sortField, sortOrder);

        // Debug output to console
        System.out.println("Filtered and sorted jobs count: " + jobs.size());
        for (JobApplication job : jobs) {
            System.out.println("Job ID: " + job.getId());
            System.out.println("Company: " + job.getCompany());
            System.out.println("Position: " + job.getPosition());
            System.out.println("Status: " + job.getStatus());
            System.out.println("-----------------------------");
        }

        // Pass the data and filter/sort params to JSP
        request.setAttribute("jobs", jobs);
        request.setAttribute("position", positionFilter);
        request.setAttribute("company", companyFilter);
        request.setAttribute("status", statusFilter);
        request.setAttribute("sort", sortField);
        request.setAttribute("order", sortOrder);

        // Forward to jobs.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("jobs.jsp");
        dispatcher.forward(request, response);
    }
}
