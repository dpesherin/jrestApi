package server.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import server.utils.HttpLogger;

import java.io.IOException;
import java.io.OutputStream;

public class ApiHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        int statusCode;
        try {
            String response = "API Route";
            statusCode = 200;
            exchange.sendResponseHeaders(statusCode, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }catch (Exception e){
            String responce = "Bad Request";
            statusCode = 500;
            exchange.sendResponseHeaders(statusCode, responce.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(responce.getBytes());
            os.close();
        }
        HttpLogger.printInfo(exchange, statusCode);
    }
}
