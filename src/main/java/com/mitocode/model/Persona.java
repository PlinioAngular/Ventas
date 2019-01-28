package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="Información de persona")
@Entity
@Table(name="persona")
public class Persona {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPersona;
	
	@ApiModelProperty (notes="Nombres debe ser minimo de tres")
	@Size(min=3,message="Nombre debe tener mínimo 3 caracteres")
	@Column(name="apellidos",nullable=false,length=70)
	private String apellidos;
	
	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	@Size(min=3,message="Nombre debe tener mínimo 3 caracteres")
	@Column(name="nombres",nullable=false,length=70)
	private String nombres;
	
	

}
