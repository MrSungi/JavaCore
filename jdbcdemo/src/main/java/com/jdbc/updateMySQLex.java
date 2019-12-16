package com.jdbc;
import java.sql.*;

public class updateMySQLex {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "\u006C\u0065\u0062\u0065\u0064\u0061\u0073\u0037\u0034\u0031";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM jdbcdemo.user")){
            int cnt = stmt.executeUpdate("DELETE FROM jdbcdemo.user WHERE id = 88"); {
                System.out.println("Deleted rows: " + cnt);
            }} catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }





