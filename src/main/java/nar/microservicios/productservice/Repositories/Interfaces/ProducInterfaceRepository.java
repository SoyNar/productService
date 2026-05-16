package nar.microservicios.productservice.Repositories.Interfaces;

import nar.microservicios.productservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducInterfaceRepository  extends JpaRepository<Product, Long> {
}
