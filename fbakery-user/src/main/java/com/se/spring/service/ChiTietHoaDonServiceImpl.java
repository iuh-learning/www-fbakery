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

import com.se.spring.entity.ChiTietHoaDon;

@Service
public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService {

	private RestTemplate restTemplate;
	private String restUrl;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public ChiTietHoaDonServiceImpl(RestTemplate restTemplate, @Value("${crm.rest.url.orderDetails}") String url) {
		super();
		this.restTemplate = restTemplate;
		this.restUrl = url;
		logger.info("Load property: crm.rest.url.orderDetails ->" + restUrl);
	}

	@Override
	public List<ChiTietHoaDon> getListOrderDetailByIdOrder(int id) {
		logger.info("in getTypeProducts(): Calling REST API" + restUrl);

		ResponseEntity<List<ChiTietHoaDon>> responseEntity = restTemplate.exchange(restUrl + "/" + id, HttpMethod.GET,
				null, new ParameterizedTypeReference<List<ChiTietHoaDon>>() {
				});

		return responseEntity.getBody();
	}

}
