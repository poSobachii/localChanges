package libraryDatabase.Repositories;

import libraryDatabase.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

//    public Book findByAuthor(String author);
//
//    @Query("select b from BOOKSHELF b where BOOKNAME = :value")
//    Book findBookByName(@Param("value") String input);
//
//    @Query("select id from BOOKSHELF where BOOKNAME = :valueName")
//    String findID(@Param("valueName") String name);
//
//    @Query("select b.author from BOOKSHELF b where b.id = :valueId")
//    String findAuthor(@Param("valueId") Long id);
//
//    @Query("select b.publisher from BOOKSHELF b where b.name = :valueName")
//    String findPublisher(@Param("valueName") String name);
//
//    @Query("select b.publication_date from BOOKSHELF b where ID = :valueId")
//    String findDate(@Param("valueId") String id);

}
