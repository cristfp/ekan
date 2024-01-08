package com.ekan.api.documento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Documento{


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documento_id;
    private String tipoDocumento;
    private String descricao;
    private String dataInclusao;
    private String dataAtualizacao;

    public Documento(DadosDocumento dados) {
        this.documento_id = dados.documento_id();
        this.tipoDocumento = dados.tipoDocumento();
        this.descricao = dados.descricao();
        this.dataInclusao = dados.dataInclusao();
        this.dataAtualizacao = dados.dataAtualizacao();
    }

    public void atualizarInformacoes(DadosDocumento dados) {
        if (dados.documento_id() != null){
            this.documento_id = dados.documento_id();
        }
        if (dados.tipoDocumento() != null){
            this.tipoDocumento = dados.tipoDocumento();
        }
        if (dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if (dados.dataInclusao() != null){
            this.dataInclusao = dados.dataInclusao();
        }
        if (dados.dataAtualizacao() != null){
            this.dataAtualizacao = dados.dataAtualizacao();
        }
    }
}
