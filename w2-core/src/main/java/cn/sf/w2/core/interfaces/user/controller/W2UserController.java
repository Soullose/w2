package cn.sf.w2.core.interfaces.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.sf.w2.core.domain.user.W2UserService;
import cn.sf.w2.core.infrastructure.entities.W2User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(tags = "系统用户管理")
@RestController
@RequestMapping(value = "/v1/w2-user")
public class W2UserController {

    private final W2UserService service;

    public W2UserController(W2UserService w2UserService) {
        this.service = w2UserService;
    }

    @ApiOperation(value = "注册")
    @GetMapping(value = "/register")
    public ResponseEntity<W2User> register(){
        return ResponseEntity.ok(service.register());
    }
}
