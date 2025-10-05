
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
import logica.Persona;
import servicios.PersonaService;

@Path("/personas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonaResource {
    
    @Inject
    private PersonaService personaService;
    
    @GET
    public List<Persona> listarTodas() {
        return personaService.obtenerTodas();
    }
    
    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") int id) {
        Persona persona = personaService.obtenerPersona(id);
        if (persona != null) {
            return Response.ok(persona).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    public Response crear( @Valid Persona persona) {
        personaService.crearPersona(persona);
        return Response.status(Response.Status.CREATED).entity(persona).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") int id, @Valid Persona persona) {
        Persona existente = personaService.obtenerPersona(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        persona.setId(id);
        personaService.actualizarPersona(persona);
        return Response.ok(persona).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        Persona existente = personaService.obtenerPersona(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        personaService.eliminarPersona(id);
        return Response.noContent().build();
    }
}
