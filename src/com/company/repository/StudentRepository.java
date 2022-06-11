package com.company.repository;

import com.company.model.Student;

import java.sql.*;

public class StudentRepository {
    private static String url = "jdbc:postgresql://localhost:5432/postgres"; // ваша база ссылка на БД
    private static String user = "postgres"; // ваш логин
    private static String password = "123"; //  Ваш пароль

    // CRUD - Create, Read, Update, Delete

    // read
    public static void getAll() {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);

            // запустим соединение
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("select * from student");

            while (results.next()){
                String id = results.getString("id");
                String name = results.getString("name");
                String surname = results.getString("surname");
                new Student(Integer.parseInt(id), name, surname);
            }
            conn.close();
        } catch (Exception e){
            System.out.println("Не удалось подключиться к БД");
            System.out.println(e.getMessage());
        }
    }

    // Create
    public static void add(int id, String name, String surname) {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);

            // запустим соединение
            PreparedStatement statement =
                    conn.prepareStatement("insert into student " +
                            "(id, name, surname) values (?, ?, ?)");
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, surname);

            statement.executeUpdate();
            conn.close();
        } catch (Exception e){
            System.out.println("Не удалось добавить студента");
            System.out.println(e.getMessage());
        }
    }
    // update
    public static void update(int id, String name, String surname) {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);

            // запустим соединение
            PreparedStatement statement =
                    conn.prepareStatement("update student " +
                                              "set name=?, surname=?" +
                                              "where id=?");
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setInt(3, id);


            statement.executeUpdate();
            conn.close();
        } catch (Exception e){
            System.out.println("Не удалось изменить студента");
            System.out.println(e.getMessage());
        }
    }


    // delete

    public static void delete(int id) {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);
            // выполним запрос
            conn.createStatement().executeUpdate("DELETE FROM student where (id= " + id + ")");
            conn.close();
        } catch (Exception e){
            System.out.println("Не удалось удалить студента");
            System.out.println(e.getMessage());
        }
    }
}
