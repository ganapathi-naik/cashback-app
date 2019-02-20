package com.gnaik.tools.cashback.app.resource;

import com.gnaik.tools.cashback.app.documents.Account;
import com.gnaik.tools.cashback.app.repository.AccountRepository;
import com.gnaik.tools.cashback.app.service.SequenceGeneratorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/account")
public class AccountResource {

    private final AccountRepository accountRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    public AccountResource(AccountRepository accountRepository, SequenceGeneratorService sequenceGeneratorService) {
        this.accountRepository = accountRepository;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Account getAccount(@PathVariable Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @GetMapping("/register")
    public String addAccount(Model model) {
        model.addAttribute("title", "G-shop Create Account");
        return "signup";
    }

    @PostMapping("/register")
    public void addAccount(HttpServletRequest request) {
        char gender = request.getParameter("gender").charAt(0);
        Date dob = new Date(request.getParameter("dob"));
        String mobileNumber = request.getParameter("mobileNumber");
        String password = request.getParameter("password");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String email = request.getParameter("email");
        Account account = new Account(sequenceGeneratorService.generateSequence(Account.SEQUENCE_NAME),
                email, firstName, lastName, password, mobileNumber, dob, gender);
        accountRepository.save(account);
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "G-Shop Login");
        return "login";
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountRepository.deleteById(id);
    }
}
