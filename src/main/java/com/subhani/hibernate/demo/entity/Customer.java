package com.subhani.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="customers", schema="classicmodels")
@NamedQuery(name="selectall", query="select c from Customer c")
public class Customer {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerNumber;
	
	@Column(name="customerName", insertable=true, updatable=true, nullable=false)
	private String customerName;
	
	private String contactFirstName;
	
	private String contactLastName;
	
	private String phone;
	
	private String addressLine1;
	
	private String city;
	
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	private String country;
	
	//private double creditLimit;


	public String getCustomerName() {
		return customerName;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactFirstName() {
		return contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerNumber != other.customerNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", customerName=" + customerName + ", contactFirstName="
				+ contactFirstName + ", contactLastName=" + contactLastName + ", phone=" + phone + ", addressLine1="
				+ addressLine1 + ", city=" + city + ", country=" + country + "]";
	}

	
	
}
