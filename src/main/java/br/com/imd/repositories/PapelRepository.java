package br.com.imd.repositories;

import br.com.imd.domain.Papel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PapelRepository extends CrudRepository<Papel, Integer> {
}
