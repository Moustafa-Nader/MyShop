package requesthandler;

import context.IContext;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HomeHandler extends RequestHandlerBase {
    @Override
    public void handle(IContext ctx) throws IOException {
    	if(ctx.getUser() == null) {
    		this.showLogin(ctx);
    		return;
    	} else {
    		this.showHome(ctx);
    	}
    }
    
    private void showLogin(IContext ctx) throws IOException {
        String output = m_resources.htmlRead("/src/Components/login_form.html");
        ctx.write(output.getBytes());
    }
    
    private void showHome(IContext ctx) throws IOException {
    	String username = ctx.getUser().getUsername();
    	String htmlData = "<h1> welcome back " + username + "!</h1> <br>";
    	htmlData += m_resources.htmlRead("/src/Components/home.html");
    	ctx.write(htmlData.getBytes());
    }
}
