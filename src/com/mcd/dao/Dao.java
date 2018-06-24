package com.mcd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mcd.vo.Menu;
import com.mcd.vo.Order;

public class Dao {
	private static Dao dao = new Dao();

	private Dao() {
	}

	public static Dao getInstance() {
		return dao;
	}
	
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mcd";
			String user = "root";
			String password = "cs1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("connect" + e);
		}
		return conn;
	}

	public void close(Connection conn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				System.out.println("Error:close1" + e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("Error:close2" + e);
			}
		}
	}

	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				System.out.println("Error:close1" + e);
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("Error:close2" + e);
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println("Error:close3" + e);
			}
		}
	}
	public void createMenu(Menu m) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into menu (name, price) values (?,?)");
			pstmt.setString(1, m.getName());
			pstmt.setInt(2, m.getPrice());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("dao.createMenu" + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public ArrayList<Menu> menuList() {
		ArrayList<Menu> list = new ArrayList<Menu>();
		Menu m = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from menu");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				m = new Menu();
				m.setFoodNumber(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setPrice(rs.getInt(3));
				list.add(m);
			}
		} catch (Exception e) {
			System.out.println("dao.menuList" + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	public int getPrice(int foodNumber) {
		int price = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select price from menu where foodNumber=?");
			pstmt.setInt(1, foodNumber);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				price = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("dao.getPrice" + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return price;
	}
	public String getFood(int foodNumber) {
		String name = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select name from menu where foodNumber=?");
			pstmt.setInt(1, foodNumber);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				name = rs.getString(1);
			}
		} catch (Exception e) {
			System.out.println("dao.getFood" + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return name;
	}
	public void addOrder(Order o) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into orderInfo (orderId, food, totalPrice) values(?,?,?)");
			pstmt.setString(1, o.getOrderId());
			pstmt.setInt(2, o.getFood());
			pstmt.setInt(3, o.getTotalPrice());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("dao.addOrder" + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public ArrayList<Order> orderList() {
		ArrayList<Order> list = new ArrayList<Order>();
		Order o = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from orderInfo");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				o = new Order();
				o.setOrderNumber(rs.getInt(1));
				o.setOrderId(rs.getString(2));
				o.setFood(rs.getInt(3));
				o.setTotalPrice(rs.getInt(4));
				o.setOrderDate(rs.getDate(5));
				o.setState(rs.getInt(6));
				list.add(o);
			}
		} catch (Exception e) {
			System.out.println("dao.orderList" + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	public ArrayList<Order> orderList(String id) {
		ArrayList<Order> list = new ArrayList<Order>();
		Order o = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from orderInfo where orderId=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				o = new Order();
				o.setOrderNumber(rs.getInt(1));
				o.setOrderId(rs.getString(2));
				o.setFood(rs.getInt(3));
				o.setTotalPrice(rs.getInt(4));
				o.setOrderDate(rs.getDate(5));
				o.setState(rs.getInt(6));
				list.add(o);
			}
		} catch (Exception e) {
			System.out.println("dao.orderList by orderid" + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	public void orderProcess(String orderNumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update orderinfo set state=state+1 where orderNumber=?");
			pstmt.setInt(1, Integer.parseInt(orderNumber));
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("dao.orderProcess" + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public boolean isReviewWriten(String orderNumber) {
		boolean result=false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from review where order_number=?");
			pstmt.setString(1, orderNumber);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result=true;
			}
		} catch (Exception e) {
			System.out.println("dao.isReviewWriten" + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
}
