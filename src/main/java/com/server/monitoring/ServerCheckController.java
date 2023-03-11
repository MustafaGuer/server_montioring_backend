package com.server.monitoring;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/check")
@CrossOrigin
public class ServerCheckController {

  // @PostMapping
  // public List<Result> checkServers(@RequestBody List<String> urls) {
  // public List<Result> checkServers(@RequestBody List<String> urls) {
  @GetMapping
  public List<Result> checkServers() {
    // List<Result> results = new ArrayList<>();
    List<String> urls = new ArrayList<>();
    urls.add("https://www.google.com");
    urls.add("https://www.facebook.com");
    urls.add("https://www.github.com");
    urls.add("https://www.mustafaguer.com");
    urls.add("github.lala");

    List<Result> results = new ArrayList<>();

    for (String url : urls) {
      try {
        URL serverUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
          results.add(new Result(url, "OK"));
        } else {
          results.add(new Result(url, "Error"));
        }
        conn.disconnect();
      } catch (IOException e) {
        results.add(new Result(url, "Error"));
      }
    }

    return results;
  }

  static class Result {

    private String url;
    private String result;

    public Result(String url, String result) {
      this.url = url;
      this.result = result;
    }

    public String getUrl() {
      return url;
    }

    public String getResult() {
      return result;
    }
  }
}
