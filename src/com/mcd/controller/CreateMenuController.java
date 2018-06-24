package com.mcd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mcd.service.Service;
import com.mcd.vo.Menu;

public class CreateMenuController implements Controller{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		
		if (name.isEmpty() || price.isEmpty()) {
			request.setAttribute("error", "모든 항목을 입력하십시오.");
			HttpUtil.forward(request, response, "admin/menu.jsp");
			return;
		}
		Menu m = new Menu(name, Integer.parseInt(price));
		Service service = Service.getInstanse();
		service.createMenu(m);
		request.setAttribute("error", "메뉴 등록이 완료되었습니다.");
		HttpUtil.forward(request, response, "admin/menu.jsp");
		return;
	}
}
