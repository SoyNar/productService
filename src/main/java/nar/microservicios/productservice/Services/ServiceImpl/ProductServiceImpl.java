package nar.microservicios.productservice.Services.ServiceImpl;

import nar.microservicios.productservice.Config.Custom.ProductNotFoundException;
import nar.microservicios.productservice.DTOs.Request.CreateProductRequestDTO;
import nar.microservicios.productservice.DTOs.Response.GeneraResponseDTo;
import nar.microservicios.productservice.Models.Product;
import nar.microservicios.productservice.Repositories.Interfaces.ProducInterfaceRepository;
import nar.microservicios.productservice.Services.Interface.ProductInterfaceService;
import nar.microservicios.productservice.ValueObjects.Name;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductInterfaceService {

    private final ProducInterfaceRepository productRepo;

    public  ProductServiceImpl(ProducInterfaceRepository producRepo){
           this.productRepo = producRepo;
    }

    @Override
    public GeneraResponseDTo create(CreateProductRequestDTO dto) {

        Product product =  Product.builder()
                .name(new Name(dto.getName()))
                .amount(dto.getAmount())
                .price(dto.getPrice())
                .build();
        Product save =  this.productRepo.save(product);
        return GeneraResponseDTo.builder()
                .id(save.getId())
                .name(save.getName().getValue())
                .amount(save.getAmount())
                .price(save.getPrice())
                .build();
    }

    @Override
    public List<GeneraResponseDTo> all() {
        return this.productRepo.findAll()
                .stream()
                .map(product -> GeneraResponseDTo.builder()
                        .id(product.getId())
                        .name(product.getName().getValue())
                        .amount(product.getAmount())
                        .price(product.getPrice())
                        .build()).toList();
    }

    @Override
    public GeneraResponseDTo getById(Long id) {
        return this.productRepo.findById(id)
                .map(product -> GeneraResponseDTo
                        .builder()
                        .id(product.getId())
                        .name(product.getName().getValue())
                        .price(product.getPrice())
                        .amount(product.getAmount())
                        .build())
                .orElseThrow(() -> new ProductNotFoundException("No encontrado"));
    }

    @Override
    public GeneraResponseDTo deleteById(Long id) {

        Product product = this.productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("no encontrado"));
         this.productRepo.delete(product);
         return GeneraResponseDTo.builder()
                 .id(product.getId())
                 .name(product.getName().getValue())
                 .price(product.getPrice())
                 .amount(product.getAmount())
                         .build();
    }

}
