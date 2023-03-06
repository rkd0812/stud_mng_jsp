package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DataSource {

    public Connection getConnection() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/studdb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
        String user = "studMng";
        String password = "jsi5688#@";

        try{
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("|-> DB Driver Class Load Failed~!!!");
            e.printStackTrace();
        }

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            return conn;
        } catch (SQLException e) {
            System.out.println("|--> Connection Failed~!!!");
            throw new RuntimeException(e);
        }
    }
}
