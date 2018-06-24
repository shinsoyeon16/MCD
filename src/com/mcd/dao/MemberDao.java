package com.mcd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mcd.vo.Member;
import com.mcd.vo.Order;

public class MemberDao {
	private static MemberDao dao = new MemberDao();

	private MemberDao() {
	}

	public static MemberDao getInstance() {
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
	
	public String login(String id) {
		String password = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select passwd from member where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				password = rs.getString(1);
			}
		} catch (Exception e) {
			System.out.println("dao.login" + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return password;
	}
	public void join(Member m) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into member (id,passwd,name,phoneNumber) values(?,?,?,?)");
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPasswd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getPhoneNumber());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("dao.join" + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public Member getMember(String id) {
		Member m = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from member where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				m = new Member();
				m.setId(rs.getString(1));
				m.setPasswd(rs.getString(2));
				m.setName(rs.getString(3));
				m.setPhoneNumber(rs.getString(4));
				m.setMoney(rs.getInt(5));
			}
		} catch (Exception e) {
			System.out.println("dao.getMember" + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return m;
	}
	public void registerMoney(String id, String money) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update member set money= money+? where id=?");
			pstmt.setInt(1, Integer.parseInt(money));
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("dao.registerMoney" + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public void update(Member m) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update member set passwd=?, name=?, phoneNumber=? where id=?");
			pstmt.setString(1, m.getPasswd());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getPhoneNumber());
			pstmt.setString(4, m.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("dao.update" + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public void order(Member m, Order order) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update member set money=money-? where id=?");
			pstmt.setInt(1, order.getTotalPrice());
			pstmt.setString(2, m.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("dao.order" + e);
		} finally {
			close(conn, pstmt);
		}
	}
}
