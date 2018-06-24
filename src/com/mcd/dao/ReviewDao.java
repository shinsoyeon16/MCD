package com.mcd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mcd.vo.Review;

public class ReviewDao {
	private static ReviewDao dao = new ReviewDao();

	private ReviewDao() {
	}

	public static ReviewDao getInstance() {
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
	public ArrayList<Review> reviewList() {
		ArrayList<Review> list = new ArrayList<Review>();
		com.mcd.vo.Review r = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from review");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				r = new Review();
				r.setSeq(rs.getInt(1));
				r.setTitle(rs.getString(2));
				r.setWriter(rs.getString(3));
				r.setContent(rs.getString(4));
				r.setOrder(rs.getString(5));
				r.setRegDate(rs.getDate(6));
				list.add(r);
			}
		} catch (Exception e) {
			System.out.println("dao.reviewList" + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	public void reviewDelete(String seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from review where seq=?");
			pstmt.setInt(1, Integer.parseInt(seq));
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("dao.reviewDelete" + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public void reviewWrite(Review r) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into review (title, writer, content, order_number) values (?,?,?,?)");
			pstmt.setString(1, r.getTitle());
			pstmt.setString(2, r.getWriter());
			pstmt.setString(3, r.getContent());
			pstmt.setString(4, r.getOrder());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("dao.reviewWrite" + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public Review getReview(int seq) {
		Review r = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from review where seq=?");
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				r = new Review();
				r.setSeq(rs.getInt(1));
				r.setTitle(rs.getString(2));
				r.setWriter(rs.getString(3));
				r.setContent(rs.getString(4));
				r.setOrder(rs.getString(5));
				r.setRegDate(rs.getDate(6));
			}
		} catch (Exception e) {
			System.out.println("dao.getReview" + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return r;
	}
}
