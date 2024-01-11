package ac.ma.emi.secondproject.repositories;

import ac.ma.emi.secondproject.schemas.CentrePostal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentrePostalRepository extends JpaRepository<CentrePostal, Long> {
}