package org.airtribe.AsyncSyncApiCall.service;

import org.airtribe.AsyncSyncApiCall.entity.ApiResponse;
import org.airtribe.AsyncSyncApiCall.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;


@Service
public class ApiService {

  @Autowired
  public RestTemplate _restTemplate;

  @Autowired
  public WebClient _webClient;

  private String BASE_URL = "https://api.openaq.org/v2/latest";

  public String clientHello() {
    String result =  _restTemplate.getForObject("http://localhost:8081/hello", String.class);
    System.out.println("Obtained the result");
    return result;
  }

  public User clientCreate(User user) {
    return _restTemplate.postForObject("http://localhost:8081/user", user, User.class);
  }

  public ApiResponse airQualityApi() {
    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(BASE_URL)
        .queryParam("limit", 10)
        .queryParam("page", 1)
        .queryParam("radius", 1000)
        .queryParam("offset", 0)
        .queryParam("sort", "desc")
        .queryParam("order_by", "lastUpdated")
        .queryParam("dump_raw", false);

    ApiResponse apiResponse = _restTemplate.getForObject(uriComponentsBuilder.toUriString(), ApiResponse.class);
    System.out.println("Received the response");

    for (int i =0; i < 100; i++) {
      System.out.println("Doing some work in the foreground");
    }

    return apiResponse;
  }

  public Mono<ApiResponse> airQualityApiAsync() {

    long startTime = System.currentTimeMillis();

    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(BASE_URL)
        .queryParam("limit", 10)
        .queryParam("page", 1)
        .queryParam("radius", 1000)
        .queryParam("offset", 0)
        .queryParam("sort", "desc")
        .queryParam("order_by", "lastUpdated")
        .queryParam("dump_raw", false);

    Mono<ApiResponse> mono = _webClient.get().uri(uriComponentsBuilder.toUriString())
        .retrieve()
        .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("4xx error")))
        .bodyToMono(ApiResponse.class)
        .doFinally(signalType -> {
          long endTime = System.currentTimeMillis();
          System.out.println("Time taken to get the response: " + (endTime - startTime) + " ms");
          System.out.println("Received the response");
        })
        .doFirst(() -> System.out.println("API call started at: " + startTime));

    long endTime = System.currentTimeMillis();
    System.out.println("Time taken slow to get the response: " + (endTime - startTime) + " ms");

    for (int i =0; i < 100; i++) {
      System.out.println("Doing some work in the foreground");
    }

    return mono;

  }

  public ApiResponse airQualityApiSyncWebClient() {
    long startTime = System.currentTimeMillis();

    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(BASE_URL)
        .queryParam("limit", 10)
        .queryParam("page", 1)
        .queryParam("radius", 1000)
        .queryParam("offset", 0)
        .queryParam("sort", "desc")
        .queryParam("order_by", "lastUpdated")
        .queryParam("dump_raw", false);

    ApiResponse response = _webClient.get().uri(uriComponentsBuilder.toUriString())
        .retrieve()
        .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("4xx error")))
        .bodyToMono(ApiResponse.class)
        .block();

    long endTime = System.currentTimeMillis();
    System.out.println("Time taken slow to get the response: " + (endTime - startTime) + " ms");

    for (int i =0; i < 100; i++) {
      System.out.println("Doing some work in the foreground");
    }

    return response;

  }

  public Mono<ApiResponse> airQualityApiAsyncChained() {
    long startTime = System.currentTimeMillis();

    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(BASE_URL)
        .queryParam("limit", 10)
        .queryParam("page", 1)
        .queryParam("radius", 1000)
        .queryParam("offset", 0)
        .queryParam("sort", "desc")
        .queryParam("order_by", "lastUpdated")
        .queryParam("dump_raw", false);

    Mono<ApiResponse> mono = _webClient.get().uri(uriComponentsBuilder.toUriString())
        .retrieve()
        .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("4xx error")))
        .bodyToMono(ApiResponse.class)
        .doFinally(signalType -> {
          long endTime = System.currentTimeMillis();
          System.out.println("Time taken to get the response: " + (endTime - startTime) + " ms");
          System.out.println("Received the response");
        })
        .doFirst(() -> System.out.println("API call started at: " + startTime))
        .flatMap(apiResponse -> {
          System.out.println("Doing some work in the background");
          long startTime2 = System.currentTimeMillis();
          return _webClient.get().uri(uriComponentsBuilder.toUriString())
              .retrieve()
              .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("4xx error")))
              .bodyToMono(ApiResponse.class).doFinally(signalType -> {
                long endTime = System.currentTimeMillis();
                System.out.println("Time taken to get the response  for second api call: " + (endTime - startTime2) + " ms");
                System.out.println("Received the response for second api call");
              }).doFirst(() -> System.out.println("API call started at: " + startTime2)).map(secondResponse -> {
                return mergeResponses(apiResponse, secondResponse);
              });
        });

    for (int i =0; i < 100; i++) {
      System.out.println("Doing some work in the foreground");
    }

    for (int i =0; i < 100; i++) {
      System.out.println("Doing some work in the foreground 2");
    }

    return mono;
  }

  private ApiResponse mergeResponses(ApiResponse apiResponse, ApiResponse secondResponse) {
    apiResponse.getResults().addAll(secondResponse.getResults());
    return apiResponse;
  }

  public Mono<ApiResponse> airQualityApiAsyncParallel() {
    long startTime = System.currentTimeMillis();

    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(BASE_URL)
        .queryParam("limit", 10)
        .queryParam("page", 1)
        .queryParam("radius", 1000)
        .queryParam("offset", 0)
        .queryParam("sort", "desc")
        .queryParam("order_by", "lastUpdated")
        .queryParam("dump_raw", false);

    Mono<ApiResponse> apiResponseMono1 = createMono(uriComponentsBuilder);
    Mono<ApiResponse> apiResponseMono2 = createMono(uriComponentsBuilder);
    Mono<ApiResponse> apiResponseMono3 = createMono(uriComponentsBuilder);

    Mono<ApiResponse> mono = Mono.zip(apiResponseMono1, apiResponseMono2, apiResponseMono3)
        .map(tuple -> {
          ApiResponse response1 = tuple.getT1();
          ApiResponse response2 = tuple.getT2();
          ApiResponse response3 = tuple.getT3();
          response1.getResults().addAll(response2.getResults());
          response1.getResults().addAll(response3.getResults());
          return response1;
        });


    for (int i =0; i < 100; i++) {
      System.out.println("Doing some work in the foreground");
    }

    return mono;

  }

  private Mono<ApiResponse> createMono(UriComponentsBuilder uriComponentsBuilder) {
    long startTime = System.currentTimeMillis();

    return _webClient.get().uri(uriComponentsBuilder.toUriString())
        .retrieve()
        .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("4xx error")))
        .bodyToMono(ApiResponse.class)
        .doFinally(signalType -> {
          long endTime = System.currentTimeMillis();
          System.out.println("Time taken to get the response: " + (endTime - startTime) + " ms");
          System.out.println("Received the response");
        })
        .doFirst(() -> System.out.println("API call started at: " + startTime));
  }
}
