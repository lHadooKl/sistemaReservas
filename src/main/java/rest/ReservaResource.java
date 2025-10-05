/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import logica.Reserva;
import servicios.ReservaService;

/**
 *
 * @author theza
 */
@Path("/reservas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReservaResource {
    
    @Inject
    private ReservaService reservaService;
    
    @GET
    public List<Reserva> listarTodas() {
        return reservaService.obtenerTodas();
    }
    
    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") int id) {
        Reserva reserva = reservaService.obtenerReserva(id);
        if (reserva != null) {
            return Response.ok(reserva).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    public Response crear( @Valid Reserva reserva ) {
        reservaService.crearReserva(reserva);
        return Response.status(Response.Status.CREATED).entity(reserva).build();
    }
    
    @PUT
    @Path("/{id}")
    public Response actualizar(@PathParam("id") int id, @Valid Reserva reserva) {
        Reserva existente = reservaService.obtenerReserva(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        reserva.setId_reserva(id);
        reservaService.actualizarReserva(reserva);
        return Response.ok(reserva).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") int id) {
        Reserva existente = reservaService.obtenerReserva(id);
        if (existente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        reservaService.eliminarReserva(id);
        return Response.noContent().build();
    }
}