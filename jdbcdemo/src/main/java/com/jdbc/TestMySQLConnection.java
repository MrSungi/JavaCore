package com.jdbc;

import java.sql.*;

public class TestMySQLConnection {

    static String username = "root";
    static String password = "\u006C\u0065\u0062\u0065\u0064\u0061\u0073\u0037\u0034\u0031";
    // static String dbUrl = "jdbc:mysql://localhost:3306/world";
    static String dbUrl = "jdbc:mysql://127.0.0.1:3306/jdbcdemo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static void main(String[] args) throws SQLException, InterruptedException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, username, password);

            System.out.println("Connection Established to MYSQL Database");

            // PreparedStatement stmt = conn.prepareStatement("SELECT table_name FROM information_schema.tables WHERE table_schema='jdbcdemo'");
            //PreparedStatement stmt = conn.prepareStatement("select table_schema, table_name from information_schema.tablesx;");
            PreparedStatement stmt = conn.prepareStatement("select * from jdbcdemo.user;");
            ResultSet rslt = stmt.executeQuery();

            while (rslt.next()) {
                System.out.format("|%-" + "4s|",  rslt.getString(1));
                System.out.format("|%-" + "10s|  ",  rslt.getString(2));
                System.out.format("|%-" + "4s|",  rslt.getString(3));
                System.out.format("|%-" + "13s|",  rslt.getString(4));
                System.out.format("|%-" + "30s|",  rslt.getString(5));
                System.out.format("|%-" + "3s|\n",  rslt.getString(6)); // Column Index out of range, 2 > 1.
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println("Error :" + e.getMessage());
            System.err.println("Error Code :" + e.getErrorCode());
        } finally{
            conn.close();
        }
    }
}