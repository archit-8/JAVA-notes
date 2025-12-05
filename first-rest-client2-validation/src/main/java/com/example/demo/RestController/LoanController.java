package com.example.demo.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.LoanRequest;
import com.example.demo.entity.Loan;
import com.example.demo.handler.InvalidValueException;
import com.example.demo.service.LoanService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/loan/api/v1.0")
public class LoanController {

	@Autowired
	LoanService service;


@PostMapping("/create")
public ResponseEntity<Loan> loanApplication(@RequestBody @Valid LoanRequest loan) {

    // Example: Validate customer name
    if (loan.getCustomerName() == null || loan.getCustomerName().isBlank()) {
        throw new InvalidValueException("Customer name cannot be blank");
    }

    // Example: Validate amount
    if (loan.getAmount() < 1) {
        throw new InvalidValueException("Amount must be at least 1");
    }

    Loan newLoan = service.addLoan(loan);

    return ResponseEntity.ok(newLoan);
}


	@GetMapping("/fetch/{lid}")
	public Loan getLoan(@PathVariable Long lid) {

		if (lid < 0) {
			throw new InvalidValueException("Customer name cannot be blank");
		} else

			// return ResponseEntity.ok(service.getLoan(lid));

			return service.getLoan(lid); // do when id is not found
		// return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		// return ResponseEntity.badRequest().build();
		// return ResponseEntity.status(400).body(null);
	}

	@GetMapping("/all")
	public List<Loan> getLoans() {
		return service.getLoans();
	}

	@PutMapping("/modify")
	public Loan doUpdate(@RequestBody Loan loan) {
		return service.update(loan);
	}

	@PutMapping("/modify2")
//	public Loan doUpdate2(@RequestBody Loan loan) {
//		return service.update(loan);
//	}

	@DeleteMapping("/remove/{lid}")
	public ResponseEntity<Void> removeLoan(@PathVariable Long lid) {
		service.remove(lid);
		return new ResponseEntity<>(HttpStatusCode.valueOf(204));
	}

}
