import java.awt.*;
import java.sql.*;

public class H2JDBC {
    private static Statement statement = null;

    public static void main(String[] args) throws SQLException {
        try(
                Connection connection = DriverManager.getConnection("jdbc:h2:C:\\Users\\gk\\Desktop\\untitled\\H2\\src\\main\\resources\\dbase.db","sa","");
        )
        {
            statement = connection.createStatement();
            //create();
            //update();
            //delete();
            readAll();
        }
        catch(SQLException e)
        {
            e.printStackTrace(System.err);
        }
    }

    public static void readAll() throws SQLException {

        statement.setQueryTimeout(30);  // set timeout to 30 sec.
        //Список всех служащих
        ResultSet rs = statement.executeQuery("select name from character");
        while(rs.next())
            System.out.printf("name: %s, %n",rs.getString("name"));
    }

    public static void create() throws SQLException {

        statement.setQueryTimeout(30);  // set timeout to 30 sec.
        String sql = "INSERT INTO employer(name, salary) VALUES ('Zara', 100)";
        statement.executeUpdate(sql);
    }

    public static void update() throws SQLException {

        statement.setQueryTimeout(30);  // set timeout to 30 sec.
        String sql = "UPDATE employer SET salary = 200 WHERE name='Zara'";
        statement.executeUpdate(sql);
    }

    public static void delete() throws SQLException {

        statement.setQueryTimeout(30);  // set timeout to 30 sec.
        String sql = "delete from employer WHERE name='Zara'";
        statement.executeUpdate(sql);
    }
}

