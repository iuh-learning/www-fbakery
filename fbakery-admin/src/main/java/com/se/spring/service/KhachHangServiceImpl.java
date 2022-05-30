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

import com.se.spring.entity.KhachHang;

@Service
public class KhachHangServiceImpl implements KhachHangService {
	private RestTemplate restTemplate;
	private String restUrl;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public KhachHangServiceImpl(RestTemplate restTemplate, @Value("${crm.rest.url.customer}") String url) {
		this.restTemplate = restTemplate;
		this.restUrl = url;
		logger.info("Load property: crm.rest.url.customer ->" + restUrl);
	}

	@Override
	public List<KhachHang> getCustomers() {
		logger.info("in getCustomers(): Calling REST API" + restUrl);

		ResponseEntity<List<KhachHang>> responseEntity = null;
		try {
			responseEntity = restTemplate.exchange(restUrl, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<KhachHang>>() {
					});
		}catch (Exception e) {
			e.printStackTrace();
		}

		List<KhachHang> customers = responseEntity.getBody();

		return customers;
	}

	@Override
	public void saveCustomer(KhachHang cus) {
		logger.info("in saveCustomer(): Calling REST API " + restUrl);

		int id = cus.getMaKH();

		// make REST call
		if (id == 0) {
			// add customer
			restTemplate.postForEntity(restUrl, cus, String.class);
		} else {
			// update customer
			restTemplate.put(restUrl, cus);
		}

		logger.info("in saveCustomer(): success");

	}

	@Override
	public KhachHang getCustomerById(int id) {
		logger.info("in getCustomerById(): Calling REST API " + restUrl);

		// make REST call
		KhachHang theCustomer = restTemplate.getForObject(restUrl + "/" + id, KhachHang.class);

		return theCustomer;
	}

	@Override
	public void deleteCustomer(int id) {
		logger.info("in deleteCustomer(): Calling REST API " + restUrl);

		// make REST call
		restTemplate.delete(restUrl + "/" + id);

		logger.info("in deteteCustomer(): deteted customer id = " + id);

	}
}
