package com.example.demo.feign;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanghui on 2017/6/29.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

  private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);


  @Autowired
  RemoteRecommendService recommendService;

  @RequestMapping("/p")
  @HystrixCommand(fallbackMethod = "callRecommendFallback",
      commandProperties = {
          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
      })
  public List<Recommendation> remoteRecommends(
      @RequestParam(value = "productId" ) int productId) {
    return recommendService.getRecommendations(productId);
  }

  public List<Recommendation> callRecommendFallback(int productId) {
    return Collections.emptyList();
  }

  @RequestMapping("/{productId}")
  @ResponseBody
  public Product getProduct(@PathVariable int productId) {
    LOG.debug("/product return the found product");
    return new Product(productId, "name");
  }
}
