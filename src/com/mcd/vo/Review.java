package com.mcd.vo;

import java.sql.Date;

public class Review {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private String order;
	private Date regDate;
	
	public Review() {}
	public Review(String title, String writer, String content, String order) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.order = order;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
