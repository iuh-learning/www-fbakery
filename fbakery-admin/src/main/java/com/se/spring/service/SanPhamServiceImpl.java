package com.se.spring.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.spring.entity.SanPham;

@Service
public class SanPhamServiceImpl implements SanPhamService {
	private RestTemplate restTemplate;
	private String restUrl;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public SanPhamServiceImpl(RestTemplate restTemplate, @Value("${crm.rest.url.product}") String url) {
		this.restTemplate = restTemplate;
		this.restUrl = url;
		logger.info("Load property: crm.rest.url.product ->" + restUrl);
	}

	@Override
	public List<SanPham> getProducts() {
		logger.info("in getProducts(): Calling REST API" + restUrl);

		ResponseEntity<List<SanPham>> responseEntity = restTemplate.exchange(restUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<SanPham>>() {
				});

		return responseEntity.getBody();
	}

	@Override
	public void saveProduct(SanPham product) {
		logger.info("in saveProduct(): Calling REST API " + restUrl);

		int id = product.getMaSP();
		
		System.out.println("SERVICE - CLIENT: " + product);
		
		// make REST call
		if (id == 0) {
			// add product
			restTemplate.postForEntity(restUrl, product, SanPham.class);
		} else {
			// update product
			restTemplate.put(restUrl, product);
		}

		logger.info("in saveProduct(): success");
	}

	@Override
	public SanPham getProductById(int id) {
		logger.info("in getProductById(): Calling REST API " + restUrl);

		SanPham product = restTemplate.getForObject(restUrl + "/" + id, SanPham.class);
		System.out.println("SERVICE CLIENT:" + product);
		return product;
	}

	@Override
	public void deleteProduct(int id) {
		logger.info("in deleteProduct(): Calling REST API " + restUrl);

		// make REST call
		restTemplate.delete(restUrl + "/" + id);

		logger.info("in deleteProduct(): deteted customer id = " + id);

	}

	@Override
	public List<SanPham> getProductsByIdTypeProduct(int id) {
		logger.info("in getProducts(): Calling REST API" + restUrl);

		ResponseEntity<List<SanPham>> responseEntity = restTemplate.exchange(restUrl + "/role/" + id, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<SanPham>>() {
				});

		return responseEntity.getBody();
	}

}
