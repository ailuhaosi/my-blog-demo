package io.gd.modules.biz.region.dto.converter;

import io.gd.modules.biz.region.dto.RegionSaveReqDTO;
import io.gd.modules.biz.region.entity.RegionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RegionSaveReqConverter {
    RegionSaveReqConverter INSTANCE = Mappers.getMapper( RegionSaveReqConverter.class );

    @Mappings({
            @Mapping(target = "regionId", source = "regionId")
    })
    RegionSaveReqDTO getDto(RegionEntity region);

    @Mappings({
            @Mapping(target = "regionId", source = "regionId")
    })
    RegionEntity getEntity(RegionSaveReqDTO region);
}
