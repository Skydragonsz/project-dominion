package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.*; 
import javax.servlet.http.*; 
import java.io.*; 
import java.util.*; 

import com.google.gson.Gson;

import dominion.*;


/**
 * Servlet implementation class Load
 */
@WebServlet("/Load")
public class Load extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Load() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		DataConnection dataConnection = (DataConnection) request.getServletContext().getAttribute("dataConnection");
		if (dataConnection == null) {
			dataConnection = new DataConnection();
			request.getServletContext().setAttribute("dataConnection", dataConnection);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		DataConnection dataConnection = (DataConnection) request.getServletContext().getAttribute("dataConnection");
		if (dataConnection == null) {
			dataConnection = new DataConnection();
			request.getServletContext().setAttribute("dataConnection", dataConnection);
		}
		
		
		
		
		
		

		System.out.println(dataConnection.loadGameID());
		
		String json = new Gson().toJson(dataConnection.loadGameID());
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		
	}

}
