package model.account;

import model.Address;

public interface IAccount {
	void setID(int id);
	void setType(AccountType type);
	void setEmail(String email);
	void setUsername(String username);
	void setPassword(String password);
	
	int getID();
	AccountType getType();
	String getEmail();
	String getUsername();
	String getHash();
}
