//package x011act12.JUnitTest;
//
//
//import static org.junit.Assert.*;
//import java.util.List;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
///**
// * @author student
// *
// */
//public class DatabaseUnitTest1 extends StudentManager {
//
//    /**
//     * @throws java.lang.Exception
//     */
//    @BeforeClass
//    public static void setUpBeforeClass() throws Exception {
//        StudentManager manager = new StudentManager();
//        Student student = new Student(0, "John", "Smith");
//        student.getID();
//        student.getFirstName();
//        student.getLastName();
//    }
//
//    /**
//     * @throws java.lang.Exception
//     */
//    @AfterClass
//    public static void tearDownAfterClass() throws Exception {
//    }
//
//    /**
//     * @throws java.lang.Exception
//     */
//    @Before
//    public void setUp() throws Exception {
//        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?autoReconnect=true&useSSL=false", "root",
//                    "abcd1234");
//            conn.setAutoCommit(false);
//        } catch (Exception exc) {
//
//        }
//
//    }
//
//    /**
//     * @throws java.lang.Exception
//     */
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    /**
//     * Test method for {@link jtm.activity14.StudentManager#StudentManager()}.
//     */
//    @Test
//    public final void testStudentManager() {
//        fail("Not yet implemented"); // TODO
//    }
//
//    /**
//     * Test method for {@link jtm.activity14.StudentManager#findStudent(int)}.
//     */
//    @Test
//    public final void testFindStudentInt() {
//        StudentManager studentManager = new StudentManager();
//        Student expectedStudent = new Student(200, "John", "Miller");
//
//        studentManager.insertStudent(expectedStudent);
//        Student newStudent = studentManager.findStudent(200);
//
//        assertEquals(expectedStudent, newStudent);
//    }
//
//    /**
//     * Test method for
//     * {@link jtm.activity14.StudentManager#findStudent(java.lang.String, java.lang.String)}.
//     */
//    @Test
//    public final void testFindStudentStringString() {
//        StudentManager studentManager = new StudentManager();
//        Student expectedStudent = new Student(200, "John", "Miller");
//        List<Student> expected = studentManager.findStudent("oh", "ll");
//        assertNotNull(expected);
//    }
//
//    /**
//     * Test method for
//     * {@link jtm.activity14.StudentManager#insertStudent(java.lang.String, java.lang.String)}.
//     */
//    @Test
//    public final void testInsertStudentStringString() {
//        StudentManager studentManager = new StudentManager();
//        studentManager.insertStudent("Jim", "Miller");
//        studentManager.insertStudent(new Student(250, "Jim", "Miller"));
//
//    }
//
//    /**
//     * Test method for
//     * {@link jtm.activity14.StudentManager#insertStudent(jtm.activity14.Student)}.
//     */
//    @Test
//    public final void testInsertStudentStudent() {
//        StudentManager studentManager = new StudentManager();
//        Student student = new Student(250, "Jim", "Miller");
//        studentManager.insertStudent(student);
//
//    }
//
//    /**
//     * Test method for
//     * {@link jtm.activity14.StudentManager#updateStudent(jtm.activity14.Student)}.
//     */
//    @Test
//    public final void testUpdateStudent() {
//        StudentManager studentManager = new StudentManager();
//        Student one = new Student(1, "Jim", "Dreyer");
//        Student two = new Student(1, "Jane", "Dreyer");
//        studentManager.insertStudent(one);
//        studentManager.updateStudent(one);
//
//        assertEquals(one, studentManager.findStudent(one.getID()));
//    }
//
//    /**
//     * Test method for {@link jtm.activity14.StudentManager#deleteStudent(int)}.
//     */
//    @Test
//    public final void testDeleteStudent() {
//        StudentManager studentManager = new StudentManager();
//        Student student = new Student(69, "Jimmy", "Carter");
//        studentManager.deleteStudent(69);
//        studentManager.insertStudent(student);
//        studentManager.deleteStudent(69);
//        assertNotEquals(student, studentManager.findStudent(student.getID()));
//    }
//
//    /**
//     * Test method for {@link jtm.activity14.StudentManager#closeConnecion()}.
//     *
//     * @throws SQLException
//     */
//    @Test
//    public final void testCloseConnecion() throws SQLException {
//        StudentManager studentManager = new StudentManager();
//        studentManager.closeConnecion();
//        assertEquals(null, studentManager.conn);
//    }
//
//}
