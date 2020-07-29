package com.vir.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.vir.model.User;


@WebServlet("/users")
public class UserServlet extends HttpServlet{
	
//	private UserService ser = new UserService();
	
	private Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
//		List<User> users = new ArrayList<>();
		String name = (String) request.getAttribute("name");
		String givenName = (String) request.getAttribute("givenName");
		String familyName = (String) request.getAttribute("familyName");
		String email = (String) request.getAttribute("email");
		User user = new User();
		user.setName(name);
		user.setGivenName(givenName);
		user.setFamilyName(familyName);
		user.setEmail(email);
		
		
		
		String userJSON = gson.toJson(user);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(userJSON);
		out.close();
		
		
		
	}
	
	

}
