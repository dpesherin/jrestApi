package server.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Response {
    private HttpExchange exchange;
    public int status = 200;
    public String body;

    public HashMap<String, String> headers = new HashMap<String, String>();
    public Response (HttpExchange exchange) {
        this.exchange = exchange;
    }

    public void addHeader (String name, String value) {
        this.headers.put(name, value);
    }

    public Response setContentType(String value) {
        this.addHeader("Content-Type", value);
        return this;
    }

    public Response setStatus (int status) {
        this.status = status;
        return this;
    }

    public Response json (Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        this.body = mapper.writeValueAsString(obj);
        this.setContentType("application/json");
        return this;
    }

    public Response setBody (String body) {
        this.body = body;
        return this;
    }

    public void send() throws IOException {
        try {
            for(Map.Entry<String, String> entry : headers.entrySet()) {
                exchange.getResponseHeaders().add(entry.getKey(), entry.getValue());
            }
            this.exchange.sendResponseHeaders(this.status, this.body.getBytes().length);
            OutputStream os = this.exchange.getResponseBody();
            os.write(this.body.getBytes());
            os.close();
        }catch (IOException e) {
            e.printStackTrace();
            this.body = e.getMessage();
            this.exchange.sendResponseHeaders(500, this.body.getBytes().length);
            OutputStream os = this.exchange.getResponseBody();
            os.write(this.body.getBytes());
            os.close();
        }

    }


}
