package com.spring.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        // setup connection variables
        //String user = "springstudent";
        //String pass = "springstudent";
       
        String driver = "org.postgresql.Driver";

        // get connection
        try{
            PrintWriter out = response.getWriter();
            URI dbUri = new URI(System.getenv("DATABASE_URL"));
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
            out.println("Connecting to database!!");
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(dbUrl,username,password);
            out.println("Success!!");
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}







