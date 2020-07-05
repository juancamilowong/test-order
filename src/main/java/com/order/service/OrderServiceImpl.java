package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.commons.entity.BillInfo;
import com.commons.entity.Order;
import com.commons.entity.OrderWrapper;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${com.service.bill.url}")
	private String URL_BILL;
	
	@Value("${com.service.logistic.url}")
	private String URL_LOGISTIC;
	
	HttpHeaders headers = new HttpHeaders();

	@Override
	public BillInfo getBillInfo(Order order) throws Exception {
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<BillInfo> responseEntity = restTemplate.exchange(URL_BILL,
				HttpMethod.POST, new HttpEntity<>(order, headers), BillInfo.class);

		if (responseEntity.getStatusCode().is2xxSuccessful()) {
			BillInfo billInfo = responseEntity.getBody();
			return billInfo;
		}

		return null;
	}

	@Override
	public String sendOrder(Order order, BillInfo billInfo) {
		headers.setContentType(MediaType.APPLICATION_JSON);
		OrderWrapper ow = new OrderWrapper();
		ow.setOrder(order);
		ow.setBillInfo(billInfo);
		ResponseEntity<String> responseLogistic = restTemplate.exchange(URL_LOGISTIC,
				HttpMethod.POST, new HttpEntity<>(ow, headers), String.class);

		return responseLogistic.getBody();

	}

}
