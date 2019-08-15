package JPAExample.databaseS.Repos;

import JPAExample.databaseS.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserReposity extends JpaRepository<User, Integer> {

    List<User> findByuserAdress(String someinput);

    @Query("select u from User u where USERNAME = :value")
    List<User> somemethod(@Param("value")String someinput);
}
