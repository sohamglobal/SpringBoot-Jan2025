package com.sohamglobal.jpabankadmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sohamglobal.jpabankadmin.entities.Account;
import com.sohamglobal.jpabankadmin.services.AccountServices;


@Controller
public class BankAdminController {
	
	@Autowired
	AccountServices accServices;
		
	@GetMapping("/")
	public String homePage()
	{
		return "index.jsp";
	}
	
	@GetMapping("/newacc")
	public String newAccount()
	{
		return "NewAccount.jsp";
	}
	
	@PostMapping("/addacc")
	public String addAccount(Account obj,Model m)
	{
		String status=accServices.insertNewAccount(obj);
		m.addAttribute("status", status);
		return "TransactionStatus.jsp";
	}
	
	@GetMapping("/accrepo")
	public String accReport(Model m)
	{
		List<Account> acclist=accServices.getAllAccounts();
		m.addAttribute("list", acclist);
		return "AccountReport.jsp";
	}
	
	@PostMapping("/searchaccno")
	public String searchResult(int accno,Model m)
	{
		//select * from accounts where accno=1234;
		Account obj=accServices.searchAccountData(accno);
		m.addAttribute("acc", obj);
		return "SearchAccResult.jsp";
	}
	
	@GetMapping("/deposit")
	public String deposit()
	{
		return "DepositForm.jsp";
	}
	
	@PostMapping("/acctransact")
	public String accTransact(int accno,float amount,String trtype,Model m)
	{
		String status=accServices.updateAccount(accno, amount,trtype);
		m.addAttribute("status", status);
		return "TransactionStatus.jsp";
	}
	@GetMapping("/withdraw")
	public String withdraw()
	{
		
		return "WithdrawForm.jsp";
	}

	@GetMapping("/transfer")
	public String transfer()
	{
		
		return "TransferForm.jsp";
	}
	
	@PostMapping("/transferamount")
	public String transferAmount(int fromaccount,int toaccount,float amount,String purpose,Model m)
	{
		String status="";
		status=accServices.fundsTransfer(fromaccount, toaccount, amount, purpose);
		m.addAttribute("status", status);
		return "TransactionStatus.jsp";
	}
	
	@GetMapping("/close")
	public String closeAcc()
	{
		
		return "CloseAccountForm.jsp";
	}
	
	@PostMapping("/delacc")
	public String delAccount(int accno,Model m)
	{
		String status="";
		status=accServices.deleteAccount(accno);
		m.addAttribute("status", status);
		return "TransactionStatus.jsp";
	}
	
	@GetMapping("/deduct")
	public String deduct()
	{
		return "DeductForm.jsp";
	}
	
	@PostMapping("/dedamt")
	public String dedAmount(String type,float amount,Model m)
	{
		String status=accServices.deductAmount(type, amount);		
		m.addAttribute("status", status);
		return "TransactionStatus.jsp";
	}
}
