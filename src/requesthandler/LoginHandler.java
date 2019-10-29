package requesthandler;

import context.IContext;
import model.account.IAccount;
import service.account.IAccountService;

import java.io.IOException;

public class LoginHandler implements IRequestHandler {
    IAccountService m_service;
    public LoginHandler(IAccountService service){ this.m_service = service; }
    @Override
    public void handle(IContext ctx) throws IOException {
        ctx.parse();
        System.out.println(ctx.getParam("m_username"));
        System.out.println(ctx.getParam("m_password"));
        IAccount account = m_service.getByEmail(ctx.getParam("m_email"));
        if(m_service.checkPassword(account,ctx.getParam("m_password"))) {
            ctx.write("<html>Thanks :)</html>".getBytes());
        } else {
            ctx.write("<html>Sorry, Incorrect Username or Password :)</html>".getBytes());
        }

    }
}
