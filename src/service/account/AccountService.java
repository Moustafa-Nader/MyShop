package service.account;

import java.awt.*;
import java.util.ArrayList;

import model.account.Account;
import model.account.AccountType;
import model.account.IAccount;
import service.IAggregate;

public class AccountService implements IAccountService, IAggregate {
	ArrayList<IAccount> m_accounts;
	public AccountService() {
		m_accounts = new ArrayList<>();
		Account acc = new Account();
		acc.setEmail("Amr+Hassan");
		acc.setPassword("shafrafa");
		acc.setID(0);
		acc.setType(AccountType.OWNER);
		addAccount(acc);
		Account acc1 = new Account();
		acc1.setEmail("u");acc1.setPassword("u");acc1.setID(1);acc1.setType(AccountType.USER);
		addAccount(acc1);
		Account acc2 = new Account();
		acc2.setEmail("a");acc2.setPassword("a");acc2.setID(2);acc2.setType(AccountType.ADMIN);
		addAccount(acc2);
		Account acc3 = new Account();
		acc3.setEmail("s");acc3.setPassword("s");acc3.setID(3);acc3.setType(AccountType.OWNER);
		addAccount(acc3);
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
		acc.setID(m_accounts.size());
		m_accounts.add(acc);
	}

	@Override
	public boolean checkPassword(IAccount acc, String pass) {
		if(acc == null) return false;
		System.out.println("Account Added");
		return acc.getHash().equals(pass);
	}

	@Override
	public void print() {
		for(IAccount acc : m_accounts){
			System.out.println(acc.getEmail());
			System.out.println(acc.getHash());
		}
	}

	@Override
	public int count() {
		return m_accounts.size();
	}

	@Override
	public IAccount getByID(int Id) {
		for(IAccount acc : m_accounts)
		{
			if(acc.getID() == Id)
				return acc;
		}
		return null;
	}
}
