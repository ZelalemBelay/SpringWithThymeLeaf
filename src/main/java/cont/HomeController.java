package cont;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Zelalem Belay on 12/29/2016.
 */

@Controller
public class HomeController
{
    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
