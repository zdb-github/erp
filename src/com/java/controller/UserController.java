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

import com.java.bean.ErpCode;
import com.java.bean.ErpDept;
import com.java.bean.ErpJob;
import com.java.bean.ErpJobUser;
import com.java.bean.ErpUser;
import com.java.service.ErpCodeService;
import com.java.service.ErpDeptService;
import com.java.service.ErpJobService;
import com.java.service.ErpJobUserService;
import com.java.service.ErpUserService;
import com.java.util.IdUtil;
import com.java.util.VoUtil;
import com.java.vo.ErpUserVo;




@Controller
public class UserController {

	@Autowired
	private ErpUserService erpUserService;
	@Autowired
	private ErpCodeService erpCodeService;
	@Autowired
	private ErpDeptService erpDeptService;
	@Autowired
	private ErpJobService erpJobService;
	@Autowired
	private ErpJobUserService erpJobUserService;
	
	//员工列表页
	@RequestMapping("/user/toUserList.do")
	public ModelAndView toList(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpUser> listU = erpUserService.getAll(con);
		List<ErpUserVo> listV = VoUtil.getErpUserVoList(listU);
		int totalRecode = listV.size();//传一个总的记录条数用于分页
		System.out.println("++++++++++++++++++++++========"+totalRecode);
		request.setAttribute("totalRecode", totalRecode);
		List<ErpDept> dList = erpDeptService.getAll(con);
		//List<ErpJob> jList = erpJobService.getAll(con);
		request.setAttribute("userList", listV);
		request.setAttribute("deptList", dList);
		//request.setAttribute("jobList", jList);
		mav.setViewName("user/userList");
			
		return mav;
			
	}
		
	//到员工添加页
	@RequestMapping("/user/toUserAdd.do")
	public ModelAndView toAdd(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String userId = (String)request.getAttribute("userId");
		System.out.println("toUserAdd.do------------"+userId);
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpUser> list1 = erpUserService.getAll(con);
		List<ErpCode> listS = erpCodeService.getByType("SEX");
		List<ErpDept> listD = erpDeptService.getAll(con);
		List<ErpJob> listJ = erpJobService.getAll(con);
		
		request.setAttribute("user_id", userId);
		request.setAttribute("sexList", listS);
		request.setAttribute("userList", list1);
		request.setAttribute("deptList", listD);
		request.setAttribute("jobList", listJ);
		mav.setViewName("user/userAdd");
		return mav;

	}
	
	//员工添加
	@RequestMapping("/user/userAdd.do")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		 ModelAndView mav = new ModelAndView();
		 String user_id = request.getParameter("user_id");
		 System.out.println("userAdd=============="+user_id);
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String id_card = request.getParameter("id_card");
		String dept_id = request.getParameter("dept_id");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String remarks = request.getParameter("remarks");
		String job_id = request.getParameter("job_id");
		
		
		ErpUser eu = new ErpUser();
		eu.setId(user_id);
		eu.setName(name);
		eu.setSex(sex);
		eu.setAge(age);
		eu.setId_card(id_card);
		eu.setDept_id(dept_id);
		eu.setPhone(phone);
		eu.setEmail(email);
		eu.setRemarks(remarks);
		eu.setJob_id(job_id);
		
		if(erpUserService.add(eu)){
			String ujId = IdUtil.getUuid();
			ErpJobUser erpJobUser = new ErpJobUser();
			erpJobUser.setId(ujId);
			erpJobUser.setJob_id(job_id);
			erpJobUser.setUser_id(user_id);
			erpJobUserService.add(erpJobUser);
		}
		
		request.getRequestDispatcher("/user/toUserList.do").forward(request, response);
		return mav;
		
	}
	
	//跳转到修改页
	@RequestMapping("/user/toUserUpdate.do")
	public ModelAndView toUpdate(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		ErpUser eu = erpUserService.getById(id);
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpUser> list1 = erpUserService.getAll(con);
		List<ErpCode> listS = erpCodeService.getByType("SEX");
		
		List<ErpDept> listD = erpDeptService.getAll(con);
		List<ErpJob> listJ = erpJobService.getAll(con);
	
		request.setAttribute("sexList", listS);
		request.setAttribute("usertList", list1);
		
		request.setAttribute("deptList", listD);
		request.setAttribute("jobList", listJ);
		request.setAttribute("user", eu);
		
		mav.setViewName("user/userUpdate");
		return mav;

	}
	
	//员工信息修改
	@RequestMapping("/user/userUpdate.do")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String id_card = request.getParameter("id_card");
		String dept_id = request.getParameter("dept_id");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String remarks = request.getParameter("remarks");
		String job_id = request.getParameter("job_id");
		
		ErpUser eu = new ErpUser();
		eu.setId(id);
		eu.setName(name);
		eu.setSex(sex);
		eu.setAge(age);
		eu.setId_card(id_card);
		eu.setDept_id(dept_id);
		eu.setPhone(phone);
		eu.setEmail(email);
		eu.setRemarks(remarks);
		eu.setJob_id(job_id);
		
		erpUserService.update(eu);
		
		request.getRequestDispatcher("/user/toUserList.do").forward(request, response);
		return mav;
	}
	
	//员工信息删除
	@RequestMapping("/user/toUserDelete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			
		String id = request.getParameter("id");
		if(!id.contains(",")){
			erpUserService.delete(id);
		}else{
			String []idList = id.split(",");
			for(String d:idList){
				erpUserService.delete(d);
			}
		}
			
		request.getRequestDispatcher("/user/toUserList.do").forward(request, response);
			
	}
	
}




















