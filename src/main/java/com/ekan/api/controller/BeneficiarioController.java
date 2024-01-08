package com.ekan.api.controller;

import com.ekan.api.beneficiario.Beneficiario;
import com.ekan.api.beneficiario.BeneficiarioRepository;
import com.ekan.api.beneficiario.DadosBeneficiario;
import com.ekan.api.documento.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("beneficiarios")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioRepository repository;



    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosBeneficiario dados){

        repository.save(new Beneficiario(dados));
    }
    @GetMapping
    public List<Beneficiario> listarBeneficiarios(){
       return repository.findAll();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Documento listarDocumentosPorId(@PathVariable Long id){
        var beneficiario = repository.getReferenceById(id);
        return beneficiario.getDocumento();
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosBeneficiario dados){
        var beneficiarios = repository.getReferenceById(dados.id());
        beneficiarios.atualizarDados(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
