package com.example.demo.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wanghui on 2017/6/29.
 */
@Service
public class HelloService {

  @Autowired
  RestTemplate template;


  /**
   *  服务的消费者
   *  1 选择服务时,添加超时机制
   * @param name
   * @return
   */
  @HystrixCommand(fallbackMethod = "callBack" )
  public String hi( String name ){
    // 服务uri
    String serviceUri = "http://service-hi/product/hi";
    return template.getForObject( serviceUri+"?name="+name , String.class );
  }



  public String callBack( String name ){
    return " call back error "+ name ;
  }
}
