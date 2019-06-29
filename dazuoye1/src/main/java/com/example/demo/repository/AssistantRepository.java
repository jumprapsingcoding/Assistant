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

import com.example.demo.entity.Assistant;



@Mapper
public interface AssistantRepository {
	
	@Results(id="assistantMap", value={ 
    @Result(property = "id", column = "assistant_id",  jdbcType=JdbcType.INTEGER), 
    @Result(property = "name", column = "assistantn_name"),
    @Result(property = "clas", column = "class"),
    @Result(property = "teachernum",column = "teachernum"),
    @Result(property = "grade", column = "grade")
	})

	@Select("select * from t_assistant") 
	public List<Assistant> findAll();
			
	@Select("select * from t_assistant where assistantn_name like concat('%',#{name},'%')")
	@ResultMap(value="assistantMap")			
	public List<Assistant> findByName(@Param("name")String name);

	@Select("select * from t_assistant where assistant_id = #{id} limit 1")
	@ResultMap(value="assistantMap")			
	public Assistant findById(@Param("id")int id);
	
	
	@Insert("insert into t_assistant(assistant_id,assistantn_name,class,teachernum,grade) "
			+ "values(#{id}, #{name}, #{clas}, #{teachernum}, #{grade})")
	public int add(Assistant assistant);

	@Delete("delete from t_assistant where assistant_id=#{id}")
	public int delete(Integer id);
	
	@Update("update t_assistant set grade=#{grade}  where assistant_id=#{id}")
	public int update(Assistant assistant);
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