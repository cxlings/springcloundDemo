package com.example.demo.ribbon.service;

import com.example.demo.ribbon.service.impl.ProductServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wanghui on 2017/6/29.
 */

@FeignClient( name="service-hi", fallback = ProductServiceImpl.class )
public interface ProductService {

  /**
   * 消费者 （1）指定提供者入口
   * @param name
   * @return
   */
  @RequestMapping(value = "/product/hi", method = RequestMethod.GET )
  public String hello(@RequestParam String name);

  @RequestMapping("/product/{id}")
  public String sayId(@PathVariable("id") String id);
}
