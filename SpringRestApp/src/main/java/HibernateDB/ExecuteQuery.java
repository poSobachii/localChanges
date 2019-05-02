package HibernateDB;

import HibernateUtils.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ExecuteQuery {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtility.getSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            String sql = "Select e from " + Books.class.getName() + " e ";

            Query<Books> query = session.createQuery(sql);

            List<Books> bookis = query.getResultList();

            for (Books booKs : bookis) {
                System.out.println("Books are: " + booKs.getId() +
                       ", Name: " +  booKs.getBookName() +
                       ", Author: " + booKs.getBookAuthor() +
                        ", publisher: " + booKs.getBookPublisher() +
                        ", date: " + booKs.getPublication_date());
            }

            // Commit data.
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
        }
    }
}
