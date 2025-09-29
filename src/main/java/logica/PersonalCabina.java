
package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class PersonalCabina extends Persona implements Serializable {

    private String rango;
    @OneToMany(mappedBy="personal")
    private List<Vuelo> ListaVuelo;

    public PersonalCabina() {
    }

    public PersonalCabina(int id, String dni, String nombre, String apellidos, String telefono, String direccion, String fecha_nac) {
        super(id, dni, nombre, apellidos, telefono, direccion, fecha_nac);
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public List<Vuelo> getListaVuelo() {
        return ListaVuelo;
    }

    public void setListaVuelo(List<Vuelo> ListaVuelo) {
        this.ListaVuelo = ListaVuelo;
    }
    
    
}
