package server.core;

import server.handlers.ApiHandler;
import server.handlers.HomeHandler;
import server.handlers.RootHandler;

import java.io.IOException;
import java.util.concurrent.Executor;

public class Core {
    public static void Init() throws IOException {
        Router router = Router.getInstance();
        Route rootRoute = new Route("/home", new RootHandler());
        router.registerRoute(rootRoute);
        RouteGroup apiGroup = new RouteGroup("/api");
        Route apiHomeRoute = new Route("/test", new ApiHandler());
        apiGroup.add(apiHomeRoute);
        router.registerRouteGroup(apiGroup);
        router.Init();
        router.httpServer.setExecutor(null);
        router.httpServer.start();
    }
}
