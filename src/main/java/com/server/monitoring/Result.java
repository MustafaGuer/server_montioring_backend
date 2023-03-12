package com.server.monitoring;

import java.util.Date;

public class Result {

  private String serverName;
  private String result;
  private Date timestamp;

  public Result(String serverName, String result) {
    this.serverName = serverName;
    this.result = result;
    this.timestamp = new Date();
  }

  public String getServerName() {
    return serverName;
  }

  public String getResult() {
    return result;
  }

  public Date getTimestamp() {
    return timestamp;
  }
}
