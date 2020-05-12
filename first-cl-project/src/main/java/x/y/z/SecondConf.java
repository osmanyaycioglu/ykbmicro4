package x.y.z;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondConf {

    @Bean
    public MySecond mySecond() {
        return new MySecond();
    }
}
