package service.account;

import model.account.IAccount;

public interface IAccountService {
	public IAccount getByEmail(String email);
	public void addAccount(IAccount acc);
	public boolean checkPassword(IAccount acc, String pass);
}
