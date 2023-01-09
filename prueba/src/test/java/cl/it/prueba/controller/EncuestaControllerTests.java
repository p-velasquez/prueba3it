package cl.it.prueba.controller;

import cl.it.prueba.model.Encuesta;
import cl.it.prueba.service.IEncuestaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EncuestaController.class)
public class EncuestaControllerTests {

    @Autowired MockMvc mockMvc;
    @MockBean IEncuestaService encuestaService;

    @Test
    public void testGetResultados() throws Exception {
        mockMvc.perform(get("/api/resultados")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

    }

    @Test
    public void testGetGenerosMusicales() throws Exception {
        mockMvc.perform(get("/api/generos-musicales")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

    }

    @Test
    public void testAddEncuesta() throws Exception {
        Encuesta encuesta = new Encuesta();

        encuesta.setCorreoUsuario("prueba");
        encuesta.setIdGeneroMusical(1L);

        mockMvc.perform(post("/api/generar-encuesta")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(encuesta)))
                        .andExpect(status().isOk());

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
