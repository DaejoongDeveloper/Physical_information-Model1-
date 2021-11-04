package com.information.biz.physical;

import java.sql.Date;

public class PhysicalVO {
	private int seq;
	private String weight;
	private String height;
	private String blood;
	private String gender;
	private Date regDate;
	private int cnt;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "PhysicalVO [seq=" + seq + ", weight=" + weight + ", height=" + height + ", blood=" + blood + ", gender="
				+ gender + ", regDate=" + regDate + ", cnt=" + cnt + "]";
	}
	
}
