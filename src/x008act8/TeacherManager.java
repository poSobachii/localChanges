package x008act8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// import org.apache.log4j.Logger;

public class TeacherManager {

    protected Connection conn;


    public TeacherManager() {


        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/?autoReconnect=true&useSSL=false", "root", "abcd1234");

            conn.setAutoCommit(false);
        } catch (Exception exc) {

        }
    }

    public Teacher findTeacher(int id) {

        try {
            String query = "SELECT * FROM database_activity.Teacher WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, id);

            ResultSet data = pst.executeQuery();

            boolean teacherExists = false;
            int tid = 0;
            String tname = "";
            String tsurn = "";

            while (data.next()) {
                tid = data.getInt("id");
                tname = data.getString("firstname");
                tsurn = data.getString("lastname");
                teacherExists = true;
                break;
            }
            data.close();
            pst.close();

            if (teacherExists) {
                return new Teacher(tid, tname, tsurn);
            } else {
                return new Teacher(0, null, null);
            }
        } catch (SQLException exc) {
            return null;
        }
    }


    public List<Teacher> findTeacher(String firstName, String lastName) {

        List<Teacher> teachers = new ArrayList<>();

        try {
            String query = "SELECT * FROM database_activity.Teacher WHERE firstName like ? AND lastName like ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, "%" + firstName + "%");
            pst.setString(2, "%" + lastName + "%");

            ResultSet data = pst.executeQuery();

            while (data.next()) {
                int tid = data.getInt("id");
                String tname = data.getString("firstname");
                String tsurn = data.getString("lastname");

                teachers.add(new Teacher(tid, tname, tsurn));
            }
            data.close();
            pst.close();
        } catch (SQLException exc) {
        }
        return teachers;
    }


    public boolean insertTeacher(String firstName, String lastName) {
        try {
            String sql = "INSERT INTO database_activity.Teacher (`firstname`, `lastname`) VALUES (?, ?);";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, firstName);
            pst.setString(2, lastName);

            int result = pst.executeUpdate();
            conn.commit();
            pst.close();

            return result != 0;
        } catch (SQLException exc) {
            return false;
        }
    }


    public boolean insertTeacher(Teacher teacher) {
        try {
            String sql = "INSERT INTO database_activity.Teacher VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, teacher.getID());
            pst.setString(2, teacher.getFirstName());
            pst.setString(3, teacher.getLastName());

            int result = pst.executeUpdate();
            conn.commit();
            pst.close();

            return result != 0;
        } catch (SQLException exc) {
            return false;
        }
    }


    public boolean updateTeacher(Teacher teacher) {
        try {
            String sql = "UPDATE database_activity.Teacher SET firstname = ?, lastname = ? WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, teacher.getFirstName());
            pst.setString(2, teacher.getLastName());
            pst.setInt(3, teacher.getID());

            int result = pst.executeUpdate();
            conn.commit();
            pst.close();

            return result != 0;
        } catch (SQLException exc) {
            return false;
        }
    }


    public boolean deleteTeacher(int id) {
        try {
            String sql = "DELETE FROM database_activity.Teacher WHERE id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            int result = pst.executeUpdate();
            conn.commit();
            pst.close();

            return result != 0;
        } catch (SQLException exc) {
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
