package pokespring.pokespringserver.controller;

import org.bson.types.ObjectId;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import pokespring.pokespringserver.model.Pokemon;
import pokespring.pokespringserver.repository.PokemonRepository;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RestController
@RequestMapping(value = {"/pokemons"})
public class PokemonController {
    @Autowired
    private PokemonRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Pokemon> getAllPokemons() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pokemon getPokemonById(@PathVariable("id") ObjectId id) {
        System.out.println("Getting list of pokemons...");
        return repository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPokemonById(@PathVariable("id") String id, @Valid @RequestBody Pokemon pokemon) {
        pokemon.setId(id);
        repository.save(pokemon);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Pokemon createPokemon(@Valid @RequestBody Pokemon pokemon) {
        pokemon.setId(ObjectId.get().toString());
        repository.save(pokemon);
        return pokemon;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePokemon(@PathVariable ObjectId id) {
        repository.delete(repository.findById(id));
    }
}
