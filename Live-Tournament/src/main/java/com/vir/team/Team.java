package com.vir.team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

/**
 * Servlet implementation class Team
 */

@WebServlet("/team/*")
public class Team extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	class TeamModel
	{
		public int Id;
		public String TeamName;
		public String TeamDescription;
		public int CreatedBy;
		public Date CreatedOn;
		public boolean isDeleted;
		
		public TeamModel(int Id,String TeamName, String TeamDescription,int CreatedBy, Date CreatedOn,boolean isDeleted)
		{
			this.Id = Id;
			this.TeamName = TeamName;
			this.TeamDescription = TeamDescription;
			this.CreatedBy = CreatedBy;
			this.CreatedOn = CreatedOn;
			this.isDeleted = isDeleted;
			
		}
	}
	
	private Gson gson = null;
	
	
    public Team() throws Exception {
        super();
        gson = new Gson();
        
        
        
        
    }
    
    private Connection connection() throws Exception
    {
    	Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/subash", "root", "test123$");
		return con;
    	
    }
    
    private void sendAsJson(
    		HttpServletResponse response, 
    		Object obj) throws IOException {
    		
//	    	response.setHeader("Access-Control-Allow-Origin", "*");
//			response.setHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST, DELETE");
//			response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With,Access-Control-Allow-Origin");
//			response.setContentType("application/json");
//			response.setStatus(HttpServletResponse.SC_OK);
    		
    		String res = gson.toJson(obj);
    		     
    		PrintWriter out = response.getWriter();
    		  
    		out.print(res);
    		out.println();
    		out.flush();
    	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
		String pathInfo = request.getPathInfo();
		TeamModel team = null;
		Connection con = connection();
		Statement st = con.createStatement();
		

		if(pathInfo == null || pathInfo.equals("/")){
			
			String getQuery = "SELECT Id, TeamName, TeamDescription, CreatedBy, CreatedOn FROM tbl_team where isDeleted = 0";
				
			// execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery(getQuery);
		    List<TeamModel> teamList= new ArrayList<TeamModel>();  
		    // iterate through the java resultset
//		    System.out.println(rs);
		    while (rs.next())
		    {
		        int Id = rs.getInt("Id");
		        String TeamName = rs.getString("TeamName");
		        String TeamDescription = rs.getString("TeamDescription");
		        int CreatedBy = rs.getInt("CreatedBy");
		        Date CreatedOn = rs.getTimestamp("CreatedOn");
		        boolean isDeleted = false;
		        
		        //System.out.format("%d, %s, %s, %d, %s\n",Id, TeamName, TeamDescription, CreatedBy, CreatedOn);
		        team = new TeamModel(Id, TeamName, TeamDescription, CreatedBy, CreatedOn,isDeleted);
		        teamList.add(team);
		        
		        
				
		        
		        
		    }
		    sendAsJson(response, teamList);
			
		}
		String[] splits = pathInfo.split("/");
		
		if(splits.length != 2) {
			
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String Id = splits[1];
		String IdQuery = "Select Id, TeamName, TeamDescription, CreatedBy, CreatedOn from tbl_team where Id = '"+Id+"' and isDeleted = 0";
		ResultSet rs = st.executeQuery(IdQuery);
		while (rs.next())
	    {
	        
	        String TeamName = rs.getString("TeamName");
	        String TeamDescription = rs.getString("TeamDescription");
	        Date CreatedOn = rs.getDate("CreatedOn");
	        int CreatedBy = rs.getInt("CreatedBy");
	        boolean isDeleted = false;
	        team = new TeamModel(Integer.parseInt(Id), TeamName, TeamDescription, CreatedBy, CreatedOn,isDeleted);
	        
	        
	    }
		
		if(Id == null) {
			
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		sendAsJson(response, team);
		return;
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
		String pathInfo = request.getPathInfo();
		PrintWriter out = response.getWriter();
		
		Connection con = connection();

		if(pathInfo == null || pathInfo.equals("/")){

			StringBuilder buffer = new StringBuilder();
		    BufferedReader reader = request.getReader();
		    String line;
		    while ((line = reader.readLine()) != null) {
		        buffer.append(line);
		    }
//		    Calendar calendar = Calendar.getInstance();
//		    Timestamp ourJavaTimestampObject = new Timestamp(calendar.getTime().getTime());
		    String payload = buffer.toString();
		    
		    TeamModel team = gson.fromJson(payload, TeamModel.class);
		    try {
		    String insertQuery = "Insert into tbl_team(TeamName,TeamDescription,CreatedBy) values(?,?,?)";
		    PreparedStatement st = con.prepareStatement(insertQuery);
		    System.out.println(team.TeamName);
		    st.setString(1,team.TeamName);
		    st.setString(2,team.TeamDescription);
		    st.setInt(3, team.CreatedBy);
//		    st.setTimestamp(4, ourJavaTimestampObject);
		    
		    st.execute();
		    }catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
				}
//		    sendAsJson(response, team);
		    out.print("Successfully Inserted");
		    
		}
		else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
	}catch (Exception e) {
		
		e.printStackTrace();
		}
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			Enumeration<String> headerNames = request.getHeaderNames();

		    if (headerNames != null) {
//		            while (headerNames.hasMoreElements()) {
//		                    System.out.println("Header: " + request.getHeader(headerNames.nextElement()));
//		            }
		    	
		    	String tokenid = request.getHeader("Authorization");
		    	System.out.println(tokenid);
		    }
			
		Connection con = connection();
		String pathInfo = request.getPathInfo();
		PrintWriter out = response.getWriter();
		
		

		if(pathInfo == null || pathInfo.equals("/")){

			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String[] splits = pathInfo.split("/");
		
		if(splits.length != 2) {
			
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String Id = splits[1];
		
		String checkQuery = "select Id from tbl_team where Id = '"+Id+"'";
		PreparedStatement st = con.prepareStatement(checkQuery);
		
		ResultSet rs=st.executeQuery();
//		boolean recordAdded = false;
	    while(!rs.next()){            
//	         recordAdded = true;
//	         response.sendError(HttpServletResponse.SC_NOT_FOUND);
	         out.print("Id doesn't exists");
			 return;
	    }

		StringBuilder buffer = new StringBuilder();
	    BufferedReader reader = request.getReader();
	    String line;
	    while ((line = reader.readLine()) != null) {
	        buffer.append(line);
	    }
	    
	    String payload = buffer.toString();
	    
	    TeamModel team = gson.fromJson(payload, TeamModel.class);
	    String updateQuery = "update tbl_team set TeamName=?,TeamDescription=?,CreatedBy=? where Id='"+Id+"'";
		st = con.prepareStatement(updateQuery);
		st.setString(1,team.TeamName);
		st.setString(2,team.TeamDescription);
		st.setInt(3, team.CreatedBy);
		st.execute();
		
		rs = st.executeQuery("select Id, TeamName, TeamDescription, CreatedBy, CreatedOn,isDeleted from tbl_team where Id= '"+Id+"'");
		while (rs.next())
	    {
	        
	        String TeamName = rs.getString("TeamName");
	        String TeamDescription = rs.getString("TeamDescription");
	        Date CreatedOn = rs.getDate("CreatedOn");
	        int CreatedBy = rs.getInt("CreatedBy");
	        boolean isDeleted = rs.getBoolean("isDeleted");
	        team = new TeamModel(Integer.parseInt(Id), TeamName, TeamDescription, CreatedBy, CreatedOn,isDeleted);
	        
	        
	    }
		
	    
	    
	    sendAsJson(response, team);
		}catch (Exception e) {
			
			e.printStackTrace();
			}
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Connection con = connection();
		String pathInfo = request.getPathInfo();
		PrintWriter out = response.getWriter();
		

		if(pathInfo == null || pathInfo.equals("/")){

			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String[] splits = pathInfo.split("/");
		
		if(splits.length != 2) {
			
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String Id = splits[1];
		
		String checkQuery = "select Id, isDeleted from tbl_team where Id = '"+Id+"' and isDeleted = 0";
		PreparedStatement st = con.prepareStatement(checkQuery);
		
		ResultSet rs=st.executeQuery();
//		boolean recordAdded = false;
	    while(!rs.next()){            
//	         recordAdded = true;
//	         response.sendError(HttpServletResponse.SC_NOT_FOUND);
	         out.print("Id doesn't exists");
			 return;
	    }
	    
	    
	    String deleteQuery = "update tbl_team set isDeleted = 1 where Id ='"+Id+"'";
	    st = con.prepareStatement(deleteQuery);
	    st.execute();
	    out.print("Deleted Successfully");
	    
	    
	    
	    
		}catch (Exception e) {
			
			e.printStackTrace();
			}

	}

}
