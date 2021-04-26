package ar.com.bna.ws;
 
import javax.jws.WebMethod;
import javax.jws.WebService;
 
@WebService

public class Hello {
 
    @WebMethod(operationName="saludar")
    public String saludar(String nombre) {
        return String.format("Hola %s", nombre);
    }
}