package JPAExample.databaseS.Repos;

import JPAExample.databaseS.Entities.AdressInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AdressInfoRepository extends JpaRepository <AdressInfo, Integer> {
}
