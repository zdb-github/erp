package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.bean.ErpAccount;
import com.java.bean.ErpCashStatement;
import com.java.bean.ErpCode;
import com.java.bean.ErpCustomer;
import com.java.bean.ErpGoods;
import com.java.bean.ErpOrganization;
import com.java.bean.ErpSaleReturn;
import com.java.bean.ErpSrGoods;
import com.java.bean.ErpUser;
import com.java.bean.ErpWarehouse;
import com.java.service.ErpCashStatementService;
import com.java.service.ErpCodeService;
import com.java.service.ErpCustomerService;
import com.java.service.ErpGoodsService;
import com.java.service.ErpOrganizationService;
import com.java.service.ErpSaleReturnService;
import com.java.service.ErpSrGoodsService;
import com.java.service.ErpUserService;
import com.java.service.ErpWarehouseService;
import com.java.util.IdUtil;
import com.java.util.VoUtil;
import com.java.vo.ErpCashStatementVo;
import com.java.vo.ErpSaleReturnVo;
import com.java.vo.ErpSrGoodsVo;

@Controller
public class SaleReturnController {

	@Autowired
	private ErpCustomerService erpCustomerService;
	@Autowired
	private ErpOrganizationService erpOrganizationService;
	@Autowired
	private ErpWarehouseService erpWarehouseService;
	@Autowired
	private ErpUserService erpUserService;
	@Autowired
	private ErpGoodsService erpGoodsService;
	@Autowired
	private ErpSaleReturnService erpSaleReturnService;
	@Autowired
	private ErpSrGoodsService erpSrGoodsService;
	@Autowired
	private ErpCodeService erpCodeService;
	@Autowired
	private ErpCashStatementService erpCashStatementService;
	
	
	
	@RequestMapping("/saleReturn/toAddSr.do")
	public ModelAndView toAddSr(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("saleReturn/addSr");
		String sr_id = request.getParameter("sr_id");
		System.out.println("——————————toAddPo里的————————"+sr_id);
		if(sr_id==null||sr_id==""||sr_id.equals("null")){
			String srId = IdUtil.getInvoicesId();
			sr_id = srId;
			request.setAttribute("sr_id", sr_id);
			
		}
		request.setAttribute("sr_id", sr_id);
		String con = "%%";
		List<ErpCustomer> customerList = erpCustomerService.getAll(con);
		List<ErpOrganization> organizationList = erpOrganizationService.getAll(con);
		List<ErpUser> userList = erpUserService.getAll(con);
		List<ErpCode> paymentList = erpCodeService.getByType("PAYMENT_METHOD");
		List<ErpSrGoods> srGoodsList = erpSrGoodsService.getBySrId(sr_id);
		
		if(srGoodsList!=null){
			List<ErpSrGoodsVo> srGoodsVoList = VoUtil.getSrGoodsVo(srGoodsList);
			int totalRecode = srGoodsVoList.size();
			
			request.setAttribute("totalRecode", totalRecode);
			request.setAttribute("srGoodsList", srGoodsVoList);
		}
		request.setAttribute("customerList", customerList);
		request.setAttribute("organizationList", organizationList);
		request.setAttribute("userList", userList);
		request.setAttribute("paymentList", paymentList);
		
		return mav;
		
	}
	
	@RequestMapping("/saleReturn/addSr.do")
	public String addSr(HttpServletRequest request,HttpServletResponse response){
		
		System.out.println("-进入1-");
		String sr_id = request.getParameter("sr_id");
		System.out.println("——————————addPo里的————————"+sr_id);
		System.out.println(sr_id);
		String create_time = request.getParameter("create_time");
		String customer_id = request.getParameter("customer_id");
		String employee_id = request.getParameter("employee_id");
		String organization_id = request.getParameter("organization_id");
		String invoices_state = request.getParameter("invoices_state");
		String payment_method = request.getParameter("payment_method");
		int money =	erpSrGoodsService.getAmount(sr_id);
		String invalid_id="";
		
		ErpAccount ea = (ErpAccount)request.getSession().getAttribute("erpAccount");
		String originator_id = ea.getUser_id();	//制单人的id就是当前登录人员的员工id
		
		ErpSaleReturn erpSaleReturn = new ErpSaleReturn();
		erpSaleReturn.setSr_id(sr_id);
		erpSaleReturn.setCreate_time(create_time);
		erpSaleReturn.setCustomer_id(customer_id);
		erpSaleReturn.setEmployee_id(employee_id);
		erpSaleReturn.setMoney(money);
		erpSaleReturn.setOriginator_id(originator_id);
		erpSaleReturn.setOrganization_id(organization_id);
		erpSaleReturn.setInvoices_state(invoices_state);
		erpSaleReturn.setInvalid_id(invalid_id);
		erpSaleReturn.setPayment_method(payment_method);
		
		if(erpSaleReturnService.add(erpSaleReturn)){
			List<ErpSrGoods> pogList = erpSrGoodsService.getBySrId(sr_id);
			if(pogList!=null){
				for(ErpSrGoods epg:pogList){
					List<ErpCashStatement> csl =  erpCashStatementService.getByWIAndGI(epg.getWarehouse_id(), epg.getGoods_id());
					//如果不为空，就是对应的仓库原来有这个商品，只要更改数量就可以了
					if(csl.size()>0){
						int num = csl.get(0).getGoods_num();//原来库存中的对应商品的数量
						int goodsStock = num+epg.getGoods_num();//库存中原来的商品数量加上退货后的商品数量
						String csId = csl.get(0).getStatement_id();
						ErpCashStatement ecs = new ErpCashStatement();
						ecs.setGoods_num(goodsStock);
						ecs.setStatement_id(csId);
						erpCashStatementService.update(ecs);
					//如果为空，就说明原来对应的仓库中没有这个商品，就需要新添加一个记录
					}
				}
			}
		}
		
		return "forward:/saleReturn/toListSr.do";
	}
	
	@RequestMapping("/saleReturn/toAddSrGoods.do")
	public ModelAndView toAddSrGoods(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		String sr_id = request.getParameter("sr_id"); 
		System.out.println("—————#—————toAddPoGoods里的———&—————"+sr_id);
		System.out.println("++++++++++++"+sr_id);
		String con = "%%";
		List<ErpCashStatement> goodsList = erpCashStatementService.getAll(con);//库存中有的商品的列表
		if(goodsList!=null){
			List<ErpCashStatementVo> cashGoodsVo = VoUtil.getCashStatementVo(goodsList);
			request.setAttribute("goodsList", cashGoodsVo);
		}
		List<ErpSrGoods> srGoodsList = erpSrGoodsService.getBySrId(sr_id);
		
		if(srGoodsList!=null){
			List<ErpSrGoodsVo> srGoodsVoList = VoUtil.getSrGoodsVo(srGoodsList);
			request.setAttribute("srGoodsList", srGoodsVoList);
		}
		
		request.setAttribute("sr_id", sr_id);
		mav.setViewName("saleReturn/addSrGoods");
		return mav;
	}
	
	@RequestMapping("/saleReturn/addSrGoods.do")
	public  String addSrGoods(HttpServletRequest request){
          
		String id = IdUtil.getUuid();
		String cashStatement = request.getParameter("goods_id");
		String goods_numStr = request.getParameter("goods_num");
		String remark = request.getParameter("remark");
		String sr_id = request.getParameter("sr_id");
		
		System.out.println("——————————addPoGoods里的————————"+sr_id);
		
		String goods_id = "";
		String warehouse_id = "";
		int goods_prices = 0;
		ErpCashStatement erpCashGoods = erpCashStatementService.getById(cashStatement);
		if(erpCashGoods!=null){
			goods_id = erpCashGoods.getGoods_id();
			warehouse_id = erpCashGoods.getWarehouse_id();
			ErpGoods erpGoods = erpGoodsService.getById(goods_id);
			goods_prices = erpGoods.getGoods_prices();		//通过得到的商品id获取商品的单价
		}
		int goods_num = Integer.valueOf(goods_numStr);
		
		System.out.println("++++++++++++"+sr_id);
		
		ErpSrGoods erpSrGoods = new ErpSrGoods();
		erpSrGoods.setGoods_id(goods_id);
		erpSrGoods.setId(id);
		erpSrGoods.setGoods_num(goods_num);
		erpSrGoods.setGoods_prices(goods_prices);
		erpSrGoods.setRemark(remark);
		erpSrGoods.setSr_id(sr_id);
		erpSrGoods.setWarehouse_id(warehouse_id);
		erpSrGoodsService.add(erpSrGoods);
		
		request.setAttribute("sr_id", sr_id);
		return "forward:/saleReturn/toAddSrGoods.do";
	}
	
	@RequestMapping("/saleReturn/toListSr.do")
	public ModelAndView toListSr(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		//使用查询功能提取到的要查询的字段
		String sr_id = request.getParameter("sr_id");
		String create_time = request.getParameter("create_time");
		String customer_id = request.getParameter("customer_id");
		String employee_id = request.getParameter("employee_id");
		String organization_id = request.getParameter("organization_id");
		String invoices_state = request.getParameter("invoices_state");
		String payment_method = request.getParameter("payment_method");
		String originatior_id = request.getParameter("originatior_id");
		
		ErpSaleReturn erpSaleReturn = new ErpSaleReturn();
		erpSaleReturn.setSr_id(sr_id);
		erpSaleReturn.setCreate_time(create_time);
		erpSaleReturn.setCustomer_id(customer_id);
		erpSaleReturn.setEmployee_id(employee_id);
		erpSaleReturn.setOrganization_id(organization_id);
		erpSaleReturn.setInvoices_state(invoices_state);
		erpSaleReturn.setOriginator_id(originatior_id);
		erpSaleReturn.setPayment_method(payment_method);
		String con = "%%";
		
		List<ErpSaleReturnVo> erpSaleReturnVoList = new ArrayList<ErpSaleReturnVo>();
		if(erpSaleReturn==null){
			//得到还未点击查询时的所有采购订单的列表
			List<ErpSaleReturn> erpSaleReturnList = erpSaleReturnService.getAll(con);
			if(erpSaleReturnList!=null){//转换成vo类向页面输出
				erpSaleReturnVoList = VoUtil.getSaleReturnVo(erpSaleReturnList);
				int totalRecode = erpSaleReturnVoList.size();
				
				request.setAttribute("totalRecode", totalRecode);
			}
			
		}else{
			//根据点击查询时获取的查询条件得到集合
			List<ErpSaleReturn> erpSaleReturnList = erpSaleReturnService.selectSaleReturn(erpSaleReturn);
			if(erpSaleReturnList!=null){//转换成vo类向页面输出
				erpSaleReturnVoList = VoUtil.getSaleReturnVo(erpSaleReturnList);
				int totalRecode = erpSaleReturnVoList.size();
				
				request.setAttribute("totalRecode", totalRecode);
				request.setAttribute("erpSaleReturnList", erpSaleReturnVoList);
				
			}
		}
		request.setAttribute("erpSaleReturnList", erpSaleReturnVoList);
		
		//获取所有可查询的字段的列表
		List<ErpCustomer> customerList = erpCustomerService.getAll(con);//供应商列表
		List<ErpOrganization> organizationList = erpOrganizationService.getAll(con);//机构列表
		List<ErpWarehouse> warehouseList = erpWarehouseService.getAll(con);//仓库列表
		List<ErpUser> userList = erpUserService.getAll(con);//员工列表
		List<ErpCode> paymentList = erpCodeService.getByType("PAYMENT_METHOD");
		//将这些列表向页面传值
		request.setAttribute("customerList", customerList);
		request.setAttribute("organizationList", organizationList);
		request.setAttribute("warehouseList", warehouseList);
		request.setAttribute("userList", userList);
		request.setAttribute("paymentList", paymentList);
		
		request.setAttribute("sr_id", sr_id);
		mav.setViewName("saleReturn/listSr");
		return mav;
		
	}
	
	@RequestMapping("/saleReturn/toListSrGoods.do")
	public ModelAndView toListSrGoods(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		String sr_id = request.getParameter("sr_id");
		
		System.out.println("——————————toListPoGoods里的————————"+sr_id);
		
		List<ErpSrGoods> srGoodsList = erpSrGoodsService.getBySrId(sr_id);
		if(srGoodsList!=null){
			List<ErpSrGoodsVo> srGoodsVoList = VoUtil.getSrGoodsVo(srGoodsList);
			int totalRecode = srGoodsVoList.size();
			
			request.setAttribute("totalRecode", totalRecode);
			request.setAttribute("srGoodsList", srGoodsVoList);
		}
		
		
		request.setAttribute("sr_id", sr_id);
		mav.setViewName("saleReturn/listSrGoods");
		return mav;
	}
	
	@RequestMapping("/saleReturn/toLookSr.do")
	public ModelAndView toLookSr(HttpServletRequest request){
		
		
		ModelAndView mav = new ModelAndView();
		
		String sr_id = request.getParameter("sr_id");
		
		System.out.println("——————————toLookPo里的————————"+sr_id);
		
		ErpSaleReturn erpSaleReturn = erpSaleReturnService.getById(sr_id);
		if(erpSaleReturn!=null){
			ErpSaleReturnVo erpSaleReturnVo = VoUtil.getSaleReturnVo(erpSaleReturn);
			request.setAttribute("erpSaleReturn", erpSaleReturnVo);
		}
		
		List<ErpSrGoods> srGoodsList = erpSrGoodsService.getBySrId(sr_id);
		if(srGoodsList!=null){
			List<ErpSrGoodsVo> srGoodsVoList = VoUtil.getSrGoodsVo(srGoodsList);
			int totalRecode = srGoodsVoList.size();
			
			request.setAttribute("totalRecode", totalRecode);
			request.setAttribute("srGoodsList", srGoodsVoList);
		}
		
		mav.setViewName("saleReturn/lookSr");
		return mav;
		
	}
	
	
	@RequestMapping("/saleReturn/toLookSrGoods.do")
	public ModelAndView toLookSrGoods(HttpServletRequest request){
		
		
		ModelAndView mav = new ModelAndView();
		
		String sr_id = request.getParameter("sr_id");
		String id = request.getParameter("id");
		
		System.out.println("——————————toLookPoGoods里的————————"+sr_id);
		
		ErpSrGoods erpSrGoods  = erpSrGoodsService.getById(id);
		
		if(erpSrGoods!=null){
			ErpSrGoodsVo erpSrGoodsVo = VoUtil.getSrGoodsVo(erpSrGoods);
			request.setAttribute("erpSrGoodsVo", erpSrGoodsVo);
		}
		request.setAttribute("sr_id", sr_id);
		
		
		mav.setViewName("saleReturn/lookSrGoods");
		return mav;
		
	} 
	
	@RequestMapping("/saleReturn/toUpdateSr.do")
	public ModelAndView toUpdateSr(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		
		
		String sr_id = request.getParameter("sr_id");
		
		System.out.println("——————————toUpdatePo里的————————"+sr_id);
		
		request.setAttribute("sr_id", sr_id);
		ErpSaleReturn erpSaleReturn = erpSaleReturnService.getById(sr_id);
		request.setAttribute("erpSaleReturn", erpSaleReturn);
		
		String con = "%%";
		List<ErpCustomer> customerList = erpCustomerService.getAll(con);	//供应商列表
		List<ErpOrganization> organizationList = erpOrganizationService.getAll(con);//机构列表
		List<ErpWarehouse> warehouseList = erpWarehouseService.getAll(con);//仓库列表
		List<ErpUser> userList = erpUserService.getAll(con);//员工列表
		List<ErpSrGoods> srGoodsList = erpSrGoodsService.getBySrId(sr_id);//采购订单商品列表
		
		if(srGoodsList!=null){
			List<ErpSrGoodsVo> srGoodsVoList = VoUtil.getSrGoodsVo(srGoodsList);
			int totalRecode = srGoodsVoList.size();
			
			request.setAttribute("totalRecode", totalRecode);
			request.setAttribute("srGoodsList", srGoodsVoList);
		}
		List<ErpCode> paymentList = erpCodeService.getByType("PAYMENT_METHOD");
		//将这些列表向页面传值
		request.setAttribute("customerList", customerList);
		request.setAttribute("organizationList", organizationList);
		request.setAttribute("warehouseList", warehouseList);
		request.setAttribute("userList", userList);
		request.setAttribute("paymentList", paymentList);
		
		mav.setViewName("saleReturn/updateSr");
		return mav;
		
	}
	
	@RequestMapping("/saleReturn/updateSr.do")
	public String updateSr(HttpServletRequest request,HttpServletResponse response){
		System.out.println("-进入修改-");
		String sr_id = request.getParameter("sr_id");
		
		System.out.println("——————————updatePo里的————————"+sr_id);
		
		String create_time = request.getParameter("create_time");
		String customer_id = request.getParameter("customer_id");
		String employee_id = request.getParameter("employee_id");
		String organization_id = request.getParameter("organization_id");
		String invoices_state = request.getParameter("invoices_state");
		String payment_method = request.getParameter("payment_method");
		
		String invalid_id="";
		if(invoices_state.equals("B")){
			ErpAccount ea = (ErpAccount)request.getSession().getAttribute("erpAccount");
			invalid_id = ea.getUser_id();
		}
		int money =	erpSrGoodsService.getAmount(sr_id);
		
		ErpSaleReturn erpSaleReturn = new ErpSaleReturn();
		erpSaleReturn.setSr_id(sr_id);
		erpSaleReturn.setCreate_time(create_time);
		erpSaleReturn.setCustomer_id(customer_id);
		erpSaleReturn.setEmployee_id(employee_id);
		erpSaleReturn.setMoney(money);
		erpSaleReturn.setOrganization_id(organization_id);
		erpSaleReturn.setInvoices_state(invoices_state);
		erpSaleReturn.setInvalid_id(invalid_id);
		erpSaleReturn.setPayment_method(payment_method);
		
		erpSaleReturnService.update(erpSaleReturn);
		
		return "forward:/saleReturn/toListSr.do";
	}
	
	
	@RequestMapping("/saleReturn/toUpdateSrGoods.do")
	public ModelAndView toUpdateSrGoods(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		String sr_id = request.getParameter("sr_id"); 
		String id = request.getParameter("id");
		
		System.out.println("——————————toUpdatePoGoods里的————————"+sr_id);
		String con = "%%";
		List<ErpCashStatement> goodsList = erpCashStatementService.getAll(con);//库存中有的商品的列表
		if(goodsList!=null){
			List<ErpCashStatementVo> cashGoodsVo = VoUtil.getCashStatementVo(goodsList);
			request.setAttribute("goodsList", cashGoodsVo);
		}
		
		ErpSrGoods erpSrGoods  = erpSrGoodsService.getById(id);
		
		if(erpSrGoods!=null){
			ErpSrGoodsVo erpSrGoodsVo = VoUtil.getSrGoodsVo(erpSrGoods);
			request.setAttribute("erpSrGoodsVo", erpSrGoodsVo);
		}
		
		request.setAttribute("sr_id", sr_id);
		mav.setViewName("saleReturn/updateSrGoods");
		return mav;
	}
	
	/**
	 * 修改销售退货单的商品
	 * @param request
	 * @return
	 */
	@RequestMapping("/saleReturn/updateSrGoods.do")
	public String updateSrGoods(HttpServletRequest request){
		
		String id = request.getParameter("id");
		String cashStatement = request.getParameter("goods_id");
		String goods_numStr = request.getParameter("goods_num");
		String remark = request.getParameter("remark");
		String sr_id = request.getParameter("sr_id");
		
		System.out.println("——————————updatePoGoods里的————————"+sr_id);
	
		String goods_id = "";
		String warehouse_id = "";
		int goods_prices = 0;
		ErpCashStatement erpCashGoods = erpCashStatementService.getById(cashStatement);
		if(erpCashGoods!=null){
			goods_id = erpCashGoods.getGoods_id();
			warehouse_id = erpCashGoods.getWarehouse_id();
			ErpGoods erpGoods = erpGoodsService.getById(goods_id);
			goods_prices = erpGoods.getGoods_prices();		//通过得到的商品id获取商品的单价
		}
		int goods_num = Integer.valueOf(goods_numStr);
		
		System.out.println("++++++++++++"+sr_id);
		
		ErpSrGoods erpSrGoods = new ErpSrGoods();
		erpSrGoods.setGoods_id(goods_id);
		erpSrGoods.setId(id);
		erpSrGoods.setGoods_num(goods_num);
		erpSrGoods.setGoods_prices(goods_prices);
		erpSrGoods.setRemark(remark);
		erpSrGoods.setSr_id(sr_id);
		erpSrGoods.setWarehouse_id(warehouse_id);
		erpSrGoodsService.update(erpSrGoods);
		
		request.setAttribute("sr_id", sr_id);
		return "forward:/saleReturn/toListSrGoods.do";
	}
	
	/**
	 * 删除销售退货单
	 * @param request
	 * @return
	 */
	@RequestMapping("/saleReturn/deleteSr.do")
	public String deleteSr(HttpServletRequest request){
		
		String sr_id = request.getParameter("sr_id");
		List<ErpSrGoods> srGoodsList = erpSrGoodsService.getBySrId(sr_id);

		if(srGoodsList!=null){
			for(int i=0;i<srGoodsList.size();i++){
				erpSrGoodsService.delete(srGoodsList.get(i).getGoods_id());
			}
		}
		erpSaleReturnService.delete(sr_id);
		
		
		return "forward:/saleReturn/toListSr.do";
	}
	
	/**
	 * 删除销售退货单的商品
	 * @param request
	 * @return
	 */
	@RequestMapping("/saleReturn/deleteSrGoods.do")
	public String deleteSrGoods(HttpServletRequest request){
		String id = request.getParameter("id");

		if(id.indexOf(",")>-1){
			String[] idArr = id.split(",");
			for(int i=0;i<idArr.length;i++){
				erpSrGoodsService.delete(idArr[i]);
			}
		}else{
			erpSrGoodsService.delete(id);
		}
		
		return "forward:/saleReturn/toListSrGoods.do";
	}
	
}
