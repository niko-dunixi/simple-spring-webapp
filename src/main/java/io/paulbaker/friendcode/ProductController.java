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

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "productadmin";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getProduct(@RequestParam(value = "id") long productId, Model model) {
        Product product = productRepository.findOne(productId);
        return applyProductToModel(product, model);
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String createProduct(@RequestParam(value = "name") String name, @RequestParam(value = "cost") double cost, @RequestParam(value = "description") String description) {
        Product product = new Product();
        product.setName(name);
        product.setCost(cost);
        product.setDescription(description);
        productRepository.save(product);
        return "redirect:/product/admin";
    }

    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    public String postDeleteProduct(@RequestParam(value = "id") long productId) {
        productRepository.delete(productId);
        return "redirect:/product/admin";
    }

    private String applyProductToModel(Product product, Model model) {
        model.addAttribute("id", product.getId());
        model.addAttribute("name", product.getName());
        model.addAttribute("cost", product.getCost());
        model.addAttribute("description", product.getDescription());
        return "product";
    }

}
