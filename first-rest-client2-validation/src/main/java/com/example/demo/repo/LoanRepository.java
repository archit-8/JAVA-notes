package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository <Loan ,Long>{
	
	List<Loan> findByBorrowerNameLike(String patternString);
	List<Loan> findByBorrowerNameOrderByBorrowerName(String name);
	List<Loan> findByLoanStatus(boolean loanStatus);
	List<Loan> findByTenureLessThan(Long loanId);
	List<Loan> findByTenureBetween(int tenure1, int tenure2 );
	List<Loan> findByDateBorrowedBefore(String dateBorrowed);
	
	 @Query("Select l.borrowerName, l.balanceEMI from Loan l where l.loanId = :id")
		String findBorrowerNameAndBalanceEMIById(@Param("id") Long id);
		


@Query("Select l.borrowerName from Loan l where l.loanId= :id")
		String findBorrowerNameById(@Param("id") Long id);

	

}
