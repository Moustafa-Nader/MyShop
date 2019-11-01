package requesthandler;

import context.IContext;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SignUpHandler extends RequestHandlerBase {
    @Override
    public void handle(IContext ctx) throws IOException {
        String output = "";
        File homeFile = new File("src/signup.html");
        Scanner scanner = new Scanner(homeFile);
        while(scanner.hasNextLine())
            output += scanner.nextLine();

        ctx.write(output.getBytes());
    }
}
