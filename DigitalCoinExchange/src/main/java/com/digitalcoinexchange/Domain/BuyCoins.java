package com.digitalcoinexchange.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BuyCoins {

	@Id
	String orderId;
	String location;
	String currencyType;
	long margin;
	Long minAmount;
	Long maxAmount;
	String phoneNumber;
	String otherContactId;
	String BankDetails;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User userId;
	
	public BuyCoins() {
		
	}
	public BuyCoins(String orderId, String location, String currencyType, long margin, Long minAmount, Long maxAmount,
			String phoneNumber, String otherContactId, String bankDetails,User userId) {
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
		//this.user=new User(userId,"","","","",false,"");
		this.userId=userId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrency(String currency) {
		this.currencyType = currency;
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
	public User getUserId()
	{
		return userId;
		
	}
	
	public void setUser(User userId)
	{
		this.userId=userId;
	}
	
}
