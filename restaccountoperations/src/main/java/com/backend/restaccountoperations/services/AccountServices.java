package com.backend.restaccountoperations.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.restaccountoperations.entities.Account;
import com.backend.restaccountoperations.repositories.AccountRepository;

@Service
public class AccountServices {
	
	@Autowired
	private AccountRepository accRepo;
	
	public Account searchOnAccno(int accno)
	{
		Account obj=accRepo.findByAccno(accno);
		return obj;
	}
	
	public List<Account> searchOnAcctype(String acctype)
	{
		List<Account> list=accRepo.findByAcctype(acctype);
		return list;
	}
	
	public List<Account> getAllAccountsData()
	{
		return accRepo.findAll();
	}
	
	public Account addNewAccount(Account obj)
	{
		return accRepo.save(obj);
	}
	
	public Account depositToAccount(int accno,float amount)
	{
		Account obj=accRepo.findByAccno(accno);
		obj.setBalance(obj.getBalance()+amount);
		accRepo.save(obj);
		return obj;
	}

	public Account withdrawFromAccount(int accno,float amount)
	{
		Account obj=accRepo.findByAccno(accno);
		obj.setBalance(obj.getBalance()-amount);
		accRepo.save(obj);
		return obj;
	}
	
	public String deleteAccount(int accno)
	{
		String status="";
		Account obj=accRepo.findByAccno(accno);
		if(obj!=null)
		{
			accRepo.delete(obj);
			status="success";
		}
		else
			status="failed";
		
		return status;
	}
}
