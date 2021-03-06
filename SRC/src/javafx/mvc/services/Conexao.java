package javafx.mvc.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Pedro Enju
 */
public class Conexao {

    private Connection conn;
    private static Conexao instance = null;

    private Conexao() {
        this.conn = Conexao.createConnection();
    }

    private static Connection createConnection() {
        Properties config = new Properties();
        config.put("user", "root");
        config.put("password", "enju");
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/projetosorveteria",
                    config
            );

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return conn;
    }

    public static Conexao getInstance() {
        if (Conexao.instance == null) {
            Conexao.instance = new Conexao();
        }
        return Conexao.instance;
    }

    public Connection getConn() {
        return conn;
    }
}
