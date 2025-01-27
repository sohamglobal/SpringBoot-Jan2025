package com.netbanking.accountadmin.services;

import org.springframework.stereotype.Service;
import java.sql.*;

@Service
public class UserServices {
	public String authenticate(String uid,String psw)
	{
		String status="";
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://mysql-java-javaee-project.c.aivencloud.com:19179/sharayudb?user=avnadmin&password=AVNS_ethan913");
			pst=con.prepareStatement("select * from bankadmin where userid=? and pswd=?");
			pst.setString(1, uid);
			pst.setString(2, psw);
			rs=pst.executeQuery();
			if(rs.next())
				status="BankAdmin.jsp";
			else
				status="Failure.jsp";
			con.close();
		}
		catch(Exception e)
		{
			status="Error.jsp";
		}
		return status;
	}

}
