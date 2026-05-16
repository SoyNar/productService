package nar.microservicios.productservice.DTOs.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequestDTO {

    @NotBlank(message = "El nombre del producto es obligatorio")
    private String name;
    private Double price;
    private Integer amount;
}
