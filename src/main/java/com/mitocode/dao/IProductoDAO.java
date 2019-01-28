package com.mitocode.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Producto;

public interface IProductoDAO extends JpaRepository<Producto, Integer> {

}
