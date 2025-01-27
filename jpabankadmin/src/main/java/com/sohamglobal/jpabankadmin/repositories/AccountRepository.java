package com.sohamglobal.jpabankadmin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sohamglobal.jpabankadmin.entities.Account;



@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	Account findByAccno(int accno);
	List<Account> findByAcctype(String acctype);
	Account findByAccnm(String accnm);

	@Modifying
	@Transactional
	@Query("Update Account a set a.balance=a.balance- :amount where a.acctype= :type")
	void deductAmountFromAccounts(String type,float amount);
	
	@Modifying
	@Transactional
	@Query(value="Call transfer(:fno, :tno, :amt, :det)",nativeQuery = true)
	void transferMoneyBetweenAccounts(int fno,int tno,float amt,String det);
	
}
