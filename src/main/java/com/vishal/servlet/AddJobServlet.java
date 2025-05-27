package com.vishal.servlet;

import com.vishal.dao.JobDAO;
import com.vishal.model.JobApplication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/add-job")
public class AddJobServlet extends HttpServlet {
    private JobDAO jobDAO;
    private static final Logger LOGGER = Logger.getLogger(AddJobServlet.class.getName());

    @Override
    public void init() throws ServletException {
        super.init();
        jobDAO = new JobDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String position = request.getParameter("position");
        String company = request.getParameter("company");
        String status = request.getParameter("status");
        String dateAppliedStr = request.getParameter("dateApplied");

        // Validate required fields
        if (position == null || position.trim().isEmpty() ||
                company == null || company.trim().isEmpty() ||
                status == null || status.trim().isEmpty() ||
                dateAppliedStr == null || dateAppliedStr.trim().isEmpty()) {

            request.setAttribute("errorMessage", "All fields are required.");
            request.getRequestDispatcher("add-job.jsp").forward(request, response);
            return;
        }

        Date dateApplied;
        try {
            dateApplied = new SimpleDateFormat("yyyy-MM-dd").parse(dateAppliedStr);
        } catch (ParseException e) {
            LOGGER.log(Level.WARNING, "Date parsing error: " + dateAppliedStr, e);
            request.setAttribute("errorMessage", "Invalid date format. Please use YYYY-MM-DD.");
            request.getRequestDispatcher("add-job.jsp").forward(request, response);
            return;
        }

        // Create JobApplication using constructor (no setters needed)
        JobApplication newJob = new JobApplication(position.trim(), company.trim(), status.trim(), dateApplied);

        try {
            jobDAO.insertJob(newJob);
            response.sendRedirect("jobs");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error saving job application", e);
            request.setAttribute("errorMessage", "An error occurred while saving the job application.");
            request.getRequestDispatcher("add-job.jsp").forward(request, response);
        }
    }
}
