package server;

import server.handlers.HomeHandler;
import server.handlers.RootHandler;

import java.io.IOException;

public class Core {
    public static void Init() throws IOException {
        Router router = Router.getInstance();
        Route rootRoute = new Route("/", new RootHandler());
        router.register(rootRoute);
        Route homeRoute = new Route("/home", new HomeHandler());
        router.register(homeRoute);
        router.Init();

        router.httpServer.setExecutor(null);
        router.httpServer.start();
    }
}
