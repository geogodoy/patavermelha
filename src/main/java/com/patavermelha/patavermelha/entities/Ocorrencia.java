package com.patavermelha.patavermelha.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "Ocorrencia")
public class Ocorrencia {

    @Id
    @GeneratedValue(generator = "system-uuid", strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID idOcorrencia;

    private String nomeAnimal;
    private String tipoAnimal;
    private String caracteristicaAnimal;
    private String descricaoOcorrencia;
    private String localizacaoOcorrencia;
}
