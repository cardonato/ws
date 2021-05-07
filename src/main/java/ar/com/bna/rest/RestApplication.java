package ar.com.bna.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.jaxrs.config.BeanConfig;

/**
 * @author Fernando
 * Clase que representa la App Rest con su respectiva configuracion para Swagger
 *
 */
@ApplicationPath("/api")
public class RestApplication extends Application {

	public RestApplication() {
//		//Bean de configuracion para Swagger UI
//		BeanConfig beanConfig = new BeanConfig();
//		beanConfig.setTitle("Swagger Cheques");
//        beanConfig.setVersion("1.0.0");
//        beanConfig.setSchemes(new String[]{"http"});
//        //Host donde buscara el swagger.json
//        beanConfig.setHost("localhost:9080");
//        beanConfig.setBasePath("soapRest/api");
//        //Posible implementacion de Package basado en nombre de Clase
////        beanConfig.setResourcePackage(ChequeSOAPRestController.class.getPackage().getName());
//        //Implementacion de packages separados por coma para que scanee Servicios REST
//        beanConfig.setResourcePackage("ar.com.bna.rest,ar.com.bna.wsRest");
//        //Titulos y Descripciones para la Home de Swagger UI
//        beanConfig.setTitle("Swagger Json para JAX-RS");
//        beanConfig.setDescription("Documentacion Swagger para API REST (JAX-RS) Cheques");
//        beanConfig.setScan(true);
	}
//	@Override
//	public Set<Class<?>> getClasses() {
//	    Set<Class<?>> resources = new HashSet();
//	    resources.add(ChequeSOAPRestController.class);
//	    //...       
//	    resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
//	    resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
//	    return resources;
//	}

}
