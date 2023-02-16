package mx.utez.edu.pokemon.models.trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Optional<Trainer> findById(Long id); // optional para ver si estaba vacia
    List<Trainer> findAllByStatus(Boolean status);
    Optional<Trainer> findByName(String name);

    @Query(value = "UPDATE trainer SET status = :status WHERE id = :id", nativeQuery = true)
    boolean updateStatusById(@Param("status") Boolean status, @Param("id") Long id);

}
