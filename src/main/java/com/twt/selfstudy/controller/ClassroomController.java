package com.twt.selfstudy.controller;

import com.alibaba.fastjson.JSON;
import com.twt.selfstudy.pojo.entity.*;
import com.twt.selfstudy.service.BuildingService;
import com.twt.selfstudy.service.ClassService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class ClassroomController {

    @Resource
    ClassService classService;

    @RequestMapping("/getDayData/{term}/{week}/{day}")
    @ResponseBody
    public String getDayData(@PathVariable("term") String term, @PathVariable("week") String week, @PathVariable("day") String day){

        List<ClassroomStatus> classroomStatusList = classService.getClassroomStatus(term,week,day);

        List<Map<String,Object>> data = new ArrayList<>();
        Map<String,Object> response = new HashMap<>();

        if (classroomStatusList.isEmpty()) {

            response.put("error_code",2);
            response.put("message","拉取数据为空");
            response.put("data",data);
            return JSON.toJSONString(response);

        }

        String current_building_id = "";
        HashMap<String,Object> Building = null;
        List<Map<String,Object>> areas = null;
        HashMap<String,Object> area = null;
        List<Map<String,Object>> classrooms = null;
        for (ClassroomStatus classroom_status: classroomStatusList) {

            if (classroom_status.getBuildingId().equals("1084") || classroom_status.getBuildingId().equals("1085") || classroom_status.getBuildingId().equals("1096") || classroom_status.getBuildingId().equals("1101") || classroom_status.getBuildingId().equals("1099") || classroom_status.getBuildingId().equals("1100") || classroom_status.getBuildingId().equals("1095")){
                continue;   //跳过26 33 44 45 46 50，后面单独处理
            }

            if (!classroom_status.getBuildingId().equals(current_building_id)) {

                if (Building != null) {

                    area.put("area_id","-1");
                    area.put("classrooms",classrooms);
                    areas.add(area);
                    Building.put("areas",areas);
                    data.add(Building);

                }

                current_building_id = classroom_status.getBuildingId();
                Building = new HashMap<>();
                Building.put("building_id",current_building_id);
                Building.put("building", classroom_status.getBuilding());
                Building.put("campus_id", classroom_status.getCampusId());

                areas = new ArrayList<>();
                area = new HashMap<>();
                classrooms = new ArrayList<>();

            }

            HashMap<String,Object> classroom = new HashMap<>();
            classroom.put("classroom_id",classroom_status.getClassroomId());
            classroom.put("status",classroom_status.getStatus());
            String room = classroom_status.getClassroom();
            String room_id = room.substring(room.length()-3,room.length());
            classroom.put("classroom",room_id);

            classrooms.add(classroom);

        }

        area.put("area_id","-1");
        area.put("classrooms",classrooms);
        areas.add(area);
        Building.put("areas",areas);
        data.add(Building);

        //处理44 45 26 46 33 50
        List<Map<String,Object>> classrooms33 = new ArrayList<>();  //33教教室清单
        List<Map<String,Object>> classrooms26A = new ArrayList<>();  //26A教教室清单
        List<Map<String,Object>> classrooms26B = new ArrayList<>();  //26B教教室清单
        List<Map<String,Object>> classrooms44A = new ArrayList<>();  //44教A教室清单
        List<Map<String,Object>> classrooms44B = new ArrayList<>();  //44教B教室清单
        List<Map<String,Object>> classrooms45 = new ArrayList<>();  //45教教室清单
        List<Map<String,Object>> classrooms46 = new ArrayList<>();  //46教教室清单
        List<Map<String,Object>> classrooms50A = new ArrayList<>();  //50教A教室清单
        List<Map<String,Object>> classrooms50B = new ArrayList<>();  //50教B教室清单

        HashMap<String,Object> building33 = new HashMap<>();    //33教
        HashMap<String,Object> building26 = new HashMap<>();    //26教
        HashMap<String,Object> building44 = new HashMap<>();    //44教
        HashMap<String,Object> building45 = new HashMap<>();    //45教
        HashMap<String,Object> building46 = new HashMap<>();    //46教
        HashMap<String,Object> building50 = new HashMap<>();    //50教

        Map<String,Object> area33 = new HashMap<>();
        Map<String,Object> area26A = new HashMap<>();
        Map<String,Object> area26B = new HashMap<>();
        Map<String,Object> area44A = new HashMap<>();
        Map<String,Object> area44B = new HashMap<>();
        Map<String,Object> area45 = new HashMap<>();
        Map<String,Object> area46 = new HashMap<>();
        Map<String,Object> area50A = new HashMap<>();
        Map<String,Object> area50B = new HashMap<>();

        building33.put("building_id","1096");
        building33.put("building","33楼");
        building33.put("campus_id", "2");

        building26.put("building_id","1084");
        building26.put("building","26楼");
        building26.put("campus_id", "1");

        building44.put("building_id","1099");
        building44.put("building","44楼");
        building44.put("campus_id", "2");

        building45.put("building_id","1105");
        building45.put("building","45楼");
        building45.put("campus_id", "2");

        building46.put("building_id","1106");
        building46.put("building","46楼");
        building46.put("campus_id", "2");

        building50.put("building_id","1095");
        building50.put("building","50楼");
        building50.put("campus_id", "2");

        for (ClassroomStatus classroomStatus: classroomStatusList) {

            String room = classroomStatus.getClassroom();
            String room_id = room.substring(room.length()-3,room.length());


            HashMap<String,Object> Classroom = new HashMap<>();
            Classroom.put("classroom_id",classroomStatus.getClassroomId());
            Classroom.put("classroom",room_id);
            Classroom.put("status",classroomStatus.getStatus());

            if (classroomStatus.getBuildingId().equals("1100")){  //45或46教

                char area_id = room.charAt(1);

                if (area_id == '5')     //45教
                    classrooms45.add(Classroom);
                else                    //46教
                    classrooms46.add(Classroom);

            } else if (classroomStatus.getBuildingId().equals("1099")) {  //44教

                char area_id = room.charAt(3);

                if (area_id == 'A')                 //44A
                    classrooms44A.add(Classroom);
                else                                //44B
                    classrooms44B.add(Classroom);

            } else if (classroomStatus.getBuildingId().equals("1101") || classroomStatus.getBuildingId().equals("1096"))

                classrooms33.add(Classroom);

            else if (classroomStatus.getBuildingId().equals("1084")){

                classrooms26A.add(Classroom);

            } else if (classroomStatus.getBuildingId().equals("1085"))
                classrooms26B.add(Classroom);
            else if (classroomStatus.getBuildingId().equals("1095")) {  //50教

                char area_id = room.charAt(3);

                if (area_id == 'A')                 //50A
                    classrooms50A.add(Classroom);
                else                                //50B
                    classrooms50B.add(Classroom);

            }
        }
        area26A.put("area_id","A");
        area26A.put("classrooms",classrooms26A);
        area26B.put("area_id","B");
        area26B.put("classrooms",classrooms26B);
        area33.put("area_id","-1");
        area33.put("classrooms",classrooms33);
        area44A.put("area_id","A");
        area44A.put("classrooms",classrooms44A);
        area44B.put("area_id","B");
        area44B.put("classrooms",classrooms44B);
        area45.put("area_id","B");
        area45.put("classrooms",classrooms45);
        area46.put("area_id","A");
        area46.put("classrooms",classrooms46);
        area50A.put("area_id","A");
        area50A.put("classrooms",classrooms50A);
        area50B.put("area_id","B");
        area50B.put("classrooms",classrooms50B);

        List<Map<String,Object>> areas26 = new ArrayList<>();
        List<Map<String,Object>> areas33 = new ArrayList<>();
        List<Map<String,Object>> areas44 = new ArrayList<>();
        List<Map<String,Object>> areas45 = new ArrayList<>();
        List<Map<String,Object>> areas46 = new ArrayList<>();
        List<Map<String,Object>> areas50 = new ArrayList<>();

        areas26.add(area26A);
        areas26.add(area26B);
        areas33.add(area33);
        areas44.add(area44A);
        areas44.add(area44B);
        areas45.add(area45);
        areas46.add(area46);
        areas50.add(area50A);
        areas50.add(area50B);

        building26.put("areas",areas26);
        building33.put("areas",areas33);
        building44.put("areas",areas44);
        building45.put("areas",areas45);
        building46.put("areas",areas46);
        building50.put("areas",areas50);

        data.add(building26);
        data.add(building33);
        data.add(building44);
        data.add(building45);
        data.add(building46);
        data.add(building50);

//        List<Map<String,Object>> mapList = new ArrayList<>();
//        HashMap<String,Object> map = null;
//        for (int i = 0; i < 5; i++) {
//
//            if (i == 0 || i == 2 || i == 3) {
//
//                if (map != null) {
//                    mapList.add(map);
//                }
//                map = new HashMap<>();
//                map.put("111",111);
//                map.put("222",222);
//
//                List<Integer> list = new ArrayList<>();
//                list.add(i+1);
//                list.add(i+2);
//
//                map.put("list",list);
//
//            }
//
//        }
//
//        mapList.add(map);

        response.put("error_code",0);
        response.put("message","拉取成功");
        response.put("data",data);

        return JSON.toJSONString(response);
    }

    @RequestMapping("/getWeekData/{term}/{week}/{classroom_id}")
    @ResponseBody
    public String getWeekData(@PathVariable("term") String term, @PathVariable("week") String week, @PathVariable("classroom_id") String classroom_id){

        Map<String,Object> allResponse = new HashMap<>();

        List<ClassroomDayData> classroomDayDataList = classService.getClassroomDayData(term,week,classroom_id);

        if (classroomDayDataList.isEmpty()) {
            allResponse.put("error_code",1);
            allResponse.put("message","拉取数据为空");
            allResponse.put("data",null);
            return JSON.toJSONString(allResponse);
        }

        List<Map<String,Object>> data = new ArrayList<>();

        for (ClassroomDayData classroomDayData: classroomDayDataList) {
            Map<String,Object> classroom = new HashMap<>();
            classroom.put("day",Integer.parseInt(classroomDayData.getDay()));
            classroom.put("status",classroomDayData.getStatus());
            data.add(classroom);
        }

        allResponse.put("data",data);
        allResponse.put("error_code",0);
        allResponse.put("message","获取成功");

        return JSON.toJSONString(allResponse);
    }

}
