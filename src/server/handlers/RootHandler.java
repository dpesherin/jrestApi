package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import server.core.Response;
import server.utils.HttpLogger;

import java.io.IOException;
import java.io.OutputStream;

public class RootHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Response response = new Response(exchange);
        response.setStatus(200).setBody("Root route").send();
    }
}
