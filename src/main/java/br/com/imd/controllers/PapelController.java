package br.com.imd.controllers;

import br.com.imd.domain.Papel;
import br.com.imd.repositories.PapelRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class PapelController {
    @RequestMapping("/papeis")
    public Set<Papel> getPapeis() {
        return PapelRepository.getPapeis();
    }

    @PostMapping("/papeis")
    public Papel addPapel(@RequestBody Papel papel) {
        return PapelRepository.addPapel(papel);
    }
}
