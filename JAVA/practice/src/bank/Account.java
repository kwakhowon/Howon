package bank;

import java.util.ArrayList;

public class Account {
	private String accountno;
	private String name;
	private long balance;
	private ArrayList<Transaction> transactions;
	
	public Account() { }
	public Account(String accountno, String name) {
		this.accountno = accountno;
		this.name = name;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public void deposit(long amount) {
		balance += amount;
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setBalance(this.balance);
		
		System.out.println("입금 금액 : " +amount);
	}
	
	public void withdraw(long amount) {
		if(this.balance<amount) {
			System.out.println("잔액이 부족합니다.");
			return;
		}else {
		this.balance -= amount;
		System.out.println("출금 금액 : " +amount);
		}
	}
	
	public long getBalance() {
		System.out.println("현재 잔액 : " +this.balance);
		return this.balance;
		
	}
	
	public ArrayList<Transaction> getTransactions() {
		ArrayList<Transaction> transaction = null;
		
		for(int i=0; i<transactions.size(); i++) {
			System.out.println(transactions.toString());
		}
		return transactions;
	}

}
