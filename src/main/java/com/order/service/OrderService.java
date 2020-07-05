package com.order.service;

import com.commons.entity.BillInfo;
import com.commons.entity.Order;

public interface OrderService {
	
	public BillInfo getBillInfo(Order order) throws Exception;
	public String sendOrder(Order order, BillInfo billInfo);

}
