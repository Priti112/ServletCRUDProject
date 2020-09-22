package com.test.code.dao;

import java.sql.SQLException;
import java.util.List;

import com.test.code.model.Student;

public interface StudentDao {
	
	
	//this is an interface
	//here, we can declare all methods
    //this all methods implements in implementation class to write queries
	int insert(Student student) throws SQLException;
	int update(Student student) throws SQLException;
	int delete(int id) throws SQLException;
	List<Student> listAll() throws SQLException;
	Student getById(int id) throws SQLException;

}
