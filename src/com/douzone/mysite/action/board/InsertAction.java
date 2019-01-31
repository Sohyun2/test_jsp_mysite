package com.douzone.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.UserVo;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession(true);
		UserVo userVo = (UserVo) session.getAttribute("authuser");
		
		long userNo = userVo.getNo();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
				
		BoardVo vo = new BoardVo();
		vo.setUserNo(userNo);
		vo.setTitle(title);
		vo.setContents(content);
		
		new BoardDao().insert(vo);
		WebUtils.redirect( request, response, request.getContextPath()+"/board?page=1" );
	}

}
