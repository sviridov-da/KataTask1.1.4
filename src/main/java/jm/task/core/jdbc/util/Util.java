package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        return sessionFactory == null ? buildSessionFactory() : sessionFactory;
    }
    private static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration();
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, url);
        settings.put(Environment.USER, user);
        settings.put(Environment.PASS, pass);
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

        configuration.setProperties(settings);
        configuration.addAnnotatedClass(User.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
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
