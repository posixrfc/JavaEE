package cn.itcast.javaee.springmvc.app10;

import java.util.Date;

/**
 * Ա��
 * @author AdminTC
 */
public class Emp {
	private String username;//����
	private String gender;//�Ա�
	private Date hiredate;//��ְʱ��
	public Emp(){}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
}
