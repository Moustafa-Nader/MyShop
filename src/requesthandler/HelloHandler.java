package requesthandler;
import java.io.IOException;

import context.IContext;

public class HelloHandler implements IRequestHandler {

	@Override
	public void handle(IContext ctx) throws IOException
	{
		ctx.write("<h1>Hell0!!!!!!</h1>".getBytes());
	}
	
}
