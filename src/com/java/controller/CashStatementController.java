package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.bean.ErpAccount;
import com.java.bean.ErpBlitem;
import com.java.bean.ErpCashStatement;
import com.java.bean.ErpCode;
import com.java.bean.ErpGoods;
import com.java.bean.ErpRequisition;
import com.java.bean.ErpWarehouse;
import com.java.service.ErpBlitemService;
import com.java.service.ErpCashStatementService;
import com.java.service.ErpCodeService;
import com.java.service.ErpGoodsService;
import com.java.service.ErpRequisitionService;
import com.java.service.ErpWarehouseService;
import com.java.util.IdUtil;
import com.java.util.VoUtil;
import com.java.vo.ErpBlitemVo;
import com.java.vo.ErpCashStatementVo;
import com.java.vo.ErpRequisitionVo;

@Controller
public class CashStatementController {
	
	@Autowired
	private ErpWarehouseService erpWarehouseService;//创建仓库对象
	@Autowired
	private ErpCashStatementService erpCashStatementService;//仓库余额表
	@Autowired
	private ErpBlitemService erpBlitemService;//创建盘点单对象
	@Autowired
	private ErpGoodsService erpGoodsService;//创建商品的对象
	@Autowired
	private ErpCodeService erpCodeService;//获取码表对象
	@Autowired
	private ErpRequisitionService erpRequisitionService;
	//查询仓库余额，并将
	@RequestMapping("/cashStatement/toBalance.do")
	public ModelAndView toBlance(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cashStatement/blance");
		
		String con = "%%";
		//获取仓库的相关信息
		List<ErpWarehouse> warehouseList = erpWarehouseService.getAll(con);
		//获取商品的相关信息
		List<ErpGoods> goodsList = erpGoodsService.getAll(con);
		
		request.setAttribute("EGlist", goodsList);
		request.setAttribute("EWlist", warehouseList);
		
		//获取仓库的id
		String warehouse_id = request.getParameter("warehouse_id");
		System.out.println("jjjjjjjjjjjjjjjj============"+warehouse_id);
		request.setAttribute("id",warehouse_id );
		//获取商品的id
		String goods_id=request.getParameter("goods_id");
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhh================"+goods_id);
		request.setAttribute("goods_id", goods_id);
		
		List<ErpCashStatementVo> list = new ArrayList<ErpCashStatementVo>();
		

		if(warehouse_id==null || "null".equals(warehouse_id)||"".equals(warehouse_id)){
			warehouse_id = "";
			if(goods_id==null || "null".equals(goods_id)){
				goods_id = "%%";
				
			}else{
				goods_id = "%"+goods_id+"%";
				
			}
			//根据商品的id使用模糊查询，将所有的商品查询出来
			List<ErpCashStatement>	erpCashStatementList = erpCashStatementService.getAll(goods_id);
			list = VoUtil.getCashStatementVo(erpCashStatementList);
		}else{
			
			if(goods_id==null || "null".equals(goods_id)||"".equals(goods_id)){
				goods_id = "";
				List<ErpCashStatement>	erpCashStatementList = erpCashStatementService.getByWarehouseId(warehouse_id);
				list = VoUtil.getCashStatementVo(erpCashStatementList);
			}else{
				List<ErpCashStatement>	erpCashStatementList = erpCashStatementService.getByWIAndGI(warehouse_id,goods_id);
				list = VoUtil.getCashStatementVo(erpCashStatementList);
			}
		}
		
		request.setAttribute("cashStatementList", list);
		return mav;
	}
	//盘点之前先将仓库余额表中的数据写入盘点表中
	@RequestMapping("/cashStatement/toBlitem.do")
	public ModelAndView toBlitem(HttpServletRequest request){
		//先获取仓库余额中数据
		String  con="%%";
		List<ErpCashStatement> ECSlist =  erpCashStatementService.getAll(con);
		//将此数据中
		
			for(ErpCashStatement ecs:ECSlist){
				System.out.println("11111111111111111111111111111111111111111");
				ErpBlitem eb = new ErpBlitem();//创建一个盘点单对象
				
				//根据仓库id和商品id现获取盘点单中的商品集合
				List<ErpBlitem> list = erpBlitemService.getByWIAndGI(ecs.getWarehouse_id(),ecs.getGoods_id());
				if(list.size()==0){//判断盘点单中是否含有该商品
					eb.setWarehouse_id(ecs.getWarehouse_id());
					eb.setGoods_id(ecs.getGoods_id());
					eb.setNum(ecs.getGoods_num());
					eb.setBlitem_id(IdUtil.getUuid());
					ErpAccount erpAccount = (ErpAccount)request.getSession().getAttribute("erpAccount");
					eb.setHandler_id(erpAccount.getUser_id());
					
					//将对象添加到盘点单中
					erpBlitemService.add(eb);
					
				}else{//如果盘点单中有该条记录，只需更新
					eb.setWarehouse_id(ecs.getWarehouse_id());
					eb.setGoods_id(ecs.getGoods_id());
					eb.setNum(ecs.getGoods_num());
					eb.setCheck_num(1);
					//获取blitem_id
					String blitem_id = list.get(0).getBlitem_id();
					eb.setBlitem_id(blitem_id);
					//将对象更新
					erpBlitemService.update(eb);
					
					
					
				}
				
			}
			
		
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cashStatement/blitem");

		List<ErpWarehouse> warehouseList = erpWarehouseService.getAll(con);
		
		request.setAttribute("EWlist", warehouseList);
		String warehouse_id = request.getParameter("warehouse_id");//，因为上传的是value的值，所以可以根据通过name获取页面上的值
		
		request.setAttribute("warehouse_id", warehouse_id);
		List<ErpBlitemVo> erpBlitemVo = null;
		if(warehouse_id==null || "null".equals(warehouse_id) || "".equals(warehouse_id)){
			warehouse_id = "%%";
			List<ErpBlitem> list = erpBlitemService.getAll(warehouse_id);
			erpBlitemVo = VoUtil.getBlitemVo(list);
		}else{
			List<ErpBlitem> list = erpBlitemService.getByWarehouseId(warehouse_id);
			erpBlitemVo = VoUtil.getBlitemVo(list);
		}
		int totalRecode = erpBlitemVo.size();//传一个总的记录条数用于分页
		
		request.setAttribute("totalRecode", totalRecode);
		request.setAttribute("list", erpBlitemVo);
		
		return mav;
		
		
		
		
		
	}
	@RequestMapping("/cashStatement/toUpdate.do")
	public ModelAndView toUpdate(HttpServletRequest request){
//		System.out.println("jjjjjjjjjjjj");
		ModelAndView mav =  new ModelAndView();
		String id = request.getParameter("id");
		System.out.println("------------------"+id);
		 ErpBlitem	eb =  erpBlitemService.getById(id);
		 ErpBlitemVo ebv = VoUtil.getBlitemVo(eb);
			
		request.setAttribute("eb", ebv);
		mav.setViewName("cashStatement/update");
		return mav;
		
	}
	//更新操作
	@RequestMapping("/cashStatement/update.do")
	public String update(HttpServletRequest request){
		
		
		//将string 转化成int型
		int check_num = Integer.parseInt(request.getParameter("check_num"));//盘点的数量
		System.out.println("-----------------------------------");
		System.out.println("盘点数量zzzzzzzzzzzzz"+check_num);
		System.out.println("-----------------------------------");
		String blitem_id = request.getParameter("blitem_id");
		String warehouse_id = request.getParameter("warehouse_id");
		String goods_id = request.getParameter("goods_id");
		int num = Integer.parseInt(request.getParameter("num"));//盘点前的数量
		System.out.println("-----------------------------------");
		System.out.println("盘点前的数量hhhhhhhhhhhhhhhhhhhhhh"+num);
		System.out.println("-----------------------------------");
		int profit_and_loss =Integer.parseInt(request.getParameter("profit_and_loss"));
		String handler_id = request.getParameter("handler_id");
		
		ErpBlitem eb = new ErpBlitem();
		eb.setBlitem_id(blitem_id);
		eb.setCheck_num(check_num);
		eb.setGoods_id(goods_id);
		eb.setHandler_id(handler_id);
		eb.setNum(num);
		eb.setProfit_and_loss(profit_and_loss);
		eb.setWarehouse_id(warehouse_id);
		
		erpBlitemService.update(eb);//更新盘点表中的数据
		//更新仓库余额表中的数据
		ErpCashStatement ecs = new ErpCashStatement();
		ecs.setGoods_id(goods_id);
		ecs.setWarehouse_id(warehouse_id);
		ecs.setGoods_num(check_num);
		erpCashStatementService.updateNum(ecs);
		
		return "forward:/cashStatement/toBlitem.do";
		
	}
	
	//跳转到调拨单
	@RequestMapping("/cashStatement/toRequisition.do")
	public ModelAndView toRequisition(HttpServletRequest request){
		
		//需要先将
		String con = "%%";
		//获取仓库的相关信息
		List<ErpWarehouse> warehouseList = erpWarehouseService.getAll(con);
		//获取商品的相关信息和
		//List<ErpGoods> goodsList = erpGoodsService.getAll(con);
		List<ErpCashStatement> goodsList = erpCashStatementService.getAll(con);
		List<ErpCashStatementVo> goodListVo = VoUtil.getCashStatementVo(goodsList);
		//获取单据状态
		List<ErpCode> codeList = erpCodeService.getByType("RE_STATE");
		
		request.setAttribute("EGlist", goodListVo);
		request.setAttribute("EWlist", warehouseList);
		request.setAttribute("codeList", codeList);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cashStatement/requisition");
		return mav;
		
	}
	
	//调拨单提交后跳转到列表页
	@RequestMapping("/cashStatement/list.do")
	public ModelAndView list(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		//先从页面上获取数据
		String out_warehouse_id = request.getParameter("Out_warehouse_id");//调出仓库的id
		String in_warehouse_id = request.getParameter("in_warehouse_id");//调如仓库的id
		String goods_id = request.getParameter("goods_id");//商品的id
		String requision_state = request.getParameter("re_state");//单据状态
		String num1 = request.getParameter("num");//调出量
		
		int num = Integer.valueOf(num1);//调拨量
		String out_time = request.getParameter("time");
		
		String describe = request.getParameter("describe");
		
		//创建ErpRequisition对象
		ErpRequisition er = new ErpRequisition();
		er.setDescribe(describe);
		er.setGoods_id(goods_id);
		er.setIn_warehouse_id(in_warehouse_id);
		er.setNum(num);
		er.setOut_time(out_time);
		er.setOut_warehouse_id(out_warehouse_id);
		er.setRequision_state(requision_state);
		er.setRequisition_id(IdUtil.getUuid());
		//将对象添加到ErpRequisition添加到数据库中
		erpRequisitionService.add(er);
		//创建仓库余额的对象
		ErpCashStatement erpCashStatement = new ErpCashStatement();
		if(requision_state.equals("A")){
			//先计算出两个仓库的该商品的数量
			//调出仓库的信息
			List<ErpCashStatement> ecsList_out = erpCashStatementService.getByWIAndGI(out_warehouse_id, goods_id);
			if(ecsList_out.size()>0){//如果要是有改商品的
				int out_goods_num = ecsList_out.get(0).getGoods_num();
				if(out_goods_num>num){
					/*//将对象添加到ErpRequisition添加到数据库中
					erpRequisitionService.add(er);*/
					ErpRequisitionVo erv = VoUtil.getRequisitionVo(er);
					request.setAttribute("er", erv);//将对象传过去
					
					//改变仓库的数量，调出仓库的量减少，而调入仓库的量增加（先判断调入仓库是否含有该商品如果有只需更新数量，如果没有则需从新添加）
					 out_goods_num = out_goods_num-num;//调出仓库剩余量
					//更新调出仓库该商品的数量
					
					erpCashStatement.setGoods_id(goods_id);
					erpCashStatement.setWarehouse_id(out_warehouse_id);
					erpCashStatement.setGoods_num(out_goods_num);
					erpCashStatementService.updateNum(erpCashStatement);
					//更新调入仓库的数量
					//调入仓库的信息
					List<ErpCashStatement> ecsList_in = erpCashStatementService.getByWIAndGI(in_warehouse_id, goods_id);
					
					if(ecsList_in.size()>0){//如果仓库中含有,直接更新数量
						
						int in_goods_num = ecsList_in.get(0).getGoods_num();
						in_goods_num = in_goods_num+num;
						erpCashStatement.setGoods_id(goods_id);
						erpCashStatement.setWarehouse_id(in_warehouse_id);
						erpCashStatement.setGoods_num(in_goods_num);
						erpCashStatementService.updateNum(erpCashStatement);
						
					}else{//如果仓库中没有自动添加
						erpCashStatement.setGoods_id(goods_id);
						erpCashStatement.setWarehouse_id(in_warehouse_id);
						erpCashStatement.setStatement_id(IdUtil.getUuid());
						erpCashStatement.setGoods_num(num);
						erpCashStatementService.add(erpCashStatement);
						
					}
					
					mav.setViewName("cashStatement/list");//成功跳转到调拨单列表页
					
				}else{
					mav.setViewName("cashStatement/errorList");
					
				}
			}else{//如果要是调出仓库中没有该商品
				mav.setViewName("cashStatement/errorList");
				
			}
		}else{//如果状态为B，直接跳转到错误页
			mav.setViewName("cashStatement/errorList");
			
		}
		return mav;
	}
	
	
	
}
