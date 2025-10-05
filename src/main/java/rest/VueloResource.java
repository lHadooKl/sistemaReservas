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
import logica.Vuelo;
import servicios.VueloService;

@Path("/vuelos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VueloResource {
    
    @Inject
    private VueloService vueloService;
    
    @GET
    public List<Vuelo> listarTodos() {
        return vueloService.obtenerTodos();
    }
    
    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") int id) {
        Vuelo vuelo = vueloService.obtenerVuelo(id);
        if (vuelo != null) {
            return Response.ok(vuelo).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    public Response crear(@Valid Vuelo vuelo) {
        vueloService.crearVuelo(vuelo);
        return Response.status(Response.Status.CREATED).entity(vuelo).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") int id, @Valid Vuelo vuelo) {
        Vuelo existente = vueloService.obtenerVuelo(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        vuelo.setId_vuelo(id);
        vueloService.actualizarVuelo(vuelo);
        return Response.ok(vuelo).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        Vuelo existente = vueloService.obtenerVuelo(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        vueloService.eliminarVuelo(id);
        return Response.noContent().build();
    }
}