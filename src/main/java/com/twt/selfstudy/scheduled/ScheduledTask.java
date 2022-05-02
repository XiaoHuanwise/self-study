package com.twt.selfstudy.scheduled;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.twt.selfstudy.pojo.entity.Redis;
import com.twt.selfstudy.pojo.entity.Term;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledTask {

    @Scheduled(cron = "0 0 3 * * ?")
    public void scheduledDaily (){

        Redis.clearRedis();     //清除缓存

    }

//    @Scheduled(cron = "0 0 3 1 2,8 ?")
//    public void getTerm(){
//
//
//
//        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
//
//        String url = "https://api.twt.edu.cn/api/semester";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//
//        String ticket = "bGVtb24uN2E4NThmZjMyNjI4ODQzMDQzNTI0YjcyOWNlZGZhYTcwNjIzZWZjOQ==";
//        String domain = "selfstudy.twt.edu.cn";
//
//        headers.add("ticket",ticket);
//        headers.add("domain",domain);
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null,headers);
//
//        ResponseEntity<String> response = restTemplate.postForEntity(url,request,String.class);
//
//        JSONObject responseBody = JSON.parseObject(response.getBody());
//        Integer errorCode = responseBody.getInteger("error_code");
//
//        if (errorCode != 0) {
//            System.out.println("获取学期信息异常");
//            System.out.println(responseBody.getString("message"));
//        } else {
//            JSONObject bodyResult = responseBody.getJSONObject("result");
//            Term.setTerm(bodyResult.getString("semesterName"));
//            Term.setCurrentYear(Term.getTerm());
//        }
//
//    }
}
