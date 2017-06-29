package com.example.demo.feign.controller;

import com.example.demo.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务消费方
 * 1 指定消费者 SERVICE-HI
 * Created by wanghui on 2017/6/29.
 */
@RestController
@RequestMapping("/")
public class HelloController{


  @Autowired
  HelloService helloService;

  @RequestMapping("/hello")
  String hello(@RequestParam  String name){
     return  helloService.say( name );
  }

  @RequestMapping("{id}")
  String id(@PathVariable String id ){
    return  helloService.id( id );
  }
}
