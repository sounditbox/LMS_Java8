package com.company.view.course;

import com.company.Main;
import com.company.model.Course;

import javax.swing.*;
import java.awt.*;

public class AddCoursePanel extends JPanel {
    public AddCoursePanel(){

        setBackground(Color.GRAY);
        // Поля для ввода
        JTextField titleTF = new JTextField(10);
        JTextField descriptionTF = new JTextField(10);
        JTextField teacherTF = new JTextField(10);
        // Кнопка
        JButton addButton2 = new JButton("Добавить курс");
        // Если нажата кнопка:
        addButton2.addActionListener(e -> {
            if (!titleTF.getText().isEmpty()) {
                new Course(titleTF.getText(), descriptionTF.getText(), teacherTF.getText());
                titleTF.setText("");
                descriptionTF.setText("");
                teacherTF.setText("");
                Main.addStudentFrame.setVisible(false);
            }
        });



        add(titleTF);
        add(descriptionTF);
        add(teacherTF);
        add(addButton2);
    }
}
