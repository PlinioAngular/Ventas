package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IVentaDAO;
import com.mitocode.model.Venta;
import com.mitocode.service.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService {
	
	@Autowired
	private IVentaDAO dao;

	@Override
	public Venta registrar(Venta t) {
		// TODO Auto-generated method stub
		t.getDetalleVenta().forEach(det->det.setVenta(t));
		return dao.save(t);
	}

	@Override
	public Venta modificar(Venta t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Venta> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Venta listarid(int id) {
		// TODO Auto-generated method stub
		return dao.findOne(id);
	}

}
