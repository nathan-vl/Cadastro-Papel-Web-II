package br.com.imd.repositories;

import br.com.imd.domain.Papel;

import java.util.ArrayList;
import java.util.List;

public class PapelRepository {
    private static final List<Papel> papeis = new ArrayList<>();

    public static List<Papel> getPapeis() {
        return papeis;
    }

    public static Papel addPapel(Papel p) {
        papeis.add(p);
        return p;
    }
}
