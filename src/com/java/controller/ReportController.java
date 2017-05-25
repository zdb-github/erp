package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.bean.ErpCode;
import com.java.bean.ErpCustomer;
import com.java.bean.ErpDept;
import com.java.bean.ErpOrganization;
import com.java.bean.ErpPurchase;
import com.java.bean.ErpPurchaseGoods;
import com.java.bean.ErpSale;
import com.java.bean.ErpSaleGoods;
import com.java.bean.ErpUser;
import com.java.bean.ErpWarehouse;
import com.java.service.ErpCodeService;
import com.java.service.ErpCustomerService;
import com.java.service.ErpDeptService;
import com.java.service.ErpOrganizationService;
import com.java.service.ErpPurchaseGoodsService;
import com.java.service.ErpPurchaseService;
import com.java.service.ErpSaleGoodsService;
import com.java.service.ErpSaleService;
import com.java.service.ErpUserService;
import com.java.service.ErpWarehouseService;
import com.java.util.VoUtil;
import com.java.vo.ErpPurchaseGoodsVo;
import com.java.vo.ErpPurchaseVo;
import com.java.vo.ErpSaleGoodsVo;
import com.java.vo.ErpSaleVo;

@Controller
public class ReportController {

	@Autowired
	private ErpSaleService erpSaleService;
	@Autowired
	private ErpPurchaseService erpPurchaseService;
	@Autowired
	private ErpCustomerService erpCustomerService;
	@Autowired
	private ErpDeptService erpDeptService;
	@Autowired
	private ErpOrganizationService erpOrganizationService;
	@Autowired
	private ErpWarehouseService erpWarehouseService;
	@Autowired
	private ErpUserService erpUserService;
	@Autowired
	private ErpCodeService erpCodeService;
	@Autowired
	private ErpPurchaseGoodsService erpPurchaseGoodsService;
	@Autowired
	private ErpSaleGoodsService erpSaleGoodsService;
	
	
	@RequestMapping("/report/toListSale.do")
	public ModelAndView toListSale(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		//使用查询功能提取到的要查询的字段
		String customer_id = request.getParameter("customer_id");
		String salesman_id = request.getParameter("salesman_id");
		String dept_id = request.getParameter("dept_id");
		String organization_id = request.getParameter("organization_id");
		String sale_type = request.getParameter("sale_type");	
		String create_time = request.getParameter("create_time");
		
		ErpSale erpSale = new ErpSale();
		erpSale.setCustomer_id(customer_id);
		erpSale.setSalesman_id(salesman_id);
		erpSale.setDept_id(dept_id);
		erpSale.setOrganization_id(organization_id);
		erpSale.setSale_type(sale_type);
		erpSale.setCreate_time(create_time);
		
		String con = "%%";
		
		List<ErpSaleVo> erpSaleVoList = new ArrayList<ErpSaleVo>();
		if(erpSale==null){
			//得到还未点击查询时的所有采购订单的列表
			List<ErpSale> erpSaleList = erpSaleService.getAll(con);
			if(erpSaleList!=null){//转换成vo类向页面输出
				erpSaleVoList = VoUtil.getSaleVo(erpSaleList);
				int totalRecode = erpSaleVoList.size();
				
				request.setAttribute("totalRecode", totalRecode);
			}
			
		}else{
			//根据点击查询时获取的查询条件得到集合
			List<ErpSale> erpSaleList = erpSaleService.selectSale(erpSale);
			if(erpSaleList!=null){//转换成vo类向页面输出
				erpSaleVoList = VoUtil.getSaleVo(erpSaleList);
				int totalRecode = erpSaleVoList.size();
				
				request.setAttribute("totalRecode", totalRecode);
				request.setAttribute("erpSaleList", erpSaleVoList);
			}
		}
		request.setAttribute("erpSaleList", erpSaleVoList);
		
		//获取所有可查询的字段的列表
		List<ErpCustomer> customerList = erpCustomerService.getAll(con);//供应商列表
		List<ErpDept> deptList = erpDeptService.getAll(con);//部门列表
		List<ErpOrganization> organizationList = erpOrganizationService.getAll(con);//机构列表
		List<ErpUser> userList = erpUserService.getAll(con);//员工列表
		List<ErpCode> saleTypeList = erpCodeService.getByType("SALE_TYPE");
		//将这些列表向页面传值
		request.setAttribute("customerList", customerList);
		request.setAttribute("deptList", deptList);
		request.setAttribute("organizationList", organizationList);
		request.setAttribute("userList", userList);
		request.setAttribute("saleTypeList", saleTypeList);
		
		mav.setViewName("report/saleReport");
		return mav;
	}
	
	@RequestMapping("/report/toListPurchase.do")
	public ModelAndView toListPurchase(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		//使用查询功能提取到的要查询的字段
		String purchase_id = request.getParameter("purchase_id");
		String create_time = request.getParameter("create_time");
		String supplier_id = request.getParameter("supplier_id");
		String purchaser_id = request.getParameter("purchaser_id");
		String dept_id = request.getParameter("dept_id");
		String warehouse_id = request.getParameter("warehouse_id");
		String organization_id = request.getParameter("organization_id");
		
		ErpPurchase erpPurchase = new ErpPurchase();
		erpPurchase.setPurchase_id(purchase_id);
		erpPurchase.setCreate_time(create_time);
		erpPurchase.setSupplier_id(supplier_id);
		erpPurchase.setPurchaser_id(purchaser_id);
		erpPurchase.setDept_id(dept_id);
		erpPurchase.setWarehouse_id(warehouse_id);
		erpPurchase.setOrganization_id(organization_id);
		
		String con = "%%";
		List<ErpPurchaseVo> erpPurchaseVoList = new ArrayList<ErpPurchaseVo>();
		if(erpPurchase==null){
			//得到还未点击查询时的所有采购订单的列表
			List<ErpPurchase> erpPurchaseList = erpPurchaseService.getAll(con);
			if(erpPurchaseList!=null){//转换成vo类向页面输出
				erpPurchaseVoList = VoUtil.getPurchaseVo(erpPurchaseList);
				int totalRecode = erpPurchaseVoList.size();
				
				request.setAttribute("totalRecode", totalRecode);
			}
			
		}else{
			//根据点击查询时获取的查询条件得到集合
			List<ErpPurchase> erpPurchaseList = erpPurchaseService.selectPurchase(erpPurchase);
			if(erpPurchaseList!=null){//转换成vo类向页面输出
				erpPurchaseVoList = VoUtil.getPurchaseVo(erpPurchaseList);
				int totalRecode = erpPurchaseVoList.size();
				
				request.setAttribute("totalRecode", totalRecode);
				//request.setAttribute("erpPurchaseList", erpPurchaseVoList);
			}
		}
		request.setAttribute("erpPurchaseList", erpPurchaseVoList);
		
		//获取所有可查询的字段的列表
		List<ErpCustomer> customerList = erpCustomerService.getAll(con);//供应商列表
		List<ErpDept> deptList = erpDeptService.getAll(con);//部门列表
		List<ErpOrganization> organizationList = erpOrganizationService.getAll(con);//机构列表
		List<ErpWarehouse> warehouseList = erpWarehouseService.getAll(con);//仓库列表
		List<ErpUser> userList = erpUserService.getAll(con);//员工列表
		//将这些列表向页面传值
		request.setAttribute("customerList", customerList);
		request.setAttribute("deptList", deptList);
		request.setAttribute("organizationList", organizationList);
		request.setAttribute("warehouseList", warehouseList);
		request.setAttribute("userList", userList);
		
		request.setAttribute("purchase_id", purchase_id);
		mav.setViewName("report/purchaseReport");
		return mav;
		
	}
	
	@RequestMapping("/report/toLookSale.do")
	public ModelAndView toLookSale(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		
		String sale_id = request.getParameter("sale_id");
		
		ErpSale erpSale = erpSaleService.getById(sale_id);
		if(erpSale!=null){
			ErpSaleVo erpSaleVo = VoUtil.getSaleVo(erpSale);
			
			request.setAttribute("erpSale", erpSaleVo);
		}
		
		List<ErpSaleGoods> saleGoodsList = erpSaleGoodsService.getBySaleId(sale_id);
		if(saleGoodsList!=null){
			List<ErpSaleGoodsVo> saleGoodsVoList = VoUtil.getSaleGoodsVo(saleGoodsList);
			int totalRecode = saleGoodsVoList.size();
			
			request.setAttribute("totalRecode", totalRecode);
			request.setAttribute("saleGoodsList", saleGoodsVoList);
		}
		
		mav.setViewName("report/lookSale");
		return mav;
	}
	
	@RequestMapping("/report/toLookPurchase.do")
	public ModelAndView toLookPurchase(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		
		String purchase_id = request.getParameter("purchase_id");
		
		ErpPurchase erpPurchase = erpPurchaseService.getById(purchase_id);
		if(erpPurchase!=null){
			ErpPurchaseVo erpPurchaseVo = VoUtil.getPurchaseVo(erpPurchase);
			request.setAttribute("erpPurchase", erpPurchaseVo);
		}
		
		List<ErpPurchaseGoods> purchaseGoodsList = erpPurchaseGoodsService.getByPurchaseId(purchase_id);
		if(purchaseGoodsList!=null){
			List<ErpPurchaseGoodsVo> purchaseGoodsVoList = VoUtil.getPurchaseGoodsVo(purchaseGoodsList);
			int totalRecode = purchaseGoodsVoList.size();
			
			request.setAttribute("totalRecode", totalRecode);
			request.setAttribute("purchaseGoodsList", purchaseGoodsVoList);
		}
		
		mav.setViewName("report/lookPurchase");
		return mav;
		
		
	}
	
}
