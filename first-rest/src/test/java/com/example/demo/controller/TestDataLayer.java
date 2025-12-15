
package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.entity.Loan;
import com.example.demo.repositry.LoanRepository; // rename package to 'repository' if possible

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestDataLayer {

    @Autowired
    private LoanRepository loanrepo;

    @DisplayName("Test 1: save Loan")
    @Order(1)
    @Rollback(value = false)
    @Test
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
    void saveLoan() {
        Loan loan = new Loan();
                loan.setCustomerName("jhone");
                loan.setDateBorrowed("12/4/26");
                loan.setTenure(20);
                loan.setBalanceEMI(20000);
                loan.setAmount(1000000);
                loan.setLoanStatus(true);

        Loan saved = loanrepo.save(loan);

        Assertions.assertNotNull(saved, "Saved entity must not be null");
        Assertions.assertNotNull(saved.getLoanId(), "Generated ID must not be null");
        Assertions.assertTrue(saved.getLoanId() > 0, "Generated ID must be positive");
        Assertions.assertEquals("jhone", saved.getCustomerName());
    }
}
