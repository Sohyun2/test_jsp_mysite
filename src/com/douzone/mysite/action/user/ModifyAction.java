package com.douzone.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.UserDao;
import com.douzone.mysite.vo.UserVo;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		/* 인증성공 -> 인증처리 */
		HttpSession session = request.getSession(true);

		UserVo userVo = (UserVo) session.getAttribute("authuser");
		
		String email = userVo.getEmail();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		UserVo vo = new UserVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setGender(gender);
		vo.setEmail(email);
		
		new UserDao().update(vo);
		
		// 세션수정
		session.setAttribute("authuser", vo);
		
		/* main redirect */
		WebUtils.redirect(request, response, request.getContextPath());
	}

}
