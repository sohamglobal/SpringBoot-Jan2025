package com.netbanking.accountadmin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.netbanking.accountadmin.entities.Account;
import com.netbanking.accountadmin.services.AccountServices;
import com.netbanking.accountadmin.services.UserServices;


import jakarta.servlet.http.HttpSession;

@Controller
public class SohamBankController {
	
	@Autowired
	UserServices us;
	
	@Autowired
	AccountServices accserv;
	
	@GetMapping("/")
	public String index()
	{
		return "index.jsp";
	}
	
	@PostMapping("/login")
	public String login(String userid,String password,HttpSession session)
	{
		String page="";
		System.out.println(userid);
		System.out.println(password);
		session.setAttribute("user", userid);
		
		page=us.authenticate(userid, password);
		return page;
	}
	
	@GetMapping("/newacc")
	public String newAccount()
	{
		return "NewAccountForm.jsp";
	}
	
	@PostMapping("/addacc")
	public String accAccount(Account obj,Model m)
	{
		String status=accserv.addNewAccount(obj);
		m.addAttribute("status", status);		
		return "AccountCreated.jsp";
	}
	
	@PostMapping("/searchaccno")
	public String searchAccno(int accno,Model m)
	{
		Account obj=accserv.searchAccountDataOnAccno(accno);
		m.addAttribute("acc", obj);
		return "SearchResult.jsp";
	}
	
	@GetMapping("/report")
	public String showReport(Model m)
	{
		ArrayList<Account> lst=accserv.getAllAccounts();
		m.addAttribute("acclist", lst);
		return "AccountsReport.jsp";
	}
	
	@GetMapping("/deposit")
	public String deposit()
	{
		return "DepositForm.jsp";
	}
	
	@GetMapping("/withdraw")
	public String withdraw()
	{
		return "WithdrawForm.jsp";
	}
	
	@PostMapping("/acctransact")
	public String accTransact(int accno,float amount,String trtype,Model m)
	{
		String status=accserv.accountTransaction(accno, amount, trtype);
		m.addAttribute("status", status);
		m.addAttribute("type", trtype.toUpperCase());
		return "TransactionStatus.jsp";
	}
	
	@GetMapping("/transfer")
	public String transfer()
	{
		return "TransferForm.jsp";
	}
	
	@PostMapping("/transferamount")
	public String transferAmount(int fromaccount,int toaccount,float amount,String purpose,Model m)
	{
		String status=accserv.transferFund(fromaccount, toaccount, amount, purpose);
		m.addAttribute("status", status);
		m.addAttribute("type", "Transfer");
		return "TransactionStatus.jsp";
	}
	
	@GetMapping("/delete")
	public String closeAccount()
	{
		return "CloseAccount.jsp";
	}
	
	@PostMapping("/delacc")
	public String delete(int accno,Model m)
	{
		String status=accserv.deleteAccount(accno);
		m.addAttribute("status", status);
		m.addAttribute("type", "Delete");
		return "TransactionStatus.jsp";
	}
	
	@GetMapping("/adminhome")
	public String adminHome()
	{
		return "BankAdmin.jsp";
	}
	
	@GetMapping("/acctypes")
	public String accTypes()
	{
		return "AccountTypes.jsp";
	}

}
