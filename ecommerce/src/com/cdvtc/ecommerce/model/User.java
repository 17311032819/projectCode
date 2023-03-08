package com.cdvtc.ecommerce.model;

import java.util.Date;

/**
 * 平台会员（用户）
 */
public class User {
	/**
	 * 会员编号
	 */
	private String m_no;
	/**
	 * 会员姓名
	 */
	private String m_name;
	/**
	 * 邮件（作账户用）
	 */
	private String m_mail;
	/**
	 * 密码
	 */
	private String m_password;

	/**
	 * 姓别
	 */
	private String m_sex;



	/**
	 * 生日
	 */
	private Date m_birth;

	/**
	 * 手机号码
	 */
	private String m_phone;

	@Override
	public String toString() {
		return "User{" +
				"m_no='" + m_no + '\'' +
				", m_name='" + m_name + '\'' +
				", m_mail='" + m_mail + '\'' +
				", m_password='" + m_password + '\'' +
				", m_phone='" + m_phone + '\'' +
				'}';
	}

	public String getM_no() {
		return m_no;
	}

	public void setM_no(String m_no) {
		this.m_no = m_no;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_mail() {
		return m_mail;
	}

	public void setM_mail(String m_mail) {
		this.m_mail = m_mail;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_sex() {
		return m_sex;
	}

	public void setM_sex(String m_sex) {
		this.m_sex = m_sex;
	}

	public Date getM_birth() {
		return m_birth;
	}

	public void setM_birth(Date m_birth) {
		this.m_birth = m_birth;
	}
}
