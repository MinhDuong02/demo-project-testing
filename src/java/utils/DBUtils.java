package utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtils implements Serializable {

    public static Connection makeConnect() throws ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=dbSE161605";
        con = DriverManager.getConnection(url, "sa", "12345");
        return con;
    }
}
