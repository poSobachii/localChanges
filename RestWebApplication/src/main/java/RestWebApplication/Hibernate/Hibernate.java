package RestWebApplication.Hibernate;

import RestWebApplication.DatabaseDAO.DatabaseDAO;
import RestWebApplication.Controller.AppController;
import RestWebApplication.Entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
//@ConditionalOnProperty(name = "conn.prop", havingValue = "hibernate")
@Profile("hibernate")
public class Hibernate implements DatabaseDAO {


    @Value("${welcome.message:msg_not_found}")
    private String message;

    @Override
    public String getPrint() {
        return message;
    }

    @Override
    public void addBook(String name, String author, String publisher, String date) {

    }

    @Override
    public void deleteBook(String deletion) {
        System.out.println("NOTHIN BITCH");

    }

    @Override
    public void fetchBook(String insert) {

    }

    @Override
    public void getAllBooks() {
            System.out.println("HIBERNATE bean involved");
            SessionFactory factory = HibernateUtility.getSessionFactory();

            Session session = factory.getCurrentSession();

            try {
                session.getTransaction().begin();
                String sql = "Select e from " + Book.class.getName() + " e ";

                Query<Book> query = session.createQuery(sql);

                AppController.updateList(query.getResultList());

                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
    }

}
