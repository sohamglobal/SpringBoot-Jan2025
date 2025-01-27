package com.sohamglobal.jpabankadmin.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sohamglobal.jpabankadmin.entities.Account;
import com.sohamglobal.jpabankadmin.repositories.AccountRepository;

@Service
public class AccountServices {
	
	@Autowired
	AccountRepository accRepo;
	
	public String insertNewAccount(Account obj)
	{
		String status="";
		try
		{
			accRepo.save(obj);
			status="success";
		}
		catch(Exception e)
		{
			status="failed";
			System.out.println(e);
		}
		return status;
	}
	
	public List<Account> getAllAccounts()
	{
		List<Account> lst=accRepo.findAll();
		//List<Account> lst=accRepo.findByAcctype("ppf");
		return lst;
	}
	
	public Account searchAccountData(int accno)
	{
		Account obj=accRepo.findByAccno(accno);
		//Account obj=accRepo.findByAccnm("joe root");
		if(obj==null)
		{
			obj=new Account();
			obj.setAccno(accno);
			obj.setAccnm("Not found");
			obj.setAcctype("Not found");
			obj.setBalance(0);
			
		}
		return obj;
	}
	
	public String updateAccount(int accno,float amount,String trtype)
	{
		String status="";
		Account obj=accRepo.findByAccno(accno);
		if(trtype.equals("deposit"))
			obj.setBalance(obj.getBalance()+amount);
		else
			obj.setBalance(obj.getBalance()-amount);
		accRepo.save(obj);
		status="success";
		return status;
	}
	
	public String fundsTransfer(int fno,int tno,float amt,String det)
	{
		String status="";
		try
		{
			accRepo.transferMoneyBetweenAccounts(fno, tno, amt, det);
			status="success";
		}
		catch(Exception e)
		{
			System.out.println(e);
			status="failed";
		}
		return status;
	}
	
	public String deleteAccount(int accno)
	{
		String status="";
		Account obj=accRepo.findByAccno(accno);
		if(obj!=null)
		{
		System.out.println(obj.getAccnm());
		accRepo.delete(obj);
		status="success";
		}
		else
			status="failed";
		return status;
	}
	
	public String deductAmount(String type,float amount)
	{
		accRepo.deductAmountFromAccounts(type, amount);
		return "success";
	}
}
