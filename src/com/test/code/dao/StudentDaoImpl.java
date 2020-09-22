package com.test.code.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.code.model.Student;

public class StudentDaoImpl implements StudentDao {
	
	//this is an implementation class
	//here, we write all queries
	//this class is connect with the database
     
	 //take sql as a string
	 String sql;
	 //take connection
	 //create connection object
     Connection connection;	

     String url="jdbc:mysql://localhost:3306/stud_db?useTimezone=true&serverTimezone=UTC";
     String user="root";
     String pass="";

//this is connect method
//to open connection for execute query 
//it use in all queries     
public void connect() throws SQLException {
	if(connection == null || connection.isClosed()) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection = DriverManager.getConnection(url,user,pass);
	}
	
}

//this is disconnect method
//to close connection after execute query
//it use in all queries 
public void disconnect() throws SQLException {
	if(connection != null && !connection.isClosed()) {
		connection.close();
	}
	
}
	
    //this is insert method
	//to insert new data in database
	@Override
	public int insert(Student student) throws SQLException {
		sql = "insert into student(name, age, city, email) values(?,?,?,?)";
		connect();
		PreparedStatement statement  = connection.prepareStatement(sql);
	    statement.setString(1, student.getName());
	    statement.setString(2, student.getAge());
	    statement.setString(3, student.getCity());
	    statement.setString(4, student.getEmail());
	    int n = statement.executeUpdate();
		disconnect();
		return n;
	}

	//this is update method
	//to update data from database
	//it works on particular id
	@Override
	public int update(Student student) throws SQLException {
		sql = "update student set name = ?, age = ?, city = ?, email = ? where id = ?";
		connect();
		PreparedStatement statement  = connection.prepareStatement(sql);
	    statement.setString(1, student.getName());
	    statement.setString(2, student.getAge());
	    statement.setString(3, student.getCity());
	    statement.setString(4, student.getEmail());
	    statement.setInt(5, student.getId());
	    int n = statement.executeUpdate();
		disconnect();
		return n;
	}

	//this is delete method
	//to delete data from database
	//it also works on particular id
	@Override
	public int delete(int id) throws SQLException {
		sql = "delete from student where id = ?";
		connect();
		PreparedStatement statement  = connection.prepareStatement(sql);
	    statement.setInt(1, id);
	    int n = statement.executeUpdate();
		disconnect();
		return n;
	}

	//this is list method
	//it shows whole data from database in particular form
	//without list you can't perform other queries
    @Override
	public List<Student> listAll() throws SQLException {
		List<Student> studentList = new ArrayList<Student>();
		sql = "select * from student";
		connect();
		//create a statement using connection object
		Statement statement = connection.createStatement();
		//execute the query or update query
		ResultSet resultSet = statement.executeQuery(sql);
		
		//process the resultset object
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String age = resultSet.getString("age");
			String city = resultSet.getString("city");
			String email = resultSet.getString("email");
			Student student = new Student(id,name,age,city,email);
			studentList.add(student);
			}
		disconnect();
		return studentList;
		
		
	}

    //this is getbyid method
  	//it shows particular data from database 
  	//it works on particular id for update or delete data
	@Override
	public Student getById(int id) throws SQLException {
		sql = "select * from student where id = ?";
		connect();
		//create a statement using connection object
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		//execute the query or update query
		ResultSet resultSet = statement.executeQuery();
		Student student = null;
		
		//process the resultset object
		if(resultSet.next()) {
			int xid = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String age = resultSet.getString("age");
			String city = resultSet.getString("city");
			String email = resultSet.getString("email");
			student = new Student(xid,name,age,city,email);
		}
		disconnect();
		return student;
	}

}
