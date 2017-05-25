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
import com.java.bean.ErpGoods;
import com.java.bean.ErpWarehouse;
import com.java.service.ErpCodeService;
import com.java.service.ErpGoodsService;
import com.java.service.ErpWarehouseService;
import com.java.util.IdUtil;
import com.java.util.VoUtil;
import com.java.vo.GoodsVo;

@Controller
public class GoodsController {

	@Autowired
	private ErpGoodsService erpGoodsService;
	@Autowired
	private ErpCodeService erpCodeService;
	@Autowired
	private ErpWarehouseService erpWarehouseService;
	
	
	@RequestMapping("/goods/toList.do")
	public ModelAndView toList(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		List<ErpGoods> listG = erpGoodsService.getAll(con);
		List<GoodsVo> listVo = VoUtil.getGoodsVoList(listG);
		int totalRecode = listVo.size();
		
		request.setAttribute("totalRecode", totalRecode);
		request.getSession().setAttribute("goodsList", listVo);
		
		mav.setViewName("goods/list"); 
		
		return mav;
	}
	
	//到机构添加页
	@RequestMapping("/goods/toAdd.do")
	public ModelAndView toAdd(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		
		List<ErpWarehouse> listEW = erpWarehouseService.getAll(con);
		List<ErpCode> listC = erpCodeService.getByType("GOODS");
		request.getSession().setAttribute("EWList", listEW);
		request.getSession().setAttribute("codeList", listC);
				
		mav.setViewName("goods/add");
		return mav;

	}	
	
	//添加商品
	@RequestMapping("/goods/add.do")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		
		String goods_name = request.getParameter("goods_name");
		int goods_prices = Integer.valueOf(request.getParameter("goods_prices"));
		String goods_type = request.getParameter("goods_type");
		String goods_unit = request.getParameter("goods_unit");
		String warehouse_id = request.getParameter("warehouse_id");
		
		ErpGoods eg = new ErpGoods();
		eg.setGoods_id(IdUtil.getInvoicesId());
		eg.setGoods_name(goods_name);
		eg.setGoods_num(1);
		eg.setGoods_prices(goods_prices);
		eg.setGoods_type(goods_type);
		eg.setGoods_unit(goods_unit);
		eg.setWarehouse_id(warehouse_id);
		
		erpGoodsService.add(eg);
		
		request.getRequestDispatcher("/goods/toList.do").forward(request, response);
		
		return mav;
	}
	
	//跳转到修改页
	@RequestMapping("/goods/toUpdate.do")
	public ModelAndView toUpdate(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String id = request.getParameter("goods_id");
		ErpGoods eg = erpGoodsService.getById(id);
		String con = request.getParameter("con");
		if(con==null||con==""){
			con = "%%";
		}else{
			con = "%"+con+"%";
		}
		
		List<ErpWarehouse> listEW = erpWarehouseService.getAll(con);
		List<ErpCode> listC = erpCodeService.getByType("GOODS");
		request.getSession().setAttribute("EWList", listEW);
		request.getSession().setAttribute("codeList", listC);
		request.setAttribute("goods", eg);
		
		mav.setViewName("goods/update");
		return mav;
		
	}
	
	//更新商品信息
	@RequestMapping("/goods/update")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ModelAndView mav = new ModelAndView();
		ErpGoods eg = new ErpGoods();
		
		String goods_id = request.getParameter("goods_id");
		String goods_name = request.getParameter("goods_name");
		int goods_num = Integer.parseInt(request.getParameter("goods_num"));
		int goods_prices = Integer.valueOf(request.getParameter("goods_prices"));
		String goods_type = request.getParameter("goods_type");
		String goods_unit = request.getParameter("goods_unit");
		String warehouse_id = request.getParameter("warehouse_id");
		
		eg.setGoods_id(goods_id);
		eg.setGoods_name(goods_name);
		eg.setGoods_num(goods_num);
		eg.setGoods_prices(goods_prices);
		eg.setGoods_type(goods_type);
		eg.setGoods_unit(goods_unit);
		eg.setWarehouse_id(warehouse_id); 
		
		erpGoodsService.update(eg);
		
		request.getRequestDispatcher("/goods/toList.do").forward(request, response);
		return mav;
		
	}
	
	//商品信息删除
	@RequestMapping("/goods/toDelete.do")
	public void toDelete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("goods_id");
		if(!id.contains(",")){
			erpGoodsService.delete(id);
		}else{
			String []idList = id.split(",");
			for(String d:idList){
				erpGoodsService.delete(d);
			}
		}
			
		request.getRequestDispatcher("/goods/toList.do").forward(request, response);
			
		
	}
	
	
	
	
}
