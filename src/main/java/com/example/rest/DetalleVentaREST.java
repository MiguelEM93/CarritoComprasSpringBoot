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

import com.example.model.DetalleVenta;
import com.example.service.DetalleVentaService;

@RestController
@RequestMapping("/detalle-venta")
public class DetalleVentaREST {
	
	@Autowired
	private DetalleVentaService detalleVentaService;
		
	@GetMapping("/lista")
	private ResponseEntity<List<DetalleVenta>> getAllDetalleVentas (){
		return ResponseEntity.ok(detalleVentaService.findAll());
	}
	
	@PostMapping("/save")
	private ResponseEntity<DetalleVenta> saveDetalleVenta(@RequestBody DetalleVenta venta) {
		try {
			return ResponseEntity.ok(detalleVentaService.save(venta));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
}
