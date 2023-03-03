package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("medicos")
public class MedicoController {             //Controller responsavel por receber e cadastrar um medico vindo do Insomnia

    @Autowired                    //Instancia atributo repository dentro da classe
    private MedicoRepository repository;

    @PostMapping                                //Post pois irá receber um metodo Post do Insomnia para cadastror
    @Transactional                              // Transacao com o bando de dados
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    //  recebendo um DTO, representado pelo record DadosCadastroMedico.

//    @GetMapping
//    public List<DadosListagemMedico> listar(){                     //Não listamos a partir da classe Medico, pois nao iremos devolver todos os dados de Medico
//        return repository.findAll().stream().map(DadosListagemMedico::new).toList();       //Metodo para listar medicos e convertendo de Lista de Medicos para DadosListagemMedico
//    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {                         //Listando de forma ordenada e descrecente e paginada
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
       var medico = repository.getReferenceById(dados.id());    //Carregando medico por id
        medico.atualizarInformacoes(dados);    //chamando metodo para atualizar dados
    }

//    @DeleteMapping("/{id}")
//    @Transactional
//    public void excluir(@PathVariable Long id) {                     //Exclusao por ID
//        repository.deleteById(id);
//
//    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);                               //Exlusao logica por ID nao ira excluir mas sim inativar
        medico.excluir();
    }

}

