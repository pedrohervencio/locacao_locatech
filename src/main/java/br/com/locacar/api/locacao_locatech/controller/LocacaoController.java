package br.com.locacar.api.locacao_locatech.controller;

import br.com.locacar.api.locacao_locatech.dto.LocacaoDTO;
import br.com.locacar.api.locacao_locatech.service.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/locacao")
@RestController
public class LocacaoController {
    private final LocacaoService locacaoService;

    @Autowired
    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @GetMapping
    public ResponseEntity<Page<LocacaoDTO>> findAll(
            @PageableDefault(size = 10, page = 0, sort = "numero")Pageable pageable) {
        Page<LocacaoDTO> locacoesDTO = locacaoService.findAll(pageable);
        return ResponseEntity.ok(locacoesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocacaoDTO> findById(@PathVariable Long id) {
        LocacaoDTO locacaoDTO = locacaoService.findById(id);
        return ResponseEntity.ok(locacaoDTO);
    }

    @PostMapping
    public ResponseEntity<LocacaoDTO> save(@RequestBody LocacaoDTO locacaoDTO) {
        LocacaoDTO savedLocacaoDTO = locacaoService.save(locacaoDTO);
        return new ResponseEntity<>(savedLocacaoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocacaoDTO> update(@PathVariable Long id,
                                             @RequestBody LocacaoDTO locacaoDTO) {
        LocacaoDTO updatedLocacaoDTO = locacaoService.update(id, locacaoDTO);
        return ResponseEntity.ok(updatedLocacaoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        locacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
