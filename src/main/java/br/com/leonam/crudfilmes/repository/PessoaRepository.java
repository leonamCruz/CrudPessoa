package br.com.leonam.crudfilmes.repository;

import br.com.leonam.crudfilmes.model.entidade.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

}