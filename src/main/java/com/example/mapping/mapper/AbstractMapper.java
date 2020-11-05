package com.example.mapping.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractMapper<Resource, Entity> {

    public abstract Resource map(Entity entity);

    public List<Resource> map(List<Entity> entities){
        if(entities == null)
            return Collections.emptyList();
        return entities.stream().map(this::map).collect(Collectors.toList());
    }
}
