package com.order.controller;

import java.net.ConnectException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.commons.entity.BillInfo;
import com.commons.entity.Order;
import com.google.gson.Gson;
import com.order.service.OrderService;


@RestController
@RequestMapping(value = { "/order" })
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping(value = "/checkout", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> checkoutOrder(@RequestBody Order order) throws Exception {
		
		BillInfo billInfo = orderService.getBillInfo(order);
		
		return ResponseEntity.status(HttpStatus.OK).body(orderService.sendOrder(order, billInfo));		
		
	}
	
	
//	@ExceptionHandler({ ConnectException.class})
//    public ResponseEntity<String> handleException() {
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comunication error");
//    }
}
