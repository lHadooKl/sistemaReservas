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
import logica.PersonalCabina;
import servicios.PersonalService;

@Path("/personalCabina")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonalResource {
    
    @Inject
    private PersonalService personalService;
    
    @GET
    public List<PersonalCabina> listarTodos(){
        return personalService.obtenerTodos();
    }
    
    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") int id){
        PersonalCabina personal = personalService.obtenerPersonal(id);
        if (personal != null){
            return Response.ok(personal).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    public Response crear(@Valid PersonalCabina personal){
        personalService.crearPersonal(personal);
        return Response.status(Response.Status.CREATED).entity(personal).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") int id, @Valid PersonalCabina personal){
        PersonalCabina existente = personalService.obtenerPersonal(id);
        if (existente == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        personal.setId(id);
        personalService.actualizarPersonal(personal);
        return Response.ok(personal).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id){
        PersonalCabina existente = personalService.obtenerPersonal(id);
        if (existente == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        personalService.eliminarPersonal(id);
        return Response.noContent().build();
    }
}
