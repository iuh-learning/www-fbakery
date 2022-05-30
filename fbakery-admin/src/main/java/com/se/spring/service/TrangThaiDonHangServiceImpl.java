package com.se.spring.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.spring.entity.TrangThaiDonHang;

@Service
public class TrangThaiDonHangServiceImpl implements TrangThaiDonHangService{
	private RestTemplate restTemplate;
	private String restUrl;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public TrangThaiDonHangServiceImpl(RestTemplate restTemplate, @Value("${crm.rest.url.orderStatus}") String url) {
		super();
		this.restTemplate = restTemplate;
		this.restUrl = url;
		logger.info("Load property: crm.rest.url.order ->" + restUrl);
	}

	@Override
	public TrangThaiDonHang findOrderStatus(int id) {
		logger.info("in findOrderStatus(): Calling REST API " + restUrl);
		
		TrangThaiDonHang orderStatus = restTemplate.getForObject(restUrl + "/" + id, TrangThaiDonHang.class);
		
		return orderStatus;
	}
	
}
