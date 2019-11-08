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
        String output = "";
        File homeFile = new File("src/login_form.html");
        Scanner scanner = new Scanner(homeFile);
        while(scanner.hasNextLine())
            output += scanner.nextLine();

        ctx.write(output.getBytes());
    }
    
    private void showHome(IContext ctx) throws IOException {
    	String username = ctx.getUser().getUsername();
    	String htmlData = "<h1> welcome back " + username + "!</h1>";
    	ctx.write(htmlData.getBytes());
    }
}
