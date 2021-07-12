package io.gd.modules.biz.resident.dto.converter;

import io.gd.modules.biz.resident.dto.ResidentSaveReqDTO;
import io.gd.modules.biz.resident.entity.ResidentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResidentSaveReqConverter {
    ResidentSaveReqConverter INSTANCE = Mappers.getMapper( ResidentSaveReqConverter.class );

    @Mappings({
            @Mapping(target = "residentId", source = "residentId")
    })
    ResidentSaveReqDTO getDto(ResidentEntity resident);

    @Mappings({
            @Mapping(target = "residentId", source = "residentId")
    })
    ResidentEntity getEntity(ResidentSaveReqDTO resident);
}
