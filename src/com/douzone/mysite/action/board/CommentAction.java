package com.douzone.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.vo.CommentVo;
import com.douzone.mysite.vo.UserVo;

public class CommentAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		CommentVo vo = new CommentVo();
		
		UserVo user = (UserVo)request.getSession().getAttribute("authuser");
		vo.setUserNo(user.getNo());
		vo.setBoardNo(Long.parseLong(request.getParameter("board_no")));
		vo.setContent(request.getParameter("content"));
		
		new BoardDao().insertComment(vo);
		
		WebUtils.redirect(request, response, request.getContextPath()+"/board?a=detail&no="+vo.getBoardNo());
	}
}
