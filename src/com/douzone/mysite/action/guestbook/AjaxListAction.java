package com.douzone.mysite.action.guestbook;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mvc.action.Action;
import com.douzone.mysite.repository.GuestbookDao;
import com.douzone.mysite.vo.GuestbookVo;

import net.sf.json.JSONObject;

public class AjaxListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String sPage = request.getParameter("p");
		if("".equals(sPage)) {				
			sPage = "1";
		}
		if( sPage.matches("\\d*") == false) {
			sPage = "1";
		}
		int page = Integer.parseInt(sPage);
		
		GuestbookDao dao = new GuestbookDao();
		List<GuestbookVo> list = dao.getList(page);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("data", list); // ajax에서 response로 받는 데이터 = list
		
		response.setContentType("application/json; charset=UTF-8"); // ajax함수에서 dataType이 json이라는 것을 알려줌 
		JSONObject jsonObject = JSONObject.fromObject(map);
		response.getWriter().print(jsonObject.toString());
	}
}
