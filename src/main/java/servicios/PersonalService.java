package servicios;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import logica.PersonalCabina;

@Stateless
public class PersonalService {
    @PersistenceContext(unitName = "reservasJpa")
    private EntityManager em;
    
    public void crearPersonal(PersonalCabina personal) {
        em.persist(personal);
    }
    
    public PersonalCabina obtenerPersonal(int id) {
        return em.find(PersonalCabina.class, id);
    }
    
    public List<PersonalCabina> obtenerTodos() {
        return em.createQuery("SELECT p FROM PersonalCabina p", PersonalCabina.class).getResultList();
    }
    
    public void actualizarPersonal(PersonalCabina personal) {
        em.merge(personal);
    }
    
    public void eliminarPersonal(int id) {
        PersonalCabina personal = obtenerPersonal(id);
        if (personal != null) {
            em.remove(personal);
        }
    }
}
