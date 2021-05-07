package ar.com.bna.rest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import io.swagger.jaxrs.config.BeanConfig;

public class SwaggerJaxrsConfig extends HttpServlet {

	@Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
//      Bean de configuracion para Swagger UI
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setTitle("Swagger Cheques");
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        //Host donde buscara el swagger.json
        beanConfig.setHost("localhost:9080");
        beanConfig.setBasePath("soapRest/api");
        //Posible implementacion de Package basado en nombre de Clase
//        beanConfig.setResourcePackage(ChequeSOAPRestController.class.getPackage().getName());
        //Implementacion de packages separados por coma para que scanee Servicios REST
        beanConfig.setResourcePackage("ar.com.bna.rest,ar.com.bna.wsRest");
        //Titulos y Descripciones para la Home de Swagger UI
        beanConfig.setTitle("Swagger Json para JAX-RS");
        beanConfig.setDescription("Documentacion Swagger para API REST (JAX-RS) Cheques");
        beanConfig.setScan(true);
	}
}