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
import com.java.service.ErpCodeService;
import com.java.util.IdUtil;

@Controller
public class CodeController {

	@Autowired
	private ErpCodeService erpCodeService;
	
	//码表列表页
	@RequestMapping("/code/toCodeList.do")
	public ModelAndView toList(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpCode> listC = erpCodeService.getAll(con);
		int totalRecode = listC.size();
		
		request.setAttribute("totalRecode", totalRecode);
		request.setAttribute("codeList", listC);
			
		mav.setViewName("code/codeList");
			
		return mav;
			
	}
	//到码表添加页
	@RequestMapping("/code/toCodeAdd.do")
	public ModelAndView toAdd(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
			
		mav.setViewName("code/codeAdd");
		return mav;

	}
	//码表添加
	@RequestMapping("/code/codeAdd.do")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		String key = request.getParameter("key");
		String value = request.getParameter("value");
		String type = request.getParameter("type");
		
		ErpCode ec = new ErpCode();
		ec.setId(IdUtil.getUuid());
		ec.setKey(key);
		ec.setValue(value);
		ec.setType(type);
		erpCodeService.add(ec);
		
		request.getRequestDispatcher("/code/toCodeList.do").forward(request, response);
		return mav;
		
	}
	
	//跳转到修改页
	@RequestMapping("/code/toCodeUpdate.do")
	public ModelAndView toUpdate(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		ErpCode ec = erpCodeService.getById(id);
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
	
		
		
		request.setAttribute("code", ec);
		
		mav.setViewName("code/codeUpdate");
		return mav;

	}
	
	//码表信息修改
	@RequestMapping("/code/codeUpdate.do")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		ErpCode ec = new ErpCode();
		String id = request.getParameter("id");
		String key = request.getParameter("key");
		String value = request.getParameter("value");
		String type = request.getParameter("type");
		
		ec.setId(id);
		ec.setKey(key);
		ec.setValue(value);
		ec.setType(type);
		erpCodeService.update(ec);
		
		request.getRequestDispatcher("/code/toCodeList.do").forward(request, response);
		return mav;
	}
	//码表删除
	@RequestMapping("/code/toCodeDelete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			
		String id = request.getParameter("id");
		if(!id.contains(",")){
			erpCodeService.delete(id);
		}else{
			String []idList = id.split(",");
			for(String c:idList){
				erpCodeService.delete(c);
			}
		}
			
		request.getRequestDispatcher("/code/toCodeList.do").forward(request, response);
			
	}
}



















