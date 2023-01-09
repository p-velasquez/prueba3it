package cl.it.prueba.dao;

import cl.it.prueba.model.Encuesta;
import cl.it.prueba.model.GeneroMusical;
import cl.it.prueba.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class EncuestaDaoTests {

    @Autowired
    private IEncuestaDao encuestaDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testGetEncuestas() {
        // Configuramos los datos de prueba
        Encuesta encuesta1 = new Encuesta(null, null,"pablovelasquezr@gmail.com",1L);
        Encuesta encuesta2 = new Encuesta(null, null,"hg",1L);
        Encuesta encuesta3 = new Encuesta(null, null,"asd",1L);
        entityManager.persist(encuesta1);
        entityManager.persist(encuesta2);
        entityManager.persist(encuesta3);

        // Llamamos al método que queremos probar
        List<Encuesta> encuestas = encuestaDao.getEncuestas();

        // Comprobamos que los resultados sean los esperados
        assertTrue(encuestas.contains(encuesta1));
        assertTrue(encuestas.contains(encuesta2));
        assertTrue(encuestas.contains(encuesta3));
    }

    @Test
    public void testGetGenerosMusicales() {
        // Configuramos los datos de prueba
        GeneroMusical generoMusical1 = new GeneroMusical(null, "Pop");
        GeneroMusical generoMusical2 = new GeneroMusical(null, "Rock");
        GeneroMusical generoMusical3 = new GeneroMusical(null, "Jazz");
        entityManager.persist(generoMusical1);
        entityManager.persist(generoMusical2);
        entityManager.persist(generoMusical3);

        // Llamamos al método que queremos probar
        List<GeneroMusical> generosMusicales = encuestaDao.getGenerosMusicales();

        // Comprobamos que los resultados sean los esperados
        assertTrue(generosMusicales.contains(generoMusical1));
        assertTrue(generosMusicales.contains(generoMusical2));
        assertTrue(generosMusicales.contains(generoMusical3));
    }

    @Test
    public void testAddEncuesta() {
        // Configuramos los datos de prueba
        Encuesta encuesta = new Encuesta(1L, null, "pablovelasquezr@gmail.com", 1L);

        // Llamamos al método que queremos probar
        encuestaDao.addEncuesta(encuesta);

        // Comprobamos que la encuesta se ha insertado correctamente
        Encuesta encuestaRecuperada = entityManager.find(Encuesta.class, encuesta.getIdEncuesta());
        assertEquals(encuesta, encuestaRecuperada);
    }

    @Test
    public void testAddUsuario() {
        // Configuramos los datos de prueba
        Usuario usuario = new Usuario("pablovelasquezr@gmail.com");

        // Llamamos al método que queremos probar
        encuestaDao.addUsuario(usuario);

        // Comprobamos que el usuario se ha insertado correctamente
        Usuario usuarioRecuperado = entityManager.find(Usuario.class, usuario.getCorreoUsuario());
        assertEquals(usuario, usuarioRecuperado);
    }


}

