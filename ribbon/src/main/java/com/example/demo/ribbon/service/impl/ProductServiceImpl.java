package com.example.demo.ribbon.service.impl;

import com.example.demo.ribbon.service.ProductService;
import org.springframework.stereotype.Component;

/**
 * Created by wanghui on 2017/6/29.
 */

@Component
public class ProductServiceImpl implements ProductService {
  @Override
  public String hello( String name) {
    return "hello errro fall back "+ name;
  }

  @Override
  public String sayId( String id) {
    return "error id from feign";
  }
}
