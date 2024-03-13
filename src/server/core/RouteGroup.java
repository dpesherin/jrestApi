package server.core;

import org.jetbrains.annotations.NotNull;
import server.core.Route;

import java.util.ArrayList;

public class RouteGroup {
    protected String extPath;
    ArrayList <Route> routeList = new ArrayList <Route> ();

    public RouteGroup (String extPath) {
        this.extPath = extPath;
    }

    public void add (@NotNull Route route) {
        route.path = this.extPath + route.path;
        for (Route r : routeList) {
            if (r.path.equals(route.path)) {
                return;
            }
        }
        routeList.add(route);
    }
}
