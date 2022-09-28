package com.twt.selfstudy.controller;

import com.alibaba.fastjson.JSON;
import com.twt.selfstudy.entity.CollectionKey;
import com.twt.selfstudy.entity.LoginResponse;
import com.twt.selfstudy.entity.Response;
import com.twt.selfstudy.service.CollectionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class CollectionController {
    @Value("${app.domain}")
    private String DOMAIN;

    @Resource
    CollectionService collectionService;

    @PostMapping("/addCollection")      //添加收藏
    @ResponseBody
    public String addCollection(@RequestParam("classroom_id") String classroom_id, @RequestHeader("ticket") String ticket,@RequestHeader("domain") String domain,@RequestHeader("token") String token){

        Response allResponse = new Response();

        if (ticket == null || domain == null) {
            allResponse.setError_code(5);
            allResponse.setMessage("不可访问");
            return JSON.toJSONString(allResponse);
        }

        if (token == null) {
            allResponse.setError_code(7);
            allResponse.setMessage("请先登录");
        }

        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String url = DOMAIN + "api/user/single";
        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        headers.add("ticket",ticket);
        headers.add("domain",domain);
        headers.add("token",token);

        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(null,headers);  //无参数有header

        ResponseEntity response = restTemplate.exchange(url, HttpMethod.GET,request,String.class);
        LoginResponse body = JSON.parseObject((String) response.getBody(),LoginResponse.class);

        int error_code = body.getError_code();

        if (error_code == 40005) {
            allResponse.setError_code(8);
            allResponse.setMessage("请重新登录");
        } else if (error_code == 0) {

            String user_id = body.getResult().getUserNumber();

            int code = collectionService.insertCollection(user_id,classroom_id);

            if (code == 0) {
                allResponse.setMessage("收藏失败");
                allResponse.setError_code(1);
            } else if (code == 2) {
                allResponse.setMessage("请勿重复收藏");
                allResponse.setError_code(1);
            }else {
                allResponse.setError_code(0);
                allResponse.setMessage("收藏成功");
            }

        } else {
            allResponse.setError_code(1);
            allResponse.setMessage(body.getMessage());
        }

        return JSON.toJSONString(allResponse);

    }

    @GetMapping("/getCollections")      //获取收藏
    @ResponseBody
    public String getCollections(@RequestHeader("ticket") String ticket,@RequestHeader("domain") String domain,@RequestHeader("token") String token){

        Response allResponse = new Response();

        if (ticket == null || domain == null) {
            allResponse.setError_code(5);
            allResponse.setMessage("不可访问");
            return JSON.toJSONString(allResponse);
        }

        if (token == null) {
            allResponse.setError_code(7);
            allResponse.setMessage("请先登录");
        }

        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String url = DOMAIN + "api/user/single";
        HttpHeaders headers = new HttpHeaders();

        headers.add("ticket",ticket);
        headers.add("domain",domain);
        headers.add("token",token);

        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(null,headers);  //无参数有header

        ResponseEntity response = restTemplate.exchange(url, HttpMethod.GET,request,String.class);
        LoginResponse body = JSON.parseObject((String) response.getBody(),LoginResponse.class);

        int error_code = body.getError_code();

        if (error_code == 40005) {
            allResponse.setError_code(8);
            allResponse.setMessage("请重新登录");
        } else if (error_code == 0) {

            String user_id = body.getResult().getUserNumber();
            List<CollectionKey> collectionList = collectionService.selectCollections(user_id);

            if (collectionList.isEmpty()) {
                allResponse.setError_code(9);
                allResponse.setMessage("收藏列表为空");
                return JSON.toJSONString(allResponse);
            }

            List<String> classroom_id = new ArrayList<>();

            for (CollectionKey collection: collectionList) {
                classroom_id.add(collection.getClassroomId());
            }

            Map<String,Object> data = new HashMap<>();
            data.put("classroom_id",classroom_id);

            allResponse.setData(data);
            allResponse.setMessage("获取成功");

        } else {
            allResponse.setError_code(1);
            allResponse.setMessage(body.getMessage());
        }

        return JSON.toJSONString(allResponse);
    }

    @PostMapping("/deleteCollection")   //删除收藏
    @ResponseBody
    public String deleteCollection(@RequestParam("classroom_id") String classroom_id,@RequestHeader("ticket") String ticket,@RequestHeader("domain") String domain,@RequestHeader("token") String token){

        Response allResponse = new Response();

        if (ticket == null || domain == null) {
            allResponse.setError_code(5);
            allResponse.setMessage("不可访问");
            return JSON.toJSONString(allResponse);
        }

        if (token == null) {
            allResponse.setError_code(7);
            allResponse.setMessage("请先登录");
        }

        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        String url = DOMAIN + "api/user/single";
        HttpHeaders headers = new HttpHeaders();

        headers.add("ticket",ticket);
        headers.add("domain",domain);
        headers.add("token",token);

        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(null,headers);  //无参数有header

        ResponseEntity response = restTemplate.exchange(url, HttpMethod.GET,request,String.class);
        LoginResponse body = JSON.parseObject((String) response.getBody(),LoginResponse.class);

        int error_code = body.getError_code();

        if (error_code == 40005) {
            allResponse.setError_code(8);
            allResponse.setMessage("请重新登录");
        } else if (error_code == 0) {

            String user_id = body.getResult().getUserNumber();

            CollectionKey collectionKey = new CollectionKey();
            collectionKey.setClassroomId(classroom_id);
            collectionKey.setUserId(user_id);

            int code = collectionService.deleteCollection(collectionKey);

            if (code == 0) {
                allResponse.setError_code(10);
                allResponse.setMessage("无此收藏");
            } else {
                allResponse.setMessage("删除成功");
                allResponse.setError_code(0);
            }

        } else {
            allResponse.setError_code(1);
            allResponse.setMessage(body.getMessage());
        }

        return JSON.toJSONString(allResponse);

    }

}
