package com.example.demo.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Loan;

@RestController
@RequestMapping("client/loan/api/v1.0")
public class LoanController {

	@Autowired
	RestTemplate template;

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Loan> loanApplication(@RequestBody Loan loan) {

		return null;
	}

	@GetMapping("/fetch/{lid}")
	public ResponseEntity<Loan> getLoan(@PathVariable Long lid) {
		String url = "http://localhost:8090/loan/api/v1.0/fetch/" + lid;
		Loan loan = template.getForObject(url, Loan.class);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/all")
	public String getLoans() {
		return  "hellowrold" ;
	}

	@PutMapping("/modify")
	public Loan doUpdate(@RequestBody Loan loan) {
		return null;
	}

	@PutMapping("/modify2")
	public Loan doUpdate2(@RequestBody Loan loan) {
		return null;
	}

    @PutMapping("/remove")
    public void deleteLoan(Long lid) {
//        String url = "http://localhost:8090/loan/api/v1.0/remove/" + lid;
//        template.delete(url);
    	
    }


	}


