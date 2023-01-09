package cl.it.prueba.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
public class Usuario {
    @Id @Column(name = "correo_usuario")
    private String correoUsuario;

}
