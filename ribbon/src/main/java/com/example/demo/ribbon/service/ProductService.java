package com.example.demo.ribbon.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wanghui on 2017/6/29.
 */

@FeignClient(value = "SERVICE-HI",fallback = ProductService.class )
public interface ProductService {

  /**
   * 消费者 （1）指定提供者入口
   * @param name
   * @return
   */
  @RequestMapping("/product/hi")
  public String say(@RequestParam("name") String name );

  @RequestMapping("/product/{id}")
  public String id(@PathVariable("id") String id );
}
