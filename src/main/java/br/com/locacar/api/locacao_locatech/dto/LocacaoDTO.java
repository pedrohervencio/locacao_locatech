package br.com.locacar.api.locacao_locatech.dto;

import br.com.locacar.api.locacao_locatech.entities.Atendente;
import br.com.locacar.api.locacao_locatech.entities.Veiculo;
import br.com.locacar.api.locacao_locatech.valueobject.Cliente;
import br.com.locacar.api.locacao_locatech.valueobject.Laudo;

import java.time.LocalDate;

public record LocacaoDTO(
        Long numero,
        LocalDate dataInicio,
        Integer qtdeDiarias,
        Integer vlrDiaria,
        Atendente atendente,
        Cliente cliente,
        Veiculo veiculo,
        Laudo laudo
) {
}
