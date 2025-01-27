package com.backend.restaccountoperations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.restaccountoperations.entities.Account;
import com.backend.restaccountoperations.entities.Employee;
import com.backend.restaccountoperations.services.AccountServices;
import com.backend.restaccountoperations.services.EmployeeServices;

@RestController
@RequestMapping("/api")
public class AccountOperationController {
	
	@Autowired
	private AccountServices accServices;
	
	@Autowired
	private EmployeeServices empServices;
	
	// we will have to type - http://localhost:8080/api/test
	@GetMapping("/test")
	public String test()
	{
		return "rest tested ok";
	}
	
	@GetMapping("/account/single")
	public Account getSingleObject()
	{
		Account obj=new Account();
		obj.setAccno(1071);
		obj.setAccnm("bukayo saka");
		obj.setAcctype("saving");
		obj.setBalance(34000);
		
		return obj;
	}
	
	@GetMapping("/account/multi")
	public ArrayList<Account> getAccountObjectList()
	{
		ArrayList<Account> list=new ArrayList<Account>();
		Account obj1=new Account();
		obj1.setAccno(1071);
		obj1.setAccnm("bukayo saka");
		obj1.setAcctype("saving");
		obj1.setBalance(34000);
		
		list.add(obj1);
		
		Account obj2=new Account();
		obj2.setAccno(1072);
		obj2.setAccnm("cole palmer");
		obj2.setAcctype("fixed");
		obj2.setBalance(67000);
		list.add(obj2);
		
		return list;
		
	}
	
	@GetMapping("/account/search/{accno}")
	public Account getAccountInfo(@PathVariable int accno)
	{
		Account obj=accServices.searchOnAccno(accno);
		
		return obj;
	}
	
	@GetMapping("/account/search/type/{acctype}")
	public List<Account> getAccountsOnType(@PathVariable String acctype)
	{
		List<Account> list=accServices.searchOnAcctype(acctype);
		return list;
	}
	
	@GetMapping("/account/all")
	public List<Account> getAllAccountsInfo()
	{
		return accServices.getAllAccountsData();
	}
	
	@PostMapping("/account/add")
	public Account addAccount(@RequestBody Account obj)
	{
		return accServices.addNewAccount(obj);
	}
	
	@PutMapping("/account/deposit")
	public Account depositAmount(int accno,float amount)
	{
		Account obj=accServices.depositToAccount(accno, amount);
		return obj;
	}
	
	@PutMapping("/account/withdraw")
	public Account withdrawAmount(int accno,float amount)
	{
		Account obj=accServices.withdrawFromAccount(accno, amount);
		return obj;
	}
	
	@DeleteMapping("/account/close")
	public String closeAccount(int accno)
	{
		String status="";
		status=accServices.deleteAccount(accno);
		
		return status;		
	}
	
	@GetMapping("/emp/all")
	public List<Employee> getAllEmps()
	{
		return empServices.getEmps();
	}

}
