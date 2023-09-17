package br.com.imd.controllers;

import br.com.imd.arq.EntidadeNaoEncontrada;
import br.com.imd.domain.Papel;
import br.com.imd.repositories.PapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PapelMVCController {
    @Autowired
    private PapelRepository papelRepository;

    @GetMapping("/papeis")
    public String papeis(Model model) {
        Iterable<Papel> papeis = papelRepository.findAll();
        model.addAttribute("papeis", papeis);
        return "papeis";
    }

    @GetMapping("/papel/{id}")
    public String porId(@PathVariable int id, Model model) {
        Papel papel = papelRepository.findById(id).orElseThrow(EntidadeNaoEncontrada::new);
        model.addAttribute("papel", papel);
        return "papelRow";
    }

    @GetMapping("/papel/{id}/editar")
    public String porIdEditar(@PathVariable int id, Model model) {
        Papel papel = papelRepository.findById(id).orElseThrow(EntidadeNaoEncontrada::new);
        model.addAttribute("papel", papel);
        return "editarPapel";
    }

    @GetMapping("/papel/form")
    public String form() {
        return "papelForm";
    }

    @PostMapping("/papel")
    public String criar(@ModelAttribute Papel papel, Model model) {
        Papel novoPapel = papelRepository.save(papel);
        model.addAttribute("papel", novoPapel);
        return "papelRow";
    }

    @PutMapping("/papel/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Papel papel, Model model) {
        papel.setId(id);
        Papel novoPapel = papelRepository.save(papel);
        model.addAttribute("papel", novoPapel);
        return "papelRow";
    }

    @DeleteMapping("/papel/{id}")
    public ResponseEntity remover(@PathVariable int id) {
        papelRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
