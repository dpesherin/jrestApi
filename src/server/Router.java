package server;


import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.util.ArrayList;

public class Router {
    public HttpServer httpServer;
    private final ArrayList<Route> routeList = new ArrayList<Route>();

    private static Router INSTANCE;

    protected Router() throws IOException {
        this.httpServer = BasicHttpServer.getInstance().httpServer;
    }

    public static Router getInstance() throws IOException {
        if (INSTANCE == null){
            INSTANCE = new Router();
        }
        return INSTANCE;
    }

    public void register(Route route){
        this.routeList.add(route);
    }

    public void Init(){
        for (Route routeItem: routeList) {
            routeItem.add(()->{
                HttpContext context = this.httpServer.createContext(routeItem.path, routeItem.handler);
            });
        }
    }
}
