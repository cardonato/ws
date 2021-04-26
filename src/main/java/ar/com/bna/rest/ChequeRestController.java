package ar.com.bna.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/chequesRest")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "Cheque Rest Controller")
public class ChequeRestController {

	@GET
	@Path("/cheques")
	@ApiOperation(value = "cheques", notes = "Inicializa Cheques", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cheques Inicializados", response = List.class) })
	public Response getCheques() {
		ServicioCheques servicio = new ServicioCheques();
		return Response.ok().entity(servicio.listarCheques()).build();
	}

	@GET
	@Path("/{id}")
	@ApiOperation(value = "id", notes = "Busca cheque por ID", response = Cheque.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cheque by ID", response = Cheque.class),
			@ApiResponse(code = 404, message = "Cheque no encontrado", response = String.class) })
	public Response buscarCheque(@PathParam("id") Long id) {
		ServicioCheques servicio = new ServicioCheques();
		Cheque resultado;
		try {
			resultado = servicio.buscarCheque(id);
			return Response.ok().entity(resultado).build();
		} catch (CustomFault e) {
			return Response.status(Status.NOT_FOUND).entity("No se encontro el Cheque").build();
		}
	}

	@POST
	@Path("/agregarCheque")
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "agregarCheque", notes = "Agrega cheque", response = Cheque.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cheque Agregado", response = Cheque.class) })
	public Response agregarCheque(Cheque cheque) {
		ServicioCheques servicio = new ServicioCheques();
		servicio.agregarCheque(cheque);
		return Response.ok().entity(servicio.ultimo()).build();
	}
}
