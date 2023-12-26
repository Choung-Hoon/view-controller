package com.example.qrisma.posttest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ViewController {
  @GetMapping("selectParam")
  /**
   * 파라미터 전달 받기
   * 
   * @param param
   * @return
   */
  public String selectParam(@RequestParam String username, @RequestParam String password) {
    log.info("username : " + username);
    log.info("password : " + password);

    return "selectParam";
  }

  @GetMapping("/join")
  public String join() {
    return "join";
  }

  @GetMapping("/login")
  public String log() {
    return "login";
  }

  @GetMapping("/")
  public String home() {
    return "main";
  }
}