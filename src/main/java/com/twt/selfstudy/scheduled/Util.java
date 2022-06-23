package com.twt.selfstudy.scheduled;

import com.twt.selfstudy.dao.ScheduledTaskDao;
import com.twt.selfstudy.entity.RawStatus;
import com.twt.selfstudy.entity.Term;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Util {

    static public int getStartCourseNum(String startTime) {
        //before 9:15 means class 1
        if (startTime.compareTo("920") <= 0 && startTime.length() <= 3) {
            return 1;
        } else if (startTime.compareTo("1010") <= 0){
            return 2;
        } else if (startTime.compareTo("1115") <= 0){
            return 3;
        } else if (startTime.compareTo("1200") <= 0){
            return 4;
        } else if (startTime.compareTo("1420") <= 0){
            return 5;
        } else if (startTime.compareTo("1525") <= 0){
            return 6;
        } else if (startTime.compareTo("1615") <= 0){
            return 7;
        } else if (startTime.compareTo("1700") <= 0){
            return 8;
        } else if (startTime.compareTo("1920") <= 0){
            return 9;
        } else if (startTime.compareTo("2010") <= 0){
            return 10;
        } else if (startTime.compareTo("2100") <= 0){
            return 11;
        } else {
            return 12;
        }
    }

    static public int getEndCourseNum(String endTime) {
        //same as start
        return getStartCourseNum(endTime);
    }

    static public int[][][] getStatusByClassroom(final ScheduledTaskDao scheduledTaskDao, String classroomId) {
        int[][][] res = new int[26][7][12];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 7; j++) {
                for (int k = 0; k < 12; k++) {
                    res[i][j][k] = 0;
                }
            }
        }

        List<RawStatus> rawStatusList = scheduledTaskDao.getRawStatus(classroomId, Term.getTerm());
        for (RawStatus rawStatus : rawStatusList) {
            int courseStart = rawStatus.getBeginCourse();
            int courseEnd = rawStatus.getEndCourse();
            int day = rawStatus.getDay();
            char[] courseWeek = rawStatus.getWeek().toCharArray();

            int weekStart = 0;
            int count = 0;
            for (char c : courseWeek) {
                if (weekStart == 0 && c == '1') {
                    weekStart = count;
                }
                if (c == '1') {
                    for (int i = courseStart - 1; i < courseEnd; i++) {
                        res[count][day - 1][i] = 1;
                    }
                }
                count++;
            }
        }

        return res;
    }

//Try to get term but api can not use
//    @Scheduled(cron = "0/20 * * * * ?")
//    public void getTerm() {
//        RestTemplate restTemplate = new RestTemplateBuilder().build();
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
//            System.out.println(bodyResult);
//            Term.setTerm(bodyResult.getString("semesterName"));
//            Term.setCurrentYear(Term.getTerm());
//        }
//    }
}
