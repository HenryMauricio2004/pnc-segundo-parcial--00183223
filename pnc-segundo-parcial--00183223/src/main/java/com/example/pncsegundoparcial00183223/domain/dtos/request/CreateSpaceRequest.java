package com.example.pncsegundoparcial00183223.domain.dtos.request;
import com.example.pncsegundoparcial00183223.common.enums.TypeEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class CreateSpaceRequest {

    @UniqueElements (message = "name cannot be repeated")
    @NotBlank (message = "name cannot be blank")
    private String name;

    private String description;

    private TypeEnum type;

    @Positive (message = "capacity has to be positive")
    @Min(value = 1, message = "capacity has to be 1 or more")
    private Integer capacity;

    @Positive (message = "price has to be positive")
    private BigDecimal pricePerHour;
    
    private Boolean available;

    @Min(value = 0, message = "floor has to be positive")
    private Integer floor;

    private String amenities;
}
