package requesthandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HtmlHandler {
    
    public String htmlRead(String path) throws FileNotFoundException {
        path = "/home/duckling/Desktop/myshop/MyShop/" + path;
        String output = "";
        File homeFile = new File(path);
        Scanner scanner = new Scanner(homeFile);
        while (scanner.hasNextLine())
            output += scanner.nextLine();
        scanner.close();
        return output;
    }
}