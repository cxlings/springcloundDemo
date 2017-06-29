package com.example.demo.eurkaclient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanghui on 2017/6/29.
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/product")
public class ProductService {


  /**
   * /product/hi
   * @param name
   * @return
   */
  @RequestMapping("/hi")
  public String say(@RequestParam("name") String name ){
    return  "hi"+ProductService.class.getName()+" name ";
  }
}
