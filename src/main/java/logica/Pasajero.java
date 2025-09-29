
package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Pasajero extends Persona implements Serializable {
    
    private String numero_frecuente;
    @OneToMany(mappedBy="pasaje")
    private List<Reserva> ListaReserva;

    public Pasajero() {
    }

    public Pasajero(int id, String dni, String nombre, String apellidos, String telefono, String direccion, String fecha_nac) {
        super(id, dni, nombre, apellidos, telefono, direccion, fecha_nac);
    }

    public String getNumero_frecuente() {
        return numero_frecuente;
    }

    public void setNumero_frecuente(String numero_frecuente) {
        this.numero_frecuente = numero_frecuente;
    }

    public List<Reserva> getListaReserva() {
        return ListaReserva;
    }

    public void setListaReserva(List<Reserva> ListaReserva) {
        this.ListaReserva = ListaReserva;
    }
    
    
}
