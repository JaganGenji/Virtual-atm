package model;

import java.sql.SQLException;
import java.util.List;

public interface modelinterface {
	public Integer registration(modelelements m);
	public boolean loginvalidation(String name,String password);
	//public Integer balance(String name,String password);//unwanted
	//public String Accountno(String name,String password);//unwanted
	//public Integer  Balance(String name,String Accountno);//unwanted
	public Integer  Debite(String name,String Accountno,Integer money);
	public List<transaction_model> ministatement(String Accountno);
	public Integer PassswordChange(String Account_no,String newpassword) throws SQLException;
	public Integer Deposite(String Account_no,Integer amount,String name);
	public Integer balance(String Accountno);
	public String username(String Accountno);
	public boolean AccountCheck(String Accountno);
	public Integer Transfor(String Accountno,String TranformAccno,Integer money);
	
	
	
	
	

}
