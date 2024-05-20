import java.sql.*;

public class MySQLJDBC {
    private static Statement statement = null;

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");) {
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            add();
            update();
            readAll();
            updateUniv();

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

    }

    public static void readAll() throws SQLException {
        //Список всех служащих
        ResultSet rs = statement.executeQuery("select name from student");
        while (rs.next())
            System.out.printf("name: %s%n", rs.getString("name"));
    }

    public static void add() throws SQLException {
        String sql = "INSERT INTO student(name) VALUES ('Zara')";
        statement.executeUpdate(sql);
    }

    public static void update() throws SQLException {
        String sql = "update student set surname='Иванова' WHERE name='Zara'";
        statement.executeUpdate(sql);
    }

    public static void updateUniv() throws SQLException {
        String sql = "update student set surname='Иванова', univ_id=4 WHERE name='Zara'";
        statement.executeUpdate(sql);
    }
} 