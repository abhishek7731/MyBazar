package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OderDetail")
public class OderDetail 
{
	@Id
	@GeneratedValue
  int oderId;   
  public int getOderId() {
		return oderId;
	}
	public void setOderId(int oderId) {
		this.oderId = oderId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getOderDate() {
		return oderDate;
	}
	public void setOderDate(Date oderDate) {
		this.oderDate = oderDate;
	}
	public int getTotalPurchaseAmount() {
		return totalPurchaseAmount;
	}
	public void setTotalPurchaseAmount(int totalPurchaseAmount) {
		this.totalPurchaseAmount = totalPurchaseAmount;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
String username;
  Date oderDate;
  int totalPurchaseAmount;
  String paymentMode;
}
