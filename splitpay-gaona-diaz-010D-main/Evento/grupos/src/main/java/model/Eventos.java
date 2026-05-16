package model;



import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "eventos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Eventos {

    @Id
    private String id;
    private String grupoId;
    private String nombre;
    private String descripcion;
    private LocalDate fechaEvento;
    private String estado; // ACTIVO, CERRADO, CANCELADO


}