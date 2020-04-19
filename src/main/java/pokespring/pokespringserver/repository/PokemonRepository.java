package pokespring.pokespringserver.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pokespring.pokespringserver.model.Pokemon;

@Repository
public interface PokemonRepository extends MongoRepository<Pokemon, String> {
    Pokemon  findById(ObjectId _id);
}
