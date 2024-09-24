package br.com.edgarneto.medicalconsult.usuario.services;

import br.com.edgarneto.medicalconsult.consulta.services.ConsultaService;
import br.com.edgarneto.medicalconsult.usuario.models.Usuario;
import br.com.edgarneto.medicalconsult.usuario.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ConsultaService consultaService;

    public Usuario cadastrarUsuario(Usuario usuario) {
        usuario.setIdUsuario(null);
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        if(usuario.getIdUsuario()==null){
            throw new RuntimeException("Usuario sem ID");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Usuário não encontrado:", id)
        );
    }

    public void excluirUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
