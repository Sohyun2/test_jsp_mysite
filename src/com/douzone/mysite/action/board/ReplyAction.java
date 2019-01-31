package com.douzone.mysite.action.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.UserVo;

public class ReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int page = Integer.parseInt(request.getParameter("page"));
		Long no = Long.parseLong(request.getParameter("no")); //105
		
		List<BoardVo> list = new BoardDao().getList();
		BoardVo boardVo = new BoardVo();
		
		for(BoardVo empty : list) {
			if(empty.getNo() == no) {
				boardVo = empty;
				break;
			}
		}
		
		int gNo = boardVo.getgNo();
		int oNo = boardVo.getoNo();
		int depth = boardVo.getDepth();
		
		UserVo userVo = (UserVo) request.getSession().getAttribute("authuser"); // 댓글을 등록 할 userNo
		long userNo = userVo.getNo();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContents(content);
		vo.setgNo(gNo);
		vo.setoNo(++oNo);
		vo.setDepth(++depth);
		vo.setUserNo(userNo);
		
		BoardDao dao = new BoardDao();
		dao.insertReply(vo);
		
		WebUtils.redirect(request, response, request.getContextPath() + "/board?page="+page);
	}

}
