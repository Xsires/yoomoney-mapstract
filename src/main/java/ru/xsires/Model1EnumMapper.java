package ru.xsires;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;
import ru.xsires.models.Model1Backend;
import ru.xsires.models.Model1Gateway;

@Mapper
public interface Model1EnumMapper {

    @ValueMappings({
            @ValueMapping(source = "Value3", target = "Value_3")
    })
    Model1Backend.Model1BackEnum mapModel1GatewayEnum(Model1Gateway.Model1GateEnum model);

    @InheritInverseConfiguration
    Model1Gateway.Model1GateEnum mapModel1BackendEnum(Model1Backend.Model1BackEnum model);

}
