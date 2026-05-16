package nar.microservicios.productservice.DTOs.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nar.microservicios.productservice.ValueObjects.Name;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneraResponseDTo {

    private Long id;
    private String name;
    private Integer amount;
    private Double price;
}
