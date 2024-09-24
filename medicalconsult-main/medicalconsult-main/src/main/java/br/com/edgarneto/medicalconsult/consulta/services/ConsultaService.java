package br.com.edgarneto.medicalconsult.consulta.services;

import br.com.edgarneto.medicalconsult.consulta.Exceptions.ExceptionDataIntegrityViolation;
import br.com.edgarneto.medicalconsult.consulta.models.Consulta;
import br.com.edgarneto.medicalconsult.consulta.repositories.ConsultaRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta cadastrarConsulta(Consulta consulta){
        consulta.setIdConsulta(null);
        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarConsultas(){
      return consultaRepository.findAll();  
    }

    public Consulta buscarConsulta(Long id) {
        Optional<Consulta> consulta = consultaRepository.findById(id);
        return consulta.orElseThrow(
            () -> new ObjectNotFoundException("Especialidade nao foi encontrada ID :", id));

    }
    public void deletarConsulta(Long id) {
        buscarConsulta(id);
        try {
            consultaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ExceptionDataIntegrityViolation("nao e possivel excluir, porque ha entidades relacionadas.");
        }
    }
    public Consulta atualizarConsulta(Consulta consulta) {
        Consulta novaConsulta = buscarConsulta(consulta.getIdConsulta());
        updateData(novaConsulta, consulta);
        return consultaRepository.save(novaConsulta);
    }

    private void updateData(Consulta novaConsulta, Consulta consulta) {
        novaConsulta.setDataConsulta(consulta.getDataConsulta());
        novaConsulta.setProfissional(consulta.getProfissional());
        novaConsulta.setEspecialidade(consulta.getEspecialidade());
    }
}
