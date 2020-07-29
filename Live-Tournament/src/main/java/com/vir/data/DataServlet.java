package com.vir.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vir.model.User;




@WebServlet("/data")
public class DataServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		String name = (String) req.getAttribute("name");
		String givenName = (String) req.getAttribute("givenName");
		String familyName = (String) req.getAttribute("familyName");
		String email = (String) req.getAttribute("email");
		
		
		PrintWriter out = res.getWriter();
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/subash", "root", "test123$");
		    Calendar calendar = Calendar.getInstance();
		    Timestamp ourJavaTimestampObject = new Timestamp(calendar.getTime().getTime());
		    String updateQuery = "select Email from tbl_user where Email ='"+email+"'";
		    String insertQuery = "insert into tbl_user(UserName,FirstName,LastName,Email,CreatedOn) values(?,?,?,?,?)";
		    String updateValues = "update tbl_user set UserName=?,FirstName=?,LastName=?,CreatedOn =? where Email='"+email+"'";
		    Statement stmt = con.createStatement();
		   
		    
			ResultSet rs = stmt.executeQuery(updateQuery);
		    int userId = 0;
			if(rs.next())
			{

				//System.out.println(updateValues);
			   
		        PreparedStatement st = con.prepareStatement(updateValues);
				st.setString(1, name); 
			    st.setString(2, givenName);
			    st.setString(3, familyName);
			    st.setTimestamp(4, ourJavaTimestampObject);
		        st.execute();	
			}
			else
			{
				//System.out.println(insertQuery);
			 	PreparedStatement st = con.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
		        st.setString(1, name); 
			    st.setString(2, givenName);
			    st.setString(3, familyName);
			    st.setString(4, email);
			    st.setTimestamp(5, ourJavaTimestampObject);
		        st.execute();
		        rs = st.getGeneratedKeys();
		        if (rs.next()) {
				    userId = rs.getInt(1);
				}
			}
			
			
			
			//System.out.println(userId);
		
			if(userId != 0) {
			
			String roleQuery = "select Id from tbl_role where RoleName = 'User'";
			 
			rs = stmt.executeQuery(roleQuery);
			int roleId = 0;
			if (rs.next()) {
			    roleId = rs.getInt("Id");
			}
			
			
			String userRoleQuery = "insert into tbl_user_role (UserId,RoleId) values(?,?)";
			PreparedStatement st = con.prepareStatement(userRoleQuery);
			st.setInt(1, userId);
			st.setInt(2, roleId);
			st.executeUpdate();	
			}
			
			
	        con.close(); 
	        
	        
	        
	        req.setAttribute("name", name);
	    	req.setAttribute("email", email);
	    	req.setAttribute("givenName", givenName);
	    	req.setAttribute("familyName", familyName);
	    	
	    	RequestDispatcher rd  = req.getRequestDispatcher("users");
	    	rd.forward(req,res); 
		  }
		  catch (SQLException | ClassNotFoundException e) {
			  out.println("SQLException caught: " +e.getMessage());
		} 
		
		
		
	}

}
