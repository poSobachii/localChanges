package RestWebApplication.JDBC;

import RestWebApplication.DatabaseDAO.DatabaseDAO;
import RestWebApplication.Controller.AppController;
import RestWebApplication.Entity.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
//@ConditionalOnProperty(name = "conn.prop", havingValue = "jdbc")
@Profile("jdbc")
public class JDBCdb implements DatabaseDAO {


    @Value("${welcome.message:msg_not_found}")
    private String message;

    @Override
    public String getPrint() {
        return message;
    }

    @Override
    public void addBook(String name, String author, String publisher, String date) {
        if (!name.isEmpty() && !author.isEmpty() && !publisher.isEmpty() && !date.isEmpty()){
        StringBuffer strbuf = new StringBuffer();

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/bookaplication", "root", "12345678");
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "insert into books(bookName, bookAuthor, bookPublisher, publication_date) values " +
                    "(\'" + name +"\',\'" + author +"\',\'" + publisher +"\',\'" + date +"\');";
            System.out.println(strSelect);
            int rset = stmt.executeUpdate(strSelect);

        }
        catch(SQLException ex) {
            ex.printStackTrace();  }

        strbuf.append("<h3>The book succesfully added !</h3>");
        AppController.changeLine(strbuf);}
        else{AppController.changeLine(new StringBuffer("<h3>Please fill the form correctly!</h3>"));}

    }


    @Override
    public void fetchBook(String insert) {
        if (!insert.isEmpty()){
        StringBuffer strbuf = new StringBuffer();

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/bookaplication", "root", "12345678");
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "select * from bookaplication.books;";
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                if (insert.equals(rset.getNString("bookName"))
                        || insert.equals(Long.toString(rset.getLong("id")))){
                    Long id = rset.getLong("id");
                    String bookName = rset.getString("bookName");
                    String bookAuthor = rset.getString("bookAuthor");
                    String bookPublisher = rset.getString("bookPublisher");
                    String publication_date = rset.getString("publication_date");
                    strbuf.append("<h3> id: " +
                            id + ", name: " + bookName + ", author: " + bookAuthor +
                            ", publisher: " + bookPublisher + ", date: " + publication_date + "</h3>");

                }

            }
            if (strbuf.length() == 0) { strbuf.append("<h3>there is no matched books</h3>"); }
            AppController.changeLine(strbuf);

        } catch(SQLException ex) {
            ex.printStackTrace();
        }}
        else {AppController.changeLine(new StringBuffer("<h3>Please type ID to search for the book !</h3>"));}
    }

    @Override
    public void getAllBooks() {
        System.out.println("JDBC bean envolved");
        List temp = new ArrayList();
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/bookaplication", "root", "12345678");
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "select * from bookaplication.books;";
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()) {
                Long id = rset.getLong("id");
                String bookName = rset.getString("bookName");
                String bookAuthor = rset.getString("bookAuthor");
                String bookPublisher = rset.getString("bookPublisher");
                String publication_date = rset.getString("publication_date");

                temp.add(new Book(id,bookName,bookAuthor,bookPublisher,publication_date));
            }

            AppController.updateList(temp);

        } catch(SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteBook(String deletion) {

        if (!deletion.isEmpty()){
        StringBuffer strbuf = new StringBuffer();
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/bookaplication", "root", "12345678");

        ) {
            Statement stmt = conn.createStatement();
            String strSelect = "DELETE FROM `books` WHERE `id` = " + deletion;
            int rowsAffected = stmt.executeUpdate(strSelect);

            if(rowsAffected > 0) {
                strbuf.append("<h3>it's done ! The book  with ID " + deletion + " succesfully deleted </h3>");
            }
            else{
                strbuf.append("<h3>The book with ID " + deletion + " wasn't found</h3>");
            }

            AppController.changeLine(strbuf);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }}
        else {AppController.changeLine(new StringBuffer("<h3>Please type ID to delete !</h3>"));}
    }

}
