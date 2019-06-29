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


import com.example.demo.entity.Student;



@Mapper
public interface StudentRepository {
	
	@Results(id="studentMap", value={ 
    @Result(property = "id", column = "id",  jdbcType=JdbcType.INTEGER), 
    @Result(property = "studentname", column = "studentname"),
	})

	@Select("select * from student") 
	public List<Student> findAll();
	
	
	@Insert("insert into student(id,studentname) "
			+ "values(#{id}, #{studentname}")
	public int add(Student student);
	
	@Select("select * from student where id = #{id} limit 1")
	@ResultMap(value="studentMap")			
	public Student findById(@Param("id")int id);
	
	
	@Delete("delete from student where id=#{id}")
	public int delete(Integer id);

	
	
	
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