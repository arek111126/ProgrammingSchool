package pl.programmingschool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/programming_school?useSSL=false&characterEncoding=utf8&serverTimezone=UTC",
                "root",
                "coderslab");
    }
}
