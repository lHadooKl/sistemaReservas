
package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Avion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_avion;
    private String modelo;
    private int capacidad;
    
    @OneToMany(mappedBy="avio")
    private List<Vuelo> ListaVuelo;

    public Avion() {
    }

    public Avion(int id_avion, String modelo, int capacidad, List<Vuelo> ListaVuelo) {
        this.id_avion = id_avion;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.ListaVuelo = ListaVuelo;
    }

    public int getId_avion() {
        return id_avion;
    }

    public void setId_avion(int id_avion) {
        this.id_avion = id_avion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<Vuelo> getListaVuelo() {
        return ListaVuelo;
    }

    public void setListaVuelo(List<Vuelo> ListaVuelo) {
        this.ListaVuelo = ListaVuelo;
    }
    
}
