package com.mcd.vo;

import java.sql.Date;

public class Order {
private int orderNumber;
private String orderId;
private int food;
private int totalPrice;
private Date orderDate;
private int state;
// 0(기본값)=주문만 한 상태,  1=매장에서 포장완료 버튼 누른상태(고객이 찾으러 가면 되는 상태), 2=매장에서 수령완료 버튼 누른 상태(고객이 리뷰작성할 수 있는 상태), 3=리뷰 작성 완료된 상태

public Order() {
}
public Order(String orderId, int food, int totalPrice) {
	this.orderId = orderId;
	this.food = food;
	this.totalPrice = totalPrice;
}
public int getOrderNumber() {
	return orderNumber;
}
public void setOrderNumber(int orderNumber) {
	this.orderNumber = orderNumber;
}
public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}
public int getFood() {
	return food;
}
public void setFood(int food) {
	this.food = food;
}
public int getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(int totalPrice) {
	this.totalPrice = totalPrice;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}

}
