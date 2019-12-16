package com.jdbc;
import java.sql.*;
import java.util.Scanner;

public class TestTransactionManagement {
    static String username = "root";
    static String password = "\u006C\u0065\u0062\u0065\u0064\u0061\u0073\u0037\u0034\u0031";
    // static String dbUrl = "jdbc:mysql://localhost:3306/world";
    static String dbUrl = "jdbc:mysql://127.0.0.1:3306/jdbcdemo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";





    public static void main(String[] args) throws SQLException {

        Connection conn;
        try{
            conn = DriverManager.getConnection(dbUrl, username, password);
            conn.setAutoCommit(false);

            PreparedStatement pstmt = null;
            Scanner scanner = new Scanner(System.in);

            System.out.println("PSBank Transactions");
            System.out.println("----------------------");
            System.out.print("Enter From Account # :");
            int fromAcno = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter To Account # : ");
            int toAcno = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Amount To Transfer : ");
            double amount = Double.parseDouble(scanner.nextLine());

            String withdrawSQL = "Update PSBank set Amount = Amount - ? where Acno = ?";
            pstmt = conn.prepareStatement(withdrawSQL);
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, fromAcno);
            pstmt.executeUpdate();

            String depositSQL = "Update PSBank set Amount = Amount + ? where Acno = ?";
            pstmt = conn.prepareStatement(depositSQL);
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, toAcno);
            pstmt.executeUpdate();

            String sql = "Select Amount From PSBank where Acno = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, fromAcno);
            ResultSet rs = pstmt.executeQuery();
            double balanceAmount = 0;
            if(rs.next()){
                balanceAmount = rs.getDouble("Amount");
            }

            if(balanceAmount >= 5000){
                conn.commit();
                System.out.println("Amount Transferred Successfully...");
            } else{
                conn.rollback();
                System.out.println("Insufficient Funds : " + balanceAmount + " Transactions Rollbacked..");
            }

            scanner.close();
            pstmt.close();
            conn.close();
        } catch(Exception ex){
            System.err.println(ex.getMessage());
        } finally {

        }
    }
}
