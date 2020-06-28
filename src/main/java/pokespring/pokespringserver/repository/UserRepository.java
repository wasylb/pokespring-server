package pokespring.pokespringserver.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pokespring.pokespringserver.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findById(ObjectId _id);
    User findByLogin(String login);
}
