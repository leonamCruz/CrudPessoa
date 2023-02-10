package br.com.leonam.crudPessoa.controller;

import br.com.leonam.crudPessoa.model.dto.PessoaDTO;
import br.com.leonam.crudPessoa.model.entidade.Pessoa;
import br.com.leonam.crudPessoa.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pessoa")
public class PessoaController {
    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<Object> post(@RequestBody @Valid PessoaDTO pessoaDTO) {
        var pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoa));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAll());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Object> getById(@PathVariable(value = "uuid") UUID uuid) {
        var pessoaOptional = pessoaService.findById(uuid);

        return pessoaOptional.<ResponseEntity<Object>>map(pessoa ->
                ResponseEntity.status(HttpStatus.OK).body(pessoa)).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível localizar esse ID"));

    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Object> delete(@PathVariable(value = "uuid") UUID uuid) {
        var pessoaOptional = pessoaService.findById(uuid);

        if (pessoaOptional.isPresent()) {
            pessoaService.delete(uuid);
            return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizei o ID, então não posso apagar");
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Object> put(@PathVariable(value = "uuid") UUID uuid, @RequestBody @Valid PessoaDTO pessoaDTO) {
        var pessoaOptional = pessoaService.findById(uuid);

        if (pessoaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizei o Id, então não posso alterar");
        }
        var pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaDTO ,pessoa);
        pessoa.setUuid(pessoaOptional.get().getUuid());
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(pessoa));
    }
}