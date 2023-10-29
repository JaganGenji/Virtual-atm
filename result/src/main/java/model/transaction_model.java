package model;

public class transaction_model {
	/*create table Transcation (Account_no varchar2(50) not null,Name varchar2(50),
	 * ammount Integer not null,Status varchar2(6),Balance integer,Date_Time TIMESTAMP)*/
	private String Account_no;
	private String Name;
	private Integer ammount;
	private String Status;
	private Integer Balance;
	private String Date_Time;
	public String getAccount_no() {
		return Account_no;
	}
	public void setAccount_no(String account_no) {
		Account_no = account_no;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getAmmount() {
		return ammount;
	}
	public void setAmmount(Integer ammount) {
		this.ammount = ammount;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Integer getBalance() {
		return Balance;
	}
	public void setBalance(Integer balance) {
		Balance = balance;
	}
	public String getDate_Time() {
		return Date_Time;
	}
	public void setDate_Time(String date_Time) {
		Date_Time = date_Time;
	}
	@Override
	public String toString() {
		return "transaction_model [Account_no=" + Account_no + ", Name=" + Name + ", ammount=" + ammount + ", Status="
				+ Status + ", Balance=" + Balance + ", Date_Time=" + Date_Time + "]";
	}
	public transaction_model(String account_no, String name, Integer ammount, String status, Integer balance,
			String date_Time) {
		super();
		Account_no = account_no;
		Name = name;
		this.ammount = ammount;
		Status = status;
		Balance = balance;
		Date_Time = date_Time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Account_no == null) ? 0 : Account_no.hashCode());
		result = prime * result + ((Balance == null) ? 0 : Balance.hashCode());
		result = prime * result + ((Date_Time == null) ? 0 : Date_Time.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Status == null) ? 0 : Status.hashCode());
		result = prime * result + ((ammount == null) ? 0 : ammount.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		transaction_model other = (transaction_model) obj;
		if (Account_no == null) {
			if (other.Account_no != null)
				return false;
		} else if (!Account_no.equals(other.Account_no))
			return false;
		if (Balance == null) {
			if (other.Balance != null)
				return false;
		} else if (!Balance.equals(other.Balance))
			return false;
		if (Date_Time == null) {
			if (other.Date_Time != null)
				return false;
		} else if (!Date_Time.equals(other.Date_Time))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Status == null) {
			if (other.Status != null)
				return false;
		} else if (!Status.equals(other.Status))
			return false;
		if (ammount == null) {
			if (other.ammount != null)
				return false;
		} else if (!ammount.equals(other.ammount))
			return false;
		return true;
	}
	
	

}
