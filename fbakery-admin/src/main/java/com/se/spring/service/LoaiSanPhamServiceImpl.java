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

import com.se.spring.entity.LoaiSanPham;

@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService {

	private RestTemplate restTemplate;
	private String restUrl;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public LoaiSanPhamServiceImpl(RestTemplate restTemplate, @Value("${crm.rest.url.typeProducts}") String url) {
		this.restTemplate = restTemplate;
		this.restUrl = url;
		logger.info("Load property: crm.rest.url.typeProducts ->" + restUrl);
	}

	@Override
	public List<LoaiSanPham> getTypeProducts() {
		logger.info("in getTypeProducts(): Calling REST API" + restUrl);

		ResponseEntity<List<LoaiSanPham>> responseEntity = null;

		try {
			responseEntity = restTemplate.exchange(restUrl, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<LoaiSanPham>>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<LoaiSanPham> list = responseEntity.getBody();
		
		return list;
	}

	@Override
	public void saveTypeProduct(LoaiSanPham typeProduct) {
		logger.info("in saveTypeProduct(): Calling REST API " + restUrl);
		// TODO Auto-generated method stub
		int id = typeProduct.getMaLoaiSP();
		if(id == 0)
			restTemplate.postForEntity(restUrl, typeProduct, String.class);
		else
			restTemplate.put(restUrl, typeProduct);
		logger.info("in saveTypeProduct(): success");
	}

	@Override
	public LoaiSanPham getTypeProductById(int id) {
		logger.info("in getTypeProductById(): Calling REST API " + restUrl);
		
		LoaiSanPham type = restTemplate.getForObject(restUrl + "/" + id, LoaiSanPham.class);
		
		return type;
	}

	@Override
	public void deleteTypeProduct(int id) {
		logger.info("in deleteTypeProduct(): Calling REST API " + restUrl);
		
		restTemplate.delete(restUrl + "/" + id);
		
		logger.info("in deleteTypeProduct(): deteted customer id = " + id);
	}

}
