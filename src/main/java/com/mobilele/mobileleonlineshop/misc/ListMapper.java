package com.mobilele.mobileleonlineshop.misc;

import com.mobilele.mobileleonlineshop.misc.interfaces.LambdaTarget;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ListMapper {

    ModelMapper modelMapper;

    <S, T> List<T> mapList(List<S> sourceList, Class<T> targetClass) {
        return sourceList.stream()
                .map(i -> {

                    return modelMapper.map(i, targetClass);
                }).collect(Collectors.toList());
    }


}
