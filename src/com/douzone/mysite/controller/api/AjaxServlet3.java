package com.douzone.mysite.controller.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.vo.UserVo;

import net.sf.json.JSONArray;

@WebServlet("/ajax3")
public class AjaxServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Java Collection(List) -> JSON
		List<UserVo> list = new ArrayList<UserVo>();
		
		UserVo vo = new UserVo();
		vo.setNo(10);
		vo.setName("둘리");
		vo.setEmail("gooly");
		vo.setGender("male");		
		list.add(vo);
		
		vo.setNo(20);
		vo.setName("마이콜");
		vo.setEmail("michol@gmail.com");
		vo.setGender("male");
		list.add(vo);
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		String jsonString = jsonArray.toString();
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println(jsonString);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
