public boolean insertJob(JobApplication job) {
    String url = "jdbc:mysql://localhost:3306/job_tracker";
    String username = "root";
    String password = "vishA@123";

    String sql = "INSERT INTO jobs (company, position, date_applied, status) VALUES (?, ?, ?, ?)";

    try (Connection conn = DriverManager.getConnection(url, username, password);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, job.getCompany());
        pstmt.setString(2, job.getPosition());
        pstmt.setString(3, job.getDateApplied()); // If using Date, use setDate()
        pstmt.setString(4, job.getStatus());

int affectedRows = pstmt.executeUpdate();
return affectedRows > 0;

} catch (SQLException e) {
        e.printStackTrace();
}
    return false;
}
