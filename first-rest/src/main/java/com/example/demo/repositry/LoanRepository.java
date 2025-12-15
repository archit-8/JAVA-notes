package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository <Loan ,Long>{

}
