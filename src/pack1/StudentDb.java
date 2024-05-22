package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDb {

    public Connection getConnected() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "ilayda123");
    }

    public ResultSet getStudents() throws SQLException {
        Statement st = getConnected().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student");
        return rs;
    }

    public void saveStudent(Student s) throws SQLException {
        String query = "INSERT INTO student (studentId, name, surname, gender, city, department) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = getConnected().prepareStatement(query);
        ps.setInt(1, s.getStudentId());
        ps.setString(2, s.getName());
        ps.setString(3, s.getSurname());
        ps.setString(4, s.getGender());
        ps.setString(5, s.getCity());
        ps.setString(6, s.getDepartment());
        ps.executeUpdate();
    }

    public void deleteStudent(int studentId) throws SQLException {
        String query = "DELETE FROM student WHERE studentId=?";
        PreparedStatement ps = getConnected().prepareStatement(query);
        ps.setInt(1, studentId);
        ps.executeUpdate();
    }
}
