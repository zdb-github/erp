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
import com.java.bean.ErpDept;
import com.java.bean.ErpGoods;
import com.java.bean.ErpOrganization;
import com.java.bean.ErpSale;
import com.java.bean.ErpSaleGoods;
import com.java.bean.ErpSaleOrder;
import com.java.bean.ErpSoGoods;
import com.java.bean.ErpUser;
import com.java.bean.ErpWarehouse;
import com.java.service.ErpCashStatementService;
import com.java.service.ErpCodeService;
import com.java.service.ErpCustomerService;
import com.java.service.ErpDeptService;
import com.java.service.ErpGoodsService;
import com.java.service.ErpOrganizationService;
import com.java.service.ErpSaleGoodsService;
import com.java.service.ErpSaleOrderService;
import com.java.service.ErpSaleService;
import com.java.service.ErpSoGoodsService;
import com.java.service.ErpUserService;
import com.java.service.ErpWarehouseService;
import com.java.util.IdUtil;
import com.java.util.VoUtil;
import com.java.vo.ErpCashStatementVo;
import com.java.vo.ErpSaleGoodsVo;
import com.java.vo.ErpSaleVo;


@Controller
public class SaleController {
	@Autowired
	private ErpSaleOrderService erpSaleOrderService;
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
	private ErpGoodsService erpGoodsService;
	@Autowired
	private ErpSaleService erpSaleService;
	@Autowired
	private ErpSaleGoodsService erpSaleGoodsService;
	@Autowired
	private ErpCodeService erpCodeService;
	@Autowired
	private ErpSoGoodsService erpSoGoodsService;
	@Autowired
	private ErpCashStatementService erpCashStatementService;
	
	@RequestMapping("/sale/toAddSale.do")
	public ModelAndView toAddSale(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sale/addSale");
		
		String sale_id = request.getParameter("sale_id");
		System.out.println("_____"+sale_id);
		if(sale_id==null||sale_id==""||sale_id.equals("null")){
			String poId = IdUtil.getInvoicesId();
			sale_id = poId;
			request.setAttribute("sale_id", sale_id);
		}
		System.out.println("之后的sale_id"+sale_id);
		
		request.setAttribute("sale_id", sale_id);
		String con = "%%";
		List<ErpCustomer> customerList = erpCustomerService.getAll(con);
		List<ErpDept> deptList = erpDeptService.getAll(con);
		List<ErpOrganization> organizationList = erpOrganizationService.getAll(con);
		List<ErpWarehouse> warehouseList = erpWarehouseService.getAll(con);
		List<ErpUser> userList = erpUserService.getAll(con);
		List<ErpCode> paymentList = erpCodeService.getByType("PAYMENT_METHOD");
		List<ErpCode> saleTypeList = erpCodeService.getByType("SALE_TYPE");
		List<ErpCode> deliveryWayList = erpCodeService.getByType("DELIVERY_WAY");
		
		List<ErpSaleGoods> saleGoodsList = erpSaleGoodsService.getBySaleId(sale_id);
		if(saleGoodsList!=null){
			List<ErpSaleGoodsVo> saleGoodsVoList = VoUtil.getSaleGoodsVo(saleGoodsList);
			int totalRecode = saleGoodsVoList.size();
			
			request.setAttribute("totalRecode", totalRecode);
			request.setAttribute("saleGoodsList", saleGoodsVoList);
		}
		request.setAttribute("customerList", customerList);
		request.setAttribute("deptList", deptList);
		request.setAttribute("organizationList", organizationList);
		request.setAttribute("warehouseList", warehouseList);
		request.setAttribute("userList", userList);
		request.setAttribute("paymentList", paymentList);
		request.setAttribute("saleTypeList", saleTypeList);
		request.setAttribute("deliveryWayList", deliveryWayList);
		
		return mav;
	}
	
	@RequestMapping("/sale/addSale.do")
	public String addSale(HttpServletRequest request){	//正常添加销售单的路径
		//在添加销售单的同时货物出库 库存减少，可以根据商品的id和仓库id确定减少的是哪一个商品
		
		String pathUri = "";//跳转路径

		//当销售订单为空时，即没有点击生成销售
			String sale_id = request.getParameter("sale_id");				//销售订单id		
			System.out.println("------------正常添加销售单"+sale_id);
			
			String create_time = request.getParameter("create_time");				//日期
			String sale_type = request.getParameter("sale_type");			//销售类型
			String dept_id = request.getParameter("dept_id");				//部门id
			String salesman_id = request.getParameter("salesman_id");			//销售员id
			String customer_id = request.getParameter("customer_id");			//客户id
			String delivery_way = request.getParameter("delivery_way");		//发运方式
			String payment_method = request.getParameter("payment_method");		//支付方式
			String organization_id = request.getParameter("organization_id");		//所属机构id
			String invoices_state = request.getParameter("invoices_state");		//单据状态
			
			int money = erpSaleGoodsService.getAmount(sale_id);		//金额 通过销售订单商品明细表中的商品爽和金额进行获取
			
			ErpAccount ea = (ErpAccount)request.getSession().getAttribute("erpAccount");
			String originator_id = ea.getUser_id();	//制单人的id就是当前登录人员的员工id
			String invalid_id="";
			
			ErpSale erpSale = new ErpSale();
			erpSale.setSale_id(sale_id);
			erpSale.setCreate_time(create_time);
			erpSale.setCustomer_id(customer_id);
			erpSale.setDelivery_way(delivery_way);
			erpSale.setDept_id(dept_id);
			erpSale.setInvalid_id(invalid_id);
			erpSale.setInvoices_state(invoices_state);
			erpSale.setMoney(money);
			erpSale.setOrganization_id(organization_id);
			erpSale.setOriginator_id(originator_id);
			erpSale.setPayment_method(payment_method);
			erpSale.setSale_type(sale_type);
			erpSale.setSalesman_id(salesman_id);
			
			
			if(erpSaleService.add(erpSale)){
				List<ErpSaleGoods> pgList = erpSaleGoodsService.getBySaleId(sale_id);
				if(pgList!=null){
					for(ErpSaleGoods epg:pgList){
						//根据商品id和仓库id确定有没有对应的记录,这里是一定会有一条记录的，因为只有我的库存里有这个商品我才可以进行销售
						List<ErpCashStatement> csl =  erpCashStatementService.getByWIAndGI(epg.getWarehouse_id(), epg.getGoods_id());
						//如果不为空，就是对应的仓库原来有这个商品，只要更改数量就可以了
						if(csl.size()>0){
							int num = csl.get(0).getGoods_num();//原来库存中的对应商品的数量
							int goodsStock = num-epg.getGoods_num();//库存中原来的商品数量减去销售出去的商品数量
							String csId = csl.get(0).getStatement_id();
							ErpCashStatement ecs = new ErpCashStatement();
							ecs.setGoods_num(goodsStock);
							ecs.setStatement_id(csId);
							erpCashStatementService.update(ecs);
						}
					}
				}
			}
			pathUri = "forward:/sale/toListSale.do";
		
		
		
		return pathUri;
	}
	
	@RequestMapping("/sale/addSale2.do")
	public String addSale2(HttpServletRequest request){
		String so_id = request.getParameter("so_id");//销售订单生成销售单
		
		ErpSaleOrder eso = erpSaleOrderService.getById(so_id);
		System.out.println("-----------销售订单生成销售单"+so_id);
		String sale_id2 = IdUtil.getInvoicesId();
		ErpSale erpSale = new ErpSale();
		erpSale.setSale_id(sale_id2);
		erpSale.setCreate_time(eso.getCreate_time());
		erpSale.setCustomer_id(eso.getCustomer_id());
		erpSale.setDelivery_way(eso.getDelivery_way());
		erpSale.setDept_id(eso.getDept_id());
		erpSale.setInvalid_id("");
		erpSale.setInvoices_state(eso.getInvoices_state());
		erpSale.setMoney(eso.getMoney());
		erpSale.setOrganization_id(eso.getOrganization_id());
		erpSale.setPayment_method(eso.getPayment_method());
		erpSale.setSale_type(eso.getSale_type());
		erpSale.setSalesman_id(eso.getSalesman_id());
		
		ErpAccount ea = (ErpAccount)request.getSession().getAttribute("erpAccount");
		erpSale.setOriginator_id(ea.getUser_id());
		if(erpSaleService.add(erpSale)){
			ErpSaleOrder erpso = new ErpSaleOrder();
			erpso.setSo_id(so_id);
			erpso.setInvoices_state("C");//修改销售订单的状态
			erpSaleOrderService.update(erpso);
			List<ErpSoGoods> epgl = erpSoGoodsService.getBySoId(so_id);//获取销售订单里的商品，添加到采购单的商品中
			
			for(int i=0;i<epgl.size();i++){
				ErpSaleGoods erpSaleGoods = new ErpSaleGoods();
				erpSaleGoods.setId(IdUtil.getUuid());
				erpSaleGoods.setGoods_id(epgl.get(i).getGoods_id());
				erpSaleGoods.setGoods_num(epgl.get(i).getGoods_num());
				erpSaleGoods.setGoods_prices(epgl.get(i).getGoods_prices());
				erpSaleGoods.setRemark(epgl.get(i).getRemark());
				erpSaleGoods.setSale_id(sale_id2);
				erpSaleGoods.setWarehouse_id(epgl.get(i).getWarehouse_id());
				if(erpSaleGoodsService.add(erpSaleGoods)){
					
					List<ErpCashStatement> csl =  erpCashStatementService.getByWIAndGI(erpSaleGoods.getWarehouse_id(), erpSaleGoods.getGoods_id());
					//如果有，就改变查到的记录的商品数量
					if(csl.size()>0){
						int num = csl.get(0).getGoods_num();//原来库存中的对应商品的数量
						int goodsStock = num-erpSaleGoods.getGoods_num();//库存中原来的商品数量加上采购后的商品数量
						String csId = csl.get(0).getStatement_id();
						ErpCashStatement ecs = new ErpCashStatement();
						ecs.setGoods_num(goodsStock);
						ecs.setStatement_id(csId);
						erpCashStatementService.update(ecs);
					}
					
				}
			}
		}
		
		return "forward:/saleOrder/toListSo.do";
	}
	
	
	
	
	@RequestMapping("/sale/toAddSaleGoods.do")
	public ModelAndView toAddSaleGoods(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		String sale_id = request.getParameter("sale_id"); 
		System.out.println("—————#—————toAddPoGoods里的———&—————"+sale_id);
		System.out.println("++++++++++++"+sale_id);
		String con = "%%";
		List<ErpCashStatement> goodsList = erpCashStatementService.getAll(con);//库存中有的商品的列表
		if(goodsList!=null){
			List<ErpCashStatementVo> cashGoodsVo = VoUtil.getCashStatementVo(goodsList);
			
			request.setAttribute("goodsList", cashGoodsVo);
		}
		
		
		List<ErpSaleGoods> saleGoodsList = erpSaleGoodsService.getBySaleId(sale_id);
		
		if(saleGoodsList!=null){
			List<ErpSaleGoodsVo> saleGoodsVoList = VoUtil.getSaleGoodsVo(saleGoodsList);
			int totalRecode = saleGoodsVoList.size();
			
			request.setAttribute("totalRecode", totalRecode);
			request.setAttribute("saleGoodsList", saleGoodsVoList);
		}
		
		request.setAttribute("sale_id", sale_id);
		
		mav.setViewName("sale/addSaleGoods");
		return mav;
	}
	
	@RequestMapping("/sale/addSaleGoods.do")
	public  String addSaleGoods(HttpServletRequest request){
        
		
		String id = IdUtil.getUuid();
		String cashStatement = request.getParameter("goods_id");//得到的是商品在库存表中对应的库存表id
		String goods_numStr = request.getParameter("goods_num");
		String remark = request.getParameter("remark");
		String sale_id = request.getParameter("sale_id");
		
		System.out.println("——————————addSaleGoods里的————————"+sale_id);
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
		
		
		ErpSaleGoods erpSaleGoods = new ErpSaleGoods();
		erpSaleGoods.setGoods_id(goods_id);
		erpSaleGoods.setId(id);
		erpSaleGoods.setGoods_num(goods_num);
		erpSaleGoods.setGoods_prices(goods_prices);
		erpSaleGoods.setRemark(remark);
		erpSaleGoods.setSale_id(sale_id);
		erpSaleGoods.setWarehouse_id(warehouse_id);
		erpSaleGoodsService.add(erpSaleGoods);
		
		request.setAttribute("sale_id", sale_id);
		return "forward:/sale/toAddSaleGoods.do";
		
	}
	
	@RequestMapping("/sale/toListSale.do")
	public ModelAndView toListSale(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		//使用查询功能提取到的要查询的字段
		String sale_id = request.getParameter("sale_id");
		String create_time = request.getParameter("create_time");
		String customer_id = request.getParameter("customer_id");
		String purchaser_id = request.getParameter("salesman_id");
		String dept_id = request.getParameter("dept_id");
		String organization_id = request.getParameter("organization_id");
		String invoices_state = request.getParameter("invoices_state");
		String originatior_id = request.getParameter("originatior_id");
		String sale_type = request.getParameter("sale_type");	
		String delivery_way = request.getParameter("delivery_way");		//发运方式
		String payment_method = request.getParameter("payment_method");		//支付方式
		
		ErpSale erpSale = new ErpSale();
		erpSale.setSale_id(sale_id);
		erpSale.setCreate_time(create_time);
		erpSale.setCustomer_id(customer_id);
		erpSale.setSalesman_id(purchaser_id);
		erpSale.setDept_id(dept_id);
		erpSale.setOriginator_id(originatior_id);
		erpSale.setOrganization_id(organization_id);
		erpSale.setInvoices_state(invoices_state);
		erpSale.setPayment_method(payment_method);
		erpSale.setSale_type(sale_type);
		erpSale.setDelivery_way(delivery_way);
		
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
		List<ErpWarehouse> warehouseList = erpWarehouseService.getAll(con);//仓库列表
		List<ErpUser> userList = erpUserService.getAll(con);//员工列表
		List<ErpCode> paymentList = erpCodeService.getByType("PAYMENT_METHOD");
		List<ErpCode> saleTypeList = erpCodeService.getByType("SALE_TYPE");
		List<ErpCode> deliveryWayList = erpCodeService.getByType("DELIVERY_WAY");
		
		//将这些列表向页面传值
		request.setAttribute("customerList", customerList);
		request.setAttribute("deptList", deptList);
		request.setAttribute("organizationList", organizationList);
		request.setAttribute("warehouseList", warehouseList);
		request.setAttribute("userList", userList);
		request.setAttribute("paymentList", paymentList);
		request.setAttribute("saleTypeList", saleTypeList);
		request.setAttribute("deliveryWayList", deliveryWayList);
		
		
		request.setAttribute("sale_id", sale_id);
		mav.setViewName("sale/listSale");
		return mav;
	}
	
	@RequestMapping("/sale/toListSaleGoods.do")
	public ModelAndView toListSaleGoods(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String sale_id = request.getParameter("sale_id");
		String updateNum = (String)request.getAttribute("updateNum");
		
		System.out.println("——————————toListPoGoods里的————————"+sale_id);

		List<ErpSaleGoods> saleGoodsList = erpSaleGoodsService.getBySaleId(sale_id);
		if(saleGoodsList!=null){
			List<ErpSaleGoodsVo> saleGoodsVoList = VoUtil.getSaleGoodsVo(saleGoodsList);
			int totalRecode = saleGoodsVoList.size();
			
			request.setAttribute("totalRecode", totalRecode);
			request.setAttribute("saleGoodsList", saleGoodsVoList);
		}
		
		request.setAttribute("updateNum", updateNum);
		request.setAttribute("sale_id", sale_id);
		mav.setViewName("sale/listSaleGoods");
		return mav;
	}
	
	@RequestMapping("/sale/toLookSale.do")
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
		
		mav.setViewName("sale/lookSale");
		return mav;
		
	}
	
	@RequestMapping("/sale/toLookSaleGoods.do")
	public ModelAndView toLookSaleGoods(HttpServletRequest request){
		
		
		ModelAndView mav = new ModelAndView();
		
		String sale_id = request.getParameter("sale_id");			
		String id = request.getParameter("id");
		
		System.out.println("——————————toLookPoGoods里的————————"+sale_id);
		
		ErpSaleGoods erpSaleGoods  = erpSaleGoodsService.getById(id);
		
		if(erpSaleGoods!=null){
			ErpSaleGoodsVo erpSaleGoodsVo = VoUtil.getSaleGoodsVo(erpSaleGoods);
			request.setAttribute("erpSaleGoodsVo", erpSaleGoodsVo);
		}
		request.setAttribute("sale_id", sale_id);
		
		
		mav.setViewName("sale/lookSaleGoods");
		return mav;
		
	} 
	
	@RequestMapping("/sale/toUpdateSale.do")
	public ModelAndView toUpdateSale(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		
		
		String sale_id = request.getParameter("sale_id");
		
		System.out.println("——————————toUpdatePo里的————————"+sale_id);
		
		request.setAttribute("sale_id", sale_id);
		ErpSale erpSale = erpSaleService.getById(sale_id);									//=======
		request.setAttribute("erpSale", erpSale);
		
		String con = "%%";
		List<ErpCustomer> customerList = erpCustomerService.getAll(con);	//供应商列表
		List<ErpDept> deptList = erpDeptService.getAll(con);				//部门列表
		List<ErpOrganization> organizationList = erpOrganizationService.getAll(con);//机构列表
		List<ErpWarehouse> warehouseList = erpWarehouseService.getAll(con);//仓库列表
		List<ErpUser> userList = erpUserService.getAll(con);//员工列表
		List<ErpSaleGoods> saleGoodsList = erpSaleGoodsService.getBySaleId(sale_id);//采购订单商品列表
		List<ErpCode> paymentList = erpCodeService.getByType("PAYMENT_METHOD");
		List<ErpCode> saleTypeList = erpCodeService.getByType("SALE_TYPE");
		List<ErpCode> deliveryWayList = erpCodeService.getByType("DELIVERY_WAY");
		
		
		if(saleGoodsList!=null){
			List<ErpSaleGoodsVo> saleGoodsVoList = VoUtil.getSaleGoodsVo(saleGoodsList);
			int totalRecode = saleGoodsVoList.size();
			
			request.setAttribute("totalRecode", totalRecode);
			request.setAttribute("saleGoodsList", saleGoodsVoList);
		}
		request.setAttribute("customerList", customerList);
		request.setAttribute("deptList", deptList);
		request.setAttribute("organizationList", organizationList);
		request.setAttribute("warehouseList", warehouseList);
		request.setAttribute("userList", userList);
		request.setAttribute("paymentList", paymentList);
		request.setAttribute("saleTypeList", saleTypeList);
		request.setAttribute("deliveryWayList", deliveryWayList);
		
		
		mav.setViewName("sale/updateSale");
		return mav;
		
	}
	
	
	@RequestMapping("/sale/updateSale.do")
	public String updateSale(HttpServletRequest request,HttpServletResponse response){

		String sale_id = request.getParameter("sale_id");
		String create_time = request.getParameter("create_time");
		String customer_id = request.getParameter("customer_id");
		String salesman_id = request.getParameter("salesman_id");
		String dept_id = request.getParameter("dept_id");
		String organization_id = request.getParameter("organization_id");
		String invoices_state = request.getParameter("invoices_state");
		String originatior_id = request.getParameter("originatior_id");
		String sale_type = request.getParameter("sale_type");	
		String delivery_way = request.getParameter("delivery_way");		//发运方式
		String payment_method = request.getParameter("payment_method");	
		
		String invalid_id="";
		if(invoices_state.equals("B")){
			ErpAccount ea = (ErpAccount)request.getSession().getAttribute("erpAccount");
			invalid_id = ea.getUser_id();
		}
		int money =	erpSaleGoodsService.getAmount(sale_id);
		
		ErpSale erpSale = new ErpSale();
		erpSale.setSale_id(sale_id);
		erpSale.setCreate_time(create_time);
		erpSale.setCustomer_id(customer_id);
		erpSale.setSalesman_id(salesman_id);
		erpSale.setDept_id(dept_id);
		erpSale.setOriginator_id(originatior_id);
		erpSale.setOrganization_id(organization_id);
		erpSale.setInvoices_state(invoices_state);
		erpSale.setPayment_method(payment_method);
		erpSale.setSale_type(sale_type);
		erpSale.setDelivery_way(delivery_way);
		erpSale.setInvalid_id(invalid_id);
		erpSale.setMoney(money);
		
		erpSaleService.update(erpSale);
		List<ErpSaleGoods> saleGoodsList = erpSaleGoodsService.getBySaleId(sale_id);
		for(ErpSaleGoods esg :saleGoodsList){
		//更新之后再根据更新的商品信息更新库存
			List<ErpCashStatement> csl2 = erpCashStatementService.getByWIAndGI(esg.getWarehouse_id(), esg.getGoods_id());
			if(csl2.size()>0){
				String statementId2 = csl2.get(0).getStatement_id();
				int sNum2 = csl2.get(0).getGoods_num();
				int stockNum2 = sNum2-esg.getGoods_num();
				ErpCashStatement ecs2 = new ErpCashStatement();
				ecs2.setGoods_num(stockNum2);
				ecs2.setStatement_id(statementId2);
				erpCashStatementService.update(ecs2);
			}	
		}
		return "forward:/sale/toListSale.do";
	}
	
	@RequestMapping("/sale/toUpdateSaleGoods.do")
	public ModelAndView toUpdateSaleGoods(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		String sale_id = request.getParameter("sale_id"); 
		String id = request.getParameter("id");
		String updateNum = request.getParameter("updateNum");
		
		String con = "%%";
		List<ErpCashStatement> goodsList = erpCashStatementService.getAll(con);//库存中有的商品的列表
		if(goodsList!=null){
			List<ErpCashStatementVo> cashGoodsVo = VoUtil.getCashStatementVo(goodsList);
			request.setAttribute("goodsList", cashGoodsVo);
		}
		
		ErpSaleGoods erpSaleGoods  = erpSaleGoodsService.getById(id);
		
		if(erpSaleGoods!=null){
			ErpSaleGoodsVo erpSaleGoodsVo = VoUtil.getSaleGoodsVo(erpSaleGoods);
			request.setAttribute("erpSaleGoodsVo", erpSaleGoodsVo);
			//获取当前商品在库存余额表中的记录
			List<ErpCashStatement> ecsl = erpCashStatementService.getByWIAndGI(erpSaleGoods.getWarehouse_id(), erpSaleGoods.getGoods_id());
			ErpCashStatement erpCashStatement = ecsl.get(0);
			request.setAttribute("erpCashStatement",erpCashStatement);
		}
		
		
		request.setAttribute("sale_id",sale_id);
		request.setAttribute("updateNum",updateNum);
		mav.setViewName("sale/updateSaleGoods");
		return mav;
	}
	
	@RequestMapping("/sale/updateSaleGoods.do")
	public String updateSaleGoods(HttpServletRequest request){
		
		int updateNum = 0;//修改商品的次数
		
		String updateNumStr = request.getParameter("updateNum");
		if(updateNumStr==null||"".equals(updateNumStr)||"null".equals(updateNumStr)){
			updateNum = 1;
			
		}else{
			updateNum = Integer.valueOf(updateNumStr);
		}
		
		String id = request.getParameter("id");
		String cashStatement = request.getParameter("goods_id");
		String goods_numStr = request.getParameter("goods_num");
		String remark = request.getParameter("remark");
		String sale_id = request.getParameter("sale_id");
		
		System.out.println("——————————updatePoGoods里的————————"+sale_id);
		
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
		
		//进入到这个方法就默认修改了
		//修改前的商品
		if(updateNum==1){
			//ErpSaleGoods erppg1 = erpSaleGoodsService.getById(id);
			List<ErpSaleGoods> saleGoodsList = erpSaleGoodsService.getBySaleId(sale_id);
			for(ErpSaleGoods esg :saleGoodsList){
				int goods_num2 = esg.getGoods_num();
				String goods_id2 = esg.getGoods_id();
				String warehouse_id2 = esg.getWarehouse_id();
				
				//先加上以前卖出去的数量，
				List<ErpCashStatement> csl = erpCashStatementService.getByWIAndGI(warehouse_id2, goods_id2);
				String statementId = csl.get(0).getStatement_id();
				int sNum = csl.get(0).getGoods_num();
				int stockNum = sNum+goods_num2;
				ErpCashStatement ecs = new ErpCashStatement();
				ecs.setGoods_num(stockNum);
				ecs.setStatement_id(statementId);
				erpCashStatementService.update(ecs);	
			}
			
		}
		
		
		ErpSaleGoods erpSaleGoods = new ErpSaleGoods();
		erpSaleGoods.setGoods_id(goods_id);
		erpSaleGoods.setId(id);
		erpSaleGoods.setGoods_num(goods_num);
		erpSaleGoods.setGoods_prices(goods_prices);
		erpSaleGoods.setRemark(remark);
		erpSaleGoods.setSale_id(sale_id);
		erpSaleGoods.setWarehouse_id(warehouse_id);
		
		erpSaleGoodsService.update(erpSaleGoods);
		updateNum++;
		
		String updateNumstr = updateNum+"";
		request.setAttribute("updateNum", updateNumstr);
		request.setAttribute("sale_id", sale_id);
		return "forward:/sale/toListSaleGoods.do";
	}
	
	@RequestMapping("/sale/deleteSale.do")
	public String deleteSale(HttpServletRequest request){
		
		String sale_id = request.getParameter("sale_id");
		List<ErpSaleGoods> saleGoodsList = erpSaleGoodsService.getBySaleId(sale_id);

		if(saleGoodsList!=null){
			for(int i=0;i<saleGoodsList.size();i++){
				erpSaleGoodsService.delete(saleGoodsList.get(i).getGoods_id());
			}
		}
		erpSaleService.delete(sale_id);
		
		
		return "forward:/sale/toListSale.do";
	}
	
	
	@RequestMapping("/sale/deleteSaleGoods.do")
	public String deleteSoGoods(HttpServletRequest request){
		String id = request.getParameter("id");

		if(id.indexOf(",")>-1){
			String[] idArr = id.split(",");
			for(int i=0;i<idArr.length;i++){
				erpSaleGoodsService.delete(idArr[i]);
			}
		}else{
			erpSaleGoodsService.delete(id);
		}
		
		return "forward:/sale/toListSaleGoods.do";
	}
	
	
}
