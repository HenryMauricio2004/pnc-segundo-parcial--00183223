package com.example.pncsegundoparcial00183223.domain.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeneralResponse {
    private String uri;
    private String message;
    private Integer status;
    private LocalDate time;
    private Object data;
}
