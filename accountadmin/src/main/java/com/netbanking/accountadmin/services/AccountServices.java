package com.netbanking.accountadmin.services;

import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.ArrayList;

import com.netbanking.accountadmin.entities.Account;

@Service
public class AccountServices {
	
	public String addNewAccount(Account obj)
	{
		String status="";
		Connection con;
		PreparedStatement pst;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://mysql-java-javaee-project.c.aivencloud.com:19179/sharayudb?user=avnadmin&password=AVNS_TEZ17S2CIEzgqRcBnb0");
			pst=con.prepareStatement("insert into accounts values(?,?,?,?)");
			pst.setInt(1, obj.getAccno());
			pst.setString(2, obj.getAccnm());
			pst.setString(3, obj.getAcctype());
			pst.setFloat(4, obj.getBalance());
			pst.executeUpdate();
			con.close();
			status="success";
		}
		catch(Exception e)
		{
			status="failed";
			System.out.println(e);
		}
		
		return status;
	}
	
	public Account searchAccountDataOnAccno(int accno)
	{
		Account obj=new Account();
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://mysql-java-javaee-project.c.aivencloud.com:19179/sharayudb?user=avnadmin&password=AVNS_TEZ17S2CIEzgqRcBnb0");
			pst=con.prepareStatement("select * from accounts where accno=?");
			pst.setInt(1, accno);
			rs=pst.executeQuery();
			if(rs.next())
			{
				obj.setAccno(accno);
				obj.setAccnm(rs.getString("accnm"));
				obj.setAcctype(rs.getString("acctype"));
				obj.setBalance(rs.getFloat("balance"));
			}
			else
			{
				obj.setAccno(accno);
				obj.setAccnm("Not found");
				obj.setAcctype("Not found");
				obj.setBalance(0);
			}
			con.close();
		}
		catch(Exception e)
		{
			obj.setAccno(accno);
			obj.setAccnm("Error");
			obj.setAcctype("Error");
			obj.setBalance(0);
		}
		
		return obj;
	}
	
	public ArrayList<Account> getAllAccounts()
	{
		ArrayList<Account> lst=new ArrayList<>();
		Connection con;
		Statement st;
		ResultSet rs;
		Account obj;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://mysql-java-javaee-project.c.aivencloud.com:19179/sharayudb?user=avnadmin&password=AVNS_TEZ17S2CIEzgqRcBnb0");
			st=con.createStatement();
			rs=st.executeQuery("select * from accounts");
			
			while(rs.next())
			{
				obj=new Account();
				obj.setAccno(rs.getInt("accno"));
				obj.setAccnm(rs.getString("accnm"));
				obj.setAcctype(rs.getString("acctype"));
				obj.setBalance(rs.getFloat("balance"));
				lst.add(obj);
			}
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return lst;
		
	}
	
	public String accountTransaction(int accno,float amount,String trtype)
	{
		Connection con;
		PreparedStatement pst;
		String status="";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://mysql-java-javaee-project.c.aivencloud.com:19179/sharayudb?user=avnadmin&password=AVNS_TEZ17S2CIEzgqRcBnb0");
			if(trtype.equals("deposit"))
				pst=con.prepareStatement("update accounts set balance=balance+? where accno=?");
			else
				pst=con.prepareStatement("update accounts set balance=balance-? where accno=?");
			
			pst.setFloat(1, amount);
			pst.setInt(2, accno);
			
			int cnt=pst.executeUpdate();
			if(cnt>0)
				status="success";
			else
				status="failed";
			con.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			status="error";
		}
		
		return status;
	}
	
	public String transferFund(int fno,int tno,float amt,String pps)
	{
		String status="";
		Connection con;
		CallableStatement cst;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://mysql-java-javaee-project.c.aivencloud.com:19179/sharayudb?user=avnadmin&password=AVNS_TEZ17S2CIEzgqRcBnb0");
			cst=con.prepareCall("{call transfer(?,?,?,?)}");
			cst.setInt(1, fno);
			cst.setInt(2, tno);
			cst.setFloat(3, amt);
			cst.setString(4, pps);
			cst.execute();
			con.close();
			status="success";
		}
		catch(Exception e)
		{
			status="error";
		}
		return status;
	}
	
	public String deleteAccount(int accno)
	{
		Connection con;
		PreparedStatement pst;
		String status="";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://mysql-java-javaee-project.c.aivencloud.com:19179/sharayudb?user=avnadmin&password=AVNS_TEZ17S2CIEzgqRcBnb0");
			pst=con.prepareStatement("delete from accounts where accno=?");
			pst.setInt(1, accno);
			int cnt=pst.executeUpdate();
			if(cnt==1)
				status="success";
			else
				status="failed";
			con.close();
		}
		catch(Exception e)
		{
			status="error";
		}
		return status;
	}

}
