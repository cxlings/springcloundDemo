package com.example.demo.feign;

import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wanghui on 2017/6/29.
 */
@FeignClient(name = "recommend")
@Service
public interface RemoteRecommendService {

  @RequestMapping(method = RequestMethod.GET, value = "/recommend")
  public List<Recommendation> getRecommendations(
      @RequestParam(value = "productId" ) int productId);
}
