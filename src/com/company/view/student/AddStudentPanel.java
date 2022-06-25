package com.company.view.student;

import com.company.Main;
import com.company.model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentPanel extends JPanel {
    public AddStudentPanel() {

        JTextField nameTF = new JTextField("Имя",10);
        JTextField surnameTF = new JTextField("Фамилия", 10);
        JTextField emailTF = new JTextField("example@mail.org", 21);
        JTextField phoneTF = new JTextField("+78005553535",10);
        setBackground(Color.GRAY);
        JButton addButton = new JButton("Добавить");
        addButton.addActionListener(e -> {
            if (!nameTF.getText().isEmpty() && !surnameTF.getText().isEmpty()) {
                new Student(nameTF.getText(), surnameTF.getText(), emailTF.getText(), phoneTF.getText());
                nameTF.setText("");
                surnameTF.setText("");
                emailTF.setText("");
                phoneTF.setText("");
                Main.addStudentFrame.setVisible(false);
            }
        });

        add(nameTF);
        add(surnameTF);
        add(emailTF);
        add(phoneTF);
        add(addButton);
    }
}
