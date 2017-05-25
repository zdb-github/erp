package com.java.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java.bean.ErpAccount;
import com.java.bean.ErpCode;
import com.java.service.ErpAccountService;
import com.java.service.ErpCodeService;
import com.java.util.DateAndTimeUtil;
import com.java.util.IdUtil;
import com.java.util.VoUtil;
import com.java.vo.ErpAccountVo;


@Controller
public class AccountController {
	
	@Autowired
	private ErpAccountService erpAccountService;
	
	@Autowired
	private ErpCodeService erpCodeService;
	
	//员工列表页
	@RequestMapping("/account/toAccountList.do")
	public ModelAndView toList(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpAccount> listA = erpAccountService.getAll(con);
		List<ErpAccountVo>listV = VoUtil.getErpAccountVoList(listA);
		int totalRecode = listV.size();
		
		request.setAttribute("totalRecode", totalRecode);
		request.setAttribute("accountList", listV);
			
		mav.setViewName("account/accountList");
			
		return mav;
			
	}
	
	
	//跳转到账号添加页前,需要判断用户名是否已经存在
	@RequestMapping("/account/toCheckTheSameUsername.do")
	public @ResponseBody boolean checkTheSameUsername(String username){
		
		boolean data = false;
		int num = erpAccountService.checkTheSameUsername(username);
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhh============"+username+"======="+num);
		if(num==0){
			data = true;
		}
		return data;
	}

	
	
	
	//跳转到账号添加页
	@RequestMapping("/account/toAccountAdd.do")
	public ModelAndView toAdd(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpAccount> list1 = erpAccountService.getAll(con);
		List<ErpCode> listC = erpCodeService.getByType("UTYPE");


		request.setAttribute("codeList", listC);
		request.setAttribute("accountList", list1);
			
		mav.setViewName("account/accountAdd");
		return mav;

	}
	
	//账号添加
	@RequestMapping("/account/accountAdd.do")
	public String add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String uType = request.getParameter("uType");
		
		ErpAccount ea = new ErpAccount();
		ea.setId(IdUtil.getUuid());
		ea.setUsername(username);
		ea.setPassword(password);
		ea.setuType(uType);
		ea.setCreate_time(DateAndTimeUtil.getDateAndTime());
		ea.setLast_login_time(DateAndTimeUtil.getDateAndTime());
		ea.setUser_id(IdUtil.getUuid());
		
		erpAccountService.add(ea);
		//到员工添加
		String uId = ea.getUser_id();
		System.out.println("==========="+uId);
		request.setAttribute("userId",uId);
		
		return "forward:/user/toUserAdd.do";
		
	}
	//跳转到修改页
	@RequestMapping("/account/toAccountUpdate.do")
	public ModelAndView toUpdate(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		ErpAccount ea = erpAccountService.getById(id);
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpAccount> list1 = erpAccountService.getAll(con);
		List<ErpCode> listC = erpCodeService.getByType("UTYPE");
		
		request.setAttribute("codeList", listC);
		request.setAttribute("AccountList", list1);
		
		request.setAttribute("account", ea);
		
		mav.setViewName("account/accountUpdate");
		return mav;

	}
	
	//账号信息修改
	@RequestMapping("/account/accountUpdate.do")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		ErpAccount ea = new ErpAccount();
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String uType = request.getParameter("uType");
		String create_time = request.getParameter("create_time");
		String last_login_time = request.getParameter("last_login_time");
		String user_id = request.getParameter("user_id");
		ea.setId(id);
		ea.setUsername(username);
		ea.setPassword(password);
		ea.setuType(uType);
		ea.setCreate_time(create_time);
		ea.setLast_login_time(last_login_time);
		ea.setUser_id(user_id);
		erpAccountService.update(ea);
		
		request.getRequestDispatcher("/account/toAccountList.do").forward(request, response);
		return mav;
	}
	
	//部门删除
	@RequestMapping("/account/toAccountDelete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			
		String id = request.getParameter("id");
		if(!id.contains(",")){
			erpAccountService.delete(id);
		}else{
			String []idList = id.split(",");
			for(String d:idList){
				erpAccountService.delete(d);
			}
		}
			
		request.getRequestDispatcher("/account/toAccountList.do").forward(request, response);
			
	}
	
	
}
























