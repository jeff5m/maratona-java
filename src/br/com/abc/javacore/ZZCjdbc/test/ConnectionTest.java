package br.com.abc.javacore.ZZCjdbc.test;

import br.com.abc.javacore.ZZCjdbc.conn.ConnectionFactory;

public class ConnectionTest {
    public static void main(String[] args) {
        ConnectionFactory conn = new ConnectionFactory();
        conn.getConnection();
    }
}
