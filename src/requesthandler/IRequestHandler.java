package requesthandler;

import java.io.IOException;

import context.IContext;

public interface IRequestHandler {
	public void handle(IContext ctx) throws IOException;
}
