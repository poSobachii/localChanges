package x011act12.JUnitTest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import x011act12.JUnitTest.Student;
public class StudentManager {

    protected Connection conn;

    public StudentManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/?autoReconnect=true&useSSL=false","root", "abcd1234");

            conn.setAutoCommit(false);
        } catch (Exception exc) {

        }
    }

    public Student findStudent(int id) {
        try {
            String temp = "SELECT * FROM database_activity.Student WHERE id = ?";
            PreparedStatement state = conn.prepareStatement(temp);
            state.setInt(1, id);

            ResultSet rslt = state.executeQuery();

            boolean studentExists = false;
            int aid = 0;
            String name = "";
            String surn = "";

            while (rslt.next()) {
                aid = rslt.getInt("id");
                name = rslt.getString("firstname");
                surn = rslt.getString("lastname");
                studentExists = true;
                break;
            }
            rslt.close();
            state.close();

            if (studentExists) {
                return new Student(aid, name, surn);
            } else {
                return new Student(0, null, null);
            }
        } catch (SQLException e) {
        }
        return null;
    }
    public List<Student> findStudent(String firstName, String lastName) {
        List<Student> students = new ArrayList<>();

        try {
            String temp = "SELECT * FROM database_activity.Student WHERE firstName like ? AND lastName like ?";
            PreparedStatement state = conn.prepareStatement(temp);
            state.setString(1, "%" + firstName + "%");
            state.setString(2, "%" + lastName + "%");

            ResultSet rslt = state.executeQuery();

            while (rslt.next()) {
                int id = rslt.getInt("id");
                String name = rslt.getString("firstname");
                String surn = rslt.getString("lastname");

                students.add(new Student(id, name, surn));
            }
            rslt.close();
            state.close();
        } catch (SQLException e) {
        }
        return students;
    }

    public boolean insertStudent(String firstName, String lastName) {
        try {
            String temp = "INSERT INTO database_activity.Student (`firstname`, `lastname`) VALUES (?, ?);";
            PreparedStatement state = conn.prepareStatement(temp);
            state.setString(1, firstName);
            state.setString(2, lastName);

            int rslt = state.executeUpdate();
            conn.commit();
            state.close();

            return rslt != 0;
        } catch (SQLException e) {
            return false;
        }
    }


    public boolean insertStudent(Student student) {
        try {
            String temp = "INSERT INTO database_activity.Student VALUES (?, ?, ?)";
            PreparedStatement state = conn.prepareStatement(temp);
            state.setInt(1, student.getID());
            state.setString(2, student.getFirstName());
            state.setString(3, student.getLastName());

            int rslt = state.executeUpdate();
            conn.commit();
            state.close();

            return rslt != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateStudent(Student student) {
        try {
            String temp = "UPDATE database_activity.Student SET firstname = ?, lastname = ? WHERE id = ?";
            PreparedStatement state = conn.prepareStatement(temp);
            state.setString(1, student.getFirstName());
            state.setString(2, student.getLastName());
            state.setInt(3, student.getID());

            int rslt = state.executeUpdate();
            conn.commit();
            state.close();

            return rslt != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteStudent(int id) {
        try {
            String temp = "DELETE FROM database_activity.Student WHERE id = ?";
            PreparedStatement state = conn.prepareStatement(temp);
            state.setInt(1, id);

            int rslt = state.executeUpdate();
            conn.commit();
            state.close();

            return rslt != 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public void closeConnecion() {
        try {
            conn.close();
            conn = null;
        } catch (SQLException exc) {
        }
    }
}
