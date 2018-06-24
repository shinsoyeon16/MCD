package com.mcd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mcd.service.Service;

public class OrderProcessController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderNumber = request.getParameter("orderNumber");
		Service service = Service.getInstanse();
		service.orderProcess(orderNumber);
		
			HttpUtil.forward(request, response, "admin/order.jsp");
			return;
	}
}
