
package rest;

import jakarta.inject.Inject;
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
import logica.Piloto;
import servicios.PilotoService;

@Path("/pilotos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PilotoResource {
    
    @Inject
    private PilotoService pilotoService;
    
    @GET
    public List<Piloto> listarTodos() {
        return pilotoService.obtenerTodos();
    }
    
    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") int id) {
        Piloto piloto = pilotoService.obtenerPiloto(id);
        if (piloto != null) {
            return Response.ok(piloto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    public Response crear(Piloto piloto) {
        pilotoService.crearPiloto(piloto);
        return Response.status(Response.Status.CREATED).entity(piloto).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") int id, Piloto piloto) {
        Piloto existente = pilotoService.obtenerPiloto(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        piloto.setId(id);
        pilotoService.actualizarPiloto(piloto);
        return Response.ok(piloto).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        Piloto existente = pilotoService.obtenerPiloto(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        pilotoService.eliminarPiloto(id);
        return Response.noContent().build();
    }
}
