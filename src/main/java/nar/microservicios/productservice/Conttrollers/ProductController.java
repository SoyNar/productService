package nar.microservicios.productservice.Conttrollers;

import jakarta.validation.Valid;
import lombok.Getter;
import nar.microservicios.productservice.DTOs.Request.CreateProductRequestDTO;
import nar.microservicios.productservice.DTOs.Response.GeneraResponseDTo;
import nar.microservicios.productservice.Services.Interface.ProductInterfaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductInterfaceService interfaceService;


    public ProductController(ProductInterfaceService interfaceService){
        this.interfaceService = interfaceService;
    }


    @PostMapping
    public ResponseEntity<GeneraResponseDTo> create(@Valid @RequestBody
    CreateProductRequestDTO requestDTO){
        GeneraResponseDTo responseDto = interfaceService.create(requestDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/")
    public  ResponseEntity<List<GeneraResponseDTo>> all(){
        List<GeneraResponseDTo> response = this.interfaceService.all();
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneraResponseDTo> delete(@PathVariable Long id){
        GeneraResponseDTo response = this.interfaceService.deleteById(id);
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneraResponseDTo> getById(@PathVariable Long id){
        GeneraResponseDTo response = this.interfaceService.getById(id);
        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
