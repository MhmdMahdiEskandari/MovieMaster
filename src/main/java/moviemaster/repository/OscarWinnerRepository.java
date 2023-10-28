package moviemaster.repository;

import moviemaster.model.OscarWinner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OscarWinnerRepository extends JpaRepository<OscarWinner, Long> {
    boolean existsByTitleAndYear(String title, int year);
    boolean existsByTitle(String title);
}
