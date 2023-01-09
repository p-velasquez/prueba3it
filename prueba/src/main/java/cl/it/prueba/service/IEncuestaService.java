package cl.it.prueba.service;

import cl.it.prueba.model.Encuesta;
import cl.it.prueba.model.GeneroMusical;

import java.util.List;
import java.util.Map;

public interface IEncuestaService {
    Map<String, Integer> getResultados();
    List<GeneroMusical> getGenerosMusicales();
    void addEncuesta(Encuesta encuesta);
}
