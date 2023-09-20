package com.green.member.vo;

import java.sql.Date;

public class MemberVo {

	private int member_idx;
	private String member_id;
	private String member_name;
	private String member_pw;
	private String member_phone;
	private Date member_joindate;
	
	
	public MemberVo() {}
	public MemberVo(int member_idx, String member_id, String member_name, String member_pw, String member_phone,
			Date member_joindate) {
		this.member_idx = member_idx;
		this.member_id = member_id;
		this.member_name = member_name;
		this.member_pw = member_pw;
		this.member_phone = member_phone;
		this.member_joindate = member_joindate;
	}
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public Date getMember_joindate() {
		return member_joindate;
	}
	public void setMember_joindate(Date member_joindate) {
		this.member_joindate = member_joindate;
	}
	@Override
	public String toString() {
		return "MemberVo [member_idx=" + member_idx + ", member_id=" + member_id + ", member_name=" + member_name
				+ ", member_pw=" + member_pw + ", member_phone=" + member_phone + ", member_joindate=" + member_joindate
				+ "]";
	}
	
	
}
