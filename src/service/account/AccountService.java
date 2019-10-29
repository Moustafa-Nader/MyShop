package service.account;

import java.util.ArrayList;

import model.account.Account;
import model.account.IAccount;

public class AccountService implements IAccountService {
	ArrayList<IAccount> m_accounts;
	public AccountService() {
		m_accounts = new ArrayList<>();
		Account acc = new Account();
		acc.setEmail("Amr+Hassan");
		acc.setPassword("shafrafa");
		addAccount(acc);
	}

	@Override
	public IAccount getByEmail(String email) {
		for(IAccount acc : m_accounts)
		{
			if(acc.getEmail().equals(email))
				return acc;
		}
		return null;
	}

	@Override
	public void addAccount(IAccount acc) {
		m_accounts.add(acc);
	}

	@Override
	public boolean checkPassword(IAccount acc, String pass) {
		if(acc == null) return false;
		return acc.getHash().equals(pass);
	}

}
