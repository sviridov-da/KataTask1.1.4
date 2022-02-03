package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.util.List;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/katausers";
    private static final String USER = "root";
    private static final String PASSWORD = "24800369";

    public static void main(String[] args) {
        //инициализация, если данные для подключения к БД другие
//        Util.setURL("jdbc:mysql://localhost:3306/katausers");
//        Util.setUSER("root");
//        Util.setPASSWORD("24800369");
        UserService service = new UserServiceImpl();
        // Создание таблицы User(ов)
        service.createUsersTable();
        //Добавление 4 User(ов) в таблицу с данными на свой выбор.
        // После каждого добавления должен быть вывод в консоль
        // ( User с именем – name добавлен в базу данных )
        service.saveUser("Vasya", "Vasya2", (byte)17);
        service.saveUser("Petya", "Petya2", (byte)18);
        service.saveUser("Kolya", "Kolya2", (byte)19);
        service.saveUser("Masha", "Masha2", (byte)20);
        // Получение всех User из базы и вывод в консоль
        // ( должен быть переопределен toString в классе User)
        List<User> users= service.getAllUsers();
        for(User user : users){
            System.out.println(user);
        }
        // Очистка таблицы User(ов)
        service.cleanUsersTable();
        // Удаление таблицы
        service.dropUsersTable();
    }
}
