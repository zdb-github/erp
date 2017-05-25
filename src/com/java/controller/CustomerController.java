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
import com.java.bean.ErpCustomer;
import com.java.service.ErpCodeService;
import com.java.service.ErpCustomerService;
import com.java.util.IdUtil;
import com.java.util.VoUtil;
import com.java.vo.ErpCustomerVo;

@Controller
public class CustomerController {

	@Autowired
	private ErpCustomerService erpCustomerService;
	@Autowired
	private ErpCodeService erpCodeService;
	
	
	//客户列表页
	@RequestMapping("/customer/toCustomerList.do")
	public ModelAndView toList(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpCustomer> listC = erpCustomerService.getAll(con);
		List<ErpCustomerVo> listV = VoUtil.getErpCustomerVoList(listC);
		int totalRecode = listV.size();
		
		request.setAttribute("totalRecode", totalRecode);
		request.setAttribute("customerList", listV);
			
		mav.setViewName("customer/customerList");
			
		return mav;
			
	}
		
	//跳转到客户添加页
	@RequestMapping("/customer/toCustomerAdd.do")
	public ModelAndView toAdd(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpCustomer> list1 = erpCustomerService.getAll(con);
		List<ErpCode> listS = erpCodeService.getByType("SEX");
		List<ErpCode> listC = erpCodeService.getByType("C_TYPE");
		request.setAttribute("sexList", listS);
		request.setAttribute("c_typeList", listC);
		request.setAttribute("customerList", list1);
			
		mav.setViewName("customer/customerAdd");
		return mav;

	}
	
	//客户添加
	@RequestMapping("/customer/customerAdd.do")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String company = request.getParameter("company");
		String phone = request.getParameter("phone");
		String c_type = request.getParameter("c_type");
		
		ErpCustomer ec = new ErpCustomer();
		ec.setId(IdUtil.getUuid());
		ec.setName(name);
		ec.setSex(sex);
		ec.setAge(age);
		ec.setAddress(address);
		ec.setCompany(company);
		ec.setPhone(phone);
		ec.setC_type(c_type);
		
		erpCustomerService.add(ec);
		
		request.getRequestDispatcher("/customer/toCustomerList.do").forward(request, response);
		return mav;
		
	}
	
	//跳转到修改页
	@RequestMapping("/customer/toCustomerUpdate.do")
	public ModelAndView toUpdate(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		ErpCustomer ec = erpCustomerService.getById(id);
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpCustomer> list1 = erpCustomerService.getAll(con);
		List<ErpCode> listS = erpCodeService.getByType("SEX");
		List<ErpCode> listC = erpCodeService.getByType("C_TYPE");
		request.setAttribute("sexList", listS);
		request.setAttribute("c_typeList", listC);
		request.setAttribute("customerList", list1);
		
		request.setAttribute("customer", ec);
		
		mav.setViewName("customer/customerUpdate");
		return mav;

	}
	
	//客户信息修改
	@RequestMapping("/customer/customerUpdate.do")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		ErpCustomer ec = new ErpCustomer();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String company = request.getParameter("company");
		String phone = request.getParameter("phone");
		String c_type = request.getParameter("c_type");
		
		ec.setId(id);
		ec.setName(name);
		ec.setSex(sex);
		ec.setAge(age);
		ec.setAddress(address);
		ec.setCompany(company);
		ec.setPhone(phone);
		ec.setC_type(c_type);
		
		erpCustomerService.update(ec);
		
		request.getRequestDispatcher("/customer/toCustomerList.do").forward(request, response);
		return mav;
	}
	
	//客户信息删除
	@RequestMapping("/customert/toCustomerDelete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			
		String id = request.getParameter("id");
		if(!id.contains(",")){
			erpCustomerService.delete(id);
		}else{
			String []idList = id.split(",");
			for(String d:idList){
				erpCustomerService.delete(d);
			}
		}
			
		request.getRequestDispatcher("/customer/toCustomerList.do").forward(request, response);
			
	}
	
	
}
