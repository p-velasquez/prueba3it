package cl.it.prueba.dao;

import cl.it.prueba.model.Encuesta;
import cl.it.prueba.model.GeneroMusical;
import cl.it.prueba.model.Usuario;

import java.util.List;

public interface IEncuestaDao {
    List<Encuesta> getEncuestas();

    List<GeneroMusical> getGenerosMusicales();

    void addEncuesta(Encuesta encuesta);

    void addUsuario(Usuario usuario);

}
