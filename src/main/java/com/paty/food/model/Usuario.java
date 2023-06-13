package com.paty.food.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Usuario")
@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 200)
    private String nome;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "login", length = 100)
    private String login;

    @Column(name = "senha", length = 100)
    private String senha;

    @Column(name = "data_criacao", nullable = false)
	@JsonProperty("data_criacao")
    private LocalDateTime dataCriacao;

    public Usuario() {
    }

    public Usuario(Long pId) {
        this.id = pId;
    }

}
