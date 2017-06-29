package com.example.demo.feign.controller;

import com.example.demo.feign.service.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 服务消费方
 * 1 指定消费者 SERVICE-HI
 * Created by wanghui on 2017/6/29.
 */
@FeignClient(value = "SERVICE-HI", fallback = HelloService.class )
@RequestMapping("")
public interface HelloController {

  @RequestMapping("/hello")
  String hello(@RequestParam  String name);
}
