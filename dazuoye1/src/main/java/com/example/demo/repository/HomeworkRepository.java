package com.example.demo.repository;

import java.util.List;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;

import com.example.demo.entity.Homework;
import com.example.demo.entity.Teacher;

@Mapper
public interface HomeworkRepository {
	
	@Results(id="HomeworkMap", value={ 
    @Result(property = "id", column = "task_id",  jdbcType=JdbcType.INTEGER), 
    @Result(property = "opnum", column = "operation_num"),
    @Result(property = "stunum", column = "student_num"),
    @Result(property = "clas", column = "class"),
    @Result(property = "grade", column = "grade")
	})

	@Select("select * from t_task") 
	public List<Homework> findAll();

	
	@Select("select * from t_task where grade = #{grade}")
	@ResultMap(value="HomeworkMap")			
	public List<Homework> findByGrade(@Param("grade")String grade);

	@Select("select * from t_task where task_id = #{id} limit 1")
	@ResultMap(value="HomeworkMap")			
	public Homework findById(@Param("id")int id);
	
	
	@Insert("insert into t_task(task_id,operation_num,student_num,class,grade) "
			+ "values(#{id}, #{opnum}, #{stunum}, #{clas}, #{grade})")
	public int add(Homework homework);

	@Delete("delete from t_task where task_id=#{id}")
	public int delete(int id);
	
	@Update("update t_task set grade=#{grade} where task_id=#{id}")
	public int update(Homework homework);
	
	@Update("update t_task set grade=#{grade2} where task_id=#{id2}")
	public int update2(Homework homework);
}



/*
 * @Repository public class TeacherRepositort {
 * 
 * @Autowired private JdbcTemplate jdbcTemplate; public List<Teacher> findAll(){
 * return null; } public Teacher validTeacher(String account,String password) {
 * String
 * sql="select teacher_id as id,teacher_account as account,teacher_name as name from t_teacher where teacher_account=? and teacher_password=md5(?)"
 * ; RowMapper<Teacher> rowMapper=new
 * BeanPropertyRowMapper<Teacher>(Teacher.class); List<Teacher> list =
 * jdbcTemplate.query(sql, rowMapper,account,password); if (list != null &&
 * list.size()>0) { // System.out.println(list.get(0).getName()); return
 * list.get(0); }else return null; }
 * 
 * }
 */