package requesthandler;

import java.io.IOException;

import context.IContext;
import session.ISessionManager;

public interface IRequestHandler {
	public void handle(IContext ctx) throws IOException;
	public void setSessionManager(ISessionManager smgr);
	public ISessionManager getSessionManager();
	//TODO htmlreader function public String htmlRead(String path);
}
