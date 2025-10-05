package servicios;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import logica.Avion;

@Stateless
public class AvionService {
    @PersistenceContext(unitName = "reservasJpa")
    private EntityManager em;
    
    public void crearAvion(Avion avion) {
        em.persist(avion);
    }
    
    public Avion obtenerAvion(int id) {
        return em.find(Avion.class, id);
    }
    
    public List<Avion> obtenerTodos() {
        return em.createQuery("SELECT a FROM Avion a", Avion.class).getResultList();
    }
    
    public void actualizarAvion(Avion avion) {
        em.merge(avion);
    }
    
    public void eliminarAvion(int id) {
        Avion avion = obtenerAvion(id);
        if (avion != null) {
            em.remove(avion);
        }
    }
}
