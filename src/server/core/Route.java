package server.core;


import com.sun.net.httpserver.HttpHandler;
import org.jetbrains.annotations.NotNull;

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

    public void add(@NotNull RouteAction action) {
        action.execute();
    }
}
