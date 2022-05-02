package com.twt.selfstudy.controller;

import com.alibaba.fastjson.JSON;
import com.sun.javafx.collections.MappingChange;
import com.twt.selfstudy.pojo.entity.EduBCourseClassroom;
import com.twt.selfstudy.pojo.entity.EduBTeachbuilding;
import com.twt.selfstudy.pojo.entity.Redis;
import com.twt.selfstudy.service.BuildingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class BuildingController {

    @Resource
    BuildingService buildings;

    @RequestMapping("/getBuildingList")
    @ResponseBody
    public String getBuildList () {

        String redis = Redis.getRedisByKey("getBuildingList");
        if (!redis.isEmpty()) {
            return redis;
        }

        HashMap<String, Object> response = new HashMap<>();
        List<Map<String, Object>> data = new ArrayList<>();

        List<EduBTeachbuilding> allBuildings = buildings.getAllBuildings();
        List<EduBCourseClassroom> allClassrooms = buildings.getAllCourses();
        for (EduBTeachbuilding building: allBuildings) {
            String current_building_id = building.getBuildingId();
            if (current_building_id.equals("1084") || current_building_id.equals("1085") || current_building_id.equals("1099") || building.getBuildingId().equals("1100") || building.getBuildingId().equals("1101") || building.getBuildingId().equals("1096") || building.getBuildingId().equals("1095")){
                continue;
            }   //跳过26 44 45 46 33 50，后面单独处理

            HashMap<String,Object> Building = new HashMap<>();
            Building.put("building_id",current_building_id);
            Building.put("building", building.getBuilding());
            Building.put("campus_id", building.getCampusId());

            List<Map<String,Object>> classrooms = new ArrayList<>();
            for (EduBCourseClassroom classroom: allClassrooms) {
                if (classroom.getBuildingId().equals(current_building_id)){
                    HashMap<String,Object> Classroom = new HashMap<>();
                    Classroom.put("classroom_id", classroom.getClassroomId());
                    String room = classroom.getClassroom();
                    String room_id = room.substring(room.length()-3,room.length());
                    Classroom.put("classroom",room_id);
                    Classroom.put("capacity", classroom.getCapacity());
                    classrooms.add(Classroom);
                }
            }

            Map<String,Object> area = new HashMap<>();
            area.put("area_id", "-1");
            area.put("classrooms", classrooms);

            List<Map<String,Object>> areas = new ArrayList<>();
            areas.add(area);

            Building.put("areas", areas);

            data.add(Building);
        }

        //处理44 45 26 46 33 50
        List<Map<String,Object>> classrooms33 = new ArrayList<>();  //33教教室清单
        List<Map<String,Object>> classrooms26A = new ArrayList<>();  //26A教教室清单
        List<Map<String,Object>> classrooms26B = new ArrayList<>();  //26B教教室清单
        List<Map<String,Object>> classrooms44A = new ArrayList<>();  //44教A教室清单
        List<Map<String,Object>> classrooms44B = new ArrayList<>();  //44教B教室清单
        List<Map<String,Object>> classrooms45 = new ArrayList<>();  //45教教室清单
        List<Map<String,Object>> classrooms46 = new ArrayList<>();  //46教教室清单
        List<Map<String,Object>> classrooms50A = new ArrayList<>();  //50A教教室清单
        List<Map<String,Object>> classrooms50B = new ArrayList<>();  //50B教教室清单

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

        for (EduBCourseClassroom classroom: allClassrooms) {

            String room = classroom.getClassroom();
            String room_id = room.substring(room.length()-3,room.length());


            HashMap<String,Object> Classroom = new HashMap<>();
            Classroom.put("classroom_id",classroom.getClassroomId());
            Classroom.put("classroom",room_id);
            Classroom.put("capacity",classroom.getCapacity());

            if (classroom.getBuildingId().equals("1100")){  //45或46教

                char area_id = room.charAt(1);

                if (area_id == '5')     //45教
                    classrooms45.add(Classroom);
                else                    //46教
                    classrooms46.add(Classroom);

            } else if (classroom.getBuildingId().equals("1099")) {  //44教

                char area_id = room.charAt(3);

                if (area_id == 'A')                 //44A
                    classrooms44A.add(Classroom);
                else                                //44B
                    classrooms44B.add(Classroom);

            } else if (classroom.getBuildingId().equals("1101") || classroom.getBuildingId().equals("1096"))

                classrooms33.add(Classroom);

            else if (classroom.getBuildingId().equals("1084")){

                classrooms26A.add(Classroom);

            } else if (classroom.getBuildingId().equals("1085"))
                classrooms26B.add(Classroom);
            else if (classroom.getBuildingId().equals("1095")) {    //50教

                char area_id = room.charAt(3);

                if (area_id == 'A')     //50教A
                    classrooms50A.add(Classroom);
                else                    //50教B
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

        response.put("data",data);



        if (response.get("data") == null) {
            response.put("error_code", 1);
            response.put("message","拉取失败");
        } else {
            response.put("error_code", 0);
            response.put("message","拉取成功");
        }

        redis = JSON.toJSONString(response);
        Redis.setKeyValue("getBuildingList",redis);
        return redis;

    }

}
