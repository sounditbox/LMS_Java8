package com.company.repository;

import com.company.model.Enrollment;
import com.company.model.Student;

import java.sql.*;

public class EnrollmentRepository {
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String user = "postgres";
    private static String password = "123";

    public static void getAll(){
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);

            // запустим соединение
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("select * from enrollment order by id");

            while (results.next()){
                int id = Integer.parseInt(results.getString("id"));
                int studentId = Integer.parseInt(results.getString("student_id"));
                int courseId = Integer.parseInt(results.getString("course_id"));
                new Enrollment(id, studentId, courseId);
            }
            conn.close();
        } catch (Exception e){
            System.out.println("Не удалось подключиться к БД");
            System.out.println(e.getMessage());
        }
    }

    public static void add(int id, int studentId, int courseId) {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);

            // запустим соединение
            PreparedStatement statement =
                    conn.prepareStatement("insert into enrollment " +
                            "(id, student_id, course_id) values (?, ?, ?)");
            statement.setInt(1, id);
            statement.setInt(2, studentId);
            statement.setInt(3, courseId);
            statement.executeUpdate();
            conn.close();
        } catch (Exception e){
            System.out.println("Зачисление не удалось");
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id) {
        try {
            // создаём соединение
            Connection conn = DriverManager.getConnection(url, user, password);
            // выполним запрос
            conn.createStatement().executeUpdate("DELETE FROM enrollment where (id= " + id + ")");
            conn.close();
        } catch (Exception e){
            System.out.println("Не удалось удалить запись");
            System.out.println(e.getMessage());
        }
    }
}
