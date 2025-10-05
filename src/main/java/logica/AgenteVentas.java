
package logica;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@Entity
public class AgenteVentas extends Persona implements Serializable {
    
    @NotBlank(message = "El nombre de la oficiona no puede estar vacio")
    @Size(max = 100, message = "El nombre de la oficina no puede superar los 100 caracteres")
    private String oficina;
    
    @OneToMany(mappedBy="agente")
    @JsonbTransient
    private List<Vuelo> ListaVuelo;

    public AgenteVentas() {
    }

    public AgenteVentas(String oficina, List<Vuelo> ListaVuelo, int id, String dni, String nombre, String apellidos, String telefono, String direccion, String fecha_nac) {
        super(id, dni, nombre, apellidos, telefono, direccion, fecha_nac);
        this.oficina = oficina;
        this.ListaVuelo = ListaVuelo;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public List<Vuelo> getListaVuelo() {
        return ListaVuelo;
    }

    public void setListaVuelo(List<Vuelo> ListaVuelo) {
        this.ListaVuelo = ListaVuelo;
    }
 
}
