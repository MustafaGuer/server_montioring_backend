package com.server.monitoring;
import java.util.Date;

public class Result {
  // private String url;
  private String serverName;
  private String result;
  private Date timestamp;

  // public Result(String url, String result) {
  public Result(String serverName, String result) {
    // this.url = url;
    this.serverName = serverName;
    this.result = result;
    this.timestamp = new Date();
  }

  // public String getUrl() {
  //   return url;
  // }
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
