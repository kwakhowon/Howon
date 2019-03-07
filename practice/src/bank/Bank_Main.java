package bank;

public class Bank_Main {
	public static void main(String[] args) {
		Bank bank = new Bank();
		Account kwak = new Account("1111", "곽호원");
		bank.addAccount("1111", "곽호원");
		bank.addAccount("2222", "정규현");
		bank.findAccounts("곽호원");
		kwak.deposit(1000);
		kwak.getBalance();
		bank.getTotalAccount();
		bank.findAccounts("곽호원");
		kwak.getTransactions();
	}
}
