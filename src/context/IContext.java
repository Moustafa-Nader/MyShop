package context;

import java.io.IOException;

public interface IContext {
	public void write(byte[] data) throws IOException;
}
