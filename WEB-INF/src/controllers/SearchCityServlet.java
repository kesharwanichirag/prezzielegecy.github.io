package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import models.City;
import models.User;

public class SearchCityServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		User user =(User) session.getAttribute("user");
		if(user!=null){
			String sKey = request.getParameter("skey");
			
			ArrayList<City> cityList = City.searchCity(sKey);
			
			Gson gson = new Gson();
			String cities = gson.toJson(cityList);

			response.getWriter().write(cities);
		}else{
			response.getWriter().write("session expired....");
		}
	}
}