
package servicios;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import logica.AgenteVentas;

@Stateless
public class AgenteVentasService {
    @PersistenceContext(unitName="reservasJpa")
    private EntityManager em;
    
    public void crearAgenteVentas(AgenteVentas agente){
        em.persist(agente);
    }
    
    public AgenteVentas obtenerAgenteVentas(int id){
        return em.find(AgenteVentas.class, id);
    }
    
    public List<AgenteVentas> obtenerTodos(){
        return em.createQuery("SELECT a FROM AgenteVentas as a", AgenteVentas.class ).getResultList();
    }
    
    public void actualizarAgenteVentas(AgenteVentas agente){
        em.merge(agente);
    }
    
    public void eliminarAgenteVentas(int id){
        AgenteVentas agente = obtenerAgenteVentas(id);
        
        if(agente != null){
            em.remove(agente);
        }
        
    }
    
}
