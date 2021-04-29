package ar.com.bna.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import ar.com.bna.wsRest.ChequeSOAPRestController;
import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("/api")
public class RestApplication extends Application {

	public RestApplication() {
		BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:9080");
        beanConfig.setBasePath("soapRest/api");
//        beanConfig.setResourcePackage(ChequeSOAPRestController.class.getPackage().getName());
        beanConfig.setResourcePackage("ar.com.bna.rest,ar.com.bna.wsRest");
        beanConfig.setTitle("Swagger Json para JAX-RS");
        beanConfig.setDescription("Documentacion Swagger para API REST (JAX-RS) Cheques");
        beanConfig.setScan(true);
	}

}
