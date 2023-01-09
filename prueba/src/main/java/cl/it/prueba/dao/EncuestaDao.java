package cl.it.prueba.dao;

import cl.it.prueba.model.Encuesta;
import cl.it.prueba.model.GeneroMusical;
import cl.it.prueba.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EncuestaDao implements IEncuestaDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Encuesta> getEncuestas() {
        String query = "FROM Encuesta";
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public List<GeneroMusical> getGenerosMusicales() {
        String query = "FROM GeneroMusical";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void addEncuesta(Encuesta encuesta) {
        entityManager.merge(encuesta);
    }

    @Override
    public void addUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }
}
