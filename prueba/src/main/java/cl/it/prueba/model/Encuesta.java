package cl.it.prueba.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@AllArgsConstructor
@Entity
@Table(name = "encuesta")
@Data
@NoArgsConstructor
public class Encuesta {
    @Id @Column(name = "id_encuesta") @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idEncuesta;
    @Column(name = "fecha")
    private Timestamp fecha;

    @Column(name = "correo_usuario")
    private String correoUsuario;

    @Column(name = "id_genero_musical")
    private Long idGeneroMusical;
}
