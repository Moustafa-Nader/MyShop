package requesthandler;

import java.io.IOException;

import context.IContext;
import session.ISessionManager;

public class RequestHandlerBase implements IRequestHandler {
	ISessionManager m_smgr;
	HtmlHandler m_resources= new HtmlHandler();
	@Override
	public void handle(IContext ctx) throws IOException {
		// no implementation
	}

	@Override
	public void setSessionManager(ISessionManager smgr) {
		m_smgr = smgr;
	}
	
	@Override
	public ISessionManager getSessionManager() {
		return m_smgr;
	}
}
