package pack1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

public class TeacherForm extends JFrame {
    private JPanel contentPane;
    private JTextField txtTeacherName;
    private JTextField txtTeacherSurname;
    private JComboBox<String> cbTeacherGender;
    private JTextField txtTeacherDepartment;

    public TeacherForm() {
        setTitle("Teacher Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTeacherName = new JLabel("Name:");
        lblTeacherName.setBounds(20, 20, 80, 20);
        contentPane.add(lblTeacherName);

        txtTeacherName = new JTextField();
        txtTeacherName.setBounds(110, 20, 150, 20);
        contentPane.add(txtTeacherName);
        txtTeacherName.setColumns(10);

        JLabel lblTeacherSurname = new JLabel("Surname:");
        lblTeacherSurname.setBounds(20, 50, 80, 20);
        contentPane.add(lblTeacherSurname);

        txtTeacherSurname = new JTextField();
        txtTeacherSurname.setBounds(110, 50, 150, 20);
        contentPane.add(txtTeacherSurname);
        txtTeacherSurname.setColumns(10);

        JLabel lblTeacherGender = new JLabel("Gender:");
        lblTeacherGender.setBounds(20, 80, 80, 20);
        contentPane.add(lblTeacherGender);

        cbTeacherGender = new JComboBox<>(new String[]{"Male", "Female"});
        cbTeacherGender.setBounds(110, 80, 150, 20);
        contentPane.add(cbTeacherGender);

        JLabel lblTeacherDepartment = new JLabel("Department:");
        lblTeacherDepartment.setBounds(20, 110, 80, 20);
        contentPane.add(lblTeacherDepartment);

        txtTeacherDepartment = new JTextField();
        txtTeacherDepartment.setBounds(110, 110, 150, 20);
        contentPane.add(txtTeacherDepartment);
        txtTeacherDepartment.setColumns(10);

        JButton btnSaveTeacher = new JButton("SAVE");
        btnSaveTeacher.addActionListener(this::saveTeacherButtonActionPerformed);
        btnSaveTeacher.setBounds(110, 140, 80, 25);
        contentPane.add(btnSaveTeacher);
    }

    private void saveTeacherButtonActionPerformed(ActionEvent evt) {
        String teacherName = txtTeacherName.getText();
        String teacherSurname = txtTeacherSurname.getText();
        String teacherGender = cbTeacherGender.getSelectedItem().toString();
        String teacherDepartment = txtTeacherDepartment.getText();

       
        JOptionPane.showMessageDialog(this, 
            "Teacher Information:\n" +
            "Name: " + teacherName + "\n" +
            "Surname: " + teacherSurname + "\n" +
            "Gender: " + teacherGender + "\n" +
            "Department: " + teacherDepartment
        );

        clearFields();
    }

    private void clearFields() {
        txtTeacherName.setText("");
        txtTeacherSurname.setText("");
        cbTeacherGender.setSelectedIndex(0);
        txtTeacherDepartment.setText("");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TeacherForm frame = new TeacherForm();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
