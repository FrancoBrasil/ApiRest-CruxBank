package com.orion.cruxbank.controllers;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.orion.cruxbank.controllers.dto.ContaDTO;
import com.orion.cruxbank.controllers.dto.ContaFormDTO;
import com.orion.cruxbank.model.Conta;
import com.orion.cruxbank.repositories.ClienteRepository;
import com.orion.cruxbank.repositories.ContaRepository;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	@Cacheable(value = "listaConta")
	public Page<ContaDTO> lista(@RequestParam(required = false) String tipo, @PageableDefault(sort = "id",
			direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		if (tipo == null) {
			Page<Conta> contas = contaRepository.findAll(paginacao);
			return ContaDTO.converter(contas);
		} else {
			Page<Conta> contas = contaRepository.findByTipo(tipo, paginacao);
			return ContaDTO.converter(contas);
		}
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaConta", allEntries = true)
	public ResponseEntity<ContaDTO> cadastrar(@RequestBody ContaFormDTO form,
			UriComponentsBuilder uriBuilder) {
		Conta conta = form.converter(clienteRepository);
		contaRepository.save(conta);
		
		URI uri = uriBuilder.path("/contas/{id}").buildAndExpand(conta.getId()).toUri();

		return ResponseEntity.created(uri).body(new ContaDTO(conta));
	}
}
