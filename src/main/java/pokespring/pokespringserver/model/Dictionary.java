package pokespring.pokespringserver.model;

import java.util.List;

public interface Dictionary {
    <T> T findById(final String id);
    void init(final List<?> dictObjects);
}
