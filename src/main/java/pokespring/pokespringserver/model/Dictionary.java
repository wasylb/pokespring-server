package pokespring.pokespringserver.model;

import java.util.List;

public abstract class Dictionary<T extends IdContent> {
    private List<T> dictionaryObjects;

    public T findById(String id) {
        return (T) dictionaryObjects.stream().filter(object -> object.getId().equals(id));
    }
}
