package com.sampleproject.sampleproject.restfull;

import com.sampleproject.sampleproject.models.Product;
import com.sampleproject.sampleproject.services.ProductService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products", produces = "application/json")
public class ProductRest {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/")
    public String getIndex() throws Exception {

        JSONObject response = new JSONObject();

        List<Product> result = productService.findAllLatest();
        response.put("status",1);
        response.put("message","ok");
        response.put("data", result);

        return response.toString();
    }


    @GetMapping(value = "/detail/{id}")
    public String getDetail(@PathVariable("id") String id) throws Exception {

        JSONObject response = new JSONObject();
        Product result = productService.findById(id);
        response.put("status",1);
        response.put("message","ok");
        response.put("data", result);

        return response.toString();
    }

    @PostMapping(value = "/create")
    public String postCreate(@RequestParam("sku") String sku,
                            @RequestParam("name") String name,
                            @RequestParam("description") String description,
                            @RequestParam("price") String price,
                            @RequestParam("stock") String stock) throws Exception {

        Product data = new Product();
        data.setSku(sku);
        data.setName(name);
        data.setDescription(description);
        data.setPrice(Double.valueOf(price));
        data.setStock(Integer.valueOf(stock));
        productService.save(data);

        JSONObject response = new JSONObject();
        response.put("status",1);
        response.put("message","ok");

        return response.toString();
    }


    @PostMapping(value = "/update")
    public String postUpdate(@RequestParam("id") String id,
                             @RequestParam("sku") String sku,
                             @RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("price") String price,
                             @RequestParam("stock") String stock) throws Exception {

        Product data = productService.findById(id);
        data.setSku(sku);
        data.setName(name);
        data.setDescription(description);
        data.setPrice(Double.valueOf(price));
        data.setStock(Integer.valueOf(stock));
        productService.save(data);

        JSONObject response = new JSONObject();
        response.put("status",1);
        response.put("message","ok");

        return response.toString();
    }


    @PostMapping(value = "/delete")
    public String postDelete(@RequestParam("id") String id) throws Exception {

        productService.delete(id);

        JSONObject response = new JSONObject();
        response.put("status",1);
        response.put("message","ok");

        return response.toString();
    }
}
