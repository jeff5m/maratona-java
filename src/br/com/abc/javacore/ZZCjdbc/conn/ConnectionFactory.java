package br.com.abc.javacore.ZZCjdbc.conn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
//    java.sql main interfaces and classes:
//      DriverManager (class that search for the specific connector for the DB and returns a Connection),
//      Connection (get connection with DB),
//      Statement (responsible for operation that will change Db state),
//      ResultSet (responsible for query results)
    public Connection getConnection() {
        try {
            String url = System.getenv("MYSQL_URL");
            String username = System.getenv("MYSQL_USERNAME");
            String password = System.getenv("MYSQL_PASSWORD");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
