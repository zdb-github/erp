package com.java.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.bean.ErpAccount;
import com.java.bean.ErpComment;
import com.java.service.ErpAccountService;
import com.java.service.ErpCommentService;
import com.java.util.DateAndTimeUtil;
import com.java.util.IdUtil;

@Controller
public class CommentController {

	@Autowired
	private ErpAccountService erpAccountService;
	@Autowired
	private ErpCommentService erpCommentService;
//	@Autowired
//	private ErpReplyService erpReplyService;
	
	@RequestMapping("/public/toCommentList.do")
	public ModelAndView  toCommentList(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpAccount> listA = erpAccountService.getErpAccountAndErpCommentAndErpReplyAll();
		request.setAttribute("erpAccountList", listA);
		
		mav.setViewName("public/comment");
		return mav;
	}
	
	@RequestMapping("/public/toCommentAdd.do")
	public ModelAndView toAdd(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
			
		mav.setViewName("public/commentAdd");
		return mav;
	}
	@RequestMapping("/public/commentAdd.do")
	public ModelAndView commentAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		String content = request.getParameter("content");
		//String account_id = request.getParameter("account_id");
		
		ErpComment erpComment = new ErpComment();
		erpComment.setId(IdUtil.getUuid());
		erpComment.setContent(content);
		erpComment.setComment_time(DateAndTimeUtil.getDateAndTime());
		erpComment.setAccount_id("");
		
		erpCommentService.add(erpComment);
		request.getRequestDispatcher("/public/toCommentAdd.do").forward(request, response);
		return mav;
	}
	@RequestMapping("/public/toGroup.do")
	public ModelAndView group(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("public/group");
		return mav;
	}
	@RequestMapping("/public/toAbout.do")
	public ModelAndView about(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("public/about");
		return mav;
	}
	@RequestMapping("/public/toProject.do")
	public ModelAndView project(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("public/project");
		return mav;
	}
	@RequestMapping("/public/toNews.do")
	public ModelAndView news(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("public/news");
		return mav;
	}
	
	
}


















