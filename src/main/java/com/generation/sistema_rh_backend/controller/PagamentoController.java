package com.generation.sistema_rh_backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.sistema_rh_backend.model.Pagamento;
import com.generation.sistema_rh_backend.repository.PagamentoRepository;
import com.generation.sistema_rh_backend.service.PagamentoService;
import com.generation.sistema_rh_backend.repository.FuncionarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pagamentos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PagamentoController {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
    @Autowired
    private PagamentoService pagamentoService;
    
    @GetMapping()
    public ResponseEntity<List<Pagamento>> getAll(){
        return ResponseEntity.ok(pagamentoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> getById(@PathVariable Long id){
        return pagamentoRepository.findById(id)
            .map(resposta -> ResponseEntity.ok(resposta))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    
    @GetMapping("/mes-referencia/{mesReferencia}")
    public ResponseEntity<List<Pagamento>> getByMesReferencia(@PathVariable String mesReferencia){
        return ResponseEntity.ok(pagamentoRepository
            .findByMesReferenciaContainingIgnoreCase(mesReferencia));
    }
    
    @PostMapping
    public ResponseEntity<Pagamento> post(@Valid @RequestBody Pagamento pagamento) {
        if (funcionarioRepository.existsById(pagamento.getFuncionario().getId())) {

            pagamento.setBonus(pagamentoService.calculo_bonus(pagamento));
            pagamento.setDescontos(pagamentoService.calculo_desconto(pagamento));
            pagamento.setValorFinal(pagamentoService.calculo_salarioFinal(pagamento));

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(pagamentoRepository.save(pagamento));
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Funcionário não existe!", null);
    }
    
    @PutMapping
    public ResponseEntity<Pagamento> put(@Valid @RequestBody Pagamento pagamento){
        if(pagamentoRepository.existsById(pagamento.getId())){
            if (funcionarioRepository.existsById(pagamento.getFuncionario().getId()))
                return ResponseEntity.status(HttpStatus.OK)
                .body(pagamentoRepository.save(pagamento));

                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Funcionário não existe!", null);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        
        if(pagamento.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        
        pagamentoRepository.deleteById(id);              
    }
}
