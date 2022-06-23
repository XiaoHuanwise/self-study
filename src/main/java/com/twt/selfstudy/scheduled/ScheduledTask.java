package com.twt.selfstudy.scheduled;

import com.twt.selfstudy.dao.ScheduledTaskDao;
import com.twt.selfstudy.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.twt.selfstudy.scheduled.Util.*;

@Component
public class ScheduledTask {
    private final ScheduledTaskDao scheduledTaskDao;

    @Autowired
    public ScheduledTask(ScheduledTaskDao scheduledTaskDao) {
        this.scheduledTaskDao = scheduledTaskDao;
    }

    @Scheduled(cron = "0 0 3 * * ?")
    public void scheduledDaily (){

        Redis.clearRedis();     //清除缓存

    }

    @Scheduled(cron = "0 0 2 * * ?")
    @Transactional
    public void calWeekTemp() {
        System.out.println(new Date());
        System.out.println("Update dao start.");

        getTermInfo();
        System.out.println("Term info has got.");

        scheduledTaskDao.deleteAllFixedOccupies();
        System.out.println("Old fixed_occupy has deleted.");

        List<String> classroomIdList = scheduledTaskDao.getClassroomId(Term.getCurrentYear());
        for (String classroomId : classroomIdList) {
            if (classroomId == null || classroomId.isEmpty()) {
                System.out.println("Found one null");
                continue;
            }

            for (EduOccupancy eduOccupancy : scheduledTaskDao.getEduOccupancy(Term.getCurrentYear(), classroomId)) {
                int courseStart = getStartCourseNum(eduOccupancy.getStartTime());
                int courseEnd = getEndCourseNum(eduOccupancy.getEndTime());
                int day = Integer.parseInt(eduOccupancy.getWeekday());
                String courseWeek;
                if (day == 7) {
                    courseWeek = eduOccupancy.getWeekState()
                            .substring(Term.getStartWeek(), Term.getStartWeek() + Term.getWeekLen() + 1);
                }
                else {
                    courseWeek = eduOccupancy.getWeekState()
                            .substring(Term.getStartWeek() - 1, Term.getStartWeek() + Term.getWeekLen());
                }
                FixedOccupy fixedOccupy = new FixedOccupy(Term.getTerm(), day, courseWeek, courseStart, courseEnd, classroomId);
                scheduledTaskDao.insertFixedOccupy(fixedOccupy);
            }
        }
        System.out.println("New fixed_occupy has founded.");

        calStatus();

        System.out.println(new Date());
        System.out.println("All done.");
    }

    public void getTermInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        Term.setCurrentYear(sdf.format(date));
        Term.setTerm(scheduledTaskDao.getTerm());
        Term.setStartWeek(scheduledTaskDao.getStartWeek());
        Term.setWeekLen(scheduledTaskDao.getWeekLen());
    }

    private void calStatus() {
        String sql;

        sql = "DELETE FROM edu_b_course_classroom WHERE classroom_id = 'sl001'";
        scheduledTaskDao.deleteFromSql(sql);

        sql = "DELETE FROM edu_b_course_classroom WHERE classroom_id IN ('2A407','2A409','2A411','4J109','4J110','4J111','4J112','4J113','4J114','4J115','4J116','4J117','4J205','4J206','4J207','4J208','4J209','4J210','4J211','4J212','4J213','4J214','4J215','LB401','LB402','LB404','LB501','LB502','LB503','LB505','LB506','SA217','ZH001','ZH002','ZH003','ZH004','ZH005','ZH006','ZH007','ZH008','ZH009','ZH010')";
        scheduledTaskDao.deleteFromSql(sql);

        sql = "DELETE FROM edu_b_teachbuilding WHERE building_id NOT IN('0015','0026','0032','1084','1085','1093','1094','1095','1096','1097','1098','1099','1100','1101','1102')";
        scheduledTaskDao.deleteFromSql(sql);

        sql = "DELETE FROM edu_b_course_classroom WHERE building_id NOT IN (SELECT building_id FROM edu_b_teachbuilding)";
        scheduledTaskDao.deleteFromSql(sql);

        scheduledTaskDao.deleteAllClassroomStatus();
        System.out.println("Old classroom_status has deleted.");

        List<Classroom> classroomList = scheduledTaskDao.getClassroom();
        for (Classroom classroom : classroomList) {
            String classroomId = classroom.getClassroomId();
            int[][][] status = getStatusByClassroom(scheduledTaskDao, classroomId);

            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 7; j++) {
                    StringBuilder stringStatus = new StringBuilder();
                    for (int k : status[i][j]) {
                        stringStatus.append(k);
                    }

                    ClassroomStatusforScheduled classroomStatusforScheduled = new ClassroomStatusforScheduled(
                            Term.getTerm(), classroomId, i + 1, j + 1, stringStatus.toString()
                    );
                    scheduledTaskDao.insertClassroomStatus(classroomStatusforScheduled);
                }
            }
        }
        System.out.println("New classroom_status has founded.");

        sql = "UPDATE edu_b_teachbuilding SET building = '55楼' WHERE building_id = '1093'";
        scheduledTaskDao.updateFromSql(sql);

        sql = "UPDATE edu_b_teachbuilding SET building = '43楼' WHERE building_id = '1094'";
        scheduledTaskDao.updateFromSql(sql);

        sql = "UPDATE edu_b_teachbuilding SET building = '50楼' WHERE building_id = '1095'";
        scheduledTaskDao.updateFromSql(sql);

        sql = "UPDATE edu_b_teachbuilding SET building = '33楼' WHERE building_id = '1096'";
        scheduledTaskDao.updateFromSql(sql);

        sql = "UPDATE edu_b_teachbuilding SET building = '31楼' WHERE building_id = '1097'";
        scheduledTaskDao.updateFromSql(sql);

        sql = "UPDATE edu_b_teachbuilding SET building = '32楼' WHERE building_id = '1098'";
        scheduledTaskDao.updateFromSql(sql);

        sql = "UPDATE edu_b_teachbuilding SET building = '44楼' WHERE building_id = '1099'";
        scheduledTaskDao.updateFromSql(sql);

        sql = "UPDATE edu_b_teachbuilding SET building = '45、46楼' WHERE building_id = '1100'";
        scheduledTaskDao.updateFromSql(sql);

        sql = "UPDATE edu_b_teachbuilding SET building = '33楼' WHERE building_id = '1101'";
        scheduledTaskDao.updateFromSql(sql);

        sql = "UPDATE edu_b_teachbuilding SET building = '37楼' WHERE building_id = '1102'";
        scheduledTaskDao.updateFromSql(sql);
    }
}
