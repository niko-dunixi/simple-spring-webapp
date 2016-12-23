package io.paulbaker.friendcode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by paulbaker on 12/23/16.
 */
@Controller
@RequestMapping(method = RequestMethod.GET)
public class HomeController {

    @RequestMapping(path = "/")
    public String home() {
        return "index";
    }

    @RequestMapping(path = "/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
