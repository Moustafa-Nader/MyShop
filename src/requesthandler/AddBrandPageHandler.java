package requesthandler;

import java.io.IOException;

import context.IContext;
import model.account.AccountType;

public class AddBrandPageHandler extends RequestHandlerBase {

    @Override
    public void handle(IContext ctx) throws IOException {
        if (ctx.getUser() == null || ctx.getUser().getType() != AccountType.ADMIN) {
            ctx.write("<h1>Unauthorized</h1>".getBytes());
            ctx.redirect("/home");
            return;
        }
        ctx.write(m_resources.htmlRead("/src/Components/brand.html").getBytes());
    }
}