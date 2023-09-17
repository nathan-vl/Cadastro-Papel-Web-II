package br.com.imd.arq;

import br.com.imd.domain.Papel;
import br.com.imd.repositories.PapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracao {
    @Autowired
    private final PapelRepository papelRepository;

    public Configuracao(PapelRepository papelRepository) {
        this.papelRepository = papelRepository;

        this.papelRepository.save(new Papel("Admin"));
        this.papelRepository.save(new Papel("Moderador"));
        this.papelRepository.save(new Papel("Comum"));
    }
}
