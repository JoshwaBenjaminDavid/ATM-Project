package org.atm.project;

import java.sql.*;

public class ATMDAO {
	public ATMpojo getdata(int accno) throws Exception {
		ATMpojo a =null;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/atmproject";
		String user = "root";
		String pass = "160799";
		String query = "select * from customerdetails where accno="+accno;
		Connection c = DriverManager.getConnection(url, user, pass);
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery(query);
		if (r.next()) {
			int i= r.getInt(1);
			String name = r.getString(2);
			int pin = r.getInt(3);
			int balance = r.getInt(4);
			a = new ATMpojo(i, name, pin, balance);
		}
		return a;
		}
	public int updatedata(int accno, int balance) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/atmproject";
		String user = "root";
		String pass = "160799";
		String query = "update customerdetails set balance=? where accno=?";
		Connection c = DriverManager.getConnection(url, user, pass);
		PreparedStatement p = c.prepareStatement(query);
		p.setInt(1, balance);p.setInt(2, accno);
		int r = p.executeUpdate();
		return r;
		
	}
}
