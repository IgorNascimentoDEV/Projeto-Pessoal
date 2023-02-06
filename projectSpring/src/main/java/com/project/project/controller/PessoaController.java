package com.project.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.project.Resopitory.PessoaRepository;
import com.project.project.exception.ResourceNotFoundException;
import com.project.project.model.Pessoa;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;


	@GetMapping
	public List<Pessoa> getAll(){
		return pessoaRepository.findAll();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getSalaById(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
		
		Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Sala nao encontrada "+id));
			
		return ResponseEntity.ok().body(pessoa);
		
	}
	
	@PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
	public Pessoa createPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> updateSala(@PathVariable(value = "id") Long id, @RequestBody Pessoa pessoaDetalhes) throws ResourceNotFoundException{
		Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pessoa não encontrada"+id));
		
		pessoa.setNome(pessoaDetalhes.getNome());
		pessoa.setEmail(pessoaDetalhes.getEmail());
		pessoa.setNumero(pessoaDetalhes.getNumero());
		
		final Pessoa updatePessoa = pessoaRepository.save(pessoa);
		
		return ResponseEntity.ok(updatePessoa);
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deletePessoa(@PathVariable(value="id") Long id ) throws ResourceNotFoundException{
		
		Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pessoa não encontrada"+id));
		pessoaRepository.delete(pessoa);
		Map<String, Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return response;
		
	}
	
		
}
