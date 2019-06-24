package com.fourfinanceit.loan.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;

	private BigDecimal amount;

	private LocalDateTime loanStartDate;

	private LocalDateTime loanEndDate;

	Loan() {
	}

	public Loan(BigDecimal amount, LocalDateTime loanStartDate, LocalDateTime loanEndDate) {
		this.amount = amount;
		this.loanStartDate = loanStartDate;
		this.loanEndDate = loanEndDate;
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

	public LocalDateTime getLoanStartDate() {
		return loanStartDate;
	}

	public void setLoanStartDate(LocalDateTime loanStartDate) {
		this.loanStartDate = loanStartDate;
	}

	public LocalDateTime getLoanEndDate() {
		return loanEndDate;
	}

	public void setLoanEndDate(LocalDateTime loanEndDate) {
		this.loanEndDate = loanEndDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Loan loan = (Loan) o;
		return Objects.equals(id, loan.id) &&
				Objects.equals(amount, loan.amount) &&
				Objects.equals(loanStartDate, loan.loanStartDate) &&
				Objects.equals(loanEndDate, loan.loanEndDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, amount, loanStartDate, loanEndDate);
	}

	@Override
	public String toString() {
		return "Loan{" +
				"id=" + id +
				", amount=" + amount +
				", loanStartDate=" + loanStartDate +
				", loanEndDate=" + loanEndDate +
				'}';
	}
}
