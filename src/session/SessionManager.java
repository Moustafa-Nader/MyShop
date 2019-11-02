package session;

import java.util.HashMap;
import java.util.UUID;

import context.IContext;
import cookie.Cookie;
import cookie.ICookie;

public class SessionManager implements ISessionManager {
	
	HashMap<String, ISession> m_sessions;
	
	public SessionManager()
	{
		m_sessions = new HashMap<String, ISession>();
	}
	
	@Override
	public void load(IContext ctx) {
		ISession session;
		ICookie sessionCookie = ctx.getCookie("sessionID");
		// create session if it does not exist
		if(sessionCookie == null || m_sessions.get(sessionCookie.getValue()) == null) {
			session = createSession();
			sessionCookie = new Cookie("sessionID", session.ID());
			m_sessions.put(session.ID(), session);
		} else {
			session = m_sessions.get(sessionCookie.getValue());
		}
		ctx.setSession(session);
		ctx.setCookie(sessionCookie);
	}

	@Override
	public void destroy(IContext ctx) {
		ICookie sessionCookie = ctx.getCookie("sessionID");
		// no session exists
		if(sessionCookie == null || m_sessions.get(sessionCookie.getValue()) == null)
			return;
		m_sessions.remove(sessionCookie.getValue());
	}

	private ISession createSession()
	{
		return new Session(UUID.randomUUID().toString());
	}
}
