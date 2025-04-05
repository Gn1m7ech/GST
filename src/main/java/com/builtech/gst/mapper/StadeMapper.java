package com.builtech.gst.mapper;

import com.builtech.gst.dto.StadeDto;
import com.builtech.gst.entity.Stade;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StadeMapper {

    StadeMapper INSTANCE = Mappers.getMapper(StadeMapper.class);

    @Mapping(source = "location", target = "localisaation")
    StadeDto stadeToDto(Stade stade);

}
