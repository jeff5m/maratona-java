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
//      DriverManager (class that search for the specific connector for the DB and return a Connection),
//      Connection (get connection with DB),
//      Statement (responsible for operation that will change Db state),
//      ResultSet (responsible for query results)
    public Connection getConnection() {

        try (FileReader reader = new FileReader("config.properties")) {
            Properties properties = new Properties();
            properties.load(reader);

            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
//            in old days, we need to explicit load the Driver.
//            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection);
            return connection;
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
