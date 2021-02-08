package com.mobilele.mobileleonlineshop.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mobilele.mobileleonlineshop.entities.enums.Category;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationBeansConfig {

    @Bean
    public Gson gson(){
        return new GsonBuilder().setPrettyPrinting()

                //registerTypeAdapter(Srource.class,new SourceTypeAdapter())

                .create();
    }

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE).setMatchingStrategy(MatchingStrategies.STANDARD);

//        mapper.addConverter(new Converter<Integer, Category>() {
//            @Override
//            public Category convert(MappingContext<Integer, Category> mappingContext) {
//                return mappingContext.getDestination().;
//            }
//        });

        return mapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
