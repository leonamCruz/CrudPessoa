package br.com.leonam.crudPessoa.model.entidade;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    @Column(nullable = false, length = 70)
    private String nome;
    // ### ### ### ##
    @Column(nullable = false, unique = true,length = 11)
    private String cpf;
    // ### ## # #### ####
    @Column(nullable = false, length = 14)
    private String numeroDoWhatsapp;
    public UUID getUuid() {
        return uuid;
    }
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

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
