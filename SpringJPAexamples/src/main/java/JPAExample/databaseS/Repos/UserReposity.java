package JPAExample.databaseS.Repos;

import JPAExample.databaseS.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserReposity extends JpaRepository<User, Integer> {

    List<User> findByuserAdress(String someinput);

    List<User> findBysurname(String surname);

    @Query("select u from User u where USERNAME = :value")
    List<User> somemethod(@Param("value")String someinput);

    @Query(value = "select * from myUser where USERNAME = :value LIMIT 1", nativeQuery = true)
    String somemethodv2(@Param("value")String value);
}
