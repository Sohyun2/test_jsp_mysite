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

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int page = Integer.parseInt(request.getParameter("page"));

		int limit = 10;
		// 원하는 페이지에 보여줄 리스트 뽑아오기
		List<BoardVo> list = new BoardDao().getList(page, limit); // 10개
		
		// 총 리스트 size구하기
		List<BoardVo> listCount = new BoardDao().getList();
		
		int startNum = listCount.size();

		// 하단 페이지 번호를 위한 변수
		int listSize = listCount.size();
		if(listSize % limit != 0) {
			listSize = listSize / limit + 1;
		} else {
			listSize /= limit;
		}
		request.setAttribute("list", list);
		request.setAttribute("list_size", listSize);
		request.setAttribute("limit", limit);
		request.setAttribute("page", page);
		request.setAttribute("startNum", startNum);
		
		WebUtils.forward(request, response, "/WEB-INF/views/board/list.jsp");
	}
}
