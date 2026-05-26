package com.example.pncsegundoparcial00183223.services.impl;

import com.example.pncsegundoparcial00183223.common.mappers.SpaceMappers;
import com.example.pncsegundoparcial00183223.domain.dtos.request.CreateSpaceRequest;
import com.example.pncsegundoparcial00183223.domain.dtos.request.UpdateSpaceRequest;
import com.example.pncsegundoparcial00183223.domain.dtos.response.SpaceResponse;
import com.example.pncsegundoparcial00183223.domain.entities.Space;
import com.example.pncsegundoparcial00183223.exceptions.SpaceNotFoundException;
import com.example.pncsegundoparcial00183223.repositories.SpaceRepository;
import com.example.pncsegundoparcial00183223.services.SpaceServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SpaceServicesImpl implements SpaceServices {

    private SpaceRepository spaceRepository;
    private SpaceMappers spaceMappers;

    public SpaceResponse createSpace(CreateSpaceRequest spaceRequest){
        return spaceMappers.toDto(
                spaceRepository.save(spaceMappers.toEntityCreate(spaceRequest))
        );
    }

    public List<SpaceResponse> getAllSpaces(){
        List<Space> spaceList = spaceRepository.findAll();
        return spaceList.stream().map(spaceMappers::toDto).toList();
    }

    public SpaceResponse getSpaceById(Long id){
        return spaceMappers.toDto(spaceRepository.getSpaceById(id));
    }

    public SpaceResponse updateSpace(Long id, UpdateSpaceRequest updateSpaceRequest){
        Space originalSpace = spaceRepository.getSpaceById(id);

        if (originalSpace == null){
            throw new SpaceNotFoundException("No Space Found");
        } else {

            originalSpace.setName(updateSpaceRequest.getName());
            originalSpace.setDescription(updateSpaceRequest.getDescription());
            originalSpace.setType(updateSpaceRequest.getType());
            originalSpace.setCapacity(updateSpaceRequest.getCapacity());
            originalSpace.setPricePerHour(updateSpaceRequest.getPricePerHour());
            originalSpace.setAvailable(updateSpaceRequest.getAvailable());
            originalSpace.setFloor(updateSpaceRequest.getFloor());
            originalSpace.setAmenities(updateSpaceRequest.getAmenities());

            return spaceMappers.toDto(spaceRepository.save(originalSpace));
        }
    }

    public SpaceResponse deleteSpace(Long id){
        Space space = spaceRepository.getSpaceById(id);

        if (space == null){
            throw new SpaceNotFoundException("No Space Found");
        } else {
            return spaceMappers.toDto(spaceRepository.deleteById(id));
        }
    }

}
