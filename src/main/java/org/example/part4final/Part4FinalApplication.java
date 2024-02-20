package org.example.part4final;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

@SpringBootApplication
public class Part4FinalApplication {
    static Connection conn = null;
    public static String password = "Honeymoon21!";
    public static String username = "root";

    public static void main(String[] args) {
        createDatabase();
        connect();
        createMultiChoiceTable();
        SpringApplication.run(Part4FinalApplication.class, args);
    }

    private static void createDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/";

            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection made.");
        } catch (Exception e) {
            //serr
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        try {
            Statement stmt = conn.createStatement();
            String sql;
            sql = "Drop DATABASE IF EXISTS DBQuiz";
            stmt.executeUpdate(sql);
            sql = "CREATE DATABASE DBQuiz";
            stmt.executeUpdate(sql);
            System.out.println("Database made.");
        } catch (SQLException e) {
            System.err.println("Cannot create database.");
            System.err.println(e.getMessage());
        }
    }

    private static void connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/DBQuiz";
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
    }

    private static void createMultiChoiceTable() {
        Statement s;
        try {
            s = conn.createStatement();
            conn.setAutoCommit(false);
            s.executeUpdate("DROP TABLE IF EXISTS multiChoice");
            String createStatement = (
                    "CREATE TABLE multichoice ("
                            + "id INT UNSIGNED NOT NULL AUTO_INCREMENT,"
                            + "PRIMARY KEY (id),"
                            + "multiChoiceQuestion VARCHAR(150), "
                            + "choices VARCHAR(50), "
                            + "answer VARCHAR(50)"
                            + ")"
            );
            System.out.println(createStatement);
            s.executeUpdate(createStatement + " ENGINE = innoDB");
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("SQL error during DROP/CREATE");
            e.printStackTrace();
        }
    }
}
