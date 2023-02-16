package mx.utez.edu.pokemon.models.trainer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.utez.edu.pokemon.models.pokemon.Pokemon;

import javax.persistence.*;
import java.util.List;

//ID del entrenador (entero, clave primaria)
  //      Nombre del entrenador (texto)
    //    Equipo de Pokemon (texto)
@Entity
@Table(name = "trainer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trainer_id;
    @Column(nullable = false,length = 150)
    private String name;
    @Column(nullable = false, columnDefinition = "TINYINT DEFAULT 1")
    private Boolean status;
    @Column(nullable = false,length = 150)
    private String team;
    @OneToMany(mappedBy = "trainer")
    @JsonIgnore
    private List<Pokemon> pokemons;

    public Trainer(Long id, String name, Boolean status, String team) {
    }


    public Long getTrainer_id() {
        return trainer_id;
    }

    public void setTrainer_id(Long trainer_id) {
        this.trainer_id = trainer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
