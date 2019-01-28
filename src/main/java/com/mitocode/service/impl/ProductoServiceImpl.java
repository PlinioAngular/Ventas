package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IProductoDAO;
import com.mitocode.model.Producto;
import com.mitocode.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private IProductoDAO dao;

	@Override
	public Producto registrar(Producto t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Producto modificar(Producto t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Producto listarid(int id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

}
