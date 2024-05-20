import java.sql.*;

public class MySQLJDBC {
    private static Statement statement = null;

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");) {
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            readAll();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public static void readAll() throws SQLException {
        //Список всех служащих
        ResultSet rs = statement.executeQuery("select name from character");
        while (rs.next())
            System.out.printf("name: %s%n", rs.getString("name"));
    }
}
