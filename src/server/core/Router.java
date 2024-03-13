package server.core;


import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.util.ArrayList;

public class Router {
    public HttpServer httpServer;
    private final ArrayList<Route> routeList = new ArrayList<Route>();
    private final ArrayList<RouteGroup> routeGroupList = new ArrayList<RouteGroup>();


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

    public void registerRoute(Route route){
        for (Route r : routeList){
            if (r.path.equals(route.path)) {
                return;
            }
        }
        this.routeList.add(route);
    }

    public void registerRouteGroup(RouteGroup routeGroup){
        for (RouteGroup rg : routeGroupList){
            if (rg.extPath.equals(routeGroup.extPath)) {
                return;
            }
        }
        this.routeGroupList.add(routeGroup);
    }

    public void Init(){
        for (Route routeItem: routeList) {
            routeItem.add(()->{
                HttpContext context = this.httpServer.createContext(routeItem.path, routeItem.handler);
            });
        }
        for (RouteGroup routeGroupItem: routeGroupList) {
            for (Route routeItem: routeGroupItem.routeList) {
                routeItem.add(()->{
                    HttpContext context = this.httpServer.createContext(routeItem.path, routeItem.handler);
                });
            }
        }
    }
}
