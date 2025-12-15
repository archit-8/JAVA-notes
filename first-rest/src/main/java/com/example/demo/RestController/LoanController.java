package com.example.demo.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Loan;
import com.example.demo.service.LoanService;

@RestController
@RequestMapping("/loan/api/v1.0")
public class LoanController {

	@Autowired
	LoanService service;

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Loan> loanApplication(@RequestBody Loan loan) {

		Loan newLoan = service.addLoan(loan);
		HttpHeaders headers = new HttpHeaders();
		headers.add("xx-created-by", "archit");
		headers.add("content-type", "application/json");

		return new ResponseEntity<Loan>(newLoan, headers, HttpStatus.OK);
	}

	@GetMapping("/fetch/{lid}")
	public ResponseEntity<Loan>getLoan(@PathVariable Long lid) {
	    return ResponseEntity.ok(service.getLoan(lid));
		
		//return service.getLoan(lid); //do when id is not found
		//return  new ResponseEntity<> (HttpStatus.BAD_REQUEST);
       //return ResponseEntity.badRequest().build();
		//return ResponseEntity.status(400).body(null);
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
	public Loan doUpdate2(@RequestBody Loan loan) {
		return service.update(loan);
	}

	@DeleteMapping("/remove/{lid}")
	public ResponseEntity<Void> removeLoan(@PathVariable Long lid) {
		service.remove(lid);
		return new ResponseEntity<>( HttpStatusCode.valueOf(204));
	}




}
