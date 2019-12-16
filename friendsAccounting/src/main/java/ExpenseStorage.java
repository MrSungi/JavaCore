import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ExpenseStorage {
    private Connection connection;

    public ExpenseStorage(Connection connection) {
        this.connection = connection;
    }

    public void createTable() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "create table expense (" +
                        "uuid text primary key, " +
                        "payer text, " +
                        "date date, " +
                        "amount double, " +
                        "description text)");
        preparedStatement.execute();
    }

    public Expense insert(Expense expense) throws SQLException {
        String uuid = UUID.randomUUID().toString();

        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into expense (uuid, payer, date, amount, description)" +
                        " values (?, ?, ?, ?, ?)");
        preparedStatement.setString(1, uuid);
        preparedStatement.setString(2, expense.getPayer());
        preparedStatement.setDate(3, expense.getDate());
        preparedStatement.setDouble(4, expense.getAmount());
        preparedStatement.setString(5, expense.getDescription());
        preparedStatement.execute();

        expense.setUuid(uuid);
        return expense;
    }

    public Expense findOne(String uuid) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from expense where uuid = ?");
        preparedStatement.setString(1, uuid);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (!resultSet.next()) {
            return null;
        }

        return buildExpense(resultSet);
    }

    public List<Expense> findAll() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from expense");
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Expense> expenses = new ArrayList<>();
        while (resultSet.next()) {
            expenses.add(buildExpense(resultSet));
        }

        return expenses;
    }

    public void update(Expense expense) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "update expense set" +
                        " payer = ?," +
                        " date = ?," +
                        " amount = ?," +
                        " description = ?" +
                        " where uuid = ?");

        preparedStatement.setString(1, expense.getPayer());
        preparedStatement.setDate(2, expense.getDate());
        preparedStatement.setDouble(3, expense.getAmount());
        preparedStatement.setString(4, expense.getDescription());

        preparedStatement.setString(5, expense.getUuid());

        preparedStatement.execute();
    }

    private Expense buildExpense(ResultSet resultSet) throws SQLException {
        Expense expense = new Expense();
        expense.setUuid(resultSet.getString("uuid"));
        expense.setPayer(resultSet.getString("payer"));
        expense.setDate(resultSet.getDate("date"));
        expense.setAmount(resultSet.getDouble("amount"));
        expense.setDescription(resultSet.getString("description"));

        return expense;
    }
}