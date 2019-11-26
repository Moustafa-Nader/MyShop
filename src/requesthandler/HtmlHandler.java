package requesthandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HtmlHandler {

    public String htmlRead(String path) throws FileNotFoundException {

        path =  System.getProperty("user.dir") + path;
        String output = "";
        File homeFile = new File(path);
        Scanner scanner = new Scanner(homeFile);
        while (scanner.hasNextLine())
            output += scanner.nextLine() + '\n';
        scanner.close();
        return output;
    }
}