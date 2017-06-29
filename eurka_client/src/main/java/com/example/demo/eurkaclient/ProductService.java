package com.example.demo.eurkaclient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
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
   * 服务的提供者
   * /product/hi
   * @param name
   * @return
   */
  @RequestMapping("/hi")
  public String say(@RequestParam("name") String name ){
    return  "hi"+ProductService.class.getName()+ "   " +name;
  }

  /**
   * 服务的提供者
   * /product/{3456}
   * @param id
   * @return
   */
  @RequestMapping("/{id}")
  public String product(@PathVariable("id") String id ){
    return  "eurka client , hi"+ id;
  }


}
