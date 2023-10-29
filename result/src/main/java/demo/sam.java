package demo;

import java.util.List;

import model.transaction_model;
import moelimplimetaton.interaceimplimentation;

public class sam {
	public static void main(String[] args) {
		/*
		 * interaceimplimentation i1 = new interaceimplimentation();
		 * 
		 * boolean res1=i.loginvalidation("JAGAN MOHAN GENJI", "123456");
		 * System.out.println("res1========="+res1);
		 * 
		 * int res=i.Balance("JAGAN MOHAN GENJI", "12345678");
		 * System.out.println("balance==="+res);
		 * 
		 * int r=i.Deposite("JAGAN MOHAN GENJI", "12345678", 100);
		 * System.out.println("deposite res===="+r);
		 * 
		 * String Acc = i1.Accountno("JAGAN MOHAN GENJI", "123456");
		 * System.out.println("account no===" + Acc); List<transaction_model> result =
		 * i1.ministatement("456321"); for (transaction_model i : result) {
		 * System.out.println(i.getAccount_no() + "\t" + i.getName() + "\t" +
		 * i.getAmmount() + "\t" + i.getStatus() + "\t" + i.getBalance() + "\t" +
		 * i.getDate_Time()); }
		 */
		 interaceimplimentation i1 = new interaceimplimentation();
		System.out.println( i1.Transfor("12345", "nvmb", 480));
		System.out.println(i1.AccountCheck("nvmb"));
	}

}
