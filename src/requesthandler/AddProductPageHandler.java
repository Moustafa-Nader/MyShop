package requesthandler;

import context.IContext;
import model.account.AccountType;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AddProductPageHandler extends RequestHandlerBase {
    @Override
    public void handle(IContext ctx) throws IOException {
    	if(ctx.getUser() == null || ctx.getUser().getType() != AccountType.ADMIN) {
    		ctx.write("<h1>Unauthorized</h1>".getBytes());
    		return;
    	}

        String output = m_resources.htmlRead("/src/Components/product.html");
        ctx.write(output.getBytes());

    }
}
