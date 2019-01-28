package com.mitocode.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Producto;
import com.mitocode.model.Venta;
import com.mitocode.service.impl.VentaServiceImpl;

@RestController
@RequestMapping("/ventas")
public class VentaController {
	
	@Autowired
	private VentaServiceImpl service;
	
	@PostMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<Object> registrar(@RequestBody Venta ven)
	{
		Venta venta=new Venta();
		venta=service.registrar(ven);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venta.getIdVenta()).toUri();
		return ResponseEntity.created(location).build();
	}
	@GetMapping(produces="application/json")
	public ResponseEntity<List<Venta>> listar(){
		return new ResponseEntity<List<Venta>>(service.listar(), HttpStatus.OK);
	}
	@GetMapping(value="/{id}",produces="application/json")
	public Resource<Venta> listarporid(@PathVariable("id") Integer id){
		Venta prod=service.listarid(id);
		if(prod==null) {
			throw new ModeloNotFoundException("Id no encontrado "+id);
		}
		Resource <Venta> resource = new Resource<Venta>(prod);
		ControllerLinkBuilder linkTo= linkTo(methodOn(this.getClass()).listarporid(id));
		resource.add(linkTo.withRel("Producto-resource"));
		return resource;
	}
	

}
