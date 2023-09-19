package br.com.imd.controllers;

import br.com.imd.arq.EntidadeNaoEncontrada;
import br.com.imd.domain.Usuario;
import br.com.imd.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/usuarios";
    }

    @GetMapping("/usuario/{id}")
    public String porId(@PathVariable int id, Model model) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(EntidadeNaoEncontrada::new);
        model.addAttribute("usuario", usuario);
        return "usuarios/usuarioRow";
    }

    @GetMapping("/usuario/{id}/editar")
    public String porIdEditar(@PathVariable int id, Model model) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(EntidadeNaoEncontrada::new);
        model.addAttribute("usuario", usuario);
        return "usuarios/editarUsuario";
    }

    @GetMapping("/usuario/form")
    public String form() {
        return "usuarios/usuarioForm";
    }

    @PostMapping("/usuario")
    public String criar(@ModelAttribute Usuario usuario, Model model) {
        Usuario novoUsuario = usuarioRepository.save(usuario);
        model.addAttribute("usuario", novoUsuario);
        return "usuarios/usuarioRow";
    }

    @PutMapping("/usuario/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Usuario usuario, Model model) {
        usuario.setId(id);
        Usuario novoUsuario = usuarioRepository.save(usuario);
        model.addAttribute("usuario", novoUsuario);
        return "usuarios/usuarioRow";
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity remover(@PathVariable int id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
