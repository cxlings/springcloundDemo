package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by wanghui on 2017/6/28.
 */

@SpringBootApplication
public class Application {

  public static void main(String[] args) throws Exception {
    SpringApplication.run( Application.class , args);
//    System.out.println( args[0] );
  }

}
