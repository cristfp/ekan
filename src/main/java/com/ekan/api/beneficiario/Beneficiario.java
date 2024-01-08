package com.ekan.api.beneficiario;

import com.ekan.api.documento.Documento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "beneficiarios")
@Entity(name = "Beneficiario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Beneficiario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;

    @Embedded
    private Documento documento;
    private String dataNascimento;
    private String dataDaInclusao;
    private String dataDaAtualizacao;

    public Beneficiario(DadosBeneficiario dados) {
        this.id = dados.id();
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.documento = new Documento(dados.documento());
        this.dataNascimento = dados.dataNascimento();
        this.dataDaInclusao = dados.dataDaInclusao();
        this.dataDaAtualizacao = dados.dataDaAtualizacao();
    }

    public void atualizarDados(DadosBeneficiario dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if (dados.documento() != null){
            this.documento.atualizarInformacoes(dados.documento());
        }
        if (dados.dataNascimento() != null){
            this.dataNascimento = dados.dataNascimento();
        }
        if (dados.dataDaInclusao() != null){
            this.dataDaInclusao = dados.dataDaInclusao();
        }
        if (dados.dataDaAtualizacao() != null){
            this.dataDaAtualizacao = dados.dataDaAtualizacao();
        }
    }
}
