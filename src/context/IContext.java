package context;

import java.io.IOException;

public interface IContext {
	public void write(byte[] data) throws IOException;
	public void parse() throws IOException;
	public String getParam(String key);
}
