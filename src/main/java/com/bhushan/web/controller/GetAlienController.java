package com.bhushan.web.controller;

import java.io.IOException;

import com.bhushan.web.dao.AlienDao;
import com.bhushan.web.model.Alien;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAlienController
 */

public class GetAlienController extends HttpServlet {
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AlienDao adao = new AlienDao();
		Alien alien = adao.getAlien(Integer.parseInt(request.getParameter("aid")));
		
		request.setAttribute("alien", alien);
		RequestDispatcher rd = request.getRequestDispatcher("showAlien.jsp");
		rd.forward(request, response);
	}

}
