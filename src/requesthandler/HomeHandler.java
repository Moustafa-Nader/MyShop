package requesthandler;

import context.IContext;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HomeHandler implements IRequestHandler {
    @Override
    public void handle(IContext ctx) throws IOException {
        String output = "";
        File homeFile = new File("src/home.html");
        Scanner scanner = new Scanner(homeFile);
        while(scanner.hasNextLine())
            output += scanner.nextLine();

        ctx.write(output.getBytes());

    }
}
