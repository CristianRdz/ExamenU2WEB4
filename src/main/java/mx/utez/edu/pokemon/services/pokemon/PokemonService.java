package mx.utez.edu.pokemon.services.pokemon;

import mx.utez.edu.pokemon.models.pokemon.Pokemon;
import mx.utez.edu.pokemon.models.pokemon.PokemonRepository;
import mx.utez.edu.pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PokemonService {
    @Autowired
    private PokemonRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Pokemon>> getAll(){
        return new Response<>(
                this.repository.findAll(), false, 200, "Tabn"
        );
    }
    @Transactional(readOnly= true)
    public Response<Pokemon> getOne(Long id) {
        if(this.repository.existsById(id)){
            return new Response<>(
                    this.repository.findById(id).get(), false,200, "ok"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro la categoria"
        );

    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> insert(Pokemon Pokemon){
        Optional<Pokemon> exist = this.repository.findByName(Pokemon.getName());
        if (exist.isPresent())
            return new Response<>(
                    null, true, 400,"Pokemon ya fue registrada"
            );
        return new Response<>(
                this.repository.saveAndFlush(Pokemon), false,200,"Pokemon registrado correctamente"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> update(Pokemon Pokemon){
        if(this.repository.existsById(Pokemon.getId())){
            return new Response<>(
                    this.repository.saveAndFlush(Pokemon), false,200,"Pokemon actualizada correctamente"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro el Pokemon"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> delete(Long id){
        if(this.repository.existsById(id)){
            this.repository.updateStatusById(false, id);
            return new Response<>(
                    true, false,200,"Pokemon eliminada correctamente"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro el Pokemon"
        );
    }

}
