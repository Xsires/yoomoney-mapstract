package ru.xsires;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.xsires.models.Model1Backend;
import ru.xsires.models.Model1Gateway;

@Mapper(uses = {Model1EnumMapper.class})
public interface Model1ToBackendMapper {

    @Mapping(source = "id2OrNull", target = "id2", defaultValue = "Value1")
    Model1Backend mapModel1ToBackend(Model1Gateway model);

}