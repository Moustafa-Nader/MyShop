package requesthandler;

import context.IContext;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SignUpHandler extends RequestHandlerBase {
    @Override
    public void handle(IContext ctx) throws IOException {
       // m_resources = new HtmlHandler();
        String path = "src/Components/signup.html";
        ctx.write(m_resources.htmlRead(path).getBytes());
    }
}
