package requesthandler;

import context.IContext;
import cookie.Cookie;
import model.account.IAccount;
import service.account.IAccountService;

import java.io.IOException;

public class LoginHandler extends RequestHandlerBase {
    IAccountService m_service;
    public LoginHandler(IAccountService service){ this.m_service = service; }
    @Override
    public void handle(IContext ctx) throws IOException {
    	if(ctx.getUser() != null) {
    		ctx.redirect("/home");
    		return;
    	}
        ctx.parse();
        System.out.println(ctx.getParam("m_email"));
        System.out.println(ctx.getParam("m_password"));
        IAccount account = m_service.getByEmail(ctx.getParam("m_email"));
        if(m_service.checkPassword(account,ctx.getParam("m_password"))) {
            ctx.getSession().set("user", account);
        	ctx.write("<html>Thanks :)</html>".getBytes());
        } else {
            ctx.write("<html>Sorry, Incorrect Username or Password :)</html>".getBytes());
        }

    }
}
