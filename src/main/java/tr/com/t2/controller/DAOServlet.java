/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tr.com.t2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import tr.com.t2.controller.ValidateUserInfo;
import tr.com.t2.domain.T2TFProject;
import tr.com.t2.domain.T2TFUser;
import tr.com.t2.service.IUserService;

/**
 *
 * @author CAKIN
 */
public class DAOServlet extends HttpServlet {
    @Autowired
    IUserService userService;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
   
    }
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

            userService.createProject(project);
            
    }
}
