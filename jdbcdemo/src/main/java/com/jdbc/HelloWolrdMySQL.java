package com.jdbc;
import java.sql.*;

public class HelloWolrdMySQL {

    public static void main(String[] args) {


        // CREATE DATABASE jdbcdemo;
        // USE    jdbcdemo;
        // CREATE TABLE `user` (
        //     `id` bigint(20) NOT NULL AUTO_INCREMENT,
        //     `birthdate` date DEFAULT NULL,
        //     `height` int(11) NOT NULL,
        //     `name` varchar(255) DEFAULT NULL,
        //     `email` varchar(255) DEFAULT NULL,
        //     `country` varchar(255) DEFAULT NULL,
        //     PRIMARY KEY (`id`)
        // ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_lithuanian_ci;

        // Showcase data generation with online tools: http://filldb.info

        String url = "jdbc:mysql://localhost:3306/jdbcdemo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "\u006C\u0065\u0062\u0065\u0064\u0061\u0073\u0037\u0034\u0031";

        // OLD WAY: see the other file

        // NEW WAY - using try with resources (it destroys all what's in try(??) resources if it successfully compiles code without exception)
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM jdbcdemo.user")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String date = rs.getString("birthdate");
                String height = rs.getString("height");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                System.out.println(id + "\t| " + date + "\t| " + height + "\t| " + name + "\t| " + email + "\t| " + country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}