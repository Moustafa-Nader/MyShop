package requesthandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import context.IContext;

public class StaticFilesHandler extends RequestHandlerBase implements IRequestHandler {
	
	@Override
    public void handle(IContext ctx) throws IOException {
		String path = System.getProperty("user.dir") + ctx.getHttpExchange().getRequestURI().getPath();
		path = path.replace('/', '\\');
		System.out.println(path);
		Path fileLocation = Paths.get(path);
		if(!fileLocation.toFile().exists() || fileLocation.toFile().isDirectory()) {
			ctx.write("file does not exist".getBytes());
			return;
		}
		ctx.write(Files.readAllBytes(fileLocation));
	}
}
