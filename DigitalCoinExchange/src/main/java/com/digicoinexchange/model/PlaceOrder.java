package com.digicoinexchange.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PlaceOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int orderId;
	String location;
	CurrencyType currencyType;
	long margin;
	Long minAmount;
	Long maxAmount;
	String phoneNumber;
	String otherContactId;
	String BankDetails;
	OrderType orderType;
	
	@ManyToOne
	@JoinColumn(name = "Id")
	private User userId;

	public PlaceOrder()
	{
		
	}

	public PlaceOrder(int orderId, String location, CurrencyType currencyType, long margin, Long minAmount,
			Long maxAmount, String phoneNumber, String otherContactId, String bankDetails, OrderType orderType,
			User userId) {
		super();
		this.orderId = orderId;
		this.location = location;
		this.currencyType = currencyType;
		this.margin = margin;
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;
		this.phoneNumber = phoneNumber;
		this.otherContactId = otherContactId;
		BankDetails = bankDetails;
		this.orderType = orderType;
		this.userId = userId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public CurrencyType getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(CurrencyType currencyType) {
		this.currencyType = currencyType;
	}

	public long getMargin() {
		return margin;
	}

	public void setMargin(long margin) {
		this.margin = margin;
	}

	public Long getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(Long minAmount) {
		this.minAmount = minAmount;
	}

	public Long getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(Long maxAmount) {
		this.maxAmount = maxAmount;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOtherContactId() {
		return otherContactId;
	}

	public void setOtherContactId(String otherContactId) {
		this.otherContactId = otherContactId;
	}

	public String getBankDetails() {
		return BankDetails;
	}

	public void setBankDetails(String bankDetails) {
		BankDetails = bankDetails;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public User getUserId() {
		return userId;
	}

	public void setUser(User userId) {
		this.userId = userId;
	}

	
	
}
