package requesthandler;
import java.io.IOException;

import context.IContext;

public class HelloHandler extends RequestHandlerBase {

	@Override
	public void handle(IContext ctx) throws IOException
	{
		ctx.write("<h1>Hell0!!!!!!</h1>".getBytes());
	}
	
}
