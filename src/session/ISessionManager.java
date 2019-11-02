package session;

import context.IContext;

public interface ISessionManager {
	public void load(IContext ctx);
	public void destroy(IContext ctx);
}
