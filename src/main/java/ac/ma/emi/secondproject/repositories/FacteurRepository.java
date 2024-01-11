package ac.ma.emi.secondproject.repositories;

import ac.ma.emi.secondproject.schemas.Facteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacteurRepository extends JpaRepository<Facteur, Long> {
}
