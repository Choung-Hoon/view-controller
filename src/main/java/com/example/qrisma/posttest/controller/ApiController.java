package com.example.qrisma.posttest.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.qrisma.posttest.dto.UserDto;
import com.example.qrisma.posttest.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@Slf4j
public class ApiController {
  @PostMapping("/api/join")
  public String createUser(@ModelAttribute UserVo userVo) {
    // username과 password 값이 각각 user 객체의 username과 password 프로퍼티에 매핑됩니다.
    // url-encode 로 요청 시, 값을 가져옴
    log.info("/api/join");
    log.info("UserVo : " + userVo);
    return "성공";
  }

  @PostMapping("/api/login/json")
  public String login(@RequestBody UserDto userDto) {
    log.info("/api/login/json");
    log.info("userDto : " + userDto);
    return "성공";
  }

  @PostMapping("/api/login/urlencode")
  public String login1(@RequestBody UserDto userDto) {
    // url-encode로 보낸 값은 @RequestBody 받을 수없다.
    log.info("/api/login/urlencode");
    log.info("userDto : " + userDto);
    return "성공";
  }

  @PostMapping("/api/login/urlencode1")
  public String login1(@RequestParam String username, @RequestParam String password) {
    log.info("/api/login/urlencode1");
    log.info("username : " + username);
    log.info("password : " + password);
    return "redirect:/";
  }

  @PostMapping("/api/login/urlencode/redirect")
  public ResponseEntity<String> handlePostRequest(@RequestParam String username, @RequestParam String password,
      RedirectAttributes redirectAttributes) {
    // 여기에서 POST 요청을 처리하는 로직을 작성합니다.
    log.info("/api/login/urlencode/redirect");
    log.info("username : " + username);
    log.info("password : " + password);

    // 리다이렉트할 경로를 지정합니다.
    String redirectPath = "/";

    // 리다이렉트 시에 데이터를 전달하려면 RedirectAttributes를 사용합니다.
    // 여기에서는 리다이렉트 후에 "message"라는 속성으로 메시지를 전달하는 예제입니다.
    redirectAttributes.addFlashAttribute("message", "Your message here");

    // ResponseEntity를 사용하여 HTTP 상태코드와 함께 응답을 반환합니다.
    return ResponseEntity.status(HttpStatus.FOUND).location(java.net.URI.create(redirectPath)).build();
  }
}
