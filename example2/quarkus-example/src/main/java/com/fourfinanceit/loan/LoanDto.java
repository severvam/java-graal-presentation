package com.fourfinanceit.loan;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class LoanDto {

	private Integer id;
	private BigDecimal amount;
	private LocalDateTime returnDate;

	LoanDto() {
	}

	LoanDto(Integer id, BigDecimal amount, LocalDateTime returnDate) {
		this.id = id;
		this.amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
		this.returnDate = returnDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}
}
