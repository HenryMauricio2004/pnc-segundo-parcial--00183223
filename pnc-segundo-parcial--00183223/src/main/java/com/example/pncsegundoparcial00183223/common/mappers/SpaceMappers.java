package com.example.pncsegundoparcial00183223.common.mappers;

import com.example.pncsegundoparcial00183223.domain.dtos.request.CreateSpaceRequest;
import com.example.pncsegundoparcial00183223.domain.dtos.response.SpaceResponse;
import com.example.pncsegundoparcial00183223.domain.entities.Space;
import org.springframework.stereotype.Component;

@Component
public class SpaceMappers {

    public Space toEntityCreate(CreateSpaceRequest spaceRequest){
        return Space.builder()
                .name(spaceRequest.getName())
                .description(spaceRequest.getDescription())
                .type(spaceRequest.getType())
                .capacity(spaceRequest.getCapacity())
                .pricePerHour(spaceRequest.getPricePerHour())
                .available(spaceRequest.getAvailable())
                .floor(spaceRequest.getFloor())
                .amenities(spaceRequest.getAmenities())
                .build();
    }

    public SpaceResponse toDto(Space space){
        return SpaceResponse.builder()
                .name(space.getName())
                .description(space.getDescription())
                .type(space.getType())
                .capacity(space.getCapacity())
                .pricePerHour(space.getPricePerHour())
                .available(space.getAvailable())
                .floor(space.getFloor())
                .amenities(space.getAmenities())
                .build();
    }
}
