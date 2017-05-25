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
import com.java.bean.ErpCustomer;
import com.java.bean.ErpDept;
import com.java.bean.ErpGoods;
import com.java.bean.ErpOrganization;
import com.java.bean.ErpPoGoods;
import com.java.bean.ErpPurchaseOrder;
import com.java.bean.ErpUser;
import com.java.bean.ErpWarehouse;
import com.java.service.ErpCustomerService;
import com.java.service.ErpDeptService;
import com.java.service.ErpGoodsService;
import com.java.service.ErpOrganizationService;
import com.java.service.ErpPoGoodsService;
import com.java.service.ErpPurchaseOrderService;
import com.java.service.ErpUserService;
import com.java.service.ErpWarehouseService;
import com.java.util.IdUtil;
import com.java.util.VoUtil;
import com.java.vo.ErpPoGoodsVo;
import com.java.vo.ErpPurchaseOrderVo;

@Controller
public class PurchaseOrderController {

	@Autowired
	private ErpPurchaseOrderService erpPurchaseOrderService;
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
	private ErpPoGoodsService erpPoGoodsService;
	
	
	@RequestMapping("/purchaseOrder/toAddPo.do")
	public ModelAndView toAddPo(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("purchaseOrder/addPo");
		String po_id = request.getParameter("po_id");
		System.out.println("——————————toAddPo里的————————"+po_id);
		if(po_id==null||po_id==""||po_id.equals("null")){
			String poId = IdUtil.getInvoicesId();
			po_id = poId;
			request.setAttribute("po_id", po_id);
			
		}
		request.setAttribute("po_id", po_id);
		String con = "%%";
		List<ErpCustomer> customerList = erpCustomerService.getAll(con);
		List<ErpDept> deptList = erpDeptService.getAll(con);
		List<ErpOrganization> organizationList = erpOrganizationService.getAll(con);
		List<ErpWarehouse> warehouseList = erpWarehouseService.getAll(con);
		List<ErpUser> userList = erpUserService.getAll(con);
		List<ErpPoGoods> poGoodsList = erpPoGoodsService.getByPoId(po_id);
		
		if(poGoodsList!=null){
			List<ErpPoGoodsVo> poGoodsVoList = VoUtil.getErpPoGoodsVoList(poGoodsList);
			int totalRecode = poGoodsVoList.size();
			
			request.setAttribute("totalRecode", totalRecode);
			request.setAttribute("poGoodsList", poGoodsVoList);
		}
		request.setAttribute("customerList", customerList);
		request.setAttribute("deptList", deptList);
		request.setAttribute("organizationList", organizationList);
		request.setAttribute("warehouseList", warehouseList);
		request.setAttribute("userList", userList);
		return mav;
	}
	
	@RequestMapping("/purchaseOrder/addPo.do")
	public String addPo(HttpServletRequest request,HttpServletResponse response){
		
		System.out.println("-进入1-");
		String po_id = request.getParameter("po_id");
		System.out.println("——————————addPo里的————————"+po_id);
		System.out.println(po_id);
		String create_time = request.getParameter("create_time");
		String supplier_id = request.getParameter("supplier_id");
		String purchaser_id = request.getParameter("purchaser_id");
		String dept_id = request.getParameter("dept_id");
		String warehouse_id = request.getParameter("warehouse_id");
		
		String organization_id = request.getParameter("organization_id");
		String invoices_state = request.getParameter("invoices_state");
		ErpAccount ea = (ErpAccount)request.getSession().getAttribute("erpAccount");
		String originator_id = ea.getUser_id();	//制单人的id就是当前登录人员的员工id
		String invalid_id="";
		int po_amount =	erpPoGoodsService.getAmount(po_id);
		
		ErpPurchaseOrder erpPurchaseOrder = new ErpPurchaseOrder();
		erpPurchaseOrder.setPo_id(po_id);
		erpPurchaseOrder.setCreate_time(create_time);
		erpPurchaseOrder.setSupplier_id(supplier_id);
		erpPurchaseOrder.setPurchaser_id(purchaser_id);
		erpPurchaseOrder.setDept_id(dept_id);
		erpPurchaseOrder.setWarehouse_id(warehouse_id);
		erpPurchaseOrder.setPo_amount(po_amount);
		erpPurchaseOrder.setOriginator_id(originator_id);
		erpPurchaseOrder.setOrganization_id(organization_id);
		erpPurchaseOrder.setInvoices_state(invoices_state);
		erpPurchaseOrder.setInvalid_id(invalid_id);
		
		if(!erpPurchaseOrderService.add(erpPurchaseOrder)){
			List<ErpPoGoods> pogList = erpPoGoodsService.getByPoId(po_id);
			if(pogList!=null){
				for(int i=0;i<pogList.size();i++){
					erpPoGoodsService.delete(pogList.get(i).getId());
				}
			}
		}
		
		return "forward:/purchaseOrder/toListPo.do";
	}
	
	
	@RequestMapping("/purchaseOrder/toAddPoGoods.do")
	public ModelAndView toAddPoGoods(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		String po_id = request.getParameter("po_id"); 
		System.out.println("—————#—————toAddPoGoods里的———&—————"+po_id);
		System.out.println("++++++++++++"+po_id);
		String con = "%%";
		List<ErpGoods> goodsList = erpGoodsService.getAll(con);
		
		List<ErpPoGoods> poGoodsList = erpPoGoodsService.getByPoId(po_id);
		
		if(poGoodsList!=null){
			List<ErpPoGoodsVo> poGoodsVoList = VoUtil.getErpPoGoodsVoList(poGoodsList);
			int totalRecode = poGoodsVoList.size();
			
			request.setAttribute("totalRecode", totalRecode);
			request.setAttribute("poGoodsList", poGoodsVoList);
		}
		
		request.setAttribute("po_id", po_id);
		request.setAttribute("goodsList", goodsList);
		mav.setViewName("purchaseOrder/addPoGoods");
		return mav;
	}
	
	
	@RequestMapping("/purchaseOrder/addPoGoods.do")
	public  String addPoGoods(HttpServletRequest request){
		//采购的是商品表中没有的商品是，要让他先添加商品表中的记录，然后添加存货表中的记录，
		String id = IdUtil.getUuid();
		String goods_id = request.getParameter("goods_id");
		String goods_numStr = request.getParameter("goods_num");
		String remark = request.getParameter("remark");
		String po_id = request.getParameter("po_id");
		
		System.out.println("——————————addPoGoods里的————————"+po_id);
		
		int goods_prices = 0;
		ErpGoods erpGoods = erpGoodsService.getById(goods_id);
		if(erpGoods!=null){
			goods_prices = erpGoods.getGoods_prices();		//通过得到的商品id获取商品的单价
		}
		int goods_num = Integer.valueOf(goods_numStr);
		
		System.out.println("++++++++++++"+po_id);
		
		ErpPoGoods erpPoGoods = new ErpPoGoods();
		erpPoGoods.setGoods_id(goods_id);
		erpPoGoods.setId(id);
		erpPoGoods.setGoods_num(goods_num);
		erpPoGoods.setGoods_prices(goods_prices);
		erpPoGoods.setRemark(remark);
		erpPoGoods.setPo_id(po_id);
		erpPoGoodsService.add(erpPoGoods);
		
		request.setAttribute("po_id", po_id);
		return "forward:/purchaseOrder/toAddPoGoods.do";
		
	}
	
	@RequestMapping("/purchaseOrder/toListPo.do")
	public ModelAndView toListPo(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		//使用查询功能提取到的要查询的字段
		String po_id = request.getParameter("po_id");
		String create_time = request.getParameter("create_time");
		String supplier_id = request.getParameter("supplier_id");
		String purchaser_id = request.getParameter("purchaser_id");
		String dept_id = request.getParameter("dept_id");
		String warehouse_id = request.getParameter("warehouse_id");
		String organization_id = request.getParameter("organization_id");
		String invoices_state = request.getParameter("invoices_state");
		String originatior_id = request.getParameter("originatior_id");
		
		ErpPurchaseOrder erpPurchaseOrder = new ErpPurchaseOrder();
		erpPurchaseOrder.setPo_id(po_id);
		erpPurchaseOrder.setCreate_time(create_time);
		erpPurchaseOrder.setSupplier_id(supplier_id);
		erpPurchaseOrder.setPurchaser_id(purchaser_id);
		erpPurchaseOrder.setDept_id(dept_id);
		erpPurchaseOrder.setWarehouse_id(warehouse_id);
		erpPurchaseOrder.setOriginator_id(originatior_id);
		erpPurchaseOrder.setOrganization_id(organization_id);
		erpPurchaseOrder.setInvoices_state(invoices_state);
		
		String con = "%%";
		
		List<ErpPurchaseOrderVo> erpPurchaseOrderVoList = new ArrayList<ErpPurchaseOrderVo>();
		if(erpPurchaseOrder==null){
			//得到还未点击查询时的所有采购订单的列表
			List<ErpPurchaseOrder> erpPurchaseOrderList = erpPurchaseOrderService.getAll(con);
			if(erpPurchaseOrderList!=null){//转换成vo类向页面输出
				erpPurchaseOrderVoList = VoUtil.getErpPoVoList(erpPurchaseOrderList);
				int totalRecode = erpPurchaseOrderVoList.size();
				
				request.setAttribute("totalRecode", totalRecode);
			}
			
		}else{
			//根据点击查询时获取的查询条件得到集合
			List<ErpPurchaseOrder> erpPurchaseOrderList = erpPurchaseOrderService.selectPo(erpPurchaseOrder);
			if(erpPurchaseOrderList!=null){//转换成vo类向页面输出
				erpPurchaseOrderVoList = VoUtil.getErpPoVoList(erpPurchaseOrderList);
				int totalRecode = erpPurchaseOrderVoList.size();
				
				request.setAttribute("totalRecode", totalRecode);
				request.setAttribute("erpPurchaseOrderList", erpPurchaseOrderVoList);
			}
		}
		request.setAttribute("erpPurchaseOrderList", erpPurchaseOrderVoList);
		
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
		
		request.setAttribute("po_id", po_id);
		mav.setViewName("purchaseOrder/listPo");
		return mav;
		
	}
	
	@RequestMapping("/purchaseOrder/toListPoGoods.do")
	public ModelAndView toListPoGoods(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		String po_id = request.getParameter("po_id");
		
		System.out.println("——————————toListPoGoods里的————————"+po_id);
		
		List<ErpPoGoods> poGoodsList = erpPoGoodsService.getByPoId(po_id);
		if(poGoodsList!=null){
			List<ErpPoGoodsVo> poGoodsVoList = VoUtil.getErpPoGoodsVoList(poGoodsList);
			int totalRecode = poGoodsVoList.size();
			
			request.setAttribute("totalRecode", totalRecode);
			request.setAttribute("poGoodsList", poGoodsVoList);
		}
		
		
		request.setAttribute("po_id", po_id);
		mav.setViewName("purchaseOrder/listPoGoods");
		return mav;
	}
	
	@RequestMapping("/purchaseOrder/toLookPo.do")
	public ModelAndView toLookPo(HttpServletRequest request){
		
		
		ModelAndView mav = new ModelAndView();
		
		String po_id = request.getParameter("po_id");
		
		System.out.println("——————————toLookPo里的————————"+po_id);
		
		ErpPurchaseOrder erpPurchaseOrder = erpPurchaseOrderService.getById(po_id);
		if(erpPurchaseOrder!=null){
			ErpPurchaseOrderVo erpPurchaseOrderVo = VoUtil.getPurchaseOrderVo(erpPurchaseOrder);
			request.setAttribute("erpPurchaseOrder", erpPurchaseOrderVo);
		}
		
		List<ErpPoGoods> poGoodsList = erpPoGoodsService.getByPoId(po_id);
		if(poGoodsList!=null){
			List<ErpPoGoodsVo> poGoodsVoList = VoUtil.getErpPoGoodsVoList(poGoodsList);
			int totalRecode = poGoodsVoList.size();
			
			request.setAttribute("totalRecode", totalRecode);
			request.setAttribute("poGoodsList", poGoodsVoList);
		}
		
		mav.setViewName("purchaseOrder/lookPo");
		return mav;
		
	}
	
	
	@RequestMapping("/purchaseOrder/toLookPoGoods.do")
	public ModelAndView toLookPoGoods(HttpServletRequest request){
		
		
		ModelAndView mav = new ModelAndView();
		
		String po_id = request.getParameter("po_id");
		String id = request.getParameter("id");
		
		System.out.println("——————————toLookPoGoods里的————————"+po_id);
		
		ErpPoGoods erpPoGoods  = erpPoGoodsService.getById(id);
		
		if(erpPoGoods!=null){
			ErpPoGoodsVo erpPoGoodsVo = VoUtil.getErpPoGoodsVo(erpPoGoods);
			request.setAttribute("erpPoGoodsVo", erpPoGoodsVo);
		}
		request.setAttribute("po_id", po_id);
		
		
		mav.setViewName("purchaseOrder/lookPoGoods");
		return mav;
		
	} 
	
	
	@RequestMapping("/purchaseOrder/toUpdatePo.do")
	public ModelAndView toUpdatePo(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		
		
		String po_id = request.getParameter("po_id");
		
		System.out.println("——————————toUpdatePo里的————————"+po_id);
		
		request.setAttribute("po_id", po_id);
		ErpPurchaseOrder erpPurchaseOrder = erpPurchaseOrderService.getById(po_id);
		request.setAttribute("erpPurchaseOrder", erpPurchaseOrder);
		
		String con = "%%";
		List<ErpCustomer> customerList = erpCustomerService.getAll(con);	//供应商列表
		List<ErpDept> deptList = erpDeptService.getAll(con);				//部门列表
		List<ErpOrganization> organizationList = erpOrganizationService.getAll(con);//机构列表
		List<ErpWarehouse> warehouseList = erpWarehouseService.getAll(con);//仓库列表
		List<ErpUser> userList = erpUserService.getAll(con);//员工列表
		List<ErpPoGoods> poGoodsList = erpPoGoodsService.getByPoId(po_id);//采购订单商品列表
		
		if(poGoodsList!=null){
			List<ErpPoGoodsVo> poGoodsVoList = VoUtil.getErpPoGoodsVoList(poGoodsList);
			int totalRecode = poGoodsVoList.size();
			
			request.setAttribute("totalRecode", totalRecode);
			request.setAttribute("poGoodsList", poGoodsVoList);
		}
		request.setAttribute("customerList", customerList);
		request.setAttribute("deptList", deptList);
		request.setAttribute("organizationList", organizationList);
		request.setAttribute("warehouseList", warehouseList);
		request.setAttribute("userList", userList);
		
		mav.setViewName("purchaseOrder/updatePo");
		return mav;
		
	}
	
	@RequestMapping("/purchaseOrder/updatePo.do")
	public String updatePo(HttpServletRequest request,HttpServletResponse response){
		System.out.println("-进入修改-");
		String po_id = request.getParameter("po_id");
		
		System.out.println("——————————updatePo里的————————"+po_id);
		
		String create_time = request.getParameter("create_time");
		String supplier_id = request.getParameter("supplier_id");
		String purchaser_id = request.getParameter("purchaser_id");
		String dept_id = request.getParameter("dept_id");
		String warehouse_id = request.getParameter("warehouse_id");
		
		String organization_id = request.getParameter("organization_id");
		String invoices_state = request.getParameter("invoices_state");
		String invalid_id="";
		if(invoices_state.equals("B")){
			ErpAccount ea = (ErpAccount)request.getSession().getAttribute("erpAccount");
			invalid_id = ea.getUser_id();
		}
		int po_amount =	erpPoGoodsService.getAmount(po_id);
		
		ErpPurchaseOrder erpPurchaseOrder = new ErpPurchaseOrder();
		erpPurchaseOrder.setPo_id(po_id);
		erpPurchaseOrder.setCreate_time(create_time);
		erpPurchaseOrder.setSupplier_id(supplier_id);
		erpPurchaseOrder.setPurchaser_id(purchaser_id);
		erpPurchaseOrder.setDept_id(dept_id);
		erpPurchaseOrder.setWarehouse_id(warehouse_id);
		erpPurchaseOrder.setPo_amount(po_amount);
		//erpPurchaseOrder.setOriginator_id(originatior_id);
		erpPurchaseOrder.setOrganization_id(organization_id);
		erpPurchaseOrder.setInvoices_state(invoices_state);
		erpPurchaseOrder.setInvalid_id(invalid_id);
		
		erpPurchaseOrderService.update(erpPurchaseOrder);
		
		return "forward:/purchaseOrder/toListPo.do";
	}
	
	
	@RequestMapping("/purchaseOrder/toUpdatePoGoods.do")
	public ModelAndView toUpdatePoGoods(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		String po_id = request.getParameter("po_id"); 
		String id = request.getParameter("id");
		
		System.out.println("——————————toUpdatePoGoods里的————————"+po_id);
		String con = "%%";
		List<ErpGoods> goodsList = erpGoodsService.getAll(con);
		
		ErpPoGoods erpPoGoods  = erpPoGoodsService.getById(id);
		
		if(erpPoGoods!=null){
			ErpPoGoodsVo erpPoGoodsVo = VoUtil.getErpPoGoodsVo(erpPoGoods);
			request.setAttribute("erpPoGoodsVo", erpPoGoodsVo);
		}
		
		request.setAttribute("po_id", po_id);
		request.setAttribute("goodsList", goodsList);
		mav.setViewName("purchaseOrder/updatePoGoods");
		return mav;
	}
	
	/**
	 * 修改采购订单的商品
	 * @param request
	 * @return
	 */
	@RequestMapping("/purchaseOrder/updatePoGoods.do")
	public String updatePoGoods(HttpServletRequest request){
		
		String id = request.getParameter("id");
		String goods_id = request.getParameter("goods_id");
		String goods_numStr = request.getParameter("goods_num");
		String remark = request.getParameter("remark");
		String po_id = request.getParameter("po_id");
		
		System.out.println("——————————updatePoGoods里的————————"+po_id);
	
		int goods_prices = 0;
		ErpGoods erpGoods = erpGoodsService.getById(goods_id);
		if(erpGoods!=null){
			goods_prices = erpGoods.getGoods_prices();		//通过得到的商品id获取商品的单价
		}
		int goods_num = Integer.valueOf(goods_numStr);
		
		System.out.println("++++++++++++"+po_id);
		
		ErpPoGoods erpPoGoods = new ErpPoGoods();
		erpPoGoods.setGoods_id(goods_id);
		erpPoGoods.setId(id);
		erpPoGoods.setGoods_num(goods_num);
		erpPoGoods.setGoods_prices(goods_prices);
		erpPoGoods.setRemark(remark);
		erpPoGoods.setPo_id(po_id);
		
		erpPoGoodsService.update(erpPoGoods);
		
		request.setAttribute("po_id", po_id);
		return "forward:/purchaseOrder/toListPoGoods.do";
	}
	
	/**
	 * 删除采购订单
	 * @param request
	 * @return
	 */
	@RequestMapping("/purchaseOrder/deletePo.do")
	public String deletePo(HttpServletRequest request){
		
		String po_id = request.getParameter("po_id");
		List<ErpPoGoods> poGoodsList = erpPoGoodsService.getByPoId(po_id);

		if(poGoodsList!=null){
			for(int i=0;i<poGoodsList.size();i++){
				erpPoGoodsService.delete(poGoodsList.get(i).getGoods_id());
			}
		}
		erpPurchaseOrderService.delete(po_id);
		
		
		return "forward:/purchaseOrder/toListPo.do";
	}
	
	/**
	 * 删除采购订单的商品
	 * @param request
	 * @return
	 */
	@RequestMapping("/purchaseOrder/deletePoGoods.do")
	public String deletePoGoods(HttpServletRequest request){
		String id = request.getParameter("id");

		if(id.indexOf(",")>-1){
			String[] idArr = id.split(",");
			for(int i=0;i<idArr.length;i++){
				erpPoGoodsService.delete(idArr[i]);
			}
		}else{
			erpPoGoodsService.delete(id);
		}
		
		return "forward:/purchaseOrder/toListPoGoods.do";
	}
	
}
