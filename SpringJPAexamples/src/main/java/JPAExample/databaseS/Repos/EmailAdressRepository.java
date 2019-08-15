package JPAExample.databaseS.Repos;

import JPAExample.databaseS.Entities.EmailAdress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailAdressRepository extends JpaRepository<EmailAdress, Integer> {
}
