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

import com.java.bean.ErpResource;
import com.java.service.ErpResourceService;
import com.java.util.IdUtil;

@Controller
public class ResourceController {
	
	
	@Autowired
	private ErpResourceService erpResourceService;
	
	//tiao转到列表
	@RequestMapping("/resource/toList.do")
	public ModelAndView toList(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpResource> listR = erpResourceService.getAll(con);
		int totalRecode = listR.size();
		
		request.setAttribute("totalRecode", totalRecode);
		request.setAttribute("resourceList", listR);
		mav.setViewName("resource/list");
		
		return mav;
	}
	
	//跳转到添加页
	@RequestMapping("/resource/toAdd.do")
	public ModelAndView toAdd(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		
		mav.setViewName("resource/add");
		return mav;
	}
	
	//跳转到添加操作
	@RequestMapping("resource/add.do")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		String resource_name = request.getParameter("resource_name");
		String do_path = request.getParameter("do_path");
		String role_type = request.getParameter("role_type");
		
		ErpResource er = new ErpResource();
		er.setId(IdUtil.getUuid());
		er.setResource_name(resource_name);
		er.setDo_path(do_path);
		er.setRole_type(role_type);
		
		erpResourceService.add(er);
		
		request.getRequestDispatcher("/resource/toList.do").forward(request, response);
		
		return mav;
		
	}
	
	//跳转到修改页
	@RequestMapping("/resource/toUpdate.do")
	public ModelAndView toUpdate(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		ErpResource er = erpResourceService.getById(id);
		
		request.setAttribute("resource", er);
	
		mav.setViewName("resource/update");
		
		return mav;
	}
	
	//跳转到修改操作
	@RequestMapping("/resource/update.do")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		String resource_name = request.getParameter("resource_name");
		String do_path = request.getParameter("do_path");
		String role_type = request.getParameter("role_type");
		
		ErpResource er = new ErpResource();
		er.setId(id);
		er.setResource_name(resource_name);
		er.setDo_path(do_path);
		er.setRole_type(role_type);
		
		erpResourceService.update(er);
		
		request.getRequestDispatcher("/resource/toList.do").forward(request, response);
		
		return mav;
		
	}
	
	//删除操作
	@RequestMapping("/resource/toDelete.do")
	public void toDelete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		if(!id.contains(",")){
			erpResourceService.delete(id);
		}else{
			String []idList = id.split(",");
			for(String d:idList){
				erpResourceService.delete(d);
			}
		}
			
		request.getRequestDispatcher("/resource/toList.do").forward(request, response);
			
		
	}
	
	
	
	
	
	
	
}
