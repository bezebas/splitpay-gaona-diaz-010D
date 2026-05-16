package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "participantes_evento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipanteEvento {
    @Id
    private String id;
    private String eventoId;
    private String usuarioId;
}