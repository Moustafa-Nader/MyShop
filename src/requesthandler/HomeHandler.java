package requesthandler;

import context.IContext;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HomeHandler extends RequestHandlerBase {
    @Override
    public void handle(IContext ctx) throws IOException {
        String output =m_resources.htmlRead("src/home.html");
        ctx.write(output.getBytes());
    }
}
