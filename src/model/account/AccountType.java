package model.account;

public enum AccountType {
	USER, OWNER, ADMIN;
	
	public String toString()
	{
		switch(this)
		{
			case USER:	return "user";
			case OWNER:	return "owner";
			case ADMIN:	return "admin";
			default:	return "invalid";
		}
	}
}
