package mx.utez.edu.pokemon.controller.trainer.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.utez.edu.pokemon.models.trainer.Trainer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//ID del entrenador (entero, clave primaria)
//      Nombre del entrenador (texto)
//    Equipo de Pokemon (texto)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TrainerDto {
    private Long id;
    private String name;
    private String team;
    private Boolean status;
    public Trainer getTrainer(){
        return new Trainer(getId(),getName(),getStatus(),getTeam());
    }


}
