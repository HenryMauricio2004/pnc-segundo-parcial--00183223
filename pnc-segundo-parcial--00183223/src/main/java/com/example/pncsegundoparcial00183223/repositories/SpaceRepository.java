package com.example.pncsegundoparcial00183223.repositories;

import com.example.pncsegundoparcial00183223.domain.entities.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpaceRepository extends JpaRepository<Space, UUID> {

    List<Space> getAllSpaces();
    Space getSpaceById(Long id);
    Space deleteById(Long id);
}
