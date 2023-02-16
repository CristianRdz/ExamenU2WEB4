package mx.utez.edu.pokemon.controller.pokemon.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.utez.edu.pokemon.models.pokemon.Pokemon;
//ID del Pokemon (entero, clave primaria)
//       Nombre del Pokemon (texto)
//     Tipo de Pokemon (texto)
//   Nivel de poder (entero)
// Puntos de salud (entero)
//Ataque (entero)
// Defensa (entero)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PokemonDto {
    private Long id;
    private String name;
    private String type;
    private int powerLevel;
    private int healthPoints;
    private int attack;
    private int defense;
    private Boolean status;

    public Pokemon getPokemon(){
        return new Pokemon(getId(),getName(),getType(),getPowerLevel(),getHealthPoints(),getAttack(),getDefense(),getStatus(),null);
    }

}
