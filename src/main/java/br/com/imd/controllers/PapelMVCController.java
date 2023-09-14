package br.com.imd.controllers;

import br.com.imd.domain.Papel;
import br.com.imd.repositories.PapelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class PapelMVCController {
    @GetMapping("/papeis")
    public String papeis(Model model) {
        Set<Papel> papeis = PapelRepository.getPapeis();
        model.addAttribute("papeis", papeis);
        return "papeis";
    }

    @GetMapping("/papel/{id}")
    public String porId(@PathVariable int id, Model model) {
        Papel papel = PapelRepository.porId(id);
        model.addAttribute("papel", papel);
        return "papelRow";
    }

    @GetMapping("/papel/{id}/editar")
    public String porIdEditar(@PathVariable int id, Model model) {
        Papel papel = PapelRepository.porId(id);
        model.addAttribute("papel", papel);
        return "editarPapel";
    }

    @GetMapping("/papel/form")
    public String form() {
        return "papelForm";
    }

    @PostMapping("/papel")
    public String criar(@ModelAttribute Papel papel, Model model) {
        System.out.println(papel);
        Papel novoPapel = PapelRepository.criar(papel);
        System.out.println(novoPapel);
        model.addAttribute("papel", novoPapel);
        return "papelRow";
    }

    @PutMapping("/papel/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Papel papel, Model model) {
        Papel novoPapel = PapelRepository.atualizar(id, papel);
        model.addAttribute("papel", novoPapel);
        return "papelRow";
    }

    @DeleteMapping("/papel/{id}")
    public ResponseEntity remover(@PathVariable int id) {
        PapelRepository.remover(id);
        return ResponseEntity.ok().build();
    }
}
