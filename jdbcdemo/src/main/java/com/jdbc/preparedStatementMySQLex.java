package com.jdbc;
import java.sql.*;

public class preparedStatementMySQLex {


    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "\u006C\u0065\u0062\u0065\u0064\u0061\u0073\u0037\u0034\u0031";

        String sql = "SELECT * FROM jdbcdemo.user WHERE name = ? AND id > ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "Mia");
            stmt.setLong(2, 15);
            System.out.println(stmt);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.print(rs.getString(1) + "\t| ");
                    System.out.print(rs.getString(2) + "\t| ");
                    System.out.print(rs.getString(3) + "\t| ");
                    System.out.print(rs.getString(4) + "\t\t| ");
                    System.out.print(rs.getString(5) + "\t\t| ");
                    System.out.println(rs.getString(6)); // Column Index out of range, 2 > 1
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
