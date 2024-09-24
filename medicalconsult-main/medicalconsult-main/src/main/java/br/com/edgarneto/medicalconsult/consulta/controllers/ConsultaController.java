package br.com.edgarneto.medicalconsult.consulta.controllers;

import br.com.edgarneto.medicalconsult.consulta.models.Consulta;
import br.com.edgarneto.medicalconsult.consulta.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<Consulta> cadastrarConsulta(@RequestBody Consulta consulta) {
        Consulta novaConsulta = consultaService.cadastrarConsulta(consulta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(novaConsulta.getIdConsulta()).toUri();
        return ResponseEntity.created(uri).body(novaConsulta);
    }
    //    @PostMapping
    //    public ResponseEntity<Consulta> cadastrarUsuario(@RequestBody Consulta consulta) {
    //        Consulta novaConsulta = consultaService.cadastrarConsulta(consulta);
    //        return ResponseEntity.status(HttpStatus.CREATED).body(novaConsulta);
    //    }
}
