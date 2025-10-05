package servicios;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import logica.Persona;

@Stateless
public class PersonaService {
    @PersistenceContext(unitName = "reservasJpa")
    private EntityManager em;
    
    public void crearPersona(Persona persona) {
        em.persist(persona);
    }
    
    public Persona obtenerPersona(int id) {
        return em.find(Persona.class, id);
    }
    
    public List<Persona> obtenerTodas() {
        return em.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
    }
    
    public void actualizarPersona(Persona persona) {
        em.merge(persona);
    }
    
    public void eliminarPersona(int id) {
        Persona persona = obtenerPersona(id);
        if (persona != null) {
            em.remove(persona);
        }
    }
}
