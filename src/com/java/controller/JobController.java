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
import com.java.bean.ErpJob;
import com.java.bean.ErpJobResource;
import com.java.bean.ErpResource;
import com.java.service.ErpCodeService;
import com.java.service.ErpJobResourceService;
import com.java.service.ErpJobService;
import com.java.service.ErpResourceService;
import com.java.util.IdUtil;
import com.java.util.VoUtil;
import com.java.vo.JobVo;

@Controller
public class JobController {

	@Autowired
	private ErpJobService erpJobService;
	@Autowired
	private ErpCodeService erpCodeService;
	@Autowired
	private ErpResourceService erpResourceService;
	@Autowired
	private ErpJobResourceService erpJobResourceService;
	
	//跳转到职位列表
	@RequestMapping("/job/toList.do")
	public ModelAndView toList(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpJob> listJ = erpJobService.getAll(con);
		List<JobVo>  listVo = VoUtil.getJobVoList(listJ);
		int totalRecode = listVo.size();//传一个总的记录条数用于分页
		
		request.setAttribute("totalRecode", totalRecode);
		request.setAttribute("jobList", listVo);
		mav.setViewName("job/list");
		
		return mav;
	}
	
	
	//到职位添加页
	@RequestMapping("/job/toAdd.do")
	public ModelAndView toAdd(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		List<ErpCode> listC = erpCodeService.getByType("STATE");
		request.getSession().setAttribute("codeList", listC);

		List<ErpResource> deptList = erpResourceService.getByRole_type("dept");
		System.out.println("=============================="+deptList.size());
		List<ErpResource> goodsList = erpResourceService.getByRole_type("goods");
		List<ErpResource> erpCodeList = erpResourceService.getByRole_type("code");
		List<ErpResource> warehouseList = erpResourceService.getByRole_type("warehouse");
		List<ErpResource> organizationList = erpResourceService.getByRole_type("organization");
		List<ErpResource> myAccountList = erpResourceService.getByRole_type("account");
		List<ErpResource> customerList = erpResourceService.getByRole_type("customer");
		List<ErpResource> userList = erpResourceService.getByRole_type("user");
		List<ErpResource> purchaseList = erpResourceService.getByRole_type("purchase");
		List<ErpResource> purchaseGoodsList = erpResourceService.getByRole_type("purchaseGoods");
		List<ErpResource> purchaseOrderList = erpResourceService.getByRole_type("purchaseOrder");
		List<ErpResource> purchaseOrderGoodsList = erpResourceService.getByRole_type("purchaseOrderGoods");
		List<ErpResource> saleList = erpResourceService.getByRole_type("sale");
		List<ErpResource> saleGoodsList = erpResourceService.getByRole_type("saleGoods");
		List<ErpResource> saleOrderList = erpResourceService.getByRole_type("saleOrder");
		List<ErpResource> saleOrderGoodsList = erpResourceService.getByRole_type("saleOrderGoods");
		List<ErpResource> saleReturnList = erpResourceService.getByRole_type("saleReturn");
		List<ErpResource> saleReturnGoodsList = erpResourceService.getByRole_type("saleReturnGoods");
		List<ErpResource> cashStatementList = erpResourceService.getByRole_type("cashStatement");
		List<ErpResource> resourceList = erpResourceService.getByRole_type("resource");
		List<ErpResource> jobList = erpResourceService.getByRole_type("job");
		
		
		request.setAttribute("deptList", deptList);
		request.setAttribute("erpCodeList", erpCodeList);
		request.setAttribute("warehouseList", warehouseList);
		request.setAttribute("organizationList", organizationList);
		request.setAttribute("myAccountList", myAccountList);
		request.setAttribute("customerList", customerList);
		request.setAttribute("userList", userList);
		request.setAttribute("purchaseList", purchaseList);
		request.setAttribute("purchaseGoodsList", purchaseGoodsList);
		request.setAttribute("purchaseOrderList", purchaseOrderList);
		request.setAttribute("purchaseOrderGoodsList", purchaseOrderGoodsList);
		request.setAttribute("saleList", saleList);
		request.setAttribute("saleGoodsList", saleGoodsList);
		request.setAttribute("goodsList", goodsList);
		request.setAttribute("saleOrderList", saleOrderList);
		request.setAttribute("saleOrderGoodsList", saleOrderGoodsList);
		request.setAttribute("saleReturnList", saleReturnList);
		request.setAttribute("saleReturnGoodsList", saleReturnGoodsList);
		request.setAttribute("cashStatementList", cashStatementList);
		request.setAttribute("resourceList", resourceList);
		request.setAttribute("jobList", jobList);
		
		mav.setViewName("job/add");
		return mav;
	}
	
	//到职位添加操作
	@RequestMapping("/job/add.do")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		String job_name = request.getParameter("job_name");
		String state = request.getParameter("state");
		
		ErpJob ej = new ErpJob();
		ej.setJob_id(IdUtil.getUuid());
		ej.setJob_name(job_name);
		ej.setState(state);
		
		erpJobService.add(ej);
		String resource[] = request.getParameterValues("resource");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(resource.length);
		if(resource!=null){
			for(String id:resource){

				ErpJobResource ejr = new ErpJobResource();
				ejr.setId(IdUtil.getUuid());
				ejr.setJob_id(ej.getJob_id());
				ejr.setResource_id(id);
				erpJobResourceService.add(ejr);
			}
		}
		
		request.getRequestDispatcher("/job/toList.do").forward(request, response);
		
		return mav;
		
	}
	
	//到职位修改页
	@RequestMapping("/job/toUpdate.do")
	public ModelAndView toUpdate(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("job_id");
		ErpJob ej = erpJobService.getById(id);
		
		List<ErpCode> listC = erpCodeService.getByType("STATE");
		request.getSession().setAttribute("codeList", listC);
		request.setAttribute("job", ej);
		
		mav.setViewName("job/update");
		
		return mav;
		
	}
	
	//到职位修改操作
	@RequestMapping("/job/update.do")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		String job_id = request.getParameter("job_id");
		String job_name = request.getParameter("job_name");
		String state = request.getParameter("state");
		
		ErpJob ej = new ErpJob();
		ej.setJob_id(job_id);
		ej.setJob_name(job_name);
		ej.setState(state);
		
		erpJobService.update(ej);
		
		request.getRequestDispatcher("/job/toList.do").forward(request, response);
		
		return mav;
	
	}
	
	//到职位删除
	@RequestMapping("/job/toDelete.do")
	public void toDelete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("job_id");
		if(!id.contains(",")){
			erpJobService.delete(id);
		}else{
			String []idList = id.split(",");
			for(String d:idList){
				erpJobService.delete(d);
			}
		}
		List<ErpJobResource> list = erpJobResourceService.getAll(id);
		for(ErpJobResource erj :list){
			
			erpJobResourceService.delete(erj.getId());
		}
		
		
		
		request.getRequestDispatcher("/job/toList.do").forward(request, response);
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
