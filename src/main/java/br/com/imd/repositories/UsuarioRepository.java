package br.com.imd.repositories;

import br.com.imd.domain.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    public static List<Usuario> usuarios = new ArrayList<>();

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }
}
