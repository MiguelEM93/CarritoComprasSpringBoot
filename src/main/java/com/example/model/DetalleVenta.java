package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalleVenta")
public class DetalleVenta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@ManyToOne
	@JoinColumn(name = "id_venta")
	public Venta venta;
	
	@ManyToOne
	@JoinColumn(name = "id_producto")
	public Producto producto;
	
	@Column(name = "cantidad")
	public int cantidad;
	
	public DetalleVenta() {
		
	}

	public DetalleVenta(Venta venta, Producto producto, int cantidad) {
		super();
		this.venta = venta;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	
}
