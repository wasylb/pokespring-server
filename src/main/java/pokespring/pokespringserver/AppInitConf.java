package pokespring.pokespringserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppInitConf {

    @Bean(initMethod="init")
    public DictionaryInitBean dictionaryInitBean() {
        return new DictionaryInitBean();
    }

}
