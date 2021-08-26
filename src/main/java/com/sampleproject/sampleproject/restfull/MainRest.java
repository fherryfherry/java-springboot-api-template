package com.sampleproject.sampleproject.restfull;

import com.sampleproject.sampleproject.models.Product;
import com.sampleproject.sampleproject.repositories.ProductRepository;
import com.sampleproject.sampleproject.services.ProductService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class MainRest {


    @GetMapping(value = "/")
    public String getIndex() throws Exception {

        JSONObject response = new JSONObject();
        response.put("status",1);
        response.put("message","ok");

        return response.toString();
    }
}
