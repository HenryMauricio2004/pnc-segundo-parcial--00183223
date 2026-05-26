package com.example.pncsegundoparcial00183223.domain.dtos.response;

import com.example.pncsegundoparcial00183223.common.enums.TypeEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpaceResponse {

    private Long id;

    private String name;

    private String description;

    private TypeEnum type;

    private Integer capacity;

    private BigDecimal pricePerHour;

    private Boolean available;

    private Integer floor;

    private String amenities;
}
