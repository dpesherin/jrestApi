package server;


import com.sun.net.httpserver.HttpHandler;

interface RouteAction {
    void execute();
}

public class Route {
    protected String path;
    protected HttpHandler handler;

    public Route(String path, HttpHandler handler){
        this.path = path;
        this.handler = handler;
    }

    public void add(RouteAction action) {
        action.execute();
    }
}
