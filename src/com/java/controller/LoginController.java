package com.java.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.bean.ErpAccount;
import com.java.bean.ErpJob;
import com.java.bean.ErpJobResource;
import com.java.bean.ErpJobUser;
import com.java.bean.ErpResource;
import com.java.service.ErpAccountService;
import com.java.service.ErpJobResourceService;
import com.java.service.ErpJobService;
import com.java.service.ErpJobUserService;
import com.java.service.ErpResourceService;
import com.java.util.DateAndTimeUtil;


@Controller
public class LoginController {
	
	@Autowired
	private ErpAccountService erpAccountService;
	@Autowired
	private ErpJobUserService erpJobUserService;
	@Autowired
	private ErpJobResourceService erpJobResourceService;
	@Autowired
	private ErpJobService erpJobService;
	@Autowired
	private ErpResourceService erpResourceService;
	
	@RequestMapping("/public/toPortal.do")
	public ModelAndView toPortal(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("public/portal");
		return mav;
	}
	@RequestMapping("/public/toBigdatalogin.do")
	public ModelAndView toBigdatalogin(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("public/bigdatalogin");
		return mav;
	}
	
	@RequestMapping("/public/bigdatalogin.do")
	public String bigdatalogin(HttpServletRequest request,HttpServletResponse response,HttpSession session,
			String username,String password){
		ErpAccount ea = erpAccountService.checkLogin(username, password);
		if(ea!=null&&ea.getUsername().equals(username)&&ea.getPassword().equals(password)){
			request.setAttribute("loginMag", "登录成功！");
			ea.setLast_login_time(DateAndTimeUtil.getDateAndTime());
			erpAccountService.update(ea);
			
			request.getSession().setAttribute("erpAccount", ea);
			
			//获取资源
			ErpJobUser eju = erpJobUserService.getByUser_id(ea.getUser_id());
			ErpJob ej = erpJobService.getById(eju.getJob_id());
			List<ErpJobResource> JRList = erpJobResourceService.getByJob_id(ej.getJob_id());
			List<String> pathList = new ArrayList<String>();
			List<String> role_typeList = new ArrayList<String>();
			
			for(ErpJobResource ejr:JRList){
				ErpResource er = erpResourceService.getById(ejr.getResource_id());
				pathList.add(er.getDo_path());
				role_typeList.add(er.getRole_type());
			}
			
			request.getSession().setAttribute("myDoPathList", pathList);
			request.getSession().setAttribute("role_typeList", role_typeList);
			
			return "forward:toMain.do";
		}else{
			request.setAttribute("loginMag", "登录失败！");
			return "public/bigdatalogin";
		}
	}
	
	@RequestMapping("/public/toMain.do")
	public ModelAndView toMain(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("public/main");
		return mav;
	}
	
	@RequestMapping("public/toWelcome.do")
	public ModelAndView toWelcome(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("public/welcome");
		return mav;
	}
	

	//跳转到修改密码界面
	@RequestMapping("/public/toUpdatePw.do")
	public ModelAndView toUpdatePw(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		ErpAccount erpAccount = (ErpAccount)request.getSession().getAttribute("erpAccount");
		String id = erpAccount.getId();
		System.out.println("++++++++++++"+id);
		ErpAccount ea = erpAccountService.getById(id);
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		//List<ErpAccount> listA = erpAccountService.getAll(con);
		//request.setAttribute("accountList",listA );
		//List<ErpCode> listC = erpCodeService.getByType("UTYPE");
		
		//request.getSession().setAttribute("codeList", listC);
		request.setAttribute("account", ea);
		mav.setViewName("public/updatePw");
		
		return mav;
	}
	//修改密码操作
	@RequestMapping("/public/updatePw.do")
	public ModelAndView updatePw(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		ErpAccount ea = new ErpAccount();
		ea.setId(id);
		
		ea.setPassword(password);

		erpAccountService.update(ea);
		request.getRequestDispatcher("/public/toUpdateSucceed.do").forward(request, response);
		return mav;
	}
	//修改成功界面
	@RequestMapping("/public/toUpdateSucceed.do")
	public ModelAndView toUpdateSucceed(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("public/updateSucceed");
		return mav;
	}

	
	
	
	
	
	
}
