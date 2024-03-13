package server;

import server.handlers.ApiHandler;
import server.handlers.HomeHandler;
import server.handlers.RootHandler;

import java.io.IOException;

public class Core {
    public static void Init() throws IOException {
        Router router = Router.getInstance();
        Route rootRoute = new Route("/", new RootHandler());
        router.registerRoute(rootRoute);
        Route homeRoute = new Route("/home", new HomeHandler());
        router.registerRoute(homeRoute);
        RouteGroup apiGroup = new RouteGroup("/api");
        Route apiHomeRoute = new Route("/test", new ApiHandler());
        apiGroup.add(apiHomeRoute);
        router.registerRouteGroup(apiGroup);
        router.Init();

        router.httpServer.setExecutor(null);
        router.httpServer.start();
    }
}
