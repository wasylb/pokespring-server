package pokespring.pokespringserver.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pokemons")
public class Pokemon {
    @Id
    private ObjectId id;

    private String name;
    private String type;
    private String avatarUrl;
    private int hp;
    private int attack;
    private int defense;
    private int speed;

    public Pokemon(final ObjectId id, final String name, final String type, final String avatarUrl, final int hp, final int attack, final int defense, final int speed) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.avatarUrl = avatarUrl;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    public Pokemon() {
        this.name = "";
        this.type = "";
        this.avatarUrl = "";
        this.hp = 0;
        this.attack = 0;
        this.defense = 0;
        this.speed = 0;
    }

    public ObjectId getId() {
        return this.id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(final String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(final int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(final int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(final int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(final int speed) {
        this.speed = speed;
    }
}
