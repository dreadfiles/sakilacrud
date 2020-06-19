package com.aaol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aaol.entity.Customer;
import com.aaol.repository.CustomerRepository;

@RestController
@RequestMapping("/sakila/customer")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;

	@GetMapping("/getAll")
	public List<Customer> getAll() {
		List<Customer> salida = null;
		try {
			salida = customerRepository.findAll();
		} catch (Exception e) {
			salida = null;
		}
		return salida;
	}

	@GetMapping("/get/{id}")
	public Customer get(@PathVariable Integer id) {
		Customer salida = null;
		try {
			salida = customerRepository.findOne(id);
		} catch (Exception e) {
			salida = null;
		}
		return salida;
	}

	@PostMapping("/post")
	public Customer add(@RequestBody Customer customer) {
		Customer salida = null;
		try {
			customerRepository.save(customer);
			salida = customer;
		} catch (Exception e) {
			salida = null;
		}
		return salida;
	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable Integer id) {
		boolean salida = false;
		try {
			customerRepository.delete(id);
			salida = true;
		} catch (Exception e) {
			salida = false;
		}
		return salida;
	}

}