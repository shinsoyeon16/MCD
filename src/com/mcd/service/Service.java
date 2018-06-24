package com.mcd.service;

import java.util.ArrayList;

import com.mcd.dao.Dao;
import com.mcd.dao.MemberDao;
import com.mcd.dao.ReviewDao;
import com.mcd.vo.Member;
import com.mcd.vo.Menu;
import com.mcd.vo.Order;
import com.mcd.vo.Review;

public class Service {
	private static Service service = new Service();
	private MemberDao mdao = MemberDao.getInstance();
	private ReviewDao rdao = ReviewDao.getInstance();
	private Dao dao = Dao.getInstance();

	private Service() {
	}

	public static Service getInstanse() {
		return service;
	}
	
	public String login(String id) {
		return mdao.login(id);
	}
	public void join(Member m) {
		mdao.join(m);
	}
	public Member getMember(String id) {
		return mdao.getMember(id);
	}
	public void registerMoney(String id, String money) {
		mdao.registerMoney(id,money);
	}
	public ArrayList<Review> reviewList() {
		return rdao.reviewList();
	}
	public void reviewDelete(String seq) {
		rdao.reviewDelete(seq);
	}
	public void update(Member m) {
		mdao.update(m);
	}
	public void reviewWrite(Review r) {
		rdao.reviewWrite(r);
	}
	public Review getReview(int seq) {
		return rdao.getReview(seq);
	}
	public void createMenu(Menu m) {
		dao.createMenu(m);
	}
	public ArrayList<Menu> menuList() {
		return dao.menuList();
	}
	public int getPrice(int foodNumber) {
		return dao.getPrice(foodNumber);
	}
	public void addOrder(Order order) {
		Member member = this.getMember(order.getOrderId());
		mdao.order(member,order);
		dao.addOrder(order);
	}
	public ArrayList<Order> orderList() {
		return dao.orderList();
	}
	public ArrayList<Order> orderList(String id) {
		return dao.orderList(id);
	}
	public String getFood(int foodNumber) {
		return dao.getFood(foodNumber);
	}
	public void orderProcess(String orderNumber) {
		dao.orderProcess(orderNumber);
	}

	public boolean isReviewWriten(String orderNumber) {
		return dao.isReviewWriten(orderNumber);
	}
}
