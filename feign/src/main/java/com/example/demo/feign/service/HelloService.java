package com.example.demo.feign.service;

import com.example.demo.feign.controller.HelloController;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wanghui on 2017/6/29.
 */

@Component
public class HelloService implements HelloController {

  @Override
  public String hello(@RequestParam String name) {
    return "hello errro fall back "+ name;
  }
}
