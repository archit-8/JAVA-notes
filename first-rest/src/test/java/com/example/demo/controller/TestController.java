
package com.example.demo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.example.demo.RestController.LoanController;
import com.example.demo.entity.Loan;
import com.example.demo.service.LoanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(LoanController.class)
public class TestController {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private LoanService service;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void addLoanTest() throws Exception {
        Loan requestLoan = new Loan(12, "jhone", "12/4/26", 20, 20000, 1000000, true);
        
        when(service.addLoan(any(Loan.class))).thenReturn(requestLoan);

        mvc.perform(post("/loan/api/v1.0/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestLoan)))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().is2xxSuccessful())
            .andDo(print()) 
            .andExpect(jsonPath("$.loanId").value(12))
            .andExpect(jsonPath("$.customerName").value("jhone"))
            .andExpect(jsonPath("$.dateBorrowed").value("12/4/26"))
            .andExpect(jsonPath("$.tenure").value(20))
            .andExpect(jsonPath("$.balanceEMI").value(20000))
            .andExpect(jsonPath("$.amount").value(1000000))
            .andExpect(jsonPath("$.loanStatus").value(true));
    }
}
