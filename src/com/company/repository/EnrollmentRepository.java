package com.company.repository;

import com.company.model.Enrollment;
import com.company.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
                int studentId = Integer.parseInt(results.getString("studentId"));
                int courseId = Integer.parseInt(results.getString("courseId"));
                new Enrollment(id, studentId, courseId);
            }
            conn.close();
        } catch (Exception e){
            System.out.println("Не удалось подключиться к БД");
            System.out.println(e.getMessage());
        }
    }

}
