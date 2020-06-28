package pokespring.pokespringserver;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import pokespring.pokespringserver.model.Response;
import pokespring.pokespringserver.model.ResponseDictionary;

import java.util.ArrayList;
import java.util.List;

@Component
public class DictionaryInitBean {

    public void init() {
        List<Response> initResponses = new ArrayList<>();
        final Response userExistsResponse = new Response("USER_RESP_EXISTS", "User already exists", Response.class.getName());
        System.out.println("INIT RESPONSE DICTIONARY>>>>>>>>>>>>>>>>>>");
        initResponses.add(userExistsResponse);
        ResponseDictionary.getInstance().init(initResponses);
    }
}
