package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface EmploeeMapper {
	
	@Select("select * from company where id=#{id}")
	Emploee getEmploeeByID(long id);
	
	@Insert("insert into (id, name, age, address, salary) values(#{id}, #{name}, #{age}, #{address}, #{salary})")
	int insert(Emploee emploee);
	
	@Update("update company set name=#{name}, age=#{age}, address=#{address}, salary=#{salary} where id=#{id}")
	int update(Emploee emploee);
	
	@Delete("delete from company where id=#{id}")
	int delete(long id);
	
	@Select("select * from company")
	List<Emploee>  getAllUsers();

}
