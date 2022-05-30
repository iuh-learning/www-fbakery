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

import com.se.spring.entity.HoaDon;

@Service
public class HoaDonServiceImpl implements HoaDonService {

	private RestTemplate restTemplate;
	private String restUrl;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public HoaDonServiceImpl(RestTemplate restTemplate, @Value("${crm.rest.url.order}") String url) {
		super();
		this.restTemplate = restTemplate;
		this.restUrl = url;
		logger.info("Load property: crm.rest.url.order ->" + restUrl);
	}

	@Override
	public List<HoaDon> getAllOrder(int idStatus) {
		logger.info("in getTypeProducts(): Calling REST API" + restUrl);

		ResponseEntity<List<HoaDon>> responseEntity = restTemplate.exchange(restUrl + "/status/" + idStatus,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<HoaDon>>() {
				});

		return responseEntity.getBody();
	}

	@Override
	public void saveOrder(HoaDon order) {
		logger.info("in saveOrder(): Calling REST API " + restUrl);

		int id = order.getMaHD();

		if (id == 0)
			restTemplate.postForEntity(restUrl, order, String.class);
		else
			restTemplate.put(restUrl, order);
		logger.info("in saveTypeProduct(): success");

	}

	@Override
	public HoaDon findOrderById(int orderId) {
		logger.info("in findOrderById(): Calling REST API " + restUrl);
		HoaDon order = restTemplate.getForObject(restUrl + "/" + orderId, HoaDon.class);

		return order;
	}

	@Override
	public void deleteOrder(int orderId) {
		// TODO Auto-generated method stub

	}

}
