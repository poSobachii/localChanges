package RestApplication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookShelf extends JpaRepository<Books, Long> {
}
