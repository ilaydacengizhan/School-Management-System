package pack1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentForm extends JFrame {

    private JPanel contentPane;
    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtSurname;
    private JTextField txtCity;
    private JTable table;
    private JComboBox<String> cbDepartment;
    private JRadioButton rdbtnMale;
    private JRadioButton rdbtnFemale;
    private ButtonGroup genderGroup;
    StudentDb studentDb = new StudentDb();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentForm frame = new StudentForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public StudentForm() throws SQLException {
        setTitle("Student Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 533, 402);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblId = new JLabel("Student ID");
        lblId.setBounds(10, 25, 70, 14);
        contentPane.add(lblId);
        
        txtId = new JTextField();
        txtId.setBounds(90, 22, 100, 20);
        contentPane.add(txtId);
        txtId.setColumns(10);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(10, 53, 70, 14);
        contentPane.add(lblName);
        
        txtName = new JTextField();
        txtName.setColumns(10);
        txtName.setBounds(90, 50, 100, 20);
        contentPane.add(txtName);
        
        JLabel lblSurname = new JLabel("Surname");
        lblSurname.setBounds(10, 82, 70, 14);
        contentPane.add(lblSurname);
        
        txtSurname = new JTextField();
        txtSurname.setColumns(10);
        txtSurname.setBounds(90, 79, 100, 20);
        contentPane.add(txtSurname);
        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(10, 111, 70, 14);
        contentPane.add(lblGender);
        
        rdbtnMale = new JRadioButton("Male");
        rdbtnMale.setBounds(90, 107, 59, 23);
        contentPane.add(rdbtnMale);
        rdbtnMale.setActionCommand("Male");
        
        rdbtnFemale = new JRadioButton("Female");
        rdbtnFemale.setBounds(151, 107, 70, 23);
        contentPane.add(rdbtnFemale);
        rdbtnFemale.setActionCommand("Female");

        genderGroup = new ButtonGroup();
        genderGroup.add(rdbtnMale);
        genderGroup.add(rdbtnFemale);
        
        JLabel lblCity = new JLabel("City");
        lblCity.setBounds(10, 141, 70, 14);
        contentPane.add(lblCity);
        
        txtCity = new JTextField();
        txtCity.setColumns(10);
        txtCity.setBounds(90, 138, 100, 20);
        contentPane.add(txtCity);
        
        JLabel lblDepartment = new JLabel("Department");
        lblDepartment.setBounds(10, 175, 70, 14);
        contentPane.add(lblDepartment);
        
        cbDepartment = new JComboBox<>();
        cbDepartment.setBounds(90, 171, 122, 22);
        contentPane.add(cbDepartment);
        cbDepartment.addItem("Computer Science");
        cbDepartment.addItem("Mathematics");
        cbDepartment.addItem("Physics");
        cbDepartment.addItem("Software");
        cbDepartment.addItem("Business");
        
        JButton btnSave = new JButton("SAVE");
        btnSave.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student s = new Student();
                s.setStudentId(Integer.parseInt(txtId.getText()));
                s.setName(txtName.getText());
                s.setSurname(txtSurname.getText());
                s.setGender(genderGroup.getSelection().getActionCommand());
                s.setCity(txtCity.getText());
                s.setDepartment(cbDepartment.getSelectedItem().toString());
                
                try {
                    studentDb.saveStudent(s);
                    refreshStudentTable();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnSave.setBounds(90, 223, 100, 23);
        contentPane.add(btnSave);
        
        JButton btnNext = new JButton("NEXT");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openTeacherForm();
            }
        });
        btnNext.setBounds(90, 256, 100, 23);
        contentPane.add(btnNext);
        
        JLabel lblStudentList = new JLabel("Student List");
        lblStudentList.setBounds(250, 25, 100, 14);
        contentPane.add(lblStudentList);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(250, 50, 250, 200);
        contentPane.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
    }

    private void refreshStudentTable() throws SQLException {
        ResultSet temp_rs = studentDb.getStudents();
        int columnNumber = temp_rs.getMetaData().getColumnCount();
        String columnNames[] = new String[columnNumber];
        
        for (int i = 0; i < columnNumber; i++) {
            columnNames[i] = temp_rs.getMetaData().getColumnName(i + 1);
        }
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        
        table.setModel(model);
        
        while (temp_rs.next()) {
            Object array[] = new Object[columnNumber];
            for (int i = 0; i < array.length; i++) {
                array[i] = temp_rs.getObject(i + 1);
            }
            model.addRow(array);
        }
    }

    private void openTeacherForm() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TeacherForm teacherForm = new TeacherForm();
                    teacherForm.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
