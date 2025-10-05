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
import logica.Usuario;
import servicios.UsuarioService;

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    
    @Inject
    private UsuarioService usuarioService;
    
    @GET
    public List<Usuario> listarTodos() {
        return usuarioService.obtenerTodos();
    }
    
    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") int id) {
        Usuario usuario = usuarioService.obtenerUsuario(id);
        if (usuario != null) {
            return Response.ok(usuario).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    public Response crear( @Valid Usuario usuario) {
        usuarioService.crearUsuario(usuario);
        return Response.status(Response.Status.CREATED).entity(usuario).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") int id, @Valid Usuario usuario) {
        Usuario existente = usuarioService.obtenerUsuario(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        usuario.setId(id);
        usuarioService.actualizarUsuario(usuario);
        return Response.ok(usuario).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        Usuario existente = usuarioService.obtenerUsuario(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        usuarioService.eliminarUsuario(id);
        return Response.noContent().build();
    }
}
