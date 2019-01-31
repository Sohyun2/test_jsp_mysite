package com.douzone.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.vo.BoardVo;

public class ReplyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setAttribute("no", request.getParameter("no"));		
		request.setAttribute("page", request.getParameter("page"));		
		WebUtils.forward(request, response, "/WEB-INF/views/board/reply.jsp");
	}

}