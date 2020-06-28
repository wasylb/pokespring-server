package pokespring.pokespringserver.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseDictionary implements Dictionary {
    private List<Response> dictionaryObjects = new ArrayList<>();
    private static final ResponseDictionary instance = new ResponseDictionary();


    public static ResponseDictionary getInstance() {
        return instance;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Response findById(final String id) {
        System.out.println(id);
        dictionaryObjects.forEach(x -> System.out.println("DictObj>>>" + x.getClassRelated()));
        return dictionaryObjects.stream().filter(object -> object.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public void init(final List<?> dictObjects) {
        dictionaryObjects.addAll((List<Response>)dictObjects);
    }
}
