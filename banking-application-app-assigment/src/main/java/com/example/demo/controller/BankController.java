package com.example.demo.controller;
import com.example.demo.dto.AccountCreateDTO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.model.Account;
import com.example.demo.service.BankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/atm")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/create")
    public String createForm() {
        return "createAccount";
    }

    @PostMapping("/create")
    public String createAccount(@ModelAttribute AccountCreateDTO dto, Model model) {
        Account account = bankService.createAccount(dto);
        model.addAttribute("account", account);
        return "accountCreated";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO dto, Model model) {
        Account account = bankService.login(dto);
        model.addAttribute("account", account);
        return "accountDashboard";
    }

    @GetMapping("/deposit")
    public String depositForm() {
        return "deposit";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam String accountNo, @RequestParam Long amount, Model model) {
        Account account = bankService.deposit(accountNo, amount);
        model.addAttribute("account", account);
        return "transactionSuccess";
    }

    @GetMapping("/withdraw")
    public String withdrawForm() {
        return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam String accountNo, @RequestParam Long amount, Model model) {
        Account account = bankService.withdraw(accountNo, amount);
        model.addAttribute("account", account);
        return "transactionSuccess";
    }

    @GetMapping("/transfer")
    public String transferForm() {
        return "transfer";
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam String fromAccNo, @RequestParam String toAccNo, @RequestParam Long amount, Model model) {
        bankService.transfer(fromAccNo, toAccNo, amount);
        model.addAttribute("message", "Transfer successful!");
        return "transactionSuccess";
    }
}
