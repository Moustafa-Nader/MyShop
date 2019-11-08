package requesthandler;

import context.IContext;
import model.account.Account;
import model.account.AccountType;

import java.io.IOException;

public class AddStorePageHandler extends RequestHandlerBase{
    @Override
    public void handle(IContext ctx) throws IOException {
        if(ctx.getUser() == null || ctx.getUser().getType() != AccountType.OWNER) {
            ctx.redirect("/home");
            return;
        }

        String output = m_resources.htmlRead("/src/Components/store.html");
        ctx.write(output.getBytes());
    }
}
