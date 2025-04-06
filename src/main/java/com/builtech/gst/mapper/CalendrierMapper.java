package com.builtech.gst.mapper;

import com.builtech.gst.dto.CalendrierDto;
import com.builtech.gst.entity.Calendrier;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CalendrierMapper {

    CalendrierMapper INSTANCE = Mappers.getMapper(CalendrierMapper.class);
    CalendrierDto CalendrierToDto(Calendrier calendrier);

}
