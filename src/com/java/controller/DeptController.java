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
import com.java.bean.ErpOrganization;
import com.java.service.ErpCodeService;
import com.java.service.ErpDeptService;
import com.java.service.ErpOrganizationService;
import com.java.util.IdUtil;
import com.java.util.VoUtil;
import com.java.vo.DeptVo;

@Controller
public class DeptController {

	@Autowired
	private ErpDeptService erpDeptService;
	@Autowired
	private ErpCodeService erpCodeService;
	@Autowired
	private ErpOrganizationService erpOrganizationService;
	
	//机构列表页
	@RequestMapping("/dept/toList.do")
	public ModelAndView toList(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpDept> listD = erpDeptService.getAll(con);
		List<DeptVo> listDV = VoUtil.getDeptVoList(listD);
		int totalRecode = listDV.size();
		
		request.setAttribute("totalRecode", totalRecode);
		
		request.getSession().setAttribute("deptList", listDV);
			
		mav.setViewName("dept/list");
			
		return mav;
			
	}
		
	//到机构添加页
	@RequestMapping("/dept/toAdd.do")
	public ModelAndView toAdd(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpOrganization> list1 = erpOrganizationService.getAll(con);
		List<ErpCode> listC = erpCodeService.getByType("STATE");
		request.getSession().setAttribute("codeList", listC);
		request.getSession().setAttribute("organList", list1);
			
		mav.setViewName("dept/add");
		return mav;

	}
	
	//部门添加
	@RequestMapping("/dept/add.do")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		String name = request.getParameter("name");
		String subsidiary_organ = request.getParameter("subsidiary_organ");
		String state = request.getParameter("state");
		
		ErpDept ed = new ErpDept();
		ed.setDept_id(IdUtil.getUuid());
		ed.setName(name);
		ed.setSubsidiary_organ(subsidiary_organ);
		ed.setState(state);
		
		erpDeptService.add(ed);
		
		request.getRequestDispatcher("/dept/toList.do").forward(request, response);
		return mav;
		
	}
	
	//跳转到修改页
	@RequestMapping("/dept/toUpdate.do")
	public ModelAndView toUpdate(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("dept_id");
		ErpDept ed = erpDeptService.getById(id);
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpOrganization> list1 = erpOrganizationService.getAll(con);
		List<ErpCode> listC = erpCodeService.getByType("STATE");
		
		request.getSession().setAttribute("codeList", listC);
		request.getSession().setAttribute("organList", list1);
		
		request.setAttribute("dept", ed);
		
		mav.setViewName("dept/update");
		return mav;

	}
	
	//部门信息修改
	@RequestMapping("/dept/update.do")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		ErpDept ed = new ErpDept();
		String dept_id = request.getParameter("dept_id");
		String name = request.getParameter("name");
		String subsidiary_organ = request.getParameter("subsidiary_organ");
		String state = request.getParameter("state");
		
		ed.setDept_id(dept_id);
		ed.setName(name);
		ed.setSubsidiary_organ(subsidiary_organ);
		ed.setState(state);
		
		erpDeptService.update(ed);
		
		request.getRequestDispatcher("/dept/toList.do").forward(request, response);
		return mav;
	}
	
	//部门删除
	@RequestMapping("/dept/toDelete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			
		String id = request.getParameter("dept_id");
		if(!id.contains(",")){
			erpDeptService.delete(id);
		}else{
			String []idList = id.split(",");
			for(String d:idList){
				erpDeptService.delete(d);
			}
		}
			
		request.getRequestDispatcher("/dept/toList.do").forward(request, response);
			
	}
	
	
	
	
	
	
	
}
