package com.vir.player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;



/**
 * Servlet implementation class Player
 */

@WebServlet("/player/*")
public class Player extends HttpServlet {
	private static final long serialVersionUID = 1L;
	class PlayerModel
	{
		public int Id;
		public String PlayerName;
		public Date DOB;
		public String BattingStyle;
		public String BowlingStyle;
		public int TeamId;
		public int PlayerRoleId;
		public int CreatedBy;
		public Date CreatedOn;
		public boolean isDeleted;
		public String LogoPath;
		
		public PlayerModel(int Id,String PlayerName,Date DOB,String BattingStyle,String BowlingStyle,int CreatedBy, Date CreatedOn, int TeamId, int PlayerRoleId,boolean isDeleted, String LogoPath)
		{
			this.Id = Id;
			this.PlayerName = PlayerName;
			this.CreatedBy = CreatedBy;
			this.CreatedOn = CreatedOn;
			this.BattingStyle = BattingStyle;
			this.BowlingStyle = BowlingStyle;
			this.DOB = DOB;
			this.TeamId = TeamId;
			this.PlayerRoleId = PlayerRoleId;
			this.isDeleted = isDeleted;
			this.LogoPath = LogoPath;
		}
	}
	
	private Gson gson = null;
	
	
    public Player() throws Exception {
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
		PlayerModel player = null;
		Connection con = connection();
		Statement st = con.createStatement();
		PrintWriter out = response.getWriter();
		

		if(pathInfo == null || pathInfo.equals("/")){
			
			String getQuery = "SELECT * FROM tbl_player where isDeleted = 0";
			List<PlayerModel> playerList= new ArrayList<PlayerModel>();  
				
			// execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery(getQuery);
		      
		    // iterate through the java resultset
//		    System.out.println(rs);
		    while (rs.next())
		    {
		        int Id = rs.getInt("Id");
		        String PlayerName = rs.getString("PlayerName");
		        Date DOB = rs.getDate("DOB");
		        String BattingStyle = rs.getString("BattingStyle");
				String BowlingStyle = rs.getString("BowlingStyle");
				int TeamId = rs.getInt("TeamId");
				int PlayerRoleId = rs.getInt("PlayerRoleId");
				int CreatedBy = rs.getInt("CreatedBy");
		        Date CreatedOn = rs.getTimestamp("CreatedOn");
		        boolean isDeleted = false;
		        String LogoPath = rs.getString("LogoPath");
		        
		        //System.out.format("%d, %s, %s, %d, %s\n",Id, TeamName, TeamDescription, CreatedBy, CreatedOn);
		        player = new PlayerModel(Id,PlayerName, DOB, BattingStyle, BowlingStyle, CreatedBy,  CreatedOn,TeamId,PlayerRoleId,isDeleted,LogoPath);
		        playerList.add(player);
		            
		    }
		    sendAsJson(response, playerList);
		}
		String[] splits = pathInfo.split("/");
		
		if(splits.length != 2) {
			
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String Id = splits[1];
		String checkQuery = "select Id from tbl_player where Id = '"+Id+"' and isDeleted = 0";
		st = con.prepareStatement(checkQuery);
		
		ResultSet rs=st.executeQuery(checkQuery);
//		boolean recordAdded = false;
	    while(!rs.next()){            
//	         recordAdded = true;
//	         response.sendError(HttpServletResponse.SC_NOT_FOUND);
	         out.print("Id doesn't exists");
			 return;
	    }
	    
	    
		String IdQuery = "Select * from tbl_player where Id = '"+Id+"' and isDeleted = 0";
		rs = st.executeQuery(IdQuery);
		while (rs.next())
	    {
	        
//			int Id = rs.getInt("Id");
	        String PlayerName = rs.getString("PlayerName");
	        Date DOB = rs.getDate("DOB");
	        String BattingStyle = rs.getString("BattingStyle");
			String BowlingStyle = rs.getString("BowlingStyle");
			int CreatedBy = rs.getInt("CreatedBy");
			int TeamId = rs.getInt("TeamId");
			int PlayerRoleId = rs.getInt("PlayerRoleId");
	        Date CreatedOn = rs.getTimestamp("CreatedOn");
	        boolean isDeleted = false;
	        String LogoPath = rs.getString("LogoPath");
	        player = new PlayerModel(Integer.parseInt(Id),PlayerName, DOB, BattingStyle, BowlingStyle, CreatedBy,  CreatedOn,TeamId,PlayerRoleId,isDeleted,LogoPath);
	        
	        
	    }
		
		
		
		sendAsJson(response, player);
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
		    PlayerModel player = gson.fromJson(payload, PlayerModel.class);
		    try {
		    
		    String insertQuery = "Insert into tbl_player(PlayerName, DOB, BattingStyle, BowlingStyle, CreatedBy,TeamId,PlayerRoleId) values(?,?,?,?,?,?,?)";
		    PreparedStatement st = con.prepareStatement(insertQuery);
		    String pattern = "yyyy-MM-dd";
		    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		    String date = formatter.format(player.DOB);
		    st.setString(1,player.PlayerName);
		    st.setString(2,date);
		    st.setString(3, player.BattingStyle);
		    st.setString(4, player.BowlingStyle);
		    st.setInt(5, player.CreatedBy);
		    st.setInt(6, player.TeamId);
		    st.setInt(7, player.PlayerRoleId);
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
		
		String checkQuery = "select Id from tbl_player where Id = '"+Id+"' and isDeleted = 0";
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
	    
	    PlayerModel player = gson.fromJson(payload, PlayerModel.class);
	    String updateQuery = "update tbl_player set PlayerName=?,DOB=?,BattingStyle=?,BowlingStyle=?,CreatedBy=?,TeamId=?,PlayerRoleId=? where Id='"+Id+"'";
		st = con.prepareStatement(updateQuery);
		st.setString(1,player.PlayerName);
		String pattern = "yyyy-MM-dd";
	    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	    String date = formatter.format(player.DOB);
		
	    st.setString(2, date);
	    st.setString(3, player.BattingStyle);
	    st.setString(4, player.BowlingStyle);
	    st.setInt(5, player.CreatedBy);
	    st.setInt(6, player.TeamId);
	    st.setInt(7, player.PlayerRoleId);
		st.execute();
		
		rs = st.executeQuery("select * from tbl_player where Id= '"+Id+"'");
		while (rs.next())
	    {
	        
//			int Id = rs.getInt("Id");
	        String PlayerName = rs.getString("PlayerName");
	        Date DOB = rs.getDate("DOB");
	        String BattingStyle = rs.getString("BattingStyle");
			String BowlingStyle = rs.getString("BowlingStyle");
			int CreatedBy = rs.getInt("CreatedBy");
			int TeamId = rs.getInt("TeamId");
			int PlayerRoleId = rs.getInt("PlayerRoleId");
	        Date CreatedOn = rs.getTimestamp("CreatedOn");
	        boolean isDeleted = false;
	        String LogoPath = rs.getString("LogoPath");
	        player = new PlayerModel(Integer.parseInt(Id),PlayerName, DOB, BattingStyle, BowlingStyle, CreatedBy,  CreatedOn,TeamId,PlayerRoleId,isDeleted,LogoPath);
	        
	        
	    }
		
	    
	    
	    sendAsJson(response, player);
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
		
		String checkQuery = "select Id from tbl_player where Id = '"+Id+"' and isDeleted = 0";
		PreparedStatement st = con.prepareStatement(checkQuery);
		
		ResultSet rs=st.executeQuery();
//		boolean recordAdded = false;
	    while(!rs.next()){            
//	         recordAdded = true;
//	         response.sendError(HttpServletResponse.SC_NOT_FOUND);
	         out.print("Id doesn't exists");
			 return;
	    }
	    
	    
	    String deleteQuery = "update tbl_player set isDeleted = 1 where Id ='"+Id+"'";
	    st = con.prepareStatement(deleteQuery);
	    st.execute();
	    out.print("Deleted Successfully");
	    
	    
	    
	    
		}catch (Exception e) {
			
			e.printStackTrace();
			}

	}
}
