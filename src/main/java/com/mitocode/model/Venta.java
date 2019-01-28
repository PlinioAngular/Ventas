package com.mitocode.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name="venta")
public class Venta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVenta;
	
	@ManyToOne
	@JoinColumn(name = "id_persona", nullable=false, foreignKey=@ForeignKey(name="persona_venta"))
	private Persona persona;
	
	@Column(name="importe",nullable=false)
	private double importe;
	
	@JsonSerialize(using=ToStringSerializer.class)
	private LocalDateTime fecha;
	
	@OneToMany(mappedBy="venta", cascade= {CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.REMOVE},fetch=FetchType.LAZY,orphanRemoval=true)
	private List <DetalleVenta> detalleVenta;

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public List<DetalleVenta> getDetalleVenta() {
		return detalleVenta;
	}

	public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}
	

}
