package cl.it.prueba.controller;

import cl.it.prueba.model.Encuesta;
import cl.it.prueba.service.IEncuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api")
public class EncuestaController {
    @Autowired
    private IEncuestaService encuestaService;
    @GetMapping(value = "resultados", produces = "application/json")
    public @ResponseBody ResponseEntity<Map<String,Object>> getResultados(){
        ModelMap modelMap = new ModelMap();
        try {
            modelMap.addAttribute(encuestaService.getResultados());
            return new ResponseEntity<Map<String,Object>>(modelMap, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "generos-musicales", produces = "application/json")
    public @ResponseBody ResponseEntity<Map<String,Object>> getGenerosMusicales(){
        ModelMap modelMap = new ModelMap();
        try {
            modelMap.addAttribute(encuestaService.getGenerosMusicales());
            return new ResponseEntity<Map<String,Object>>(modelMap, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "generar-encuesta", produces = "application/json")
    public @ResponseBody ResponseEntity<Map<String,Object>> addEncuesta(
            @RequestBody Encuesta encuesta){
        ModelMap modelMap = new ModelMap();
        try {
            encuestaService.addEncuesta(encuesta);
            modelMap.addAttribute("message","Su encuesta fue ingresada exitosamente.");
            return new ResponseEntity<Map<String,Object>>(modelMap, HttpStatus.OK);
        } catch (Exception e){
            modelMap.addAttribute("message", "Ocurrió un error inesperado, intente más tarde.");
            return new ResponseEntity<Map<String,Object>>(modelMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
