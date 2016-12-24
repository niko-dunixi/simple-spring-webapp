package io.paulbaker.friendcode;

import io.paulbaker.friendcode.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by paulbaker on 12/23/16.
 */
@Controller
public class DataFakingController {

    @Bean
    @Scope(scopeName = BeanDefinition.SCOPE_SINGLETON)
    public Random getRandom() {
        return new Random();
    }

    @Autowired
    private ProductRepository repository;

    @Autowired
    private Random random;

    @Value("#{'${fake.data.adjectives}'.split(',\\s*')}")
    private List<String> adjectives;

    @Value("#{'${fake.data.products}'.split(',\\s*')}")
    private List<String> products;

    @PostConstruct
    public void postConstruct() {
        List<Product> constructedProducts = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Product product = new Product();
            product.setName(CollectionUtil.RandomElement(adjectives, random) + " " + CollectionUtil.RandomElement(products, random));
            product.setCost((random.nextInt(10000) + 1500d) / 100);
            product.setDescription(product.getName() + String.format(" is a product that costs $%.2f", product.getCost()));
            constructedProducts.add(product);
        }
        repository.save(constructedProducts);
    }
}
