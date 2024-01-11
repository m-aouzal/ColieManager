package ac.ma.emi.secondproject.repositories;

import ac.ma.emi.secondproject.schemas.CentreRegional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreRegionalRepository extends JpaRepository<CentreRegional, Long> {
}
