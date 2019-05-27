package routes;

import com.jfinal.config.Routes;
import controller.HelloController;
import controller.MyController;

public class FrontRoutes extends Routes {
    @Override
    public void config() {
        setMappingSuperClass(true);
        add("/hello", HelloController.class);
        add("/myvoice", MyController.class);
    }
}
