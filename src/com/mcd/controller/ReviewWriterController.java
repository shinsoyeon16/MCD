package com.mcd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mcd.service.Service;
import com.mcd.vo.Review;

public class ReviewWriterController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		String writer = (String) session.getAttribute("id");
		String content = request.getParameter("content");
		String order = request.getParameter("orderNumber"); 
		
		if (title.isEmpty() || content.isEmpty()) {
			request.setAttribute("error", "모든 항목을 입력하십시오.");
			HttpUtil.forward(request, response, "order.jsp");
			return;
		}
		Review r = new Review(title,writer,content,order);
		Service service = Service.getInstanse();
		service.reviewWrite(r);
		request.setAttribute("error", "리뷰작성이 성공적으로 완료되었습니다.");
		HttpUtil.forward(request, response, "reviewList.jsp");
		return;

	}

}
