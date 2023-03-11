package com.server.monitoring;

public class Server {

  private String url;
  private String name;

  public Server(String url, String name) {
    this.url = url;
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public String getName() {
    return name;
  }
}
