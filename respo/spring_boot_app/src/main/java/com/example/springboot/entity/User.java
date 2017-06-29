package com.example.springboot.entity;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 * Created by wanghui on 2017/6/28.
 */

@Entity
public class User implements Serializable {

  private long uId;
  private String userName;

  public long getuId() {
    return uId;
  }

  public void setuId(long uId) {
    this.uId = uId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
