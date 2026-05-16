package nar.microservicios.productservice.Services.Interface;

import nar.microservicios.productservice.DTOs.Request.CreateProductRequestDTO;
import nar.microservicios.productservice.DTOs.Response.GeneraResponseDTo;

import java.util.List;

public interface ProductInterfaceService {

    GeneraResponseDTo create (CreateProductRequestDTO dto);
    List<GeneraResponseDTo> all();
    GeneraResponseDTo getById(Long id);
    GeneraResponseDTo deleteById(Long id);
}
