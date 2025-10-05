
package rest;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import logica.AgenteVentas;
import servicios.AgenteVentasService;


@Path("/agente-ventas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AgenteVentasResource {
    
    @Inject
    private AgenteVentasService agenteVentasService;
    
    @GET
    public List<AgenteVentas> listarTodos(){
        return agenteVentasService.obtenerTodos();
    }
    
    @GET
    @Path("/{id}")
    public Response obtenerPorId( @PathParam("id") int id ){
        AgenteVentas agente = agenteVentasService.obtenerAgenteVentas(id);
        if (agente != null){
            return Response.ok( agente ).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    public Response crear ( @Valid AgenteVentas agente){
        agenteVentasService.crearAgenteVentas(agente);
        return Response.status(Response.Status.CREATED).entity(agente).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") int id,@Valid AgenteVentas agente) {
        AgenteVentas existente = agenteVentasService.obtenerAgenteVentas(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        agente.setId(id);
        agenteVentasService.actualizarAgenteVentas(agente);
        return Response.ok(agente).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        AgenteVentas existente = agenteVentasService.obtenerAgenteVentas(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        agenteVentasService.eliminarAgenteVentas(id);
        return Response.noContent().build();
    }
}