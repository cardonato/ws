package ar.com.bna.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import ar.com.bna.ws.dto.Cheque;
import ar.com.bna.ws.service.ServicioCheques;
import ar.gov.bna.ws.exception.CustomFault;

@WebService
public class ChequesService {
	
    @WebMethod
    public List<Cheque> getCheques() {
    	ServicioCheques servicio = new ServicioCheques();
    	return servicio.listarCheques();
    }
    
    @WebMethod
    public Cheque agregarCheque(@WebParam(name="cheque") Cheque cheque) {
    	ServicioCheques servicio = new ServicioCheques();
    	servicio.agregarCheque(cheque);
    	return servicio.ultimo();
    }
    
    @WebMethod
    public Cheque buscarCheque(@WebParam(name="id") Long id) throws CustomFault {
    	ServicioCheques servicio = new ServicioCheques();
    	Cheque resultado = servicio.buscarCheque(id);
    	if(resultado == null)
    		throw new CustomFault(String.format("No existe el cheque id=[%d]", id));
    	else
    		return resultado;
    }

}
