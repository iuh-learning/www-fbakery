package com.se.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.spring.entity.ChiTietHoaDon;
import com.se.spring.restException.CustomNotFoundException;
import com.se.spring.service.ChiTietHoaDonService;

@RestController
@RequestMapping("/api")
public class ChiTietHoaDonRestController {
	@Autowired
    private ChiTietHoaDonService chiTietHoaDonService;

    @GetMapping("/orderDetails/{orderId}")
    public List<ChiTietHoaDon> getAllOrderDetails(@PathVariable int orderId) {
        return chiTietHoaDonService.getAllOrderDetails(orderId);
    }

    //find, add, delete ...
    @GetMapping("/orderDetails/{orderId}/{productId}")
    public ChiTietHoaDon findOrderDetailById(@PathVariable int orderId, @PathVariable int productId) {
    	ChiTietHoaDon temp = chiTietHoaDonService.findOrderDetailById(orderId, productId);
    	
    	if(temp == null)
    		throw new CustomNotFoundException("Order detail not found: orderId -> " + orderId + " productId -> " + productId);
        
    	return temp;
    }

    @DeleteMapping("/orderDetails/{orderId}")
    public boolean deleteAllOrderDetailById(@PathVariable int orderId){
        return chiTietHoaDonService.deleteAllOrderDetail(orderId);
    }
}
