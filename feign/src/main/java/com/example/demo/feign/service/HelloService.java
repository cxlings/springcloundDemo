package com.example.demo.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wanghui on 2017/6/29.
 *
 *  eurka 注册的 服务提供者名称 SERVICE-HI
 */

@Service
@FeignClient(value = "SERVICE-HI", fallback = HelloService.class )
public interface HelloService{

  @RequestMapping("/product/hi")
  public String say(@RequestParam("name") String name );

  @RequestMapping("/product/{id}")
  public String id(@PathVariable("id") String id );

}
