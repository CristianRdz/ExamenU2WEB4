package mx.utez.edu.pokemon.controller.trainer;

import mx.utez.edu.pokemon.models.pokemon.Pokemon;
import mx.utez.edu.pokemon.models.trainer.Trainer;
import mx.utez.edu.pokemon.services.trainer.TrainerService;
import mx.utez.edu.pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//ID del entrenador (entero, clave primaria)
//      Nombre del entrenador (texto)
//    Equipo de Pokemon (texto)
@RestController
@RequestMapping("/api-pokemon/trainer")
@CrossOrigin(origins = {"*"})
public class TrainerController {
    @Autowired
    private TrainerService service;
    @GetMapping("/")
    public ResponseEntity<Response<List<Trainer>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<Trainer>> insert(@RequestBody Trainer trainer){
        return new ResponseEntity<>(
                this.service.insert(trainer), HttpStatus.CREATED
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<Response<Trainer>> update(@PathVariable Long id, @RequestBody Trainer Trainer){
        Trainer.setTrainer_id(id);
        return new ResponseEntity<>(
                this.service.update(Trainer), HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response<Trainer>> getOne(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.getOne(id), HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Boolean>> delete(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.delete(id), HttpStatus.OK
        );
    }
}
