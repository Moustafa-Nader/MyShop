package requesthandler;

import context.IContext;
import cookie.Cookie;
import model.account.IAccount;
import service.account.IAccountService;

import java.io.IOException;

public class LogoutHandler extends RequestHandlerBase {
    @Override
    public void handle(IContext ctx) throws IOException {
    	if(ctx.getUser() != null) {
    		// destroy user session
    		this.getSessionManager().destroy(ctx);
    	}
    	ctx.redirect("/home");
    }
}
