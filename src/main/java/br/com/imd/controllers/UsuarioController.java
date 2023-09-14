package br.com.imd.controllers;

import br.com.imd.domain.Usuario;
import br.com.imd.repositories.UsuarioRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {
    @RequestMapping("/usuarios")
    public List<Usuario> getPapeis() {
        return UsuarioRepository.getUsuarios();
    }

}
