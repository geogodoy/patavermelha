package com.patavermelha.patavermelha.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "Clinica")
public class Clinica {

    @Id
    @GeneratedValue(generator = "system-uuid", strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    private String nomeClinica;

    private String telefoneClinica;

    private String enderecoClinica;

    @OneToMany
    private Set<Ocorrencia> ocorrencias = new LinkedHashSet<>();
}
