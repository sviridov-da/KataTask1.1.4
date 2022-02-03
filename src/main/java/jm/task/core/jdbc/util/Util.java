package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static String url ="jdbc:mysql://localhost:3306/katausers";
    private static String user = "root";
    private static String pass = "24800369";
    public static Connection getConnection() throws SQLException {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к БД");
            throw e;
        }
    }

    public static void setURL(String url){
        Util.url = url;
    }
    public static void setUSER(String user){
        Util.user = user;
    }
    public static void setPASSWORD(String pass){
        Util.pass = pass;
    }


}
