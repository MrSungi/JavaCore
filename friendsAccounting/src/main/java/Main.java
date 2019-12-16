import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main  {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:friendsaccounting.db");

        ExpenseStorage expenseStorage = new ExpenseStorage(connection);
        try {    expenseStorage.createTable();
        } catch (SQLException exception){
            System.out.println("Table creation failed. Maybe it exists already.");
        }

        Expense exp1 = new Expense();
        exp1.setUuid("8");
        exp1.setPayer("Ignas");
        exp1.setDate(Date.valueOf("2019-07-13"));
        exp1.setAmount(15);
        exp1.setDescription("Burger");
        expenseStorage.insert(exp1);

        Expense exp2 = new Expense();
        exp2.setUuid("10");
        exp2.setPayer("Jonas");
        exp2.setDate(Date.valueOf("2019-07-14"));
        exp2.setAmount(16);
        exp2.setDescription("Drink");
        expenseStorage.insert(exp2);
        expenseStorage.update(exp2);


        List<Expense> expenses = expenseStorage.findAll();
        System.out.println(expenses);


    }
}
