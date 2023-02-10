package br.com.leonam.crudPessoa.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;
public class PessoaDTO {

    @NotBlank
    @Size
    private String nome;
    @NotBlank
    @CPF
    private String cpf;
    @NotBlank
    @Size(min = 11, max = 14)
    private String numeroDoWhatsapp;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroDoWhatsapp() {
        return numeroDoWhatsapp;
    }

    public void setNumeroDoWhatsapp(String numeroDoWhatsapp) {
        this.numeroDoWhatsapp = numeroDoWhatsapp;
    }
}
