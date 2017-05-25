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
import com.java.bean.ErpOrganization;
import com.java.service.ErpCodeService;
import com.java.service.ErpOrganizationService;
import com.java.util.IdUtil;
import com.java.util.VoUtil;
import com.java.vo.OrganizationVo;

@Controller
public class OrganizationController {

	@Autowired
	private ErpOrganizationService erpOrganizationService;
	@Autowired
	private ErpCodeService erpCodeService;
	
	
	//机构列表页
	@RequestMapping("/organization/toList.do")
	public ModelAndView toList(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpOrganization> listO = erpOrganizationService.getAll(con);
		List<OrganizationVo> listVo = VoUtil.getOrganizationVoList(listO);
		int totalRecode = listVo.size();
		
		request.setAttribute("totalRecode", totalRecode);
		request.getSession().setAttribute("organList", listVo);
		
		mav.setViewName("organization/list");
		
		return mav;
		
	}
	
	//到机构添加页
	@RequestMapping("/organization/toAdd.do")
	public ModelAndView toAdd(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		List<ErpCode> listC = erpCodeService.getByType("STATE");
		request.getSession().setAttribute("codeList", listC);
		
		mav.setViewName("organization/add");
		return mav;

	}
	
	//机构添加操作
	@RequestMapping("/organization/add.do")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String state = request.getParameter("state");
		
		ErpOrganization eo = new ErpOrganization();
		eo.setOrganization_id(IdUtil.getUuid());
		eo.setName(name);
		eo.setAddress(address);
		eo.setState(state);
		
		erpOrganizationService.add(eo);
		
		request.getRequestDispatcher("/organization/toList.do").forward(request, response);
		
		return mav;
	}
	
	//到机构修改页
	@RequestMapping("/organization/toUpdate.do")
	public ModelAndView toUpdate(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("organization_id");
		ErpOrganization eo = erpOrganizationService.getById(id);
		List<ErpCode> listC = erpCodeService.getByType("STATE");
		
		request.getSession().setAttribute("organ", eo);
		request.getSession().setAttribute("codeList", listC);
		
		mav.setViewName("organization/update");
		
		return mav;
	}
	
	//ji构信息更新
	@RequestMapping("/organization/update.do")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		String organization_id = request.getParameter("organization_id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String state = request.getParameter("state");
		
		ErpOrganization eo = new ErpOrganization();
		eo.setOrganization_id(organization_id);
		eo.setName(name);
		eo.setAddress(address);
		eo.setState(state);
		
		erpOrganizationService.update(eo);
		
		request.getRequestDispatcher("/organization/toList.do").forward(request, response);
		
		return mav;
	}
	
	//仓库删除
	@RequestMapping("/organization/toDelete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{			
		String id = request.getParameter("organization_id");
		if(!id.contains(",")){
			erpOrganizationService.delete(id);
		}else{
			String []idList = id.split(",");
			for(String d:idList){
				erpOrganizationService.delete(d);
			}
		}
		
		
		
		request.getRequestDispatcher("/warehouse/toList.do").forward(request, response);
			
		}
}
