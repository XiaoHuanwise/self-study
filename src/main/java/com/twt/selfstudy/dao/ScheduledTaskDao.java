package com.twt.selfstudy.dao;

import com.twt.selfstudy.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ScheduledTaskDao {

    @Insert("INSERT INTO fixed_occupy (term, day, week, begin_course, end_course, classroom_id) VALUE " +
            "(#{fixedOccupy.term}, #{fixedOccupy.day}, #{fixedOccupy.week}, #{fixedOccupy.beginCourse}" +
            ", #{fixedOccupy.endCourse}, #{fixedOccupy.classroomId})")
    void insertFixedOccupy(@Param("fixedOccupy") FixedOccupy fixedOccupy);

    @Insert("INSERT INTO classroom_status (term,classroom_id,week,day,status) " +
            "VALUES (#{classroomStatus.term}, #{classroomStatus.classroomId}, #{classroomStatus.week}" +
            ", #{classroomStatus.day}, #{classroomStatus.status})")
    void insertClassroomStatus(@Param("classroomStatus") ClassroomStatusforScheduled classroomStatusforScheduled);

    @Delete("${sql}")
    void deleteFromSql(@Param("sql") String sql);

    @Delete("DELETE FROM fixed_occupy")
    void deleteAllFixedOccupies();

    @Delete("DELETE FROM classroom_status")
    void deleteAllClassroomStatus();

    @Update("${sql}")
    void updateFromSql(@Param("sql") String sql);

    @Select("SELECT term FROM term_info WHERE id=0")
    String getTerm();

    @Select("SELECT start_week FROM term_info WHERE id=0")
    int getStartWeek();

    @Select("SELECT week_len FROM term_info WHERE id=0")
    int getWeekLen();

    @Select("SELECT classroom_id FROM EDU_OCCUPANCIES WHERE year = #{currentYear} GROUP BY classroom_id")
    List<String> getClassroomId(String currentYear);

    @Results(
            id = "eduOccupancyMap",
            value = {
                    @Result(property = "classroomId", column = "classroom_id"),
                    @Result(property = "year", column = "year"),
                    @Result(property = "weekday", column = "weekday"),
                    @Result(property = "weekState", column = "week_state"),
                    @Result(property = "weekStateNum", column = "week_state_num"),
                    @Result(property = "startTime", column = "start_time"),
                    @Result(property = "endTime", column = "end_time"),
                    @Result(property = "id", column = "id", id = true)
            }
    )
    @Select("SELECT * FROM EDU_OCCUPANCIES  WHERE  year = #{currentYear} AND classroom_id = #{classroomId}")
    List<EduOccupancy> getEduOccupancy(@Param("currentYear") String currentYear, @Param("classroomId") String classroomId);

    @Results(
            id = "rawStatusMap",
            value = {
                    @Result(property = "week", column = "week"),
                    @Result(property = "beginCourse", column = "begin_course"),
                    @Result(property = "endCourse", column = "end_course"),
                    @Result(property = "day", column = "day")
            }
    )
    @Select("SELECT week,begin_course,end_course,day FROM edu_pg_course_time " +
            "WHERE classroom_id = #{classroomId} AND term = #{term} UNION " +
            "SELECT week,begin_course,begin_course + course_count - 1 AS end_course,day FROM edu_b_course_time " +
            "WHERE classroom_id = #{classroomId} AND term = #{term} UNION " +
            "SELECT week,begin_course,end_course,day FROM fixed_occupy " +
            "WHERE classroom_id = #{classroomId} AND term = #{term}")
    List<RawStatus> getRawStatus(@Param("classroomId") String classroomId, @Param("term") String term);

    @Results(
            id = "classroomMap",
            value = {
                    @Result(property = "classroomId", column = "classroom_id"),
                    @Result(property = "classroom", column = "classroom")
            }
    )
    @Select("SELECT classroom_id, classroom FROM edu_b_course_classroom")
    List<Classroom> getClassroom();
}
