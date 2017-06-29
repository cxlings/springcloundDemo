package com.example.demo.ribbon.controller;

import com.example.demo.ribbon.service.HelloService;
import com.example.demo.ribbon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanghui on 2017/6/29.
 */
@RestController
@RequestMapping("/")
public class HelloController {

  @Autowired
  HelloService helloService;
  @Autowired
  ProductService productService;
  /**
   * 服务消费者
   */
  @RequestMapping("/hello")
  public String hi(@RequestParam String name){
    return  productService.hello( name );
  }

  @RequestMapping("product/{id}")
  public String product(@PathVariable String id ){
     return  productService.sayId( id );
  }

}
