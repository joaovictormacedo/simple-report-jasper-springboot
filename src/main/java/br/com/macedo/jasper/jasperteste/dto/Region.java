package br.com.macedo.jasper.jasperteste.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Region {

    private String id;
    private String sigla;
    private String nome;

}
