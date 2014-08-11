

<%@page import="tr.com.t2.dao.jdbc.T2TFUserJdbcDAO"%>
<%@page contentType="text/plain"%>
<%@ page import="tr.com.t2.domain.T2TFProject"%>
<%@ page import="tr.com.t2.service.impl.UserService"%>
<%@ page import="tr.com.t2.domain.T2TFUser"%>
<%@ page import="java.sql.Connection"%>;
<%@ page import="java.sql.DriverManager"%>;
<%@ page import="java.sql.PreparedStatement"%>;
<%@ page import="java.sql.ResultSet"%>;
<%@ page import="java.sql.SQLException"%>;
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
 

<%
    
  String userName = "Arda";
  String projectName = "" ;
  try{
      projectName = request.getParameter("project");
  }
  catch(Exception e){
      
  }
  T2TFUser user = new T2TFUser();
  user.setUserName("deneme1");
  user.setPassword("deneme1");
  T2TFProject project = new T2TFProject();
  project.setProjectName(projectName);
  project.setUserName(userName);
  //T2TFUserJdbcDAO dao = new T2TFUserJdbcDAO();
  try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/test",
                    "root", "CAKIN");

            PreparedStatement ps = con.prepareStatement("INSERT INTO projects VALUES('"+userName+"','"+projectName+"')");

            ps.executeUpdate();
            

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }
  //dao.createUser(user);
  //service.createUser(user);
  //service.createProject(project);
  %>
