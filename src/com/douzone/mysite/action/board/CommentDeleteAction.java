package com.douzone.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;

public class CommentDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		long no = Long.parseLong(request.getParameter("no")); // 글번호 
		long cNo = Long.parseLong(request.getParameter("c_no")); // 글번호 
		
		new BoardDao().cDelete(cNo);
		
		WebUtils.redirect(request, response, request.getContextPath()+"/board?a=detail&no="+no);
	}

}
