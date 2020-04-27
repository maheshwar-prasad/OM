/*package com.umang.springmvc.services;

*//**
 * @author Maheshwar.Prasad
 *
 *//*
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.umang.springmvc.entities.Product;
import com.umang.springmvc.repositories.ProductRepository;


@Transactional
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	public List<Product> search(String keyword) {
		return this.productRepository.search(keyword);
	}

}*/