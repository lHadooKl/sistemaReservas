
package logica;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
public class Vuelo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_vuelo;
    
    @NotBlank(message = "El origen no puede estar vacío")
    @Size(max = 100, message = "El origen no debe superar 100 caracteres")
    private String origen;
    
    @NotBlank(message = "El destino no puede estar vacío")
    @Size(max = 100, message = "El destino no debe superar 100 caracteres")
    private String destino;
    
    @NotBlank(message = "La fecha de vuelo no puede estar vacía")
    @Pattern(
            regexp = "\\d{4}-\\d{2}-\\d{2}", 
            message = "La fecha debe tener el formato YYYY-MM-DD"
    )
    private String fecha_inicio_vuelo;
    
    @NotBlank(message = "La hora de salida no puede estar vacía")
    @Pattern(
            regexp = "\\d{2}:\\d{2}", 
            message = "La hora de salida debe tener el formato HH:MM"
    )
    private String hora_inicio_vuelo;
    
    @NotBlank(message = "La fecha fin de vuelo no puede estar vacía")
    @Pattern(
            regexp = "\\d{4}-\\d{2}-\\d{2}", 
            message = "La fecha fin debe tener el formato YYYY-MM-DD"
    )
    private String fecha_fin_vuelo;
    
    @NotBlank(message = "La hora fin de salida no puede estar vacía")
    @Pattern(
            regexp = "\\d{2}:\\d{2}", 
            message = "La hora fin de salida debe tener el formato HH:MM"
    )
    private String hora_fin_vuelo;
    
    @ManyToOne
    @NotNull(message = "El Piloto es obligatorio")
    @JoinColumn(name="id_piloto")
    private Piloto pilot;
    
    @ManyToOne
    @NotNull(message = "El PersonalCabina es obligatorio")
    @JoinColumn(name="id_personal")
    private PersonalCabina personal;
    
    @ManyToOne
    @NotNull(message = "El Avion es obligatorio")
    @JoinColumn(name="id_avion")
    private Avion avio;
    
    @ManyToOne
    @NotNull(message = "El AgenteVentas es obligatorio")
    @JoinColumn(name="id_agente")
    @JsonbTransient
    private AgenteVentas agente;
    
    @OneToMany(mappedBy="vuelo")
    private List<Reserva> ListaReserva;

    public Vuelo() {
    }

    public Vuelo(int id_vuelo, String origen, String destino, String fecha_inicio_vuelo, String hora_inicio_vuelo, String fecha_fin_vuelo, String hora_fin_vuelo, Piloto pilot, PersonalCabina personal, Avion avio, AgenteVentas agente, List<Reserva> ListaReserva) {
        this.id_vuelo = id_vuelo;
        this.origen = origen;
        this.destino = destino;
        this.fecha_inicio_vuelo = fecha_inicio_vuelo;
        this.hora_inicio_vuelo = hora_inicio_vuelo;
        this.fecha_fin_vuelo = fecha_fin_vuelo;
        this.hora_fin_vuelo = hora_fin_vuelo;
        this.pilot = pilot;
        this.personal = personal;
        this.avio = avio;
        this.agente = agente;
        this.ListaReserva = ListaReserva;
    }

    public int getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(int id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha_inicio_vuelo() {
        return fecha_inicio_vuelo;
    }

    public void setFecha_inicio_vuelo(String fecha_inicio_vuelo) {
        this.fecha_inicio_vuelo = fecha_inicio_vuelo;
    }

    public String getHora_inicio_vuelo() {
        return hora_inicio_vuelo;
    }

    public void setHora_inicio_vuelo(String hora_inicio_vuelo) {
        this.hora_inicio_vuelo = hora_inicio_vuelo;
    }

    public String getFecha_fin_vuelo() {
        return fecha_fin_vuelo;
    }

    public void setFecha_fin_vuelo(String fecha_fin_vuelo) {
        this.fecha_fin_vuelo = fecha_fin_vuelo;
    }

    public String getHora_fin_vuelo() {
        return hora_fin_vuelo;
    }

    public void setHora_fin_vuelo(String hora_fin_vuelo) {
        this.hora_fin_vuelo = hora_fin_vuelo;
    }

    public Piloto getPilot() {
        return pilot;
    }

    public void setPilot(Piloto pilot) {
        this.pilot = pilot;
    }

    public PersonalCabina getPersonal() {
        return personal;
    }

    public void setPersonal(PersonalCabina personal) {
        this.personal = personal;
    }

    public Avion getAvio() {
        return avio;
    }

    public void setAvio(Avion avio) {
        this.avio = avio;
    }

    public AgenteVentas getAgente() {
        return agente;
    }

    public void setAgente(AgenteVentas agente) {
        this.agente = agente;
    }

    public List<Reserva> getListaReserva() {
        return ListaReserva;
    }

    public void setListaReserva(List<Reserva> ListaReserva) {
        this.ListaReserva = ListaReserva;
    }
    
    
    
}
