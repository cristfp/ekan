package com.ekan.api.beneficiario;

import com.ekan.api.documento.DadosDocumento;
import com.ekan.api.documento.Documento;

public record DadosBeneficiario(Long id, String nome, String telefone, DadosDocumento documento, String dataNascimento, String dataDaInclusao, String dataDaAtualizacao) {
}
