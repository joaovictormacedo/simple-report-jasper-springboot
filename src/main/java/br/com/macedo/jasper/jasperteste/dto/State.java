package br.com.macedo.jasper.jasperteste.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class State {

    private Integer id;
    private String sigla;
    private String nome;
    private Region regiao;

}
