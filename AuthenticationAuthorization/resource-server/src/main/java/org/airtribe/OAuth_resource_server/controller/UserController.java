package org.airtribe.OAuth_resource_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

  @GetMapping("/api/users")
  public String getUsers() {
    return "User 1, User 2, User 3";
  }
}
