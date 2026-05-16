package nar.microservicios.productservice.Config.Custom;

public class ProductNotFoundException extends  RuntimeException{

    public  ProductNotFoundException(String message){
        super(message);
    }
}
