package pokespring.pokespringserver.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pokespring.pokespringserver.model.Pokemon;
import pokespring.pokespringserver.model.Response;
import pokespring.pokespringserver.model.ResponseDictionary;
import pokespring.pokespringserver.model.User;
import pokespring.pokespringserver.repository.UserRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RestController
@RequestMapping(value = {"/users"})
public class UserController {

    public UserController() {
        List<Response> initResponses = new ArrayList<>();
        final Response userExistsResponse = new Response("USER_RESP_EXISTS", "User already exists", Response.class.getName());

        initResponses.add(userExistsResponse);
        ResponseDictionary.getInstance().init(initResponses);
        System.out.println(userExistsResponse.getContent());
    }

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        if (repository.findByLogin(user.getLogin()) == null) {
            user.setId(ObjectId.get().toString());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            repository.save(user);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ResponseDictionary.getInstance().findById("USER_RESP_EXISTS"));
        }
        return ResponseEntity.ok(user);
    }

}
