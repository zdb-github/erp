package com.java.bean;

public class ErpCustomer {

	private String id;
	private String name;
	private String sex;
	private String age;
	private String address;
	private String company;
	private String phone;
	private String c_type;
	
	public String getC_type() {
		return c_type;
	}
	public void setC_type(String cType) {
		c_type = cType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "ErpCustomer [address=" + address + ", age=" + age
				+ ", company=" + company + ", id=" + id + ", name=" + name
				+ ", phone=" + phone + ", sex=" + sex + "]";
	}
	
	
}
