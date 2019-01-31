package com.douzone.mysite.action.board;

import com.douzone.mvc.action.AbstractActionFactory;
import com.douzone.mvc.action.Action;

public class BoardActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("insertform".equals(actionName)) {
			action = new InsertFormAction();
		} else if("insert".equals(actionName)) {
			action = new InsertAction();
		} else if("detail".equals(actionName)) {
			action = new DetailAction();
		} else if("delete".equals(actionName)) {
			action = new DeleteFormAction();
		} else if("modifyform".equals(actionName)) {
			action = new ModifyFormAction();
		} else if("modify".equals(actionName)) {
			action = new ModifyAction();
		} else if("replyform".equals(actionName)) {
			action = new ReplyFormAction();
		} else if("reply".equals(actionName)) {
			action = new ReplyAction();
		} else if("comment".equals(actionName)) {
			action = new CommentAction();
		} else if("c_delete".equals(actionName)) {
			action = new CommentDeleteAction();
		} else {
			action = new ListAction();			
		}
		
		return action;
	}

}
