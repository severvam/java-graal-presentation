package com.fourfinanceit.loan;

import com.fourfinanceit.loan.domain.Loan;
import com.fourfinanceit.loan.domain.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping(path = "/loans", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
class LoansResource {

	private final LoanRepository loanRepository;

	@Autowired
	LoansResource(LoanRepository loanRepository) {
		this.loanRepository = loanRepository;
	}

	@RequestMapping("/all")
	ResponseEntity<List<Loan>> allLoans() {
		return ResponseEntity.ok(loanRepository.findAll());
	}

	@RequestMapping("/last/{count}")
	ResponseEntity<List<Loan>> last(@PathVariable("count") Integer count) {
		return ResponseEntity.ok(loanRepository.findAll(PageRequest.of(0, count, Sort.by(Sort.Direction.ASC, "id"))).getContent());
	}

}
