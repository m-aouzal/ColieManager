package ac.ma.emi.secondproject.repositories;

import ac.ma.emi.secondproject.schemas.Colie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColieRepository extends JpaRepository<Colie, Long> {
}