import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqliteJDBC {
    public static void main(String[] args)
    {

        List<Employer> employers = new ArrayList<>();
        try(
                // create a database connection
                Connection connection = DriverManager.getConnection("jdbc:sqlite:Sqlite/src/main/resources/employers.db");
                Statement statement = connection.createStatement();
                )
        {
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            //Список всех таблиц в базе данных
            ResultSet rs1 = statement.executeQuery("SELECT * FROM sqlite_master WHERE type='table'");
            while(
rs1.next())
                System.out.println(rs1.getString("name"));

            //Список всех служащих
            ResultSet rs = statement.executeQuery("select name,salary from employer");
            while(
rs.next())
                employers.add(new Employer(rs.getString("name"), rs.getFloat("salary")));
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            e.printStackTrace(System.err);
        }
employers.stream().forEach(System.out::println);

    }
} 