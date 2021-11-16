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

import com.example.model.Venta;
import com.example.service.VentaService;

@RestController
@RequestMapping("/ventas")
public class VentaREST {
	
	@Autowired
	private VentaService ventaService;
	
	@GetMapping("/lista")
	private ResponseEntity<List<Venta>> getAllVentas (){
		return ResponseEntity.ok(ventaService.findAll());
	}
	
	@PostMapping("/save")
	private ResponseEntity<Venta> saveVenta(@RequestBody Venta venta) {
		try {
			return ResponseEntity.ok(ventaService.save(venta));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/consultar-fecha")
	private ResponseEntity<List<Venta>> getVentaByDate (String desde, String hasta){
		return ResponseEntity.ok(ventaService.findAll());
	}
	
}
