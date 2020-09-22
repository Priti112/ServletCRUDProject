package com.test.code.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.code.dao.StudentDao;
import com.test.code.dao.StudentDaoImpl;
import com.test.code.model.Student;


@WebServlet("/")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentDao dao;   
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("action : " + action);
		
		try {
		switch(action) {
		case "/new" :
			showNewForm(request, response);
			break;
		case "/insert" :
			insertStudent(request, response);
			break;
		case "/delete" :
			deleteStudent(request, response);
			break;
		case "/edit" :
			showEditForm(request, response);
			break;
		case "/update":
		     updateStudent(request, response);
		     break;
		default :
				listStudent(request, response);
		}		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}
		
	//this is list method
	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		dao = new StudentDaoImpl();
		List<Student> list = dao.listAll();
		request.setAttribute("studentList", list);
		RequestDispatcher rd = request.getRequestDispatcher("StudentList.jsp");
		rd.forward(request, response);
		
	}

    //this is update method
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		
		Student student = new Student(id, name, age, city, email);
		dao = new StudentDaoImpl();
		dao.update(student);
		
		RequestDispatcher rd = request.getRequestDispatcher("list");
		rd.forward(request, response);
	}

    //this is edit method
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		dao = new StudentDaoImpl();
		Student student = dao.getById(id);
		request.setAttribute("student", student);
		request.setAttribute("action", "update");
		RequestDispatcher rd = request.getRequestDispatcher("StudentEntry.jsp");
		rd.forward(request, response);
		
	}

    //this is new method
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("action", "insert");
		RequestDispatcher rd = request.getRequestDispatcher("StudentEntry.jsp");
		rd.forward(request, response);
		
	}

    //this is delete method
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		dao = new StudentDaoImpl();
		dao.delete(id);
		RequestDispatcher rd = request.getRequestDispatcher("list");
		rd.forward(request, response);
		
	}

    //this is insert method
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		
		Student student = new Student(name, age, city, email);
		dao = new StudentDaoImpl();
		dao.insert(student);
		
		RequestDispatcher rd = request.getRequestDispatcher("list");
		rd.forward(request, response);
 		
	}

}
