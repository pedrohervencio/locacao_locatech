package br.com.locacar.api.locacao_locatech.service;

import br.com.locacar.api.locacao_locatech.controller.exception.ControllerNotFoundException;
import br.com.locacar.api.locacao_locatech.dto.LocacaoDTO;
import br.com.locacar.api.locacao_locatech.entities.Locacao;
import br.com.locacar.api.locacao_locatech.repository.LocacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LocacaoService {
    private final LocacaoRepository locacaoRepository;

    @Autowired
    public LocacaoService(LocacaoRepository locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    public Page<LocacaoDTO> findAll(Pageable pageable) {
        Page<Locacao> locacoes = locacaoRepository.findAll(pageable);

        return locacoes.map(this::toDTO);
    }

    public LocacaoDTO findById(Long id){
        Locacao locacao = locacaoRepository.findById(id).
                orElseThrow(() -> new ControllerNotFoundException("Locacao não encontrada"));
        return toDTO(locacao);
    }

    public LocacaoDTO save(LocacaoDTO locacaoDTO) {
        Locacao locacao = toEntity(locacaoDTO);
        locacao = locacaoRepository.save(locacao);
        return toDTO((locacao));
    }

    public LocacaoDTO update(Long id, LocacaoDTO locacaoDTO) {

        try {
            Locacao locacao = locacaoRepository.getReferenceById(id);
            locacao.setDataInicio(locacaoDTO.dataInicio());
            locacao.setQtdeDiarias(locacaoDTO.qtdeDiarias());
            locacao.setVlrDiaria(locacaoDTO.vlrDiaria());
            locacao.setAtendente(locacaoDTO.atendente());
            locacao.setCliente(locacaoDTO.cliente());
            locacao.setVeiculo(locacaoDTO.veiculo());
            locacao.setLaudo(locacaoDTO.laudo());
            locacaoRepository.save(locacao);
            return toDTO(locacao);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Locacao não encontrada");
        }
    }

    public void delete(Long id) {
        locacaoRepository.deleteById(id);
        return;
    }

    private LocacaoDTO toDTO(Locacao locacao) {
        return new LocacaoDTO(
                locacao.getNumero(),
                locacao.getDataInicio(),
                locacao.getQtdeDiarias(),
                locacao.getVlrDiaria(),
                locacao.getAtendente(),
                locacao.getCliente(),
                locacao.getVeiculo(),
                locacao.getLaudo()
                );
    }

    private Locacao toEntity(LocacaoDTO locacaoDTO) {
        return new Locacao(
                locacaoDTO.numero(),
                locacaoDTO.dataInicio(),
                locacaoDTO.qtdeDiarias(),
                locacaoDTO.vlrDiaria(),
                locacaoDTO.atendente(),
                locacaoDTO.cliente(),
                locacaoDTO.veiculo(),
                locacaoDTO.laudo()
                );
    }
}
