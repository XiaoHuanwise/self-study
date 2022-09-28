package com.twt.selfstudy.controller;

import com.alibaba.fastjson.JSON;
import com.twt.selfstudy.entity.LoginResponse;
import com.twt.selfstudy.entity.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin
public class LoginController {
    @Value("${app.domain}")
    private String DOMAIN;

    @PostMapping("/login/common")       //账号密码登录
    @ResponseBody
    public String loginCommon(@RequestParam("account") String account, @RequestParam("password") String password, @RequestHeader("ticket") String ticket,@RequestHeader("domain") String domain){

        Response allResponse = new Response();

        if (ticket == null || domain == null) {
            allResponse.setError_code(5);
            allResponse.setMessage("不可访问");
            return JSON.toJSONString(allResponse);
        }

        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String url = DOMAIN + "api/auth/common";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        /*
        app_key = "lemon"
        app_secret = "7a858ff32628843043524b729cedfaa70623efc9"
         */
        //String ticket = "bGVtb24uN2E4NThmZjMyNjI4ODQzMDQzNTI0YjcyOWNlZGZhYTcwNjIzZWZjOQ==";

        headers.add("ticket",ticket);
        headers.add("domain",domain);

        MultiValueMap<String,String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("account",account);
        paramMap.add("password",password);

        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(paramMap,headers);
        ResponseEntity response = restTemplate.postForEntity(url,request,String.class);

        LoginResponse body = JSON.parseObject((String) response.getBody(),LoginResponse.class);

        int error_code = body.getError_code();

        if (error_code == 40002){
            allResponse.setError_code(3);
            allResponse.setMessage("该用户不存在");
        }else if (error_code == 40004) {
            allResponse.setMessage("账户或密码错误");
            allResponse.setError_code(4);
        } else if (error_code == 50004) {
            allResponse.setError_code(6);
            allResponse.setMessage("错误的app_key或app_secret");
        } else if (error_code == 0) {

            allResponse.setError_code(0);
            allResponse.setMessage("登录成功");

            String token = body.getResult().getToken();     //登录成功获取的token
            String userNumber = body.getResult().getUserNumber();

            Map<String,Object> data = new HashMap<>();
            data.put("token",token);
            data.put("userNumber",userNumber);

            allResponse.setData(data);

        } else {
            allResponse.setError_code(1);
            allResponse.setMessage(body.getMessage());
        }

        return JSON.toJSONString(allResponse);
    }

    @PostMapping("/login/phoneMsg")     //发送短信验证码
    @ResponseBody
    public String getPhoneMsg(@RequestParam("phone") String phone,@RequestHeader("ticket") String ticket,@RequestHeader("domain") String domain) {

        Response allResponse = new Response();

        if (ticket == null || domain == null) {
            allResponse.setError_code(5);
            allResponse.setMessage("不可访问");
            return JSON.toJSONString(allResponse);
        }

        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String url = DOMAIN + "api/auth/phone/msg";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        headers.add("ticket",ticket);
        headers.add("domain",domain);

        MultiValueMap<String,String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("phone",phone);

        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(paramMap,headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url,request,String.class);

        LoginResponse body = JSON.parseObject(response.getBody(),LoginResponse.class);

        String[] cookie = response.getHeaders().getFirst(HttpHeaders.SET_COOKIE).split(";");

        int error_code = body.getError_code();

        if (error_code == 0) {

            Map<String,Object> data = new HashMap<>();

            data.put("cookie",cookie[0]);

            allResponse.setData(data);
            allResponse.setError_code(0);
            allResponse.setMessage("发送成功");

        } else {
            allResponse.setError_code(1);
            allResponse.setMessage(body.getMessage());
        }

        return JSON.toJSONString(allResponse);
    }

    @PostMapping("/login/phone")        //验证短信验证码
    @ResponseBody
    public String loginWithPhoneCode(@RequestParam("phone") String phone, @RequestParam("code") String code, @RequestHeader("ticket") String ticket, @RequestHeader("domain") String domain, @RequestHeader("Cookie") String Cookie) {

        Response allResponse = new Response();

        if (ticket == null || domain == null) {
            allResponse.setError_code(5);
            allResponse.setMessage("不可访问");
            return JSON.toJSONString(allResponse);
        }

        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String url = DOMAIN + "api/auth/phone";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        headers.add("ticket",ticket);
        headers.add("domain",domain);
        headers.add("Cookie",Cookie);

        MultiValueMap<String,String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("phone",phone);
        paramMap.add("code",code);

        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(paramMap,headers);
        ResponseEntity response = restTemplate.postForEntity(url,request,String.class);

        LoginResponse body = JSON.parseObject((String) response.getBody(),LoginResponse.class);

        int error_code = body.getError_code();

        if (error_code == 0) {

            allResponse.setError_code(0);
            allResponse.setMessage("登录成功");

            String token = body.getResult().getToken();     //登录成功获取的token
            String userNumber = body.getResult().getUserNumber();

            Map<String,Object> data = new HashMap<>();
            data.put("token",token);
            data.put("userNumber",userNumber);

            allResponse.setData(data);


        } else {
            allResponse.setError_code(1);
            allResponse.setMessage(body.getMessage());
        }

        return JSON.toJSONString(allResponse);
    }

}
