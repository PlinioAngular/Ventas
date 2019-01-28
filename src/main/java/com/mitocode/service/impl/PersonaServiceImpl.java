package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private IPersonaDAO dao;

	@Override
	public Persona registrar(Persona t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Persona modificar(Persona t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public List<Persona> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Persona listarid(int id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

}
