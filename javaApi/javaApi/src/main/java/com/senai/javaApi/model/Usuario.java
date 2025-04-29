package com.senai.javaApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @Column(nullable = false)
    @NotBlank(message = "Email é obrigatório.")
    @Email(message = "Email deve ser um email válido.")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Senha é obrigatória.")
    @Size(min = 4, message = "A senha deve conter no minímo 4 caracteres.")
    private String senha;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Nome é obrigatório.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Email é obrigatório.") @Email(message = "Email deve ser um válido.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email é obrigatório.") @Email(message = "Email deve ser um válido.") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Senha é obrigatória.") @Size(min = 3, message = "A senha deve conter no minímo 4 caracteres.") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "Senha é obrigatória.") @Size(min = 3, message = "A senha deve conter no minímo 4 caracteres..") String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuário: " +
                "ID: " + id +
                ", nome: '" + nome + '\'' +
                ", email: '" + email + '\'' +
                ", senha: '" + senha + '\'';
    }
}