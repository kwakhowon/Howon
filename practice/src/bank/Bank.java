package bank;

import java.util.ArrayList;
import java.util.Iterator;

public class Bank {

	private int totalAccount;
	private ArrayList<Account> accounts;

	public Bank() {
		accounts = new ArrayList<Account>();
		totalAccount = 0;
	}
	public void addAccount(String accountNo, String name) {
		accounts.add(new Account(accountNo, name));
		System.out.println("계좌 생성 : 계좌번호 = " + accountNo + " 이름 : " + name);
		totalAccount++;
	}

	public Account getAccount(String accountNo) {
		Iterator<Account> accIterator = accounts.iterator();
		Account account = null;

		while (accIterator.hasNext()) {
			Account nextAccount = accIterator.next();
			if (accountNo.equals(nextAccount.getAccountno())) {
				account = nextAccount;
			}
		}
		if (account == null) {
			System.out.println("계좌가 존재하지 않습니다.");
		} else {
			System.out.println("일치하는 계좌");
			System.out.println(account);
		}

		return account;
	}

	public ArrayList<Account> findAccounts(String name) {
		Iterator<Account> accIterator = accounts.iterator();
		ArrayList<Account> acclist = new ArrayList<Account>();

		while (accIterator.hasNext()) {
			Account nextAccount = accIterator.next();
			if (name.equals(nextAccount.getName())) {
				acclist.add(nextAccount);
			}
		}

		if (acclist.size() == 0) {
			System.out.println("계좌가 존재하지 않습니다.");
		} else {
			// System.out.println("일치하는 계좌\n" + acclist.toString());
		}

		return acclist;
	}


	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public int getTotalAccount() {
		System.out.println("총 계좌 수 : " + totalAccount);
		return totalAccount;
	}

}
