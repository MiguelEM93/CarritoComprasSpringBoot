package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Cliente;
import com.example.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteREST {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/lista")
	private ResponseEntity<List<Cliente>> getAllClientes (){
		return ResponseEntity.ok(clienteService.findAll());
	}
	
	@PostMapping("/save")
	private ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) {
		try {
			return ResponseEntity.ok(clienteService.save(cliente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
}
