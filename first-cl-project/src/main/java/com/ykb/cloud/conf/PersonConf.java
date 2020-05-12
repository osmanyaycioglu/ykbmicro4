package com.ykb.cloud.conf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.ykb.cloud.PersonManager;

import x.y.z.SecondConf;

@Configuration
@Import(SecondConf.class)
public class PersonConf {

    @Bean
    @Qualifier("osmanManager")
    public PersonManager pManager() {
        return new PersonManager();
    }


}
