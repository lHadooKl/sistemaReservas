
package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
public class PersonalCabina extends Persona implements Serializable {
    
    @NotBlank(message = "El rango es obligatorio")
    @Size(max = 50, message = "El rango no puede superar los 50 caracteres")
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
