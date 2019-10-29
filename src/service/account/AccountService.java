package service.account;

import java.util.ArrayList;

import model.account.IAccount;

public class AccountService implements IAccountService {
	ArrayList<IAccount> m_accounts;

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
		return acc.getHash().equals(pass);
	}

}
