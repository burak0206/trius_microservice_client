package com.trius.microservice.example;

import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/")
    public String handleRequest(Model model) {

        List<ServiceInstance> instances = discoveryClient.getInstances("Service");
        if (instances != null && !instances.isEmpty()) {
            ServiceInstance serviceInstance = instances.get(0);
            String url = serviceInstance.getUri().toString();
            url = url + "/list";
            RestTemplate restTemplate = new RestTemplate();
            List<Product> result = restTemplate.getForObject(url, List.class);

            model.addAttribute("result", result);
        }

        return "product";
    }

}
