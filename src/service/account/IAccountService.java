package service.account;

import model.account.IAccount;

public interface IAccountService {
	public IAccount getByEmail(String email);
	public IAccount getByID(int Id);
	public void addAccount(IAccount acc);
	public boolean checkPassword(IAccount acc, String pass);
	public void print();
}
