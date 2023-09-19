package br.com.imd.controllers;

import br.com.imd.arq.EntidadeNaoEncontrada;
import br.com.imd.domain.Papel;
import br.com.imd.domain.Usuario;
import br.com.imd.repositories.PapelRepository;
import br.com.imd.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class PapelController {
    @Autowired
    private PapelRepository papelRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/papeis")
    public String papeis(Model model) {
        Iterable<Papel> papeis = papelRepository.findAll();
        model.addAttribute("papeis", papeis);
        return "papel/papeis";
    }

    @GetMapping("/papel/{id}")
    public String porId(@PathVariable int id, Model model) {
        Papel papel = papelRepository.findById(id).orElseThrow(EntidadeNaoEncontrada::new);
        model.addAttribute("papel", papel);
        return "papel/papelRow";
    }

    @GetMapping("/papel/{id}/editar")
    public String porIdEditar(@PathVariable int id, Model model) {
        Papel papel = papelRepository.findById(id).orElseThrow(EntidadeNaoEncontrada::new);
        model.addAttribute("papel", papel);
        return "papel/editar";
    }

    @GetMapping("/papel/form")
    public String form() {
        return "papel/form";
    }

    @PostMapping("/papel")
    public String criar(@ModelAttribute Papel papel, Model model) {
        Papel novoPapel = papelRepository.save(papel);
        model.addAttribute("papel", novoPapel);
        return "papel/papelRow";
    }

    @PutMapping("/papel/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Papel papel, Model model) {
        papel.setId(id);
        Papel novoPapel = papelRepository.save(papel);
        model.addAttribute("papel", novoPapel);
        return "papel/papelRow";
    }

    @DeleteMapping("/papel/{id}")
    public String remover(@PathVariable int id) {
        List<Usuario> usuarios = usuarioRepository.findByIdPapel(id);
        System.out.println(usuarios.size());
        if (usuarios.isEmpty()) {
            papelRepository.deleteById(id);
            throw new ResponseStatusException(HttpStatus.OK);
        }

        return "";
    }
}
