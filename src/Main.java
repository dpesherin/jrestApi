import server.BasicHttpServer;
import server.Core;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting server");
        Core.Init();
        System.out.println("Server was started");
    }
}