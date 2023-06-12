package com.inventario.model;

public class Customer {
    private String customerId;
    private String customerName;
    private String city;
    private int grade;
    private int salesmanId;

    public Customer(String customerId, String customerName, String city, int grade, int salesmanId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.city = city;
        this.grade = grade;
        this.salesmanId = salesmanId;
    }

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}

}