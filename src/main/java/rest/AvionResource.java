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
import logica.Avion;
import servicios.AvionService;

@Path("/aviones")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AvionResource {
    
    @Inject
    private AvionService avionService;
    
    @GET
    public List<Avion> listarTodos() {
        return avionService.obtenerTodos();
    }
    
    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") int id) {
        Avion avion = avionService.obtenerAvion(id);
        if (avion != null) {
            return Response.ok(avion).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    public Response crear(@Valid Avion avion) {
        avionService.crearAvion(avion);
        return Response.status(Response.Status.CREATED).entity(avion).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") int id, @Valid Avion avion) {
        Avion existente = avionService.obtenerAvion(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        avion.setId_avion(id);
        avionService.actualizarAvion(avion);
        return Response.ok(avion).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        Avion existente = avionService.obtenerAvion(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        avionService.eliminarAvion(id);
        return Response.noContent().build();
    }
}
