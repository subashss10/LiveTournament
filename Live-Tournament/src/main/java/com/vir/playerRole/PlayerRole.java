package com.vir.playerRole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


/**
 * Servlet implementation class Player
 */

@WebServlet("/playerrole/*")
public class PlayerRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
	class PlayerRoleModel
	{
		public int Id;
		public String PlayerRole;
		public int CreatedBy;
		public Date CreatedOn;
		
		public PlayerRoleModel(int Id,String PlayerRole,int CreatedBy, Date CreatedOn)
		{
			this.Id = Id;
			this.PlayerRole = PlayerRole;
			this.CreatedBy = CreatedBy;
			this.CreatedOn = CreatedOn;
			
		}
	}
	
	private Gson gson = null;
	
	
    public PlayerRole() throws Exception {
        super();
        gson = new Gson();
        
        
        
        
    }
    
    private Connection connection() throws Exception
    {
    	Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/subash", "root", "test123$");
		return con;
    	
    }
    
    private void sendAsJson(HttpServletResponse response, Object obj) throws IOException {
    		
    		response.setContentType("application/json");
    		
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
		PlayerRoleModel playerRole = null;
		Connection con = connection();
		Statement st = con.createStatement();
		PrintWriter out = response.getWriter();
		

		if(pathInfo == null || pathInfo.equals("/")){
			
			String getQuery = "SELECT * FROM tbl_player_role";
				
			// execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery(getQuery);
		      
		    // iterate through the java resultset
//		    System.out.println(rs);
		    while (rs.next())
		    {
		        int Id = rs.getInt("Id");
		        String PlayerRole = rs.getString("PlayerRole");
		        int CreatedBy = rs.getInt("CreatedBy");
		        Date CreatedOn = rs.getTimestamp("CreatedOn");
		        
		        //System.out.format("%d, %s, %s, %d, %s\n",Id, TeamName, TeamDescription, CreatedBy, CreatedOn);
		        playerRole = new PlayerRoleModel(Id, PlayerRole, CreatedBy, CreatedOn);
		        sendAsJson(response, playerRole);     
		    }
		    return;
			
		}
		String[] splits = pathInfo.split("/");
		
		if(splits.length != 2) {
			
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String Id = splits[1];
		String checkQuery = "select Id from tbl_player_role where Id = '"+Id+"'";
		st = con.prepareStatement(checkQuery);
		
		ResultSet rs=st.executeQuery(checkQuery);
//		boolean recordAdded = false;
	    while(!rs.next()){            
//	         recordAdded = true;
//	         response.sendError(HttpServletResponse.SC_NOT_FOUND);
	         out.print("Id doesn't exists");
			 return;
	    }
	    
	    
		String IdQuery = "Select * from tbl_player_role where Id = '"+Id+"'";
		rs = st.executeQuery(IdQuery);
		while (rs.next())
	    {
	        
	        String PlayerRole = rs.getString("PlayerRole");
	        Date CreatedOn = rs.getDate("CreatedOn");
	        int CreatedBy = rs.getInt("CreatedBy");
	        playerRole = new PlayerRoleModel(Integer.parseInt(Id), PlayerRole, CreatedBy, CreatedOn);
	        
	        
	    }
		
		
		
		sendAsJson(response, playerRole);
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
		    
		    PlayerRoleModel playerRole = gson.fromJson(payload, PlayerRoleModel.class);
		    try {
		    String insertQuery = "Insert into tbl_player_role(PlayerRole,CreatedBy) values(?,?)";
		    PreparedStatement st = con.prepareStatement(insertQuery);
		    System.out.println(playerRole.PlayerRole);
		    st.setString(1,playerRole.PlayerRole);
		    st.setInt(2, playerRole.CreatedBy);
//		    st.setTimestamp(4, ourJavaTimestampObject);
		    st.execute();
		    out.print("Successfully Inserted");
		    
		    
		    }catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
				}
//		    sendAsJson(response, team);
		    
		    
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
		
		String checkQuery = "select Id from tbl_player_role where Id = '"+Id+"'";
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
	    
	    PlayerRoleModel playerRole = gson.fromJson(payload, PlayerRoleModel.class);
	    String updateQuery = "update tbl_player_role set PlayerRole=?,CreatedBy=? where Id='"+Id+"'";
		st = con.prepareStatement(updateQuery);
		st.setString(1,playerRole.PlayerRole);
		st.setInt(2, playerRole.CreatedBy);
		st.execute();
		
		rs = st.executeQuery("select * from tbl_player_role where Id= '"+Id+"'");
		while (rs.next())
	    {
	        
	        String PlayerRole = rs.getString("PlayerRole");
	        Date CreatedOn = rs.getDate("CreatedOn");
	        int CreatedBy = rs.getInt("CreatedBy");
	        playerRole = new PlayerRoleModel(Integer.parseInt(Id), PlayerRole, CreatedBy, CreatedOn);
	        
	        
	    }
		
	    
	    
	    sendAsJson(response, playerRole);
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
		
		String checkQuery = "select Id from tbl_player_role where Id = '"+Id+"'";
		PreparedStatement st = con.prepareStatement(checkQuery);
		
		ResultSet rs=st.executeQuery();
//		boolean recordAdded = false;
	    while(!rs.next()){            
//	         recordAdded = true;
//	         response.sendError(HttpServletResponse.SC_NOT_FOUND);
	         out.print("Id doesn't exists");
			 return;
	    }
	    
	    
	    String deleteQuery = "delete from tbl_player_role where Id ='"+Id+"'";
	    st = con.prepareStatement(deleteQuery);
	    st.execute();
	    out.print("Deleted Successfully");
	    
	    
	    
	    
		}catch (Exception e) {
			
			e.printStackTrace();
			}

	}
}
