package requesthandler;

import java.io.IOException;

import context.IContext;
import model.account.AccountType;

public class AddStatisticPageHandler extends RequestHandlerBase {
	@Override
    public void handle(IContext ctx) throws IOException {
		if(ctx.getUser() == null || ctx.getUser().getType() != AccountType.ADMIN)
			ctx.redirect("/home");
		else
			ctx.write(m_resources.htmlRead("/src/Components/add_statistic.html").getBytes());
	}
}
