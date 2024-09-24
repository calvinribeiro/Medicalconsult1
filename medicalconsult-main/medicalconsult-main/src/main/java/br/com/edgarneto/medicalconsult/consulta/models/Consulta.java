package br.com.edgarneto.medicalconsult.consulta.models;

import br.com.edgarneto.medicalconsult.usuario.models.Usuario;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Table(name = "Consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONSULTA")
    private Long idConsulta;
    @Column(name = "DATA_CONSULTA")
    private String dataConsulta;
    @Column(name = "PROFISSIONAL")
    private String profissional;
    @Column(name = "ESPECIALIDADE")
    private String especialidade;

    @ManyToOne
    @JoinColumn(name = "id_Usuario")
    private Usuario usuario;

    public Consulta() {
    }

    public Consulta(Long idConsulta, String dataConsulta, String profissional, String especialidade, Usuario usuario) {
        this.idConsulta = idConsulta;
        this.dataConsulta = dataConsulta;
        this.profissional = profissional;
        this.especialidade = especialidade;
        this.usuario = usuario;




    }














}
