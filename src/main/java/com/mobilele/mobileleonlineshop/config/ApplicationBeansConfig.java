package com.mobilele.mobileleonlineshop.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeansConfig {

    @Bean
    public Gson gson(){
        return new GsonBuilder().setPrettyPrinting()

                //registerTypeAdapter(Srource.class,new SourceTypeAdapter())

                .create();
    }
}
