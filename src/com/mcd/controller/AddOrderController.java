package com.mcd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mcd.service.Service;
import com.mcd.vo.Member;
import com.mcd.vo.Order;

public class AddOrderController implements Controller{
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			int food = Integer.parseInt(request.getParameter("foodNumber"));
			
			Service service = Service.getInstanse();
			int price = service.getPrice(food);
			Member member = service.getMember(id);
			if(member.getMoney() <price) {
				request.setAttribute("error", "보유머니가 부족합니다.");
				HttpUtil.forward(request, response, "menu.jsp");
				return;
			}
			
			Order order = new Order(id,food,price);
			service.addOrder(order);
			request.setAttribute("error", "회원님의 주문이 성공적으로 완료되었습니다.");
			HttpUtil.forward(request, response, "order.jsp");
		}
}
