package io.paulbaker.friendcode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by paulbaker on 12/23/16.
 */
@Controller
@RequestMapping(path = "/admin")
public class FauxAdminController {


    @RequestMapping(path = "/product", method = RequestMethod.GET)
    public String productAdmin() {
        return "adminproduct";
    }
}
