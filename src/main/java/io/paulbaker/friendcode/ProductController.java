package io.paulbaker.friendcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by paulbaker on 12/23/16.
 */
@Controller
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getProduct(@RequestParam(value = "id") long productId, Model model) {
        Product product = productRepository.findOne(productId);
        return applyProductToModel(product, model);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createProduct(@RequestParam(value = "name") String name, @RequestParam(value = "description") String description, Model model) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product = productRepository.save(product);
        return applyProductToModel(product, model);
    }

    private String applyProductToModel(Product product, Model model) {
        model.addAttribute("id", product.getId());
        model.addAttribute("name", product.getName());
        model.addAttribute("description", product.getDescription());
        return "product";
    }

}
