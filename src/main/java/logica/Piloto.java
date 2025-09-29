
package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Piloto extends Persona implements Serializable {

    private String licencia;
    private int horas_vuelo;
    @OneToMany(mappedBy="pilot")
    private List<Vuelo> ListaVuelo;

    public Piloto() {
    }

    public Piloto(int id, String dni, String nombre, String apellidos, String telefono, String direccion, String fecha_nac) {
        super(id, dni, nombre, apellidos, telefono, direccion, fecha_nac);
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public int getHoras_vuelo() {
        return horas_vuelo;
    }

    public void setHoras_vuelo(int horas_vuelo) {
        this.horas_vuelo = horas_vuelo;
    }

    public List<Vuelo> getListaVuelo() {
        return ListaVuelo;
    }

    public void setListaVuelo(List<Vuelo> ListaVuelo) {
        this.ListaVuelo = ListaVuelo;
    }
    
    
}
