package com.fourfinanceit.loan;

import com.fourfinanceit.loan.domain.Loan;
import com.fourfinanceit.loan.domain.LoanRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/loans")
@Produces(MediaType.APPLICATION_JSON)
public class LoansResource {

	private final LoanRepository loanRepository;

	@Inject
	public LoansResource(LoanRepository loanRepository) {
		this.loanRepository = loanRepository;
	}

	@GET
	@Path("/all")
	public List<Loan> allLoans() {
		return loanRepository.findAll();
	}

	@GET
	@Path("/last/{count}")
	public List<Loan> lastLoans(@PathParam("count") Integer count) {
		return loanRepository.findLast(count);
	}

}
