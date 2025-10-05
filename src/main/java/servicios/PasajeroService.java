package servicios;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import logica.Pasajero;

@Stateless
public class PasajeroService {
    @PersistenceContext(unitName = "reservasJpa")
    private EntityManager em;
    
    public void crearPasajero(Pasajero pasajero) {
        em.persist(pasajero);
    }
    
    public void actualizarPasajero(Pasajero pasajero) {
        em.merge(pasajero);
    }
    
    public void eliminarPasajero(int id) {
        Pasajero pasajero = em.find(Pasajero.class, id);
        if (pasajero != null) {
            em.remove(pasajero);
        }
    }
    
    public Pasajero obtenerPasajero(int id){
        return em.find(Pasajero.class, id);
    }
    
    public List<Pasajero> obtenerTodoslosPasajeros() {
        TypedQuery<Pasajero> query = em.createQuery(
                "SELECT p FROM Pasajero as p", Pasajero.class
        );
        return query.getResultList();
    }
    
    public List<Pasajero> buscarPorNumeroFrecuente(String numeroFrecuente) {
        TypedQuery<Pasajero> query = em.createQuery(
                "SELECT p FROM Pasajero as p WHERE p.numero_frecuente = :numero", Pasajero.class
        );
        query.setParameter("numero", numeroFrecuente);
        return query.getResultList();
    }
    
}
