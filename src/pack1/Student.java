package pack1;

public class Student {

    int studentId;
    String name, surname, gender, city, department;

    public Student() {
        
    }

    public Student(int studentId, String name, String surname, String gender, String city, String department) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.city = city;
        this.department = department;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
