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
import com.java.bean.ErpWarehouse;
import com.java.service.ErpCodeService;
import com.java.service.ErpOrganizationService;
import com.java.service.ErpWarehouseService;
import com.java.util.DateAndTimeUtil;
import com.java.util.IdUtil;
import com.java.util.VoUtil;
import com.java.vo.WarehouseVo;


@Controller
public class WarehouseController {

	@Autowired
	private ErpWarehouseService erpWarehouseService;
	@Autowired
	private ErpCodeService erpCodeService;
	@Autowired
	private ErpOrganizationService erpOrganizationService;
	
	
	//仓库列表
	@RequestMapping("/warehouse/toList.do")
	public ModelAndView toList(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		request.getSession().setAttribute("myCon", con);
		List<ErpWarehouse> list = erpWarehouseService.getAll(con);
		/*if(list!=null){
			for(ErpWarehouse ew:list){
				System.out.println(ew.getName());
			}
		}*/
		List<WarehouseVo> listVo = VoUtil.getWarehouseVoList(list);
		int totalRecode = listVo.size();
		
		request.setAttribute("totalRecode", totalRecode);
		request.getSession().setAttribute("ewList", listVo);
		
		mav.setViewName("warehouse/list");
		
		return mav;
	}
	
	//到仓库添加页
	@RequestMapping("/warehouse/toAdd.do")
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
		/*List<String> list = new ArrayList<String>();
		if(list1!=null){
			for(ErpDept ed:list1){
				list.add(ed.getName());
			}
			
		}*/
		request.getSession().setAttribute("codeList", listC);
		request.getSession().setAttribute("organList", list1);
		mav.setViewName("warehouse/add");
		
		return mav;
	}
	
	//仓库添加
	@RequestMapping("/warehouse/add.do")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		String name = request.getParameter("name");
		String subsidiary_organ = request.getParameter("subsidiary_organ");
		String principal = request.getParameter("principal");
		String phone = request.getParameter("phone");
		String state = request.getParameter("state");
		/*System.out.println("=========1="+name);
		System.out.println("=========2="+subsidiary_organ);
		System.out.println("=========3="+principal);
		System.out.println("=========4="+phone);*/
		ErpWarehouse ew = new ErpWarehouse();
		ew.setWarehouse_id(IdUtil.getUuid());
		ew.setName(name);
		ew.setPrincipal(principal);
		ew.setPhone(phone);
		ew.setSubsidiary_organ(subsidiary_organ);
		ew.setCreate_time(DateAndTimeUtil.getDateAndTime());
		ew.setState(state);		//state不能为空？
		
		erpWarehouseService.add(ew);
		
		request.getRequestDispatcher("/warehouse/toList.do").forward(request, response);
		return mav;
	}
	
	//跳转到仓库更新页
	@RequestMapping("/warehouse/toUpdate.do")
	public ModelAndView toUpdate(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("warehouse_id");
		ErpWarehouse ew = erpWarehouseService.getById(id);
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
		
		request.setAttribute("Warehouse", ew);
		mav.setViewName("warehouse/update");
		return mav;
		
	}
	
	//仓库信息更新
	@RequestMapping("/warehouse/update.do")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		ErpWarehouse ew = new ErpWarehouse();
		String id = request.getParameter("warehouse_id");
		String name = request.getParameter("name");
		String subsidiary_organ = request.getParameter("subsidiary_organ");
		String principal = request.getParameter("principal");
		String phone = request.getParameter("phone");
		String create_time = request.getParameter("create_time");
		String state = request.getParameter("state");
		ew.setWarehouse_id(id);
		ew.setName(name);
		ew.setSubsidiary_organ(subsidiary_organ);
		ew.setPrincipal(principal);
		ew.setPhone(phone);
		ew.setCreate_time(create_time);
		ew.setState(state);
		
		erpWarehouseService.update(ew);
		request.getRequestDispatcher("/warehouse/toList.do").forward(request, response);
		return mav;
	}
	
	/*@RequestMapping("/warehouse/toLook.do")
	public ModelAndView look(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("id");
		ErpWarehouse mu = erpWarehouseService.getById(id);
		request.setAttribute("myUser", mu);
		
		mav.setViewName("warehouse/look");
		
		return mav;
	}*/
	
	//仓库删除
	@RequestMapping("/warehouse/toDelete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("warehouse_id");
		if(!id.contains(",")){
			erpWarehouseService.delete(id);
		}else{
			String []idList = id.split(",");
			for(String d:idList){
				erpWarehouseService.delete(d);
			}
		}
		
		request.getRequestDispatcher("/warehouse/toList.do").forward(request, response);
		
	}
	
	
	
}
