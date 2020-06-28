package pokespring.pokespringserver.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pokespring.pokespringserver.model.Pokemon;
import pokespring.pokespringserver.model.User;
import pokespring.pokespringserver.repository.UserRepository;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RestController
@RequestMapping(value = {"/users"})
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User createUser(@Valid @RequestBody User user) {
        if (repository.findByLogin(user.getLogin()) == null) {
            user.setId(ObjectId.get().toString());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            repository.save(user);
        } else {

        }


        return user;
    }

}
