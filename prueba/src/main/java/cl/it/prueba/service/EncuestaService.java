package cl.it.prueba.service;

import cl.it.prueba.dao.IEncuestaDao;
import cl.it.prueba.model.Encuesta;
import cl.it.prueba.model.GeneroMusical;
import cl.it.prueba.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EncuestaService implements IEncuestaService {
    @Autowired
    private IEncuestaDao encuestaDao;

    public Map<String, Integer> getResultados() {
        List<Encuesta> encuestas = encuestaDao.getEncuestas();
        List<Long> idsGenerosMusicales = new ArrayList<>();
        for (Encuesta encuesta : encuestas) {
            idsGenerosMusicales.add(encuesta.getIdGeneroMusical());
        }
        List<GeneroMusical> generoMusicals = encuestaDao.getGenerosMusicales();
        Map<String, Integer> resultados = new HashMap<String, Integer>();

        for (GeneroMusical generoMusical : generoMusicals) {
            resultados.put(generoMusical.getNombre(), Collections.frequency(idsGenerosMusicales, generoMusical.getIdGeneroMusical()));
        }

        return resultados;
    }

    public List<GeneroMusical> getGenerosMusicales() {
        return encuestaDao.getGenerosMusicales();
    }

    public void addEncuesta(Encuesta encuesta){
        Usuario usuario = new Usuario();
        usuario.setCorreoUsuario(encuesta.getCorreoUsuario());
        encuestaDao.addUsuario(usuario);
        encuestaDao.addEncuesta(encuesta);
    }

}
