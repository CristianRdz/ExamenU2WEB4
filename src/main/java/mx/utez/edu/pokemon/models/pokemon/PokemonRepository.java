package mx.utez.edu.pokemon.models.pokemon;
import mx.utez.edu.pokemon.models.trainer.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
    Optional<Pokemon> findById(Long id); // optional para ver si estaba vacia
    List<Pokemon> findAllByStatus(Boolean status);
    Optional<Pokemon> findByName(String name);
    @Query(value = "UPDATE pokemon SET status = :status WHERE id = :id", nativeQuery = true)
    boolean updateStatusById(@Param("status") Boolean status, @Param("id") Long id);
}
