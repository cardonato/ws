package ar.com.bna.wsRest;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ar.com.bna.ws.dto.Cheque;
import ar.com.bna.ws.service.ServicioCheques;
import ar.gov.bna.ws.exception.CustomFault;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@WebService

@Path("/chequesSR")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Cheque SOAP Rest Controller")
public class ChequeSOAPRestController {

	@WebMethod
	
	@GET
	@Path("/cheques")
	@ApiOperation(value = "cheques", notes = "Inicializa Cheques", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cheques Inicializados", response = List.class) })
	public Response getCheques() {
		ServicioCheques servicio = new ServicioCheques();
		return Response.ok().entity(servicio.listarCheques()).build();
	}

	@WebMethod
	
	@GET
	@Path("/{id}")
	@ApiOperation(value = "id", notes = "Busca cheque por ID", response = Cheque.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cheque by ID", response = Cheque.class),
			@ApiResponse(code = 404, message = "Cheque no encontrado", response = String.class) })
	public Response buscarCheque(@PathParam("id") @WebParam(name="id")  Long id) {
		ServicioCheques servicio = new ServicioCheques();
		Cheque resultado;
		try {
			resultado = servicio.buscarCheque(id);
			return Response.ok().entity(resultado).build();
		} catch (CustomFault e) {
			return Response.status(Status.NOT_FOUND).entity("No se encontro el Cheque").build();
		}
	}

	@WebMethod
	
	@POST
	@Path("/agregarCheque")
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "agregarCheque", notes = "Agrega cheque", response = Cheque.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cheque Agregado", response = Cheque.class) })
	public Response agregarCheque(@WebParam(name="cheque") @ApiParam(name="cheque") Cheque cheque) {
		ServicioCheques servicio = new ServicioCheques();
		servicio.agregarCheque(cheque);
		return Response.ok().entity(servicio.ultimo()).build();
	}
	
	@WebMethod
	
	@PUT
	@Path("/modificarCheque")
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "modificarCheque", notes = "Modifica Cheque", response = Cheque.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cheque Modificado", response = Cheque.class) })
	public Response modificarCheque(@WebParam(name="cheque") @ApiParam(name="cheque") Cheque cheque) throws CustomFault {
		ServicioCheques servicio = new ServicioCheques();
		Cheque respuesta = servicio.modificarCheque(cheque);
		return Response.ok().entity(respuesta).build();
	}
	
	@WebMethod
	
	@DELETE
	@Path("/eliminarCheque")
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "eliminarCheque", notes = "Elimina Cheque", response = Cheque.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cheque Eliminado", response = Cheque.class) })
	public Response eliminarCheque(@WebParam(name="cheque") @ApiParam(name="cheque") Cheque cheque) throws CustomFault {
		ServicioCheques servicio = new ServicioCheques();
		try {
			servicio.eliminarCheque(cheque.getId());
			return Response.status(Status.OK).entity("Cheque con ID: " + cheque.getId() + "eliminado").build();
		}
		catch (CustomFault e) {
			return Response.status(Status.NOT_FOUND).entity("No se encontro el Cheque").build();
		}
	}
}
