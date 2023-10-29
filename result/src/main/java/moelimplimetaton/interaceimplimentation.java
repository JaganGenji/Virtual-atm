package moelimplimetaton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.JdbcConnection;
import model.modelelements;
import model.modelinterface;
import model.transaction_model;

public class interaceimplimentation implements modelinterface {

	@Override
	public Integer registration(modelelements m) {
		int result = 0;
		int result1 = 0;
		int return_value = 0;
		int no_of_rows = 0;
		Connection con = JdbcConnection.getconnection();

		try {
			PreparedStatement psmt = con.prepareStatement("insert into registration values(?,?,?,?,?,?,?,?)");
			psmt.setString(1, m.getName());
			psmt.setString(2, m.getAccountno());
			psmt.setString(3, m.getMobileno());
			psmt.setString(4, m.getEmail());
			psmt.setString(5, m.getGender());
			psmt.setString(6, m.getPassword());
			psmt.setString(7, m.getDate());
			psmt.setString(8, m.getAddress());
			PreparedStatement psmt1 = con.prepareStatement("insert into account values(?,?,?,?,?)");
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM account");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				no_of_rows = rs.getInt(1);
			}
			psmt1.setInt(1, no_of_rows);
			psmt1.setString(2, m.getName());
			psmt1.setString(3, m.getAccountno());
			psmt1.setString(4, m.getPassword());
			psmt1.setInt(5, 0);

			result = psmt.executeUpdate();
			result1 = psmt1.executeUpdate();
			if (result == result1) {
				return_value = result;
			} else {
				return_value = 0;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public boolean loginvalidation(String name, String password) {
		Connection con = JdbcConnection.getconnection();
		boolean output = true;
		try {
			PreparedStatement psmt = con.prepareStatement(
					"select * from registration where ACCOUNTNO='" + name + "'and password='" + password + "'");
			ResultSet res = psmt.executeQuery();

			if (res.next()) {
				output = true;
			} else {
				output = false;
			}
			System.out.println("loginvalidation===" + output);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}

	
	/*
	 * public Integer balance(String name, String password) { // TODO Auto-generated
	 * method stub Connection con = JdbcConnection.getconnection(); Integer result =
	 * 0; try { PreparedStatement psmt = con.prepareStatement(
	 * "select money from account where Name ='" + name + "'and password='" +
	 * password + "'"); ResultSet res = psmt.executeQuery(); if (res.next()) {
	 * result = res.getInt(1); } } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } return result; }
	 */
	/*
	 * @Override public Integer Balance(String name, String Accountno) { // TODO
	 * Auto-generated method stub Connection con = JdbcConnection.getconnection();
	 * Integer result = 0; try { PreparedStatement psmt = con.prepareStatement(
	 * "Select money from account where name='" + name + "'and Accountno='" +
	 * Accountno + "'"); ResultSet res = psmt.executeQuery(); if (res.next()) {
	 * result = res.getInt(1); } } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } return result; }
	 */

	@Override
	public Integer Debite(String name, String Accountno, Integer money) {
		// TODO Auto-generated method stub
		int amount = balance(Accountno);
		String status = "Debit";
		int result = 0;

		Connection con = JdbcConnection.getconnection();
		if (amount >= money) {
			int presentammout = amount - money;

			try {

				PreparedStatement psmt = con.prepareStatement("update account set money='" + presentammout
						+ "' where name='" + name + "'and Accountno='" + Accountno + "' ");
				result = psmt.executeUpdate();
				PreparedStatement psm = con.prepareStatement("insert into Transcation values(?,?,?,?,?,SYSTIMESTAMP )");
				psm.setString(1, Accountno);
				psm.setString(2, name);
				psm.setInt(3, money);
				psm.setString(4, status);
				psm.setInt(5, presentammout);
				psm.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			result = -1;
		}

		return result;
	}

	//@Override
	/*
	 * public String Accountno(String name, String password) { Connection con =
	 * JdbcConnection.getconnection(); String Accno = null; try { PreparedStatement
	 * psmt = con.prepareStatement( "select ACCOUNTNO from account where Name ='" +
	 * name + "'and password='" + password + "'"); ResultSet res =
	 * psmt.executeQuery(); if (res.next()) { Accno = res.getString(1); } } catch
	 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * return Accno; }
	 */

	@Override
	public List<transaction_model> ministatement(String Accountno) {
		List<transaction_model> result = new ArrayList<transaction_model>();
		Connection con = JdbcConnection.getconnection();
		PreparedStatement psmt;
		try {
			psmt = con.prepareStatement(
					"select * from transcation where Account_no='" + Accountno + "' and ROWNUM <= 10");
			ResultSet res = psmt.executeQuery();
			while (res.next()) {
				transaction_model tmodel = new transaction_model(res.getString(1), res.getString(2), res.getInt(3),
						res.getString(4), res.getInt(5), res.getString(6));
				result.add(tmodel);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public Integer PassswordChange(String Account_no, String newpassword) throws SQLException {
		Connection con = JdbcConnection.getconnection();
		int finalres = 0;
		PreparedStatement psmt = con.prepareStatement(
				"update registration set password ='" + newpassword + "' where Accountno ='" + Account_no + "'");
		int regreault = psmt.executeUpdate();
		System.out.println(" update registration===" + regreault);
		PreparedStatement psm = con.prepareStatement(
				"update account set password ='" + newpassword + "' where Accountno  ='" + Account_no + "'");
		int accountreault = psm.executeUpdate();
		System.out.println("acco===" + accountreault + " ac_no" + Account_no);
		if (regreault == accountreault && regreault == 1) {
			finalres = 1;
		} else {
			finalres = 0;
		}

		// TODO Auto-generated method stub
		return finalres;
	}

	@Override
	public Integer Deposite(String Account_no, Integer amount, String name) {

		int balance = balance(Account_no);
		String status = "credit";
		int result = 0;

		Connection con = JdbcConnection.getconnection();
		int presentammout = amount + balance;

		try {

			PreparedStatement psmt = con.prepareStatement("update account set money='" + presentammout
					+ "' where name='" + name + "'and Accountno='" + Account_no + "' ");
			result = psmt.executeUpdate();
			PreparedStatement psm = con.prepareStatement("insert into Transcation values(?,?,?,?,?,SYSTIMESTAMP )");
			psm.setString(1, Account_no);
			psm.setString(2, name);
			psm.setInt(3, amount);
			psm.setString(4, status);
			psm.setInt(5, presentammout);
			int t = psm.executeUpdate();
			System.out.println("result in transcation==" + t);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		// TODO Auto-generated method stub
		return result;
	}

	public boolean AccountpresentOrNOt(Integer Accountno) {
		boolean result = false;
		Connection con = JdbcConnection.getconnection();
		try {
			PreparedStatement psmt = con
					.prepareStatement("select * from registration where Accountno='" + Accountno + "'");
			ResultSet res = psmt.executeQuery();
			if (res.next()) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public Integer balance(String Accountno) {
		Connection con = JdbcConnection.getconnection();
		Integer result = 0;
		try {
			PreparedStatement psmt = con.prepareStatement(
					"Select money from account where Accountno='" + Accountno + "'");
			ResultSet res = psmt.executeQuery();
			if (res.next()) {
				result = res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String username(String Accountno) {
		Connection con = JdbcConnection.getconnection();
		String usernam = null;
		try {
			PreparedStatement psmt = con.prepareStatement(
					"select name from registration where ACCOUNTNO='"+Accountno+"'");
			ResultSet res = psmt.executeQuery();
			if (res.next()) {
				usernam = res.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usernam;
	}

	@Override
	public boolean AccountCheck(String Accountno) {
		boolean Account_STATUS=false;
		Connection con=JdbcConnection.getconnection();
		try {
			PreparedStatement psmt=con.prepareStatement("select * from registration where ACCOUNTNO='"+Accountno+"'");
			ResultSet res=psmt.executeQuery();
			if(res.next())
			{
				Account_STATUS=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Account_STATUS;
	}

	@Override
	public Integer Transfor(String Accountno, String TranformAccno, Integer money) {
		// TODO Auto-generated method stub
		boolean TranformAccountStatus=AccountCheck(TranformAccno);
		int res=0;
		System.out.println("Ststus=="+TranformAccountStatus);
		Integer Money_TransformAccount=balance(TranformAccno);
		System.out.println("moneytran"+Money_TransformAccount);
		Integer money_presentAcc=balance(Accountno);
		System.out.println("moneypre=="+money_presentAcc);
		if(money_presentAcc>=money && TranformAccountStatus==true)
		{
			
			Connection con=JdbcConnection.getconnection();
			try {
				PreparedStatement smt=con.prepareStatement("update account set money='"+( Money_TransformAccount+money)+"'where Accountno='"+TranformAccno+"'");
				res=smt.executeUpdate();
				System.out.println("res== in =="+res);
				PreparedStatement psmt=con.prepareStatement("update account set money='"+(money_presentAcc-money)+"'where Accountno='"+Accountno+"'");
				
				psmt.executeUpdate();
				PreparedStatement psm = con.prepareStatement("insert into Transcation values(?,?,?,?,?,SYSTIMESTAMP )");
				psm.setString(1, TranformAccno);
				psm.setString(2, username(TranformAccno));
				psm.setInt(3, money);
				psm.setString(4, "credit");
				psm.setInt(5, balance(TranformAccno));
				psm.executeUpdate();
				///------------------------------------------------------------------
				PreparedStatement psm1 = con.prepareStatement("insert into Transcation values(?,?,?,?,?,SYSTIMESTAMP )");
				psm1.setString(1, Accountno);
				psm1.setString(2, username(Accountno));
				psm1.setInt(3, money);
				psm1.setString(4, "credit");
				psm1.setInt(5, balance(Accountno));
				psm1.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return res;
	}

	

}
