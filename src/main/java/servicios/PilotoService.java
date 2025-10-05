package servicios;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import logica.Piloto;

@Stateless
public class PilotoService {
    @PersistenceContext(unitName = "reservasJpa")
    private EntityManager em;
    
    public void crearPiloto(Piloto piloto) {
        em.persist(piloto);
    }
    
    public Piloto obtenerPiloto(int id) {
        return em.find(Piloto.class, id);
    }
    
    public List<Piloto> obtenerTodos() {
        return em.createQuery("SELECT p FROM Piloto p", Piloto.class).getResultList();
    }
    
    public void actualizarPiloto(Piloto piloto) {
        em.merge(piloto);
    }
    
    public void eliminarPiloto(int id) {
        Piloto piloto = obtenerPiloto(id);
        if (piloto != null) {
            em.remove(piloto);
        }
    }
}
