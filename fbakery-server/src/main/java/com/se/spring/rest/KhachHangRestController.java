package com.se.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.spring.entity.KhachHang;
import com.se.spring.restException.CustomNotFoundException;
import com.se.spring.service.KhachHangService;

@RestController
@RequestMapping("/api")
public class KhachHangRestController {
	@Autowired
	private KhachHangService khachHangService;

	@GetMapping("/customers")
	public List<KhachHang> getCustomers() {
		return khachHangService.getCustomers();
	}

	// find customer by id
	@GetMapping("/customers/{customerId}")
	public KhachHang getCustomer(@PathVariable int customerId) {
		KhachHang customer = khachHangService.getCustomerById(customerId);
		if (customer == null) {
			throw new CustomNotFoundException("Customer id not found - " + customerId);
		}

		return customer;
	}

	// -- add new customer
	@PostMapping("/customers")
	public KhachHang addCustomer(@RequestBody KhachHang customer) {
		khachHangService.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/customers")
	public KhachHang updateCustomer(@RequestBody KhachHang customer) {
		khachHangService.saveCustomer(customer);
		return customer;
	}

	// -- delete
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		KhachHang tempCustomer = khachHangService.getCustomerById(customerId);
		if (tempCustomer == null) {
			throw new CustomNotFoundException("Customer id not found - " + customerId);
		}
		khachHangService.deleteCustomer(customerId);
		return "Deleted customer id - " + customerId;
	}
}
