package com.example.pncsegundoparcial00183223.controllers;

import com.example.pncsegundoparcial00183223.domain.dtos.request.UpdateSpaceRequest;
import com.example.pncsegundoparcial00183223.domain.dtos.response.GeneralResponse;
import com.example.pncsegundoparcial00183223.services.impl.SpaceServicesImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;

@RestController
@RequestMapping("api/spaces")
@AllArgsConstructor
public class SpaceController {

    private SpaceServicesImpl spaceServices;

    @GetMapping("/")
    public ResponseEntity<GeneralResponse> getAllSpaces(){
        return buildGeneralResponse(
                HttpStatus.OK,
                "All spaces found successfully",
                spaceServices.getAllSpaces()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse> getSpaceById(@PathVariable Long id){
        return buildGeneralResponse(
                HttpStatus.OK,
                "Space found successfully",
                spaceServices.getSpaceById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse> updateSpace(@PathVariable Long id, @RequestBody @Valid UpdateSpaceRequest spaceRequest){
        return buildGeneralResponse(
                HttpStatus.OK,
                "Space updated successfully",
                spaceServices.updateSpace(id, spaceRequest)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponse> deleteSpace(@PathVariable Long id){
        return buildGeneralResponse(
                HttpStatus.OK,
                "Space deleted successfully",
                spaceServices.deleteSpace(id)
        );
    }

    public ResponseEntity<GeneralResponse> buildGeneralResponse(HttpStatus status, String message, Object data){
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
        return ResponseEntity
                .status(status)
                .body(
                      GeneralResponse.builder()
                              .status(status.value())
                              .message(message)
                              .time(LocalDate.now())
                              .data(data)
                              .build()
                );
    }
}
