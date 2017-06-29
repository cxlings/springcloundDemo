package com.example.springboot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanghui on 2017/6/28.
 */


@RestController
@EnableAutoConfiguration
@RequestMapping("/")
public class BaseController {


  @RequestMapping("")
  @ResponseBody
  String home() {
    return "Hello World!";
  }





}
