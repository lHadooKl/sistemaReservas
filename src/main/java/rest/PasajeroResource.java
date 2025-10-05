
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
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import logica.Pasajero;
import servicios.PasajeroService;

@Path("/pasajeros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PasajeroResource {
    
    @Inject
    private PasajeroService pasajeroService;
    
    @GET
    public List<Pasajero> listarTodos() {
        return pasajeroService.obtenerTodoslosPasajeros();
    }
    
    @POST
    public Response crear(Pasajero pasajero) {
        pasajeroService.crearPasajero(pasajero);
        return Response.status(Response.Status.CREATED).entity(pasajero).build();
    }
    
    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") int id) {
        Pasajero pasajero = pasajeroService.obtenerPasajero(id);
        if (pasajero != null) {
            return Response.ok(pasajero).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") int id, Pasajero pasajero) {
        Pasajero existente = pasajeroService.obtenerPasajero(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        pasajero.setId(id); // aseguramos que el ID es el mismo
        pasajeroService.actualizarPasajero(pasajero);
        return Response.ok(pasajero).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        Pasajero existente = pasajeroService.obtenerPasajero(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        pasajeroService.eliminarPasajero(id);
        return Response.noContent().build();
    }


    @GET
    @Path("/frecuente/{numero}")
    public List<Pasajero> buscarPorNumeroFrecuente(@PathParam("numero") String numero) {
        return pasajeroService.buscarPorNumeroFrecuente(numero);
    }

}
