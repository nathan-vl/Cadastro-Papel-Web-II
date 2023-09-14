package br.com.imd.repositories;

import br.com.imd.arq.EntidadeNaoEncontrada;
import br.com.imd.domain.Papel;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class PapelRepository {
    private static final Set<Papel> papeis = new java.util.HashSet<>(List.of(new Papel(1, "Admin"), new Papel(2, "Moderador"), new Papel(3, "Comum")));

    public static Set<Papel> getPapeis() {
        return papeis;
    }

    public static Papel addPapel(Papel p) {
        papeis.add(p);
        return p;
    }

    public static Papel porId(int id) {
        for (Papel papel : papeis) {
            if (Objects.equals(papel.getId(), id)) {
                return papel;
            }
        }
        throw new EntidadeNaoEncontrada("papel", id);
    }

    public static void remover(int id) {
        if (!papeis.removeIf(papel -> Objects.equals(papel.getId(), id))) {
            throw new EntidadeNaoEncontrada("papel", id);
        }
    }

    public static Papel criar(Papel papel) {
        papel.setId(proximoId());
        papeis.add(papel);
        return papel;
    }

    public static Papel atualizar(@PathVariable int id, Papel papel) {
        papel.setId(id);
        if (!papeis.removeIf(p -> Objects.equals(p.getId(), id))) {
            throw new EntidadeNaoEncontrada("papel", papel.getId());
        }

        papeis.add(papel);
        return papel;
    }

    private static int proximoId() {
        int maiorId = 0;
        for (Papel papel : papeis) {
            maiorId = Math.max(papel.getId(), maiorId);
        }
        return maiorId + 1;
    }
}
