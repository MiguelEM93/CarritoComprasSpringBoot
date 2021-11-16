package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Producto;
import com.example.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoREST {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/lista")
	private ResponseEntity<List<Producto>> getAllProductos (){
		return ResponseEntity.ok(productoService.findAll());
	}
	
	@PostMapping("/save")
	private ResponseEntity<Producto> saveProducto(@RequestBody Producto producto) {
		try {
			return ResponseEntity.ok(productoService.save(producto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("/editar/{id}")
	private ResponseEntity<Producto> editProducto(@RequestBody Producto p, @PathVariable("id") int id) {
		try {
			//p.setId(id);
			return ResponseEntity.ok(productoService.save(p));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping("/eliminar/{id}")
	private ResponseEntity<Boolean> deleteProducto(@PathVariable("id") int id) {
		try {
			productoService.deleteById(id);
			return ResponseEntity.ok(productoService.findById(id) != null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
