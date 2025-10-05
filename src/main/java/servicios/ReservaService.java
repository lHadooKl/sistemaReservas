package servicios;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import logica.Reserva;

@Stateless
public class ReservaService {
    @PersistenceContext(unitName = "reservasJpa")
    private EntityManager em;
    
    public void crearReserva(Reserva reserva) {
        em.persist(reserva);
    }
    
    public Reserva obtenerReserva(int id) {
        return em.find(Reserva.class, id);
    }
    
    public List<Reserva> obtenerTodas() {
        return em.createQuery("SELECT r FROM Reserva r", Reserva.class).getResultList();
    }
    
    public void actualizarReserva(Reserva reserva) {
        em.merge(reserva);
    }
    
    public void eliminarReserva(int id) {
        Reserva reserva = obtenerReserva(id);
        if (reserva != null) {
            em.remove(reserva);
        }
    }
}