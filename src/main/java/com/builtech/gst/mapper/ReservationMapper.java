package com.builtech.gst.mapper;

import com.builtech.gst.dto.ReservationDto;
import com.builtech.gst.entity.Reservation;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = CalendrierMapper.class, componentModel = "spring")
public interface ReservationMapper {

    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mappings({
            @Mapping(source = "prix", target = "price"), @Mapping(source = "statut", target = "status"),
            @Mapping(target = "client", expression = "java(reservation.getClient().getEmail())"),
            @Mapping(target = "stade", expression = "java(reservation.getStade().getName())")
    })
    ReservationDto reservationToDto(Reservation reservation);
}
