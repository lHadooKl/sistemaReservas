
package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reserva {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reserva;
    private String fecha_reserva;
    private String asiento;
    
    @ManyToOne
    @JoinColumn(name="id_pasajero")
    private Pasajero pasaje;
    
    @ManyToOne
    @JoinColumn(name="id_vuelo")
    private Vuelo vuelo;

    public Reserva() {
    }

    public Reserva(int id_reserva, String fecha_reserva, String asiento, Pasajero pasaje, Vuelo vuelo) {
        this.id_reserva = id_reserva;
        this.fecha_reserva = fecha_reserva;
        this.asiento = asiento;
        this.pasaje = pasaje;
        this.vuelo = vuelo;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public Pasajero getPasaje() {
        return pasaje;
    }

    public void setPasaje(Pasajero pasaje) {
        this.pasaje = pasaje;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
    
}
