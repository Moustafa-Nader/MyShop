package context;

import java.io.IOException;
import java.util.List;

import cookie.ICookie;

public interface IContext {
	public void write(byte[] data) throws IOException;
	public void parse() throws IOException;
	public String getParam(String key);
	public List<String> getHeader(String headerName);
	public void addHeader(String headerName, String value);
	public ICookie getCookie(String key);
	public void setCookie(ICookie cookie);
	public void redirect(String location) throws IOException;
}
