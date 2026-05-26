package com.example.pncsegundoparcial00183223.domain.entities;

import com.example.pncsegundoparcial00183223.common.enums.TypeEnum;
import jakarta.persistence.*;
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
@Entity
@Table(name = "Space")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private TypeEnum type;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "pricePerHour")
    private BigDecimal pricePerHour;

    @Column(name = "available")
    private Boolean available;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "amenities")
    private String amenities;
}
