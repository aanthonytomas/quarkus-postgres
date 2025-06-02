package com.example;

import io.agroal.api.AgroalDataSource;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Path("/hello")
public class GreetingResource {

    @Inject
    AgroalDataSource dataSource;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws SQLException {
        try (Connection connection = dataSource.getConnection();
             Statement stmt = connection.createStatement()) {
            // Test the connection with a simple query
            stmt.execute("SELECT 1");
            return "Successfully connected to the database!";
        } catch (SQLException e) {
            return "Failed to connect to the database: " + e.getMessage();
        }
    }
}
