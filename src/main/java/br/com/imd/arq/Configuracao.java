package br.com.imd.arq;

import br.com.imd.domain.Papel;
import br.com.imd.repositories.PapelRepository;
import br.com.imd.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracao {
    @Autowired
    private final PapelRepository papelRepository;

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public Configuracao(PapelRepository papelRepository, UsuarioRepository usuarioRepository) {
        this.papelRepository = papelRepository;
        this.usuarioRepository = usuarioRepository;

        this.papelRepository.save(new Papel("Admin"));
        this.papelRepository.save(new Papel("Moderador"));
        this.papelRepository.save(new Papel("Comum"));
    }
}
