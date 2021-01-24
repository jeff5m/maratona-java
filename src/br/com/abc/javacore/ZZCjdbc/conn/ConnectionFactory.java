package br.com.abc.javacore.ZZCjdbc.conn;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
    //    java.sql main interfaces and classes:
//      DriverManager (class that search for the specific connector for the DB and returns a Connection),
//      Connection (get connection with DB),
//      Statement (responsible for operation that will change Db state),
//      ResultSet (responsible for query results)
    public static Connection getConnection() {
        String url = System.getenv("MYSQL_URL");
        String username = System.getenv("MYSQL_USERNAME");
        String password = System.getenv("MYSQL_PASSWORD");
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection, Statement statement) {
        close(connection);
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
