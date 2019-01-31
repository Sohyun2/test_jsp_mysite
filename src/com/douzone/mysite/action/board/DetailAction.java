package com.douzone.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mvc.util.WebUtils;
import com.douzone.mysite.repository.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.CommentVo;

public class DetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		System.out.println(request.getParameter("page"));
		request.setAttribute("page", request.getParameter("page"));
		
		long no = Long.parseLong(request.getParameter("no"));
		
		// 글 가져오기
		List<BoardVo> list = new BoardDao().getList();
		for(BoardVo vo : list) {
			if(vo.getNo() == no) {
				// 조회수 업데이트
				new BoardDao().updateHit(vo);	
				request.setAttribute("vo", vo);
				break;
			}
		}
		
		// 댓글 리스트 가져오기
		List<CommentVo> cList = new BoardDao().getListComment(no);
		request.setAttribute("cList", cList);
		
		WebUtils.forward(request, response, "/WEB-INF/views/board/detail.jsp");
	}

}
