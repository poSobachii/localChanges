package JPAExample.databaseS.Repos;

import JPAExample.databaseS.DiffEntities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer>{
}