package cl.it.prueba.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cl.it.prueba.dao.EncuestaDao;
import cl.it.prueba.model.Encuesta;
import cl.it.prueba.model.GeneroMusical;
import cl.it.prueba.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EncuestaServiceTests {

    @Mock
    private EncuestaDao encuestaDao;

    @InjectMocks
    private EncuestaService encuestaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetResultados() {
        // Configuramos los datos de prueba
        Encuesta encuesta1 = new Encuesta(1L,null,null, 1L);
        Encuesta encuesta2 = new Encuesta(2L,null,null, 2L);
        Encuesta encuesta3 = new Encuesta(3L,null,null, 2L);
        List<Encuesta> encuestas = new ArrayList<>();
        encuestas.add(encuesta1);
        encuestas.add(encuesta2);
        encuestas.add(encuesta3);
        when(encuestaDao.getEncuestas()).thenReturn(encuestas);
        GeneroMusical generoMusical1 = new GeneroMusical(1L, "Pop");
        GeneroMusical generoMusical2 = new GeneroMusical(2L, "Rock");

        List<GeneroMusical> generoMusicals = new ArrayList<>();
        generoMusicals.add(generoMusical1);
        generoMusicals.add(generoMusical2);
        when(encuestaDao.getGenerosMusicales()).thenReturn(generoMusicals);

        // Llamamos al método que queremos probar
        Map<String, Integer> resultados = encuestaService.getResultados();

        // Comprobamos que los resultados sean los esperados
        Map<String, Integer> esperado = new HashMap<>();
        esperado.put("Pop", 1);
        esperado.put("Rock", 2);
        assertEquals(esperado, resultados);
    }

    @Test
    public void testGetGenerosMusicales() {
        // Configuramos los datos de prueba
        GeneroMusical generoMusical1 = new GeneroMusical(1L, "Pop");
        GeneroMusical generoMusical2 = new GeneroMusical(2L, "Rock");
        List<GeneroMusical> esperado = new ArrayList<>();
        esperado.add(generoMusical1);
        esperado.add(generoMusical2);
        when(encuestaDao.getGenerosMusicales()).thenReturn(esperado);

        // Llamamos al método que queremos probar
        List<GeneroMusical> generosMusicales = encuestaService.getGenerosMusicales();

        // Comprobamos que los resultados sean los esperados
        assertEquals(esperado, generosMusicales);
    }

    @Test
    public void testAddEncuesta() {
        // Configuramos los datos de prueba
        Encuesta encuesta = new Encuesta();
        encuesta.setCorreoUsuario("usuario@example.com");

        // Llamamos al método que queremos probar
        encuestaService.addEncuesta(encuesta);

        // Verificamos que se hayan realizado las llamadas esperadas a los métodos de encuestaDao
        verify(encuestaDao).addUsuario(new Usuario("usuario@example.com"));
        verify(encuestaDao).addEncuesta(encuesta);
    }
}

