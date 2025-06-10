# Use a base image with Java and Tomcat
FROM tomcat:9.0-jdk17

# Remove default webapps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your WAR file to Tomcat and rename to ROOT.war
COPY target/job-tracker-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
