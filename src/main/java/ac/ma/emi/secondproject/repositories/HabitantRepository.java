package ac.ma.emi.secondproject.repositories;

import ac.ma.emi.secondproject.schemas.Habitant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitantRepository extends JpaRepository<Habitant, Long> {
}
