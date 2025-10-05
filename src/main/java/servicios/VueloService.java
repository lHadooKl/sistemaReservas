package servicios;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import logica.Vuelo;

@Stateless
public class VueloService {
    @PersistenceContext(unitName = "reservasJpa")
    private EntityManager em;
    
    public void crearVuelo(Vuelo vuelo) {
        em.persist(vuelo);
    }
    
    public Vuelo obtenerVuelo(int id) {
        return em.find(Vuelo.class, id);
    }
    
    public List<Vuelo> obtenerTodos() {
        return em.createQuery("SELECT v FROM Vuelo v", Vuelo.class).getResultList();
    }
    
    public void actualizarVuelo(Vuelo vuelo) {
        em.merge(vuelo);
    }
    
    public void eliminarVuelo(int id) {
        Vuelo vuelo = obtenerVuelo(id);
        if (vuelo != null) {
            em.remove(vuelo);
        }
    }
}
