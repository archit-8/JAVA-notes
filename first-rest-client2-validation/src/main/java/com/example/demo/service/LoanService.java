
package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoanRequest;
import com.example.demo.entity.Loan;

@Service
public class LoanService {

	@Autowired
	private com.example.demo.repo.LoanRepository repository;

	public Loan addLoan(LoanRequest loanDTo) {
		Loan loan = new Loan();
		loan.setCustomerName(loanDTo.getCustomerName());
		loan.setDateBorrowed(loanDTo.getDateBorrowed());
		loan.setLoanId(loanDTo.getLoanId());
		loan.setAmount(loanDTo.getAmount());
		loan.setBalanceEMI(loanDTo.getBalanceEMI());

		return repository.save(loan);

	}

	public Loan getLoan(long loanId) {
		Optional<Loan> optionalLoan = repository.findById(loanId);
		return optionalLoan.get();

	}

	public List<Loan> getLoans() {
		return repository.findAll();
	}

	public Loan update(Loan loan) {
		return repository.save(loan);
	}

	public Loan update2(Loan loan) {
		Optional<Loan> optinal = repository.findById(loan.getLoanId());
		Loan tempLoan = optinal.get();
		if (loan.getCustomerName() != null)

			tempLoan.setCustomerName(loan.getCustomerName());
		if (loan.getDateBorrowed() != null)
			tempLoan.setDateBorrowed(loan.getDateBorrowed());

		if (tempLoan.getTenure() != loan.getTenure())
			tempLoan.setTenure(loan.getTenure());

		if (tempLoan.getAmount() < loan.getAmount())
			tempLoan.setAmount(loan.getAmount());

		if (tempLoan.isLoanStatus() != loan.isLoanStatus())
			tempLoan.setLoanStatus(loan.isLoanStatus());

		return repository.save(tempLoan);

	}

	public void remove(Long lid) {
		Optional<Loan> loan = repository.findById(lid);
		if (loan.isPresent())
			repository.delete(loan.get());
		else
			throw new IllegalArgumentException(lid + "not found!");
	}

	
}
