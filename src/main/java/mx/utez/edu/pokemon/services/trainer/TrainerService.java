package mx.utez.edu.pokemon.services.trainer;

import mx.utez.edu.pokemon.models.trainer.Trainer;
import mx.utez.edu.pokemon.models.trainer.TrainerRepository;
import mx.utez.edu.pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TrainerService {
    @Autowired
    private TrainerRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Trainer>> getAll(){
        return new Response<>(
                this.repository.findAll(), false, 200, "Tabn"
        );
    }
    @Transactional(readOnly= true)
    public Response<Trainer> getOne(Long id) {
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
    public Response<Trainer> insert(Trainer Trainer){
        Optional<Trainer> exist = this.repository.findByName(Trainer.getName());
        if (exist.isPresent())
            return new Response<>(
                    null, true, 400,"Trainer ya fue registrada"
            );
        return new Response<>(
                this.repository.saveAndFlush(Trainer), false,200,"Trainer registrado correctamente"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Trainer> update(Trainer Trainer){
        if(this.repository.existsById(Trainer.getTrainer_id())){
            return new Response<>(
                    this.repository.saveAndFlush(Trainer), false,200,"Trainer actualizada correctamente"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro el Trainer"
        );
    }
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> delete(Long id){
        if(this.repository.existsById(id)){
            this.repository.updateStatusById(false, id);
            return new Response<>(
                    true, false,200,"Trainer eliminada correctamente"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro el Trainer"
        );
    }


}
