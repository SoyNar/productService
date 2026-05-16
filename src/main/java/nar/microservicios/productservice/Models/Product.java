package nar.microservicios.productservice.Models;

import jakarta.persistence.*;
import lombok.*;
import nar.microservicios.productservice.ValueObjects.Name;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Name name;
    private Integer amount;
    private Double price;
}
