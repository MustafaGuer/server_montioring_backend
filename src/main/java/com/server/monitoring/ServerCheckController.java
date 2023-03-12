package com.server.monitoring;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/check")
public class ServerCheckController {

  private List<Server> servers;

  public ServerCheckController() {
    servers = new ArrayList<>();
    servers.add(new Server("https://www.google.com", "Google"));
    servers.add(new Server("https://www.facebook.com", "Facebook"));
    servers.add(new Server("https://www.facebook.coms", "Facebooks"));
    servers.add(new Server("https://www.github.com", "Github"));
    servers.add(new Server("https://www.juniq-it.de/", "Juniq-IT"));
  }

  @GetMapping
  public List<Result> checkServers() {
    List<Result> results = new ArrayList<>();

    for (Server server : servers) {
      try {
        URL serverUrl = new URL(server.getUrl());

        HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();

        conn.setRequestMethod("HEAD");

        conn.connect();

        int responseCode = conn.getResponseCode();

        if (responseCode == 200) {
          results.add(new Result(server.getName(), "OK"));
        } else {
          results.add(new Result(server.getName(), "Error"));
        }

        conn.disconnect();
      } catch (IOException e) {
        results.add(new Result(server.getName(), "Error"));
      }
    }

    return results;
  }
}
