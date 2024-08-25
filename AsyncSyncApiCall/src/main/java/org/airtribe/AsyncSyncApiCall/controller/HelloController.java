package org.airtribe.AsyncSyncApiCall.controller;

import org.airtribe.AsyncSyncApiCall.entity.ApiResponse;
import org.airtribe.AsyncSyncApiCall.entity.User;
import org.airtribe.AsyncSyncApiCall.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
public class HelloController {

  @Autowired
  public ApiService apiService;

  @GetMapping("/hello")
  public String hello() {
    return "Hello World!";
  }

  @PostMapping("/user")
  public User createUser(@RequestBody User user) {
    return user;
  }

  @GetMapping("/helloClient")
  public String clientHello() {
    return apiService.clientHello();
  }

  @PostMapping("/userClient")
  public User clientCreate(@RequestBody User user) {
    return apiService.clientCreate(user);
  }

  @GetMapping("/airQualityApi")
  public ApiResponse airQualityApi() {
    return apiService.airQualityApi();
  }

  @GetMapping("/airQualityApiAsync")
  public Mono<ApiResponse> airQualityApiAsync() {
    return apiService.airQualityApiAsync();
  }

  @GetMapping("/airQualityApiSyncWebClient")
  public ApiResponse airQualityApiSyncWebClient() {
    return apiService.airQualityApiSyncWebClient();
  }

  @GetMapping("/airQualityApiAsyncChained")
  public Mono<ApiResponse> airQualityApiAsyncChained() {
    return apiService.airQualityApiAsyncChained();
  }

  @GetMapping("airQualityApiAsyncParallel")
  public Mono<ApiResponse> airQualityApiAsyncParallel() {
    return apiService.airQualityApiAsyncParallel();
  }
}
