package com.fourfinanceit.loan.domain;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class LoanRepository {

	@Inject
	private EntityManager em;

	public List<Loan> findAll() {
		return em.createQuery("select l from Loan l", Loan.class).getResultList();
	}

	public List<Loan> findLast(Integer count) {
		return em.createQuery("select l from Loan l order by l.id asc limit " + count, Loan.class).getResultList();
	}

}
