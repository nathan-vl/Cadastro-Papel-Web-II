package br.com.imd.repositories;

import br.com.imd.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    @Query("select p.usuarios from Papel p where p.id = ?1")
    List<Usuario> findByIdPapel(Integer idPapel);
}
