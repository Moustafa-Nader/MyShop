package requesthandler;

import context.IContext;
import model.account.Account;
import model.account.IAccount;
import model.account.AccountType;
import service.account.AccountService;
import service.account.IAccountService;

import java.io.IOException;

public class RegisterHandler extends RequestHandlerBase {

    IAccountService m_service;

    public RegisterHandler(IAccountService service)
    {
        this.m_service = service;
    }
    @Override
    public void handle(IContext ctx) throws IOException {
    	if(ctx.getUser() != null) {
    		ctx.redirect("/home");
    		return;
    	}
        ctx.parse();
        System.out.println(ctx.getParam("m_email"));
        System.out.println(ctx.getParam("m_password"));
        System.out.println(ctx.getParam("m_type"));
        System.out.println(ctx.getParam("m_username"));
        Account acc = new Account(AccountType.valueOf(ctx.getParam("m_type")),
                ctx.getParam("m_email"),ctx.getParam("m_username"), ctx.getParam("m_password"));
        this.m_service.addAccount(acc);

       // ctx.write("<html>Thanks for registering </html>".getBytes());
        ctx.redirect("/home");
    }
}
