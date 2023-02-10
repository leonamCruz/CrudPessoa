package br.com.leonam.crudfilmes.service;

import br.com.leonam.crudfilmes.model.entidade.Pessoa;
import br.com.leonam.crudfilmes.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    @Transactional
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> findById(UUID uuid) {
        return pessoaRepository.findById(uuid);
    }

    @Transactional
    public void delete(UUID uuid) {
        pessoaRepository.deleteById(uuid);
    }
}
