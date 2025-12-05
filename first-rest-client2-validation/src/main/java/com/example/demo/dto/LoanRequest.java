package com.example.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class LoanRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long loanId;
	@NotNull(message = "user name should not be null")
	@NotBlank(message = "user name cannot be blank")
	private String customerName;

	private String dateBorrowed;

	@Min(value = 1, message = "Tenure must be at least 1 month")
	@Max(value = 360, message = "Tenure cannot exceed 360 months")

	private int tenure;
	@Min(value = 0, message = "Balance EMI cannot be negative")
	private int balanceEMI;

	@NotNull(message = "Amount cannot be null")
	@DecimalMin(value = "100000.0", message = "Amount must be at least 1")
	@DecimalMax(value = "1000000.0", message = "Amount cannot exceed 10 lakh")
	private double amount;

	private boolean loanStatus;

	public long getLoanId() {
		return loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDateBorrowed() {
		return dateBorrowed;
	}

	public void setDateBorrowed(String dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public int getBalanceEMI() {
		return balanceEMI;
	}

	public void setBalanceEMI(int balanceEMI) {
		this.balanceEMI = balanceEMI;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(boolean loanStatus) {
		this.loanStatus = loanStatus;
	}

}
