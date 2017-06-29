package com.example.demo.ribbon.service.impl;

import com.example.demo.ribbon.service.ProductService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wanghui on 2017/6/29.
 */

@Component
public class ProductServiceImpl implements ProductService {

  @Override
  public String say(@RequestParam("name") String name) {
    return null;
  }

  @Override
  public String id(@PathVariable("id") String id) {
    return null;
  }
}
