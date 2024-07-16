package gr.aueb.cf.controller;

import gr.aueb.cf.dto.AccountDto;
import gr.aueb.cf.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accounts")
public class AccountViewController {

    private final AccountService accountService;

    public AccountViewController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public String showWelcomePage() {
        return "welcome";
    }

    @GetMapping("/add")
    public String showAddAccountForm(Model model) {
        model.addAttribute("account", new AccountDto());
        return "add_account";
    }

    @PostMapping("/add")
    public String addAccount(@ModelAttribute AccountDto accountDto) {
        accountService.createAccount(accountDto);
        return "redirect:/accounts"; // Redirects to the list of all accounts
    }

    @GetMapping("")
    public String showAllAccounts(Model model) {
        model.addAttribute("accounts", accountService.getAllAccounts());
        return "all_accounts";
    }

    @GetMapping("/{id}")
    public String showAccountDetails(@PathVariable Long id, Model model) {
        AccountDto accountDto = accountService.getAccountById(id);
        model.addAttribute("account", accountDto);
        return "account_details";
    }

    @GetMapping("/{id}/deposit")
    public String showDepositForm(@PathVariable Long id, Model model) {
        AccountDto accountDto = accountService.getAccountById(id);
        model.addAttribute("account", accountDto);
        return "deposit";
    }

    @PostMapping("/{id}/deposit")
    public String deposit(@PathVariable Long id, @RequestParam Double amount) {
        accountService.deposit(id, amount);
        return "redirect:/accounts/" + id; // Redirects to the account details page
    }

    @GetMapping("/{id}/withdraw")
    public String showWithdrawForm(@PathVariable Long id, Model model) {
        AccountDto accountDto = accountService.getAccountById(id);
        model.addAttribute("account", accountDto);
        return "withdraw";
    }

    @PostMapping("/{id}/withdraw")
    public String withdraw(@PathVariable Long id, @RequestParam Double amount) {
        accountService.withdraw(id, amount);
        return "redirect:/accounts/" + id; // Redirects to the account details page
    }

    @GetMapping("/{id}/delete")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        AccountDto accountDto = accountService.getAccountById(id);
        model.addAttribute("account", accountDto);
        return "delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return "redirect:/accounts"; // Redirects to the list of all accounts
    }
}




