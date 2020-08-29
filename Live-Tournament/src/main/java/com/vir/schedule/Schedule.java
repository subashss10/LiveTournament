package com.vir.schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Time;
import com.google.gson.Gson;


@WebServlet("/schedule/*")
public class Schedule extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	class ScheduleModel
	{
		public int Id;
		public Date Date;
		public int MatchTypeId;
		public String Team1;
		public String Team2;
		public String Venue;
		public String Time;
		public int CreatedBy;
		public Date CreatedOn;
		public boolean isDeleted;
		
		
		public ScheduleModel(int Id,Date Date,int MatchTypeId,String Team1, String Team2,String Venue,String Time,int CreatedBy, Date CreatedOn,boolean isDeleted)
		{
			this.Id = Id;
			this.Date = Date;
			this.MatchTypeId = MatchTypeId;
			
			this.Team1 = Team1;
			this.Team2 = Team2;
			this.Venue = Venue;
			this.Time = Time;
			this.CreatedBy = CreatedBy;
			this.CreatedOn = CreatedOn;	
			this.isDeleted = isDeleted;
		}
	}
	
	private Gson gson = null;
	
	
    public Schedule() throws Exception {
        super();
        gson = new Gson();
        
        
        
        
    }
    
    private Connection connection() throws Exception
    {
    	Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/subash", "root", "test123$");
		return con;
    	
    }
    
    public static java.sql.Time getCurrentJavaSqlTime(Date date) {
        return new java.sql.Time(date.getTime());
      }
    
    private void sendAsJson(HttpServletResponse response, Object obj) throws IOException {
    		
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
		ScheduleModel schedule = null;
		Connection con = connection();
		Statement st = con.createStatement();
		

		if(pathInfo == null || pathInfo.equals("/")){
			
			String getQuery = "SELECT Id,Date,MatchTypeId, Team1, Team2,Venue,Time, CreatedBy, CreatedOn FROM tbl_schedule where isDeleted = 0";
				
			// execute the query, and get a java resultset
		    ResultSet rs = st.executeQuery(getQuery);
		    List<ScheduleModel> scheduleList= new ArrayList<ScheduleModel>();  
		    // iterate through the java resultset
//		    System.out.println(rs);
		    while (rs.next())
		    {
		        int Id = rs.getInt("Id");
		        String Team1 = rs.getString("Team1");
		        int MatchTypeId = rs.getInt("MatchTypeId");
		        String Team2 = rs.getString("Team2");
		        String Time = rs.getString("Time");
		        String Venue = rs.getString("Venue");
		        Date Date = rs.getDate("Date");
		        
		        int CreatedBy = rs.getInt("CreatedBy");
		        Date CreatedOn = rs.getTimestamp("CreatedOn");
		        boolean isDeleted = false;
		        
		        //System.out.format("%d, %s, %s, %d, %s\n",Id, TeamName, TeamDescription, CreatedBy, CreatedOn);
		        schedule = new ScheduleModel(Id, Date, MatchTypeId, Team1, Team2, Venue, Time,CreatedBy, CreatedOn, isDeleted);
		        scheduleList.add(schedule);
		        
		        
				
		        
		        
		    }
		    sendAsJson(response, scheduleList);
			
		}
		String[] splits = pathInfo.split("/");
		
		if(splits.length != 2) {
			
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		String Id = splits[1];
		String IdQuery = "Select Id,Date,MatchTypeId, Team1, Team2,Venue,Time, CreatedBy, CreatedOn FROM tbl_schedule where Id = '"+Id+"' and isDeleted = 0";
		ResultSet rs = st.executeQuery(IdQuery);
		while (rs.next())
	    {
	        
		        String Team1 = rs.getString("Team1");
		        int MatchTypeId = rs.getInt("MatchTypeId");
		        String Team2 = rs.getString("Team2");
		        String Time = rs.getString("Time");
		        String Venue = rs.getString("Venue");
		        Date Date = rs.getDate("Date");
		        
		        int CreatedBy = rs.getInt("CreatedBy");
		        Date CreatedOn = rs.getTimestamp("CreatedOn");
		        boolean isDeleted = false;
		        
		        //System.out.format("%d, %s, %s, %d, %s\n",Id, TeamName, TeamDescription, CreatedBy, CreatedOn);
		        schedule = new ScheduleModel(Integer.parseInt(Id), Date, MatchTypeId, Team1, Team2, Venue, Time,CreatedBy, CreatedOn, isDeleted);
	        
	        
	    }
		
		if(Id == null) {
			
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		sendAsJson(response, schedule);
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
		    
		    ScheduleModel schedule = gson.fromJson(payload, ScheduleModel.class);
		    try {
		    String insertQuery = "Insert into tbl_schedule(Date,MatchTypeId, Team1, Team2,Venue,Time, CreatedBy) values(?,?,?,?,?,?,?)";
		    PreparedStatement st = con.prepareStatement(insertQuery);
		    String pattern = "yyyy-MM-dd";
		    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		    String date = formatter.format(schedule.Date);		    
		    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		    Date time= dateFormat.parse(schedule.Time);
		    java.sql.Time formattedDate = getCurrentJavaSqlTime(time);
		    System.out.println(schedule.Team1);
		    st.setString(1, date);
		    st.setInt(2, schedule.MatchTypeId);
		    st.setString(3, schedule.Team1);
		    st.setString(4, schedule.Team2);
		    st.setString(5,schedule.Venue);
		    st.setTime(6, formattedDate);
		    st.setInt(7, 2);
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
		
		String checkQuery = "select Id from tbl_schedule where Id = '"+Id+"'";
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
	    
	    ScheduleModel schedule = gson.fromJson(payload, ScheduleModel.class);
	    String updateQuery = "update tbl_schedule set Date = ?,MatchTypeId = ?, Team1 = ?, Team2 = ?,Venue = ?,Time = ?, CreatedBy = ? where Id='"+Id+"'";
		st = con.prepareStatement(updateQuery);
		String pattern = "yyyy-MM-dd";
	    SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	    String date = formatter.format(schedule.Date);
	    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	    Date time= dateFormat.parse(schedule.Time);
	    java.sql.Time formattedDate = getCurrentJavaSqlTime(time);
	    System.out.println(schedule.Team1);
	    st.setString(1, date);
	    st.setInt(2, schedule.MatchTypeId);
	    st.setString(3, schedule.Team1);
	    st.setString(4, schedule.Team2);
	    st.setString(5,schedule.Venue);
	    st.setTime(6, formattedDate);
	    st.setInt(7, 2);		
		st.execute();
		
		rs = st.executeQuery("select Id, Date,MatchTypeId, Team1, Team2,Venue,Time, CreatedBy, CreatedOn from tbl_schedule where Id= '"+Id+"'");
		while (rs.next())
	    {
	        
			 	String Team1 = rs.getString("Team1");
		        int MatchTypeId = rs.getInt("MatchTypeId");
		        String Team2 = rs.getString("Team2");
		        String Time = rs.getString("Time");
		        String Venue = rs.getString("Venue");
		        Date Date = rs.getDate("Date");
		        
		        int CreatedBy = rs.getInt("CreatedBy");
		        Date CreatedOn = rs.getTimestamp("CreatedOn");
		        boolean isDeleted = false;
		        
		        //System.out.format("%d, %s, %s, %d, %s\n",Id, TeamName, TeamDescription, CreatedBy, CreatedOn);
		        schedule = new ScheduleModel(Integer.parseInt(Id), Date, MatchTypeId, Team1, Team2, Venue, Time,CreatedBy, CreatedOn, isDeleted);
   
	    }
		
	    
	    
	    sendAsJson(response, schedule);
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
		
		String checkQuery = "select Id, isDeleted from tbl_schedule where Id = '"+Id+"' and isDeleted = 0";
		PreparedStatement st = con.prepareStatement(checkQuery);
		
		ResultSet rs=st.executeQuery();
//		boolean recordAdded = false;
	    while(!rs.next()){            
//	         recordAdded = true;
//	         response.sendError(HttpServletResponse.SC_NOT_FOUND);
	         out.print("Id doesn't exists");
			 return;
	    }
	    
	    
	    String deleteQuery = "update tbl_schedule set isDeleted = 1 where Id ='"+Id+"'";
	    st = con.prepareStatement(deleteQuery);
	    st.execute();
	    out.print("Deleted Successfully");
	    
	    
	    
	    
		}catch (Exception e) {
			
			e.printStackTrace();
			}

	}



}
