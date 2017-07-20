package cn.itcast.h3.qbc.user;

public class UserModel {
	private Long uuid;
	private String userName;
	private Integer age;
	private String address;
	
	public String toString() {
		return "UserModel [uuid=" + uuid + ", userName=" + userName + ", age="
				+ age + ", address=" + address + "]";
	}
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
