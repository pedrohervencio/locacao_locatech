package br.com.locacar.api.locacao_locatech.repository;

import br.com.locacar.api.locacao_locatech.entities.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

}
