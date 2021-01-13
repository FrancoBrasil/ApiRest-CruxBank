package com.orion.cruxbank.controllers;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.orion.cruxbank.controllers.dto.AtualizaClienteFormDTO;
import com.orion.cruxbank.controllers.dto.ClienteDTO;
import com.orion.cruxbank.controllers.dto.ClienteFormDTO;
import com.orion.cruxbank.controllers.dto.DetalharClienteDTO;
import com.orion.cruxbank.model.Cliente;
import com.orion.cruxbank.repositories.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public Page<ClienteDTO> lista(@RequestParam(required = false) String nome, 
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10)Pageable paginacao) {

		// Pageable paginacao = PageRequest.of(pagina, qtde, Direction.ASC, ordenacao);

		if (nome == null) {
			Page<Cliente> clientes = clienteRepository.findAll(paginacao);
			return ClienteDTO.converter(clientes);
		} else {
			Page<Cliente> clientes = clienteRepository.findByNome(nome, paginacao);
			return ClienteDTO.converter(clientes);
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDTO> cadastrar(@RequestBody @Valid ClienteFormDTO formDTO,
			UriComponentsBuilder uriBuilder) {

		Cliente cliente = formDTO.converter();
		clienteRepository.save(cliente);
		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

		return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalharClienteDTO> detalhar(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(new DetalharClienteDTO(cliente.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDTO> atualizar(@PathVariable Long id,
			@RequestBody @Valid AtualizaClienteFormDTO form) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent()) {
			Cliente cliente = form.atualizar(id, clienteRepository);
			return ResponseEntity.ok(new ClienteDTO(cliente));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if (optional.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}
