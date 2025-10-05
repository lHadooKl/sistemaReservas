package servicios;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import logica.Usuario;

@Stateless
public class UsuarioService {
    @PersistenceContext(unitName = "reservasJpa")
    private EntityManager em;
    
    public void crearUsuario(Usuario usuario) {
        em.persist(usuario);
    }
    
    public Usuario obtenerUsuario(int id) {
        return em.find(Usuario.class, id);
    }
    
    public List<Usuario> obtenerTodos() {
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }
    
    public void actualizarUsuario(Usuario usuario) {
        em.merge(usuario);
    }
    
    public void eliminarUsuario(int id) {
        Usuario usuario = obtenerUsuario(id);
        if (usuario != null) {
            em.remove(usuario);
        }
    }
}
