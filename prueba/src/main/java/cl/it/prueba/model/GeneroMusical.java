package cl.it.prueba.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@Table(name = "genero_musical")
@Data
@NoArgsConstructor
public class GeneroMusical {
    @Id
    @Column(name = "id_genero_musical")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idGeneroMusical;

    @Column(name = "nombre")
    private String nombre;
}
