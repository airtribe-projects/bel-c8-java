package org.airtribe.SpringSecurity.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
public class HelloController {

  @Autowired
  private WebClient _webClient;

  @GetMapping("/api/hello")
  public String hello(Principal principal) {
    System.out.println(principal);
    return "hello " + principal.getName();
  }

  @GetMapping("/api/users")
  public String getUsers(@RegisteredOAuth2AuthorizedClient("api-client-authorization-code") OAuth2AuthorizedClient client) {
    return this._webClient.get()
        .uri("http://localhost:8090/api/users")
        .attributes(ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient(client))
        .retrieve()
        .bodyToMono(String.class)
        .block();
  }
}
