package mx.utez.edu.pokemon.controller.pokemon;

import mx.utez.edu.pokemon.models.pokemon.Pokemon;
import mx.utez.edu.pokemon.services.pokemon.PokemonService;
import mx.utez.edu.pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-pokemon/pokemon")
@CrossOrigin(origins = {"*"})
public class PokemonController {
 @Autowired
    private PokemonService service;
    @GetMapping("/")
    public ResponseEntity<Response<List<Pokemon>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }
    @PostMapping("/")
    public ResponseEntity<Response<Pokemon>> insert(@RequestBody Pokemon pokemon){
        return new ResponseEntity<>(
                this.service.insert(pokemon), HttpStatus.CREATED
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<Response<Pokemon>> update(@PathVariable Long id, @RequestBody Pokemon pokemon){
        pokemon.setId(id);
        return new ResponseEntity<>(
                this.service.update(pokemon), HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response<Pokemon>> getOne(@PathVariable Long id){
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