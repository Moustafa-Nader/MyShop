package model.account;

import model.Address;

public class Account implements IAccount {
	int m_id;
	AccountType m_type;
	String m_email;
	String m_username;
	String m_hash;


	public Account() {}

	public Account(AccountType type, String email, String username, String hash) {
		this.m_id = 0;
		this.m_email = email;
		this.m_type = type;
		this.m_username = username;
		this.m_hash = hash;
	}


	@Override
	public void setID(int id)
	{
		this.m_id = id;
	}
	@Override
	public void setType(AccountType type)
	{
		this.m_type = type;
	}
	@Override
	public void setEmail(String email)
	{
		this.m_email = email;
	}
	@Override
	public void setUsername(String username)
	{
		this.m_username = username;
	}
	@Override
	public void setPassword(String password)
	{
		// TODO : hash + salt password
		this.m_hash = password;
	}
	@Override
	public int getID()
	{
		return this.m_id;
	}
	@Override
	public AccountType getType()
	{
		return this.m_type;
	}
	@Override
	public String getEmail()
	{
		return this.m_email;
	}
	@Override
	public String getUsername()
	{
		return this.m_username;
	}
	@Override
	public String getHash()
	{
		return this.m_hash;
	}
	
}
