package pe.com.consultorio.entity;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity(name = "Cita")
@Table(name = "Cita")
public class Cita implements Serializable {

    private static final long serialVersion = 1L;

    @Id
    @Column(name = "id_cita")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long codigo;  
    @Column(name = "fecha_cita")   
    private LocalDate fecha;
    @Column(name = "hora_cita")
    private Time hora;
    @Column(name = "estado_cita")
    private boolean estado; 
    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_tratamiento", nullable = false)
    private Tratamiento tratamiento;

}
