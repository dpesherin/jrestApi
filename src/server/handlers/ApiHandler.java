package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import server.ErrorNotification;
import server.Response;

import java.io.IOException;
public class ApiHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Response response = new Response(exchange);
        ErrorNotification errorNotification = new ErrorNotification("Internal Server Error 500");
        response.setStatus(500).json(errorNotification).send();
    }
}
