package com.example.pncsegundoparcial00183223.domain.dtos.request;

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
public class UpdateSpaceRequest {
    @UniqueElements
    @NotBlank
    private String name;

    private String description;

    private TypeEnum type;

    @Positive
    @Min(value = 1)
    private Integer capacity;

    @Positive
    private BigDecimal pricePerHour;

    private Boolean available;

    @Min(value = 0)
    private Integer floor;

    private String amenities;
}
