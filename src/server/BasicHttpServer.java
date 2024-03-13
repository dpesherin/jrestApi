package server;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class BasicHttpServer {
     private static final int _port = 3001;
     public HttpServer httpServer;
    private static BasicHttpServer _INSTANCE;

    public BasicHttpServer() throws IOException{
        this.httpServer = HttpServer.create(new InetSocketAddress(_port), 0);
    }

    public static BasicHttpServer getInstance() throws IOException {
        if (_INSTANCE == null){
            _INSTANCE = new BasicHttpServer();
        }
        return _INSTANCE;
    }
}
