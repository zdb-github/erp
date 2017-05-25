package com.java.util;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.bean.ErpAccount;
import com.java.bean.ErpBlitem;
import com.java.bean.ErpCashStatement;
import com.java.bean.ErpCode;
import com.java.bean.ErpCustomer;
import com.java.bean.ErpDept;
import com.java.bean.ErpGoods;
import com.java.bean.ErpJob;
import com.java.bean.ErpOrganization;
import com.java.bean.ErpPoGoods;
import com.java.bean.ErpPurchase;
import com.java.bean.ErpPurchaseGoods;
import com.java.bean.ErpPurchaseOrder;
import com.java.bean.ErpRequisition;
import com.java.bean.ErpSale;
import com.java.bean.ErpSaleGoods;
import com.java.bean.ErpSaleOrder;
import com.java.bean.ErpSaleReturn;
import com.java.bean.ErpSoGoods;
import com.java.bean.ErpSrGoods;
import com.java.bean.ErpUser;
import com.java.bean.ErpWarehouse;
import com.java.mapper.ErpCodeMapper;
import com.java.mapper.ErpCustomerMapper;
import com.java.mapper.ErpDeptMapper;
import com.java.mapper.ErpGoodsMapper;
import com.java.mapper.ErpJobMapper;
import com.java.mapper.ErpOrganizationMapper;
import com.java.mapper.ErpUserMapper;
import com.java.mapper.ErpWarehouseMapper;
import com.java.vo.DeptVo;
import com.java.vo.ErpAccountVo;
import com.java.vo.ErpBlitemVo;
import com.java.vo.ErpCashStatementVo;
import com.java.vo.ErpCustomerVo;
import com.java.vo.ErpPoGoodsVo;
import com.java.vo.ErpPurchaseGoodsVo;
import com.java.vo.ErpPurchaseOrderVo;
import com.java.vo.ErpPurchaseVo;
import com.java.vo.ErpRequisitionVo;
import com.java.vo.ErpSaleGoodsVo;
import com.java.vo.ErpSaleOrderVo;
import com.java.vo.ErpSaleReturnVo;
import com.java.vo.ErpSaleVo;
import com.java.vo.ErpSoGoodsVo;
import com.java.vo.ErpSrGoodsVo;
import com.java.vo.ErpUserVo;
import com.java.vo.GoodsVo;
import com.java.vo.JobVo;
import com.java.vo.OrganizationVo;
import com.java.vo.WarehouseVo;

public class VoUtil {
	

/*	private static ErpGoodsService erpGoodsService = new ErpGoodsServiceImpl();

	private static ErpWarehouseService erpWarehouseService = new ErpWarehouseServiceImpl();
	*/
	
	private static BeanFactory factory = new  ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
	
	private static ErpGoodsMapper erpGoodsMapper = factory.getBean("erpGoodsMapper",ErpGoodsMapper.class);
	private static ErpDeptMapper erpDeptMapper = factory.getBean("erpDeptMapper",ErpDeptMapper.class);
	private static ErpWarehouseMapper erpWarehouseMapper = factory.getBean("erpWarehouseMapper",ErpWarehouseMapper.class);
	private static ErpUserMapper erpUserMapper = factory.getBean("erpUserMapper", ErpUserMapper.class);
	private static ErpCustomerMapper erpCustomerMapper = factory.getBean("erpCustomerMapper", ErpCustomerMapper.class);
	private static ErpCodeMapper erpCodeMapper = factory.getBean("erpCodeMapper", ErpCodeMapper.class);
	private static ErpOrganizationMapper erpOrganizationMapper = factory.getBean("erpOrganizationMapper", ErpOrganizationMapper.class);
	private static ErpJobMapper erpJobMapper = factory.getBean("erpJobMapper", ErpJobMapper.class);
	
	
	/**
	 * 获取采购订单商品的vo集合
	 * @param list
	 * @return
	 */
	public static List<ErpPoGoodsVo> getErpPoGoodsVoList(List<ErpPoGoods> list){
		List<ErpPoGoodsVo> pgvl = new ArrayList<ErpPoGoodsVo>();
		
		for(ErpPoGoods pg:list){
			ErpPoGoodsVo epgv = new ErpPoGoodsVo();
			String goods_id = pg.getGoods_id();
			System.out.println(pg.getGoods_id());
			
			epgv.setGoods_id(pg.getGoods_id());
			epgv.setGoods_num(pg.getGoods_num());
			epgv.setGoods_prices(pg.getGoods_prices());
			epgv.setId(pg.getId());
			epgv.setPo_id(pg.getPo_id());
			epgv.setRemark(pg.getRemark());
			epgv.setRownum(pg.getRownum());
			if(goods_id!=null){
				ErpGoods erpgoods = erpGoodsMapper.getById(goods_id);
				if(erpgoods!=null){
					epgv.setGoods_name(erpgoods.getGoods_name());
					String goods_type = erpgoods.getGoods_type();
					ErpCode ecode = erpCodeMapper.getByKeyAndType(goods_type, "GOODS");
					epgv.setGoods_type(ecode.getValue());
					
					epgv.setGoods_unit(erpgoods.getGoods_unit());
					
					ErpWarehouse ew = erpWarehouseMapper.getById(erpgoods.getWarehouse_id());
					if(ew!=null){
						epgv.setWarehouse_name(ew.getName());
					}
				}
			}
			
			pgvl.add(epgv);
		}
		return pgvl;
		
	}
	
	/**
	 * 获取采购订单商品vo
	 * @param pg
	 * @return
	 */
	public static ErpPoGoodsVo getErpPoGoodsVo(ErpPoGoods pg){
		
		ErpPoGoodsVo epgv = new ErpPoGoodsVo();
		String goods_id = pg.getGoods_id();
		System.out.println(pg.getGoods_id());
		
		epgv.setGoods_id(pg.getGoods_id());
		epgv.setGoods_num(pg.getGoods_num());
		epgv.setGoods_prices(pg.getGoods_prices());
		epgv.setId(pg.getId());
		epgv.setPo_id(pg.getPo_id());
		epgv.setRemark(pg.getRemark());
		epgv.setRownum(pg.getRownum());
		
		if(goods_id!=null){
			ErpGoods erpgoods = erpGoodsMapper.getById(goods_id);
			if(erpgoods!=null){
				epgv.setGoods_name(erpgoods.getGoods_name());
				epgv.setGoods_unit(erpgoods.getGoods_unit());
				String goods_type = erpgoods.getGoods_type();
				ErpCode ecode = erpCodeMapper.getByKeyAndType(goods_type, "GOODS");
				epgv.setGoods_type(ecode.getValue());
				
				ErpWarehouse ew = erpWarehouseMapper.getById(erpgoods.getWarehouse_id());
				if(ew!=null){
					epgv.setWarehouse_name(ew.getName());
				}
			}
		}
		return epgv;
	}
	
	
	/**
	 * 获取一个集合的采购订单的VO
	 * @param list
	 * @return
	 */
	public static List<ErpPurchaseOrderVo> getErpPoVoList(List<ErpPurchaseOrder> list){
		List<ErpPurchaseOrderVo> povl = new ArrayList<ErpPurchaseOrderVo>();
		
		for(ErpPurchaseOrder po:list){
			
			ErpPurchaseOrderVo epov = new ErpPurchaseOrderVo();
			
			epov.setPo_id(po.getPo_id());
			epov.setCreate_time(po.getCreate_time());
			epov.setDept_id(po.getDept_id());
			
			epov.setInvoices_state(po.getInvoices_state());
			epov.setOrganization_id(po.getOrganization_id());
			epov.setOriginator_id(po.getOriginator_id());
			epov.setPo_amount(po.getPo_amount());
			epov.setPurchaser_id(po.getPurchaser_id());
			epov.setSupplier_id(po.getSupplier_id());
			epov.setWarehouse_id(po.getWarehouse_id());
			
			if(po.getInvalid_id()!=null){	//作废人
				epov.setInvalid_id(po.getInvalid_id());
				ErpUser eu1 = erpUserMapper.getById(po.getInvalid_id());
				epov.setInvalid_name(eu1.getName());
			}
			
			ErpDept ed = erpDeptMapper.getById(po.getDept_id());
			epov.setDept_name(ed.getName());
			
			ErpWarehouse ew = erpWarehouseMapper.getById(po.getWarehouse_id());
			epov.setWarehouse_name(ew.getName());
			
			ErpCustomer ec = erpCustomerMapper.getById(po.getSupplier_id());
			epov.setSupplier_name(ec.getCompany());
			
			ErpCode ecode = erpCodeMapper.getByKeyAndType(po.getInvoices_state(), "INVOICES_STATE");
			epov.setStateVo(ecode.getValue());
			
			ErpOrganization eorg = erpOrganizationMapper.getById(po.getOrganization_id());
			epov.setOrganization_name(eorg.getName());
			
			ErpUser eu2 = erpUserMapper.getById(po.getPurchaser_id());
			epov.setPurchaser_name(eu2.getName());
			
			ErpUser eu3 = erpUserMapper.getById(po.getOriginator_id());
			epov.setOriginator_name(eu3.getName());
			
			povl.add(epov);
		}
		return povl;
		
	}
	
	/**
	 * 获取单个的采购订单vo
	 * @param po
	 * @return
	 */
	public static ErpPurchaseOrderVo getPurchaseOrderVo(ErpPurchaseOrder po){
		
		
		ErpPurchaseOrderVo epov = new ErpPurchaseOrderVo();
		
		epov.setPo_id(po.getPo_id());
		epov.setCreate_time(po.getCreate_time());
		epov.setDept_id(po.getDept_id());
		
		epov.setInvoices_state(po.getInvoices_state());
		epov.setOrganization_id(po.getOrganization_id());
		epov.setOriginator_id(po.getOriginator_id());
		epov.setPo_amount(po.getPo_amount());
		epov.setPurchaser_id(po.getPurchaser_id());
		epov.setSupplier_id(po.getSupplier_id());
		epov.setWarehouse_id(po.getWarehouse_id());
		
		if(po.getInvalid_id()!=null){	//作废人
			epov.setInvalid_id(po.getInvalid_id());
			ErpUser eu1 = erpUserMapper.getById(po.getInvalid_id());
			epov.setInvalid_name(eu1.getName());
		}
		
		ErpDept ed = erpDeptMapper.getById(po.getDept_id());
		epov.setDept_name(ed.getName());
		
		ErpWarehouse ew = erpWarehouseMapper.getById(po.getWarehouse_id());
		epov.setWarehouse_name(ew.getName());
		
		ErpCustomer ec = erpCustomerMapper.getById(po.getSupplier_id());
		epov.setSupplier_name(ec.getCompany());
		
		ErpCode ecode = erpCodeMapper.getByKeyAndType(po.getInvoices_state(), "INVOICES_STATE");
		epov.setStateVo(ecode.getValue());
		
		ErpOrganization eorg = erpOrganizationMapper.getById(po.getOrganization_id());
		epov.setOrganization_name(eorg.getName());
		
		ErpUser eu2 = erpUserMapper.getById(po.getPurchaser_id());
		epov.setPurchaser_name(eu2.getName());
		
		ErpUser eu3 = erpUserMapper.getById(po.getOriginator_id());
		epov.setOriginator_name(eu3.getName());
		
		return epov;
	}
	
	/**
	 * 获取采购单集合的vo集合
	 * @param list
	 * @return
	 */
	public static List<ErpPurchaseVo> getPurchaseVo(List<ErpPurchase> list){
		
		List<ErpPurchaseVo> epl = new ArrayList<ErpPurchaseVo>();
		for(ErpPurchase ep:list){
			
			ErpPurchaseVo epov = new ErpPurchaseVo();
			
			epov.setPurchase_id(ep.getPurchase_id());
			epov.setCreate_time(ep.getCreate_time());
			epov.setDept_id(ep.getDept_id());
			
			epov.setInvoices_state(ep.getInvoices_state());
			epov.setOrganization_id(ep.getOrganization_id());
			epov.setOriginator_id(ep.getOriginator_id());
			epov.setPurchase_amount(ep.getPurchase_amount());
			epov.setPurchaser_id(ep.getPurchaser_id());
			epov.setSupplier_id(ep.getSupplier_id());
			epov.setWarehouse_id(ep.getWarehouse_id());
			
			if(ep.getInvalid_id()!=null){	//作废人
				epov.setInvalid_id(ep.getInvalid_id());
				ErpUser eu1 = erpUserMapper.getById(ep.getInvalid_id());
				epov.setInvalid_name(eu1.getName());
			}
			
			ErpDept ed = erpDeptMapper.getById(ep.getDept_id());
			epov.setDept_name(ed.getName());
			
			ErpWarehouse ew = erpWarehouseMapper.getById(ep.getWarehouse_id());
			epov.setWarehouse_name(ew.getName());
			
			ErpCustomer ec = erpCustomerMapper.getById(ep.getSupplier_id());
			epov.setSupplier_name(ec.getCompany());
			
			ErpCode ecode = erpCodeMapper.getByKeyAndType(ep.getInvoices_state(), "INVOICES_STATE");
			epov.setStateVo(ecode.getValue());
			
			ErpOrganization eorg = erpOrganizationMapper.getById(ep.getOrganization_id());
			epov.setOrganization_name(eorg.getName());
			
			ErpUser eu2 = erpUserMapper.getById(ep.getPurchaser_id());
			epov.setPurchaser_name(eu2.getName());
			
			ErpUser eu3 = erpUserMapper.getById(ep.getOriginator_id());
			epov.setOriginator_name(eu3.getName());
			
			epl.add(epov);
		}
		return epl;
	}
	
	/**
	 * 获取采购单的vo
	 * @param ep
	 * @return
	 */
	public static ErpPurchaseVo getPurchaseVo(ErpPurchase ep){
		ErpPurchaseVo epov = new ErpPurchaseVo();
		
		epov.setPurchase_id(ep.getPurchase_id());
		epov.setCreate_time(ep.getCreate_time());
		epov.setDept_id(ep.getDept_id());
		
		epov.setInvoices_state(ep.getInvoices_state());
		epov.setOrganization_id(ep.getOrganization_id());
		epov.setOriginator_id(ep.getOriginator_id());
		epov.setPurchase_amount(ep.getPurchase_amount());
		epov.setPurchaser_id(ep.getPurchaser_id());
		epov.setSupplier_id(ep.getSupplier_id());
		epov.setWarehouse_id(ep.getWarehouse_id());
		
		if(ep.getInvalid_id()!=null){	//作废人
			epov.setInvalid_id(ep.getInvalid_id());
			ErpUser eu1 = erpUserMapper.getById(ep.getInvalid_id());
			epov.setInvalid_name(eu1.getName());
		}
		
		ErpDept ed = erpDeptMapper.getById(ep.getDept_id());
		epov.setDept_name(ed.getName());
		
		ErpWarehouse ew = erpWarehouseMapper.getById(ep.getWarehouse_id());
		epov.setWarehouse_name(ew.getName());
		
		ErpCustomer ec = erpCustomerMapper.getById(ep.getSupplier_id());
		epov.setSupplier_name(ec.getCompany());
		
		ErpCode ecode = erpCodeMapper.getByKeyAndType(ep.getInvoices_state(), "INVOICES_STATE");
		epov.setStateVo(ecode.getValue());
		
		ErpOrganization eorg = erpOrganizationMapper.getById(ep.getOrganization_id());
		epov.setOrganization_name(eorg.getName());
		
		ErpUser eu2 = erpUserMapper.getById(ep.getPurchaser_id());
		epov.setPurchaser_name(eu2.getName());
		
		ErpUser eu3 = erpUserMapper.getById(ep.getOriginator_id());
		epov.setOriginator_name(eu3.getName());
		
		return epov;
	}
	
	/**
	 * 获取采购单的商品的vo集合
	 * @param list
	 * @return
	 */
	public static List<ErpPurchaseGoodsVo> getPurchaseGoodsVo(List<ErpPurchaseGoods> list){
		
		List<ErpPurchaseGoodsVo> pgvl = new ArrayList<ErpPurchaseGoodsVo>();
		
		for(ErpPurchaseGoods pg:list){
			ErpPurchaseGoodsVo epgv = new ErpPurchaseGoodsVo();
			String goods_id = pg.getGoods_id();
			System.out.println(pg.getGoods_id());
			
			epgv.setGoods_id(pg.getGoods_id());
			epgv.setGoods_num(pg.getGoods_num());
			epgv.setGoods_prices(pg.getGoods_prices());
			epgv.setId(pg.getId());
			epgv.setPurchase_id(pg.getPurchase_id());
			epgv.setRemark(pg.getRemark());
			epgv.setRownum(pg.getRownum());
			if(goods_id!=null){
				ErpGoods erpgoods = erpGoodsMapper.getById(goods_id);
				if(erpgoods!=null){
					epgv.setGoods_name(erpgoods.getGoods_name());
					epgv.setGoods_unit(erpgoods.getGoods_unit());
					
					String goods_type = erpgoods.getGoods_type();
					ErpCode ecode = erpCodeMapper.getByKeyAndType(goods_type, "GOODS");
					epgv.setGoods_type(ecode.getValue());
					
					ErpWarehouse ew = erpWarehouseMapper.getById(erpgoods.getWarehouse_id());
					if(ew!=null){
						epgv.setWarehouse_name(ew.getName());
					}
				}
			}
			
			pgvl.add(epgv);
		}
		return pgvl;
		
	}
	
	public static ErpPurchaseGoodsVo getPurchaseGoodsVo(ErpPurchaseGoods pg){
		
		ErpPurchaseGoodsVo epgv = new ErpPurchaseGoodsVo();
		String goods_id = pg.getGoods_id();
		System.out.println(pg.getGoods_id());
		
		epgv.setGoods_id(pg.getGoods_id());
		epgv.setGoods_num(pg.getGoods_num());
		epgv.setGoods_prices(pg.getGoods_prices());
		epgv.setId(pg.getId());
		epgv.setPurchase_id(pg.getPurchase_id());
		epgv.setRemark(pg.getRemark());
		epgv.setRownum(pg.getRownum());
		if(goods_id!=null){
			ErpGoods erpgoods = erpGoodsMapper.getById(goods_id);
			if(erpgoods!=null){
				epgv.setGoods_name(erpgoods.getGoods_name());
				epgv.setGoods_unit(erpgoods.getGoods_unit());
				String goods_type = erpgoods.getGoods_type();
				ErpCode ecode = erpCodeMapper.getByKeyAndType(goods_type, "GOODS");
				epgv.setGoods_type(ecode.getValue());
				ErpWarehouse ew = erpWarehouseMapper.getById(erpgoods.getWarehouse_id());
				if(ew!=null){
					epgv.setWarehouse_name(ew.getName());
				}
			}
		}
		
		return epgv;
	}
	
	/**
	 * 获取销售商品的Vo集合
	 * @param list
	 * @return
	 */
	public static List<ErpSoGoodsVo> getSoGoodsVo(List<ErpSoGoods> list){
		
		List<ErpSoGoodsVo> sgvl = new ArrayList<ErpSoGoodsVo>();
		for(ErpSoGoods pg:list){
			ErpSoGoodsVo epgv = new ErpSoGoodsVo();
			String goods_id = pg.getGoods_id();
			System.out.println(pg.getGoods_id());
			
			epgv.setGoods_id(pg.getGoods_id());
			epgv.setGoods_num(pg.getGoods_num());
			epgv.setGoods_prices(pg.getGoods_prices());
			epgv.setId(pg.getId());
			epgv.setSo_id(pg.getSo_id());
			epgv.setRemark(pg.getRemark());
			epgv.setRownum(pg.getRownum());
			epgv.setWarehouse_id(pg.getWarehouse_id());
			if(goods_id!=null){
				ErpGoods erpgoods = erpGoodsMapper.getById(goods_id);
				if(erpgoods!=null){
					epgv.setGoods_name(erpgoods.getGoods_name());
					epgv.setGoods_unit(erpgoods.getGoods_unit());
					String goods_type = erpgoods.getGoods_type();
					ErpCode ecode = erpCodeMapper.getByKeyAndType(goods_type, "GOODS");
					epgv.setGoods_type(ecode.getValue());
					
					ErpWarehouse ew = erpWarehouseMapper.getById(pg.getWarehouse_id());
					if(ew!=null){
						epgv.setWarehouse_name(ew.getName());
					}
				}
			}
			
			sgvl.add(epgv);
		}
		return sgvl;
	}
	
	/**
	 * 获取单个的销售订单商品vo
	 * @param pg
	 * @return
	 */
	public static ErpSoGoodsVo getSoGoodsVo(ErpSoGoods pg){
			ErpSoGoodsVo epgv = new ErpSoGoodsVo();
			String goods_id = pg.getGoods_id();
			System.out.println(pg.getGoods_id());
			
			epgv.setGoods_id(pg.getGoods_id());
			epgv.setGoods_num(pg.getGoods_num());
			epgv.setGoods_prices(pg.getGoods_prices());
			epgv.setId(pg.getId());
			epgv.setSo_id(pg.getSo_id());
			epgv.setRemark(pg.getRemark());
			epgv.setRownum(pg.getRownum());
			epgv.setWarehouse_id(pg.getWarehouse_id());
			if(goods_id!=null){
				ErpGoods erpgoods = erpGoodsMapper.getById(goods_id);
				if(erpgoods!=null){
					epgv.setGoods_name(erpgoods.getGoods_name());
					epgv.setGoods_unit(erpgoods.getGoods_unit());
					
					String goods_type = erpgoods.getGoods_type();
					ErpCode ecode = erpCodeMapper.getByKeyAndType(goods_type, "GOODS");
					epgv.setGoods_type(ecode.getValue());
					
					ErpWarehouse ew = erpWarehouseMapper.getById(pg.getWarehouse_id());
					if(ew!=null){
						epgv.setWarehouse_name(ew.getName());
					}
				}
			}
		return epgv;
	}
	
	/**
	 * 获取销售退货单的商品集合List<ErpSrGoodsVo>
	 * @param list
	 * @return
	 */
	public static List<ErpSrGoodsVo> getSrGoodsVo(List<ErpSrGoods> list){
		
		List<ErpSrGoodsVo> sgvl = new ArrayList<ErpSrGoodsVo>();
		for(ErpSrGoods pg:list){
			ErpSrGoodsVo epgv = new ErpSrGoodsVo();
			String goods_id = pg.getGoods_id();
			System.out.println(pg.getGoods_id());
			
			epgv.setGoods_id(pg.getGoods_id());
			epgv.setGoods_num(pg.getGoods_num());
			epgv.setGoods_prices(pg.getGoods_prices());
			epgv.setId(pg.getId());
			epgv.setSr_id(pg.getSr_id());
			epgv.setRemark(pg.getRemark());
			epgv.setRownum(pg.getRownum());
			epgv.setWarehouse_id(pg.getWarehouse_id());
			
			if(goods_id!=null){
				ErpGoods erpgoods = erpGoodsMapper.getById(goods_id);
				if(erpgoods!=null){
					epgv.setGoods_name(erpgoods.getGoods_name());
					epgv.setGoods_unit(erpgoods.getGoods_unit());
					String goods_type = erpgoods.getGoods_type();
					ErpCode ecode = erpCodeMapper.getByKeyAndType(goods_type, "GOODS");
					epgv.setGoods_type(ecode.getValue());
					
					ErpWarehouse ew = erpWarehouseMapper.getById(pg.getWarehouse_id());
					if(ew!=null){
						epgv.setWarehouse_name(ew.getName());
					}
				}
			}
			
			sgvl.add(epgv);
		}
		return sgvl;
		
	}
	
	/**
	 * 获取销售退货的单个商品vo ErpSrGoodsVo
	 * @param pg
	 * @return
	 */
	public static ErpSrGoodsVo getSrGoodsVo(ErpSrGoods pg){
		
			ErpSrGoodsVo epgv = new ErpSrGoodsVo();
			String goods_id = pg.getGoods_id();
			System.out.println(pg.getGoods_id());
			
			epgv.setGoods_id(pg.getGoods_id());
			epgv.setGoods_num(pg.getGoods_num());
			epgv.setGoods_prices(pg.getGoods_prices());
			epgv.setId(pg.getId());
			epgv.setSr_id(pg.getSr_id());
			epgv.setRemark(pg.getRemark());
			epgv.setRownum(pg.getRownum());
			epgv.setWarehouse_id(pg.getWarehouse_id());
			
			if(goods_id!=null){
				ErpGoods erpgoods = erpGoodsMapper.getById(goods_id);
				if(erpgoods!=null){
					epgv.setGoods_name(erpgoods.getGoods_name());
					epgv.setGoods_unit(erpgoods.getGoods_unit());
					String goods_type = erpgoods.getGoods_type();
					ErpCode ecode = erpCodeMapper.getByKeyAndType(goods_type, "GOODS");
					epgv.setGoods_type(ecode.getValue());
					
					ErpWarehouse ew = erpWarehouseMapper.getById(pg.getWarehouse_id());
					if(ew!=null){
						epgv.setWarehouse_name(ew.getName());
					}
				}
			}
		return epgv;
		
	}
	
	/**
	 * 获取销售单的商品集合List<ErpSaleGoodsVo>
	 * @param list
	 * @return
	 */
	public static List<ErpSaleGoodsVo> getSaleGoodsVo(List<ErpSaleGoods> list){
		
		List<ErpSaleGoodsVo> sgvl = new ArrayList<ErpSaleGoodsVo>();
		for(ErpSaleGoods pg:list){
			ErpSaleGoodsVo epgv = new ErpSaleGoodsVo();
			String goods_id = pg.getGoods_id();
			System.out.println(pg.getGoods_id());
			
			epgv.setGoods_id(pg.getGoods_id());
			epgv.setGoods_num(pg.getGoods_num());
			epgv.setGoods_prices(pg.getGoods_prices());
			epgv.setId(pg.getId());
			epgv.setSale_id(pg.getSale_id());
			epgv.setRemark(pg.getRemark());
			epgv.setRownum(pg.getRownum());
			epgv.setWarehouse_id(pg.getWarehouse_id());
			
			if(goods_id!=null){
				ErpGoods erpgoods = erpGoodsMapper.getById(goods_id);
				if(erpgoods!=null){
					epgv.setGoods_name(erpgoods.getGoods_name());
					epgv.setGoods_unit(erpgoods.getGoods_unit());
					
					String goods_type = erpgoods.getGoods_type();
					ErpCode ecode = erpCodeMapper.getByKeyAndType(goods_type, "GOODS");
					epgv.setGoods_type(ecode.getValue());
					
					ErpWarehouse ew = erpWarehouseMapper.getById(pg.getWarehouse_id());
					if(ew!=null){
						epgv.setWarehouse_name(ew.getName());
					}
				}
			}
			
			sgvl.add(epgv);
		}
		return sgvl;
		
	}
	/**
	 * 获取销售单单个商品的vo  ErpSaleGoodsVo
	 * @param pg
	 * @return
	 */
	public static ErpSaleGoodsVo getSaleGoodsVo(ErpSaleGoods pg){
			
			ErpSaleGoodsVo epgv = new ErpSaleGoodsVo();
			String goods_id = pg.getGoods_id();
			System.out.println(pg.getGoods_id());
			
			epgv.setGoods_id(pg.getGoods_id());
			epgv.setGoods_num(pg.getGoods_num());
			epgv.setGoods_prices(pg.getGoods_prices());
			epgv.setId(pg.getId());
			epgv.setSale_id(pg.getSale_id());
			epgv.setRemark(pg.getRemark());
			epgv.setRownum(pg.getRownum());
			epgv.setWarehouse_id(pg.getWarehouse_id());
			
			if(goods_id!=null){
				ErpGoods erpgoods = erpGoodsMapper.getById(goods_id);
				if(erpgoods!=null){
					epgv.setGoods_name(erpgoods.getGoods_name());
					epgv.setGoods_unit(erpgoods.getGoods_unit());
					
					String goods_type = erpgoods.getGoods_type();
					ErpCode ecode = erpCodeMapper.getByKeyAndType(goods_type, "GOODS");
					epgv.setGoods_type(ecode.getValue());
					
					ErpWarehouse ew = erpWarehouseMapper.getById(pg.getWarehouse_id());
					if(ew!=null){
						epgv.setWarehouse_name(ew.getName());
					}
				}
			}
		
		return epgv;
		
	}
	
	/**
	 * 获取销售单主表的volist   List<ErpSaleVo>
	 * @param list
	 * @return
	 */
	public static List<ErpSaleVo> getSaleVo(List<ErpSale> list){
		
		List<ErpSaleVo> es = new ArrayList<ErpSaleVo>();
		for(ErpSale ep :list){
			ErpSaleVo esv = new ErpSaleVo();
			
			esv.setRownum(ep.getRownum());
			esv.setSale_id(ep.getSale_id());//销售订单id	
			esv.setCreate_time(ep.getCreate_time());//日期
			esv.setDept_id(ep.getDept_id());//部门id
			esv.setInvoices_state(ep.getInvoices_state());//单据状态
			esv.setOrganization_id(ep.getOrganization_id());//所属机构id
			esv.setOriginator_id(ep.getOriginator_id());//制单人id
			esv.setMoney(ep.getMoney());//金额
			esv.setSalesman_id(ep.getSalesman_id());//销售员id
			esv.setCustomer_id(ep.getCustomer_id());//客户id
			esv.setDelivery_way(ep.getDelivery_way());//发运方式
			esv.setSale_type(ep.getSale_type());//销售类型
			esv.setPayment_method(ep.getPayment_method());//支付方式
			
			
			
			if(ep.getInvalid_id()!=null){	//作废人//作废人id
				esv.setInvalid_id(ep.getInvalid_id());
				ErpUser eu1 = erpUserMapper.getById(ep.getInvalid_id());
				esv.setInvalid_name(eu1.getName());
			}
			
			
			ErpDept ed = erpDeptMapper.getById(ep.getDept_id());
			esv.setDept_name(ed.getName());
			
			
			ErpCustomer ec = erpCustomerMapper.getById(ep.getCustomer_id());
			esv.setCustomer_name(ec.getCompany());
			
			ErpCode ecode = erpCodeMapper.getByKeyAndType(ep.getInvoices_state(), "INVOICES_STATE");
			esv.setStateVo(ecode.getValue());
			
			ErpCode ecode1 = erpCodeMapper.getByKeyAndType(ep.getDelivery_way(), "DELIVERY_WAY");
			esv.setDeliveryWayVo(ecode1.getValue());
			
			ErpCode ecode2 = erpCodeMapper.getByKeyAndType(ep.getPayment_method(), "PAYMENT_METHOD");
			esv.setPaymentMethodVo(ecode2.getValue());
			
			ErpCode ecode3 = erpCodeMapper.getByKeyAndType(ep.getSale_type(), "SALE_TYPE");
			esv.setSaleTypeVo(ecode3.getValue());
			
			ErpOrganization eorg = erpOrganizationMapper.getById(ep.getOrganization_id());
			esv.setOrganization_name(eorg.getName());
			
			ErpUser eu2 = erpUserMapper.getById(ep.getSalesman_id());
			esv.setSalesman_name(eu2.getName());
			
			ErpUser eu3 = erpUserMapper.getById(ep.getOriginator_id());
			esv.setOriginator_name(eu3.getName());
			
			es.add(esv);
		}
		
		return es;
	}
	
	
	/**
	 * 获取单个的销售单vo     ErpSaleVo
	 * @param ep
	 * @return
	 */
	public static ErpSaleVo getSaleVo(ErpSale ep){
		
			ErpSaleVo esv = new ErpSaleVo();
			
			esv.setRownum(ep.getRownum());
			esv.setSale_id(ep.getSale_id());//销售订单id	
			esv.setCreate_time(ep.getCreate_time());//日期
			esv.setDept_id(ep.getDept_id());//部门id
			esv.setInvoices_state(ep.getInvoices_state());//单据状态
			esv.setOrganization_id(ep.getOrganization_id());//所属机构id
			esv.setOriginator_id(ep.getOriginator_id());//制单人id
			esv.setMoney(ep.getMoney());//金额
			esv.setSalesman_id(ep.getSalesman_id());//销售员id
			esv.setCustomer_id(ep.getCustomer_id());//客户id
			esv.setDelivery_way(ep.getDelivery_way());//发运方式
			esv.setSale_type(ep.getSale_type());//销售类型
			esv.setPayment_method(ep.getPayment_method());//支付方式
			
			
			
			if(ep.getInvalid_id()!=null){	//作废人//作废人id
				esv.setInvalid_id(ep.getInvalid_id());
				ErpUser eu1 = erpUserMapper.getById(ep.getInvalid_id());
				esv.setInvalid_name(eu1.getName());
			}
			ErpDept ed = erpDeptMapper.getById(ep.getDept_id());
			esv.setDept_name(ed.getName());
			
			
			ErpCustomer ec = erpCustomerMapper.getById(ep.getCustomer_id());
			esv.setCustomer_name(ec.getCompany());
			
			ErpCode ecode = erpCodeMapper.getByKeyAndType(ep.getInvoices_state(), "INVOICES_STATE");
			esv.setStateVo(ecode.getValue());
			
			ErpCode ecode1 = erpCodeMapper.getByKeyAndType(ep.getDelivery_way(), "DELIVERY_WAY");
			esv.setDeliveryWayVo(ecode1.getValue());
			
			ErpCode ecode2 = erpCodeMapper.getByKeyAndType(ep.getPayment_method(), "PAYMENT_METHOD");
			esv.setPaymentMethodVo(ecode2.getValue());
			
			ErpCode ecode3 = erpCodeMapper.getByKeyAndType(ep.getSale_type(), "SALE_TYPE");
			esv.setSaleTypeVo(ecode3.getValue());
			
			ErpOrganization eorg = erpOrganizationMapper.getById(ep.getOrganization_id());
			esv.setOrganization_name(eorg.getName());
			
			ErpUser eu2 = erpUserMapper.getById(ep.getSalesman_id());
			esv.setSalesman_name(eu2.getName());
			
			ErpUser eu3 = erpUserMapper.getById(ep.getOriginator_id());
			esv.setOriginator_name(eu3.getName());
		
		return esv;
	}
	
	
	/**
	 * 获取销售订单的vo集合    List<ErpSaleOrderVo>
	 * @param list
	 * @return
	 */
	public static List<ErpSaleOrderVo> getSaleOrderVo(List<ErpSaleOrder> list){
		
		List<ErpSaleOrderVo> es = new ArrayList<ErpSaleOrderVo>();
		for(ErpSaleOrder ep :list){
			ErpSaleOrderVo esv = new ErpSaleOrderVo();
			
			esv.setRownum(ep.getRownum());
			esv.setSo_id(ep.getSo_id());//销售订单id	
			esv.setCreate_time(ep.getCreate_time());//日期
			esv.setDept_id(ep.getDept_id());//部门id
			esv.setInvoices_state(ep.getInvoices_state());//单据状态
			esv.setOrganization_id(ep.getOrganization_id());//所属机构id
			esv.setOriginator_id(ep.getOriginator_id());//制单人id
			esv.setMoney(ep.getMoney());//金额
			esv.setSalesman_id(ep.getSalesman_id());//销售员id
			esv.setCustomer_id(ep.getCustomer_id());//客户id
			esv.setDelivery_way(ep.getDelivery_way());//发运方式
			esv.setSale_type(ep.getSale_type());//销售类型
			esv.setPayment_method(ep.getPayment_method());//支付方式
			
			
			
			if(ep.getInvalid_id()!=null){	//作废人//作废人id
				esv.setInvalid_id(ep.getInvalid_id());
				ErpUser eu1 = erpUserMapper.getById(ep.getInvalid_id());
				esv.setInvalid_name(eu1.getName());
			}
			
			
			ErpDept ed = erpDeptMapper.getById(ep.getDept_id());
			esv.setDept_name(ed.getName());
			
			
			ErpCustomer ec = erpCustomerMapper.getById(ep.getCustomer_id());
			esv.setCustomer_name(ec.getCompany());
			
			ErpCode ecode = erpCodeMapper.getByKeyAndType(ep.getInvoices_state(), "INVOICES_STATE");
			esv.setStateVo(ecode.getValue());
			
			ErpCode ecode1 = erpCodeMapper.getByKeyAndType(ep.getDelivery_way(), "DELIVERY_WAY");
			esv.setDeliveryWayVo(ecode1.getValue());
			
			ErpCode ecode2 = erpCodeMapper.getByKeyAndType(ep.getPayment_method(), "PAYMENT_METHOD");
			esv.setPaymentMethodVo(ecode2.getValue());
			
			ErpCode ecode3 = erpCodeMapper.getByKeyAndType(ep.getSale_type(), "SALE_TYPE");
			esv.setSaleTypeVo(ecode3.getValue());
			
			ErpOrganization eorg = erpOrganizationMapper.getById(ep.getOrganization_id());
			esv.setOrganization_name(eorg.getName());
			
			ErpUser eu2 = erpUserMapper.getById(ep.getSalesman_id());
			esv.setSalesman_name(eu2.getName());
			
			ErpUser eu3 = erpUserMapper.getById(ep.getOriginator_id());
			esv.setOriginator_name(eu3.getName());
			
			es.add(esv);
		}
		
		return es;
	}
	/**
	 * 获取单个销售订单vo   ErpSaleOrderVo
	 * @param ep
	 * @return
	 */
	public static ErpSaleOrderVo getSaleOrderVo(ErpSaleOrder ep){
		
		ErpSaleOrderVo esv = new ErpSaleOrderVo();
		
		esv.setRownum(ep.getRownum());
		esv.setSo_id(ep.getSo_id());//销售订单id	
		esv.setCreate_time(ep.getCreate_time());//日期
		esv.setDept_id(ep.getDept_id());//部门id
		esv.setInvoices_state(ep.getInvoices_state());//单据状态
		esv.setOrganization_id(ep.getOrganization_id());//所属机构id
		esv.setOriginator_id(ep.getOriginator_id());//制单人id
		esv.setMoney(ep.getMoney());//金额
		esv.setSalesman_id(ep.getSalesman_id());//销售员id
		esv.setCustomer_id(ep.getCustomer_id());//客户id
		esv.setDelivery_way(ep.getDelivery_way());//发运方式
		esv.setSale_type(ep.getSale_type());//销售类型
		esv.setPayment_method(ep.getPayment_method());//支付方式
		
		
		
		if(ep.getInvalid_id()!=null){	//作废人//作废人id
			esv.setInvalid_id(ep.getInvalid_id());
			ErpUser eu1 = erpUserMapper.getById(ep.getInvalid_id());
			esv.setInvalid_name(eu1.getName());
		}
		ErpDept ed = erpDeptMapper.getById(ep.getDept_id());
		esv.setDept_name(ed.getName());
		
		
		ErpCustomer ec = erpCustomerMapper.getById(ep.getCustomer_id());
		esv.setCustomer_name(ec.getCompany());
		
		ErpCode ecode = erpCodeMapper.getByKeyAndType(ep.getInvoices_state(), "INVOICES_STATE");
		esv.setStateVo(ecode.getValue());
		
		ErpCode ecode1 = erpCodeMapper.getByKeyAndType(ep.getDelivery_way(), "DELIVERY_WAY");
		esv.setDeliveryWayVo(ecode1.getValue());
		
		ErpCode ecode2 = erpCodeMapper.getByKeyAndType(ep.getPayment_method(), "PAYMENT_METHOD");
		esv.setPaymentMethodVo(ecode2.getValue());
		
		ErpCode ecode3 = erpCodeMapper.getByKeyAndType(ep.getSale_type(), "SALE_TYPE");
		esv.setSaleTypeVo(ecode3.getValue());
		
		ErpOrganization eorg = erpOrganizationMapper.getById(ep.getOrganization_id());
		esv.setOrganization_name(eorg.getName());
		
		ErpUser eu2 = erpUserMapper.getById(ep.getSalesman_id());
		esv.setSalesman_name(eu2.getName());
		
		ErpUser eu3 = erpUserMapper.getById(ep.getOriginator_id());
		esv.setOriginator_name(eu3.getName());
	
		return esv;
	}
	
	/**
	 * 获取销售退货表的vo集合   List<ErpSaleReturnVo>
	 * @param list
	 * @return
	 */
	public static List<ErpSaleReturnVo> getSaleReturnVo(List<ErpSaleReturn> list){
		List<ErpSaleReturnVo> es = new ArrayList<ErpSaleReturnVo>();
		for(ErpSaleReturn ep :list){
			ErpSaleReturnVo esv = new ErpSaleReturnVo();
			
			esv.setRownum(ep.getRownum());
			esv.setSr_id(ep.getSr_id());//销售订单id	
			esv.setCreate_time(ep.getCreate_time());//日期
			esv.setInvoices_state(ep.getInvoices_state());//单据状态
			esv.setOrganization_id(ep.getOrganization_id());//所属机构id
			esv.setOriginator_id(ep.getOriginator_id());//制单人id
			esv.setMoney(ep.getMoney());//金额
			esv.setEmployee_id(ep.getEmployee_id());//销售员id
			esv.setCustomer_id(ep.getCustomer_id());//客户id
			esv.setPayment_method(ep.getPayment_method());//支付方式
			
			
			
			if(ep.getInvalid_id()!=null){	//作废人//作废人id
				esv.setInvalid_id(ep.getInvalid_id());
				ErpUser eu1 = erpUserMapper.getById(ep.getInvalid_id());
				esv.setInvalid_name(eu1.getName());
			}
			
			ErpCustomer ec = erpCustomerMapper.getById(ep.getCustomer_id());
			esv.setCustomer_name(ec.getCompany());
			
			ErpCode ecode2 = erpCodeMapper.getByKeyAndType(ep.getPayment_method(), "PAYMENT_METHOD");
			esv.setPaymentMethodVo(ecode2.getValue());
			
			ErpCode ecode3 = erpCodeMapper.getByKeyAndType(ep.getPayment_method(), "INVOICES_STATE");
			esv.setStateVo(ecode3.getValue());
			
			ErpOrganization eorg = erpOrganizationMapper.getById(ep.getOrganization_id());
			esv.setOrganization_name(eorg.getName());
			
			ErpUser eu2 = erpUserMapper.getById(ep.getEmployee_id());
			esv.setEmployee_name(eu2.getName());
			
			ErpUser eu3 = erpUserMapper.getById(ep.getOriginator_id());
			esv.setOriginator_name(eu3.getName());
			
			es.add(esv);
		}
		
		return es;
		
	} 

	/**
	 * 获取单个销售退货主表的vo ErpSaleReturnVo
	 * @param ep
	 * @return
	 */
	public static ErpSaleReturnVo getSaleReturnVo(ErpSaleReturn ep){
		ErpSaleReturnVo esv = new ErpSaleReturnVo();
		
		esv.setRownum(ep.getRownum());
		esv.setSr_id(ep.getSr_id());//销售订单id	
		esv.setCreate_time(ep.getCreate_time());//日期
		esv.setInvoices_state(ep.getInvoices_state());//单据状态
		esv.setOrganization_id(ep.getOrganization_id());//所属机构id
		esv.setOriginator_id(ep.getOriginator_id());//制单人id
		esv.setMoney(ep.getMoney());//金额
		esv.setEmployee_id(ep.getEmployee_id());//销售员id
		esv.setCustomer_id(ep.getCustomer_id());//客户id
		esv.setPayment_method(ep.getPayment_method());//支付方式
		
		
		
		if(ep.getInvalid_id()!=null){	//作废人//作废人id
			esv.setInvalid_id(ep.getInvalid_id());
			ErpUser eu1 = erpUserMapper.getById(ep.getInvalid_id());
			esv.setInvalid_name(eu1.getName());
		}
		
		ErpCustomer ec = erpCustomerMapper.getById(ep.getCustomer_id());
		esv.setCustomer_name(ec.getCompany());
		
		ErpCode ecode2 = erpCodeMapper.getByKeyAndType(ep.getPayment_method(), "PAYMENT_METHOD");
		esv.setPaymentMethodVo(ecode2.getValue());
		
		ErpCode ecode3 = erpCodeMapper.getByKeyAndType(ep.getPayment_method(), "INVOICES_STATE");
		esv.setStateVo(ecode3.getValue());
		
		ErpOrganization eorg = erpOrganizationMapper.getById(ep.getOrganization_id());
		esv.setOrganization_name(eorg.getName());
		
		ErpUser eu2 = erpUserMapper.getById(ep.getEmployee_id());
		esv.setEmployee_name(eu2.getName());
		
		ErpUser eu3 = erpUserMapper.getById(ep.getOriginator_id());
		esv.setOriginator_name(eu3.getName());
		
		return esv;
	}
	
	
	public static List<ErpCashStatementVo> getCashStatementVo(List<ErpCashStatement> list){
		
		List<ErpCashStatementVo> ecsv = new ArrayList<ErpCashStatementVo>();
		
		for(ErpCashStatement ec:list){
			ErpCashStatementVo ecv = new ErpCashStatementVo();
			ecv.setStatement_id(ec.getStatement_id());
			ecv.setGoods_id(ec.getGoods_id());
			ecv.setGoods_num(ec.getGoods_num());
			ecv.setWarehouse_id(ec.getWarehouse_id());
			ecv.setRownum(ec.getRownum());
			
			ErpGoods erpGoods = erpGoodsMapper.getById(ec.getGoods_id());
			String goods_name = erpGoods.getGoods_name();
			String goods_type = erpCodeMapper.getByKeyAndType(erpGoods.getGoods_type(), "GOODS").getValue();
			int goods_prices = erpGoods.getGoods_prices();
			String goods_unit = erpGoods.getGoods_unit();
			ErpWarehouse ew = erpWarehouseMapper.getById(ec.getWarehouse_id());
			String warehouse_name = ew.getName();
			
			ecv.setGoods_name(goods_name);
			ecv.setGoods_prices(goods_prices);
			ecv.setGoods_type(goods_type);
			ecv.setGoods_unit(goods_unit);
			ecv.setWarehouse_name(warehouse_name);
			
			ecsv.add(ecv);
		}
		
		return ecsv;
	}
	
	public static ErpCashStatementVo getCashStatementVo(ErpCashStatement ec){
		
			ErpCashStatementVo ecv = new ErpCashStatementVo();
			ecv.setStatement_id(ec.getStatement_id());
			ecv.setGoods_id(ec.getGoods_id());
			ecv.setGoods_num(ec.getGoods_num());
			ecv.setWarehouse_id(ec.getWarehouse_id());
			ecv.setRownum(ec.getRownum());
			
			ErpGoods erpGoods = erpGoodsMapper.getById(ec.getGoods_id());
			String goods_name = erpGoods.getGoods_name();
			String goods_type = erpCodeMapper.getByKeyAndType(erpGoods.getGoods_type(), "GOODS").getValue();
			int goods_prices = erpGoods.getGoods_prices();
			String goods_unit = erpGoods.getGoods_unit();
			ErpWarehouse ew = erpWarehouseMapper.getById(ec.getWarehouse_id());
			String warehouse_name = ew.getName();
			
			ecv.setGoods_name(goods_name);
			ecv.setGoods_prices(goods_prices);
			ecv.setGoods_type(goods_type);
			ecv.setGoods_unit(goods_unit);
			ecv.setWarehouse_name(warehouse_name);
			
		
		
		return ecv;
	}
	
	/**
	 * 获取盘点单的vo集合 List<ErpBlitemVo>
	 * @param list
	 * @return
	 */
	public static List<ErpBlitemVo> getBlitemVo(List<ErpBlitem> list){
		
		List<ErpBlitemVo> ebl = new ArrayList<ErpBlitemVo>();
		for(ErpBlitem eb :list){
			
			ErpBlitemVo ebv = new ErpBlitemVo();
			ebv.setBlitem_id(eb.getBlitem_id());
			ebv.setCheck_num(eb.getCheck_num());
			ebv.setGoods_id(eb.getGoods_id());
			ebv.setHandler_id(eb.getHandler_id());
			ebv.setNum(eb.getNum());
			ebv.setProfit_and_loss(eb.getProfit_and_loss());
			ebv.setWarehouse_id(eb.getWarehouse_id());
			
			ErpGoods erpGoods = erpGoodsMapper.getById(eb.getGoods_id());
			ebv.setGoods_name(erpGoods.getGoods_name());
			
			ErpWarehouse erpw = erpWarehouseMapper.getById(eb.getWarehouse_id());
			ebv.setWarehouse_name(erpw.getName());
			
			ErpUser erpu = erpUserMapper.getById(eb.getHandler_id());
			ebv.setHandler_name(erpu.getName());
			
			ebl.add(ebv);
			
		}
		
		return ebl;
	}
	/**
	 * 获取盘点单的vo ErpBlitemVo
	 * @param eb
	 * @return
	 */
	public static ErpBlitemVo getBlitemVo(ErpBlitem eb){
		
			ErpBlitemVo ebv = new ErpBlitemVo();
			ebv.setBlitem_id(eb.getBlitem_id());
			ebv.setCheck_num(eb.getCheck_num());
			ebv.setGoods_id(eb.getGoods_id());
			ebv.setHandler_id(eb.getHandler_id());
			ebv.setNum(eb.getNum());
			ebv.setProfit_and_loss(eb.getProfit_and_loss());
			ebv.setWarehouse_id(eb.getWarehouse_id());
			
			ErpGoods erpGoods = erpGoodsMapper.getById(eb.getGoods_id());
			ebv.setGoods_name(erpGoods.getGoods_name());
			
			ErpWarehouse erpw = erpWarehouseMapper.getById(eb.getWarehouse_id());
			ebv.setWarehouse_name(erpw.getName());
			
			ErpUser erpu = erpUserMapper.getById(eb.getHandler_id());
			ebv.setHandler_name(erpu.getName());
			
		return ebv;
	}
	
	/**
	 * 获取调拨单的vo集合
	 * @param list
	 * @return
	 */
	public static List<ErpRequisitionVo> getRequisitionVo(List<ErpRequisition> list){
		
		List<ErpRequisitionVo> erl = new ArrayList<ErpRequisitionVo>();
		
		for(ErpRequisition er:list){
			
			ErpRequisitionVo erv = new ErpRequisitionVo();
			erv.setDescribe(er.getDescribe());
			erv.setGoods_id(er.getGoods_id());
			erv.setIn_warehouse_id(er.getIn_warehouse_id());
			erv.setNum(er.getNum());
			erv.setOut_time(er.getOut_time());
			erv.setOut_warehouse_id(er.getOut_warehouse_id());
			erv.setRequision_state(er.getRequision_state());
			erv.setRequisition_id(er.getRequisition_id());
			
			ErpGoods erpGoods = erpGoodsMapper.getById(er.getGoods_id());
			erv.setGoods_name(erpGoods.getGoods_name());
			
			ErpWarehouse erpw = erpWarehouseMapper.getById(er.getIn_warehouse_id());
			erv.setIn_warehouse_name(erpw.getName());
			
			ErpWarehouse erpw2 = erpWarehouseMapper.getById(er.getOut_warehouse_id());
			erv.setOut_warehouse_name(erpw2.getName());
			
			ErpCode ec = erpCodeMapper.getByKeyAndType(er.getRequision_state(), "RE_STATE");
			erv.setRequision_stateVo(ec.getValue());
			erl.add(erv);
			
		}
		return erl;
	}
	/**
	 * 获取调拨单的vo
	 * @param er
	 * @return
	 */
	public static ErpRequisitionVo getRequisitionVo(ErpRequisition er){
		
			ErpRequisitionVo erv = new ErpRequisitionVo();
			erv.setDescribe(er.getDescribe());
			erv.setGoods_id(er.getGoods_id());
			erv.setIn_warehouse_id(er.getIn_warehouse_id());
			erv.setNum(er.getNum());
			erv.setOut_time(er.getOut_time());
			erv.setOut_warehouse_id(er.getOut_warehouse_id());
			erv.setRequision_state(er.getRequision_state());
			erv.setRequisition_id(er.getRequisition_id());
			
			ErpGoods erpGoods = erpGoodsMapper.getById(er.getGoods_id());
			erv.setGoods_name(erpGoods.getGoods_name());
			
			ErpWarehouse erpw = erpWarehouseMapper.getById(er.getIn_warehouse_id());
			erv.setIn_warehouse_name(erpw.getName());
			
			ErpWarehouse erpw2 = erpWarehouseMapper.getById(er.getOut_warehouse_id());
			erv.setOut_warehouse_name(erpw2.getName());
			
			ErpCode ec = erpCodeMapper.getByKeyAndType(er.getRequision_state(), "RE_STATE");
			erv.setRequision_stateVo(ec.getValue());
			
		return erv;
	}
	
	//获得部门 DeptVo
	public static List<DeptVo> getDeptVoList(List<ErpDept> list){
		List<DeptVo> listVo = new ArrayList<DeptVo>();
		for(ErpDept ed:list){
			DeptVo dv = new DeptVo();
			dv.setDept_id(ed.getDept_id());
			dv.setName(ed.getName());
			dv.setSubsidiary_organ(ed.getSubsidiary_organ());
			dv.setState(ed.getState());
			
			ErpCode ec = erpCodeMapper.getByKeyAndType(ed.getState(),"STATE"); 
			dv.setStateVo(ec.getValue());
			
			listVo.add(dv);
		}
		
		return listVo;
	}
	
	
	
	
	
	//获取机构 OrganizationVo
	public static List<OrganizationVo> getOrganizationVoList(List<ErpOrganization> list){
		List<OrganizationVo> listVo = new ArrayList<OrganizationVo>();
		for(ErpOrganization eo:list){
			OrganizationVo ov = new OrganizationVo();
			ov.setOrganization_id(eo.getOrganization_id());
			ov.setName(eo.getName());
			ov.setAddress(eo.getAddress());
			ov.setState(eo.getState());
			
			ErpCode ec = erpCodeMapper.getByKeyAndType(eo.getState(),"STATE"); 
			ov.setStateVo(ec.getValue());
			
			listVo.add(ov);
		}
		
		return listVo;
	}
	
	//获取仓库WarehouseVo
	public static List<WarehouseVo> getWarehouseVoList(List<ErpWarehouse> list){
		List<WarehouseVo> listVo = new ArrayList<WarehouseVo>();
		for(ErpWarehouse ew:list){
			WarehouseVo wv = new WarehouseVo();
			wv.setWarehouse_id(ew.getWarehouse_id());
			wv.setName(ew.getName());
			wv.setPrincipal(ew.getPrincipal());
			wv.setPhone(ew.getPhone());
			wv.setSubsidiary_organ(ew.getSubsidiary_organ());
			wv.setCreate_time(ew.getCreate_time());
			wv.setState(ew.getState());
				
			ErpCode ec = erpCodeMapper.getByKeyAndType(ew.getState(),"STATE"); 
			wv.setStateVo(ec.getValue());
			
			
			listVo.add(wv);
		}
		
		return listVo;
	}
	
	//获取商品GoodsVo
	public static List<GoodsVo> getGoodsVoList(List<ErpGoods> list){
		List<GoodsVo> listVo = new ArrayList<GoodsVo>();
		for(ErpGoods eg:list){
			GoodsVo gv = new GoodsVo();
			gv.setGoods_id(eg.getGoods_id());
			gv.setGoods_name(eg.getGoods_name());
			gv.setGoods_num(eg.getGoods_num());
			gv.setGoods_prices(eg.getGoods_prices());
			gv.setGoods_type(eg.getGoods_type());
			gv.setGoods_unit(eg.getGoods_unit());
			gv.setWarehouse_id(eg.getWarehouse_id());
				
			ErpCode ec = erpCodeMapper.getByKeyAndType(eg.getGoods_type(),"GOODS"); 
			gv.setTypeVo(ec.getValue());
			ErpWarehouse ew1 = erpWarehouseMapper.getById(eg.getWarehouse_id());
			gv.setWarehouseVo(ew1.getName());
			listVo.add(gv);
		}
		
		return listVo;
	}
	
	
	
	//获取职位JobVo
	public static List<JobVo> getJobVoList(List<ErpJob> list){
		List<JobVo> listVo = new ArrayList<JobVo>();
		for(ErpJob ej:list){
			JobVo jv = new JobVo();
			jv.setJob_id(ej.getJob_id());
			jv.setJob_name(ej.getJob_name());
			jv.setState(ej.getState());
			
			ErpCode ec = erpCodeMapper.getByKeyAndType(ej.getState(),"STATE"); 
			jv.setStateVo(ec.getValue());
			
			listVo.add(jv);
		}
		
		return listVo;

	}
	
public static List<ErpAccountVo> getErpAccountVoList(List<ErpAccount> list){
		
		List<ErpAccountVo> aList = new ArrayList<ErpAccountVo>();
		
		for(ErpAccount a:list){
			ErpAccountVo av = new ErpAccountVo();
			String user_id = a.getUser_id();
			
			av.setId(a.getId());
			av.setUsername(a.getUsername());
			av.setPassword(a.getPassword());
			av.setuType(a.getuType());
			av.setCreate_time(a.getCreate_time());
			av.setLast_login_time(a.getLast_login_time());
			av.setUser_id(a.getUser_id());
			
			ErpCode ecode = erpCodeMapper.getByKeyAndType(a.getuType(), "UTYPE");
			av.setuTypeVo(ecode.getValue());
			
			if(user_id!=null){
			ErpUser eu = erpUserMapper.getById(a.getUser_id());
				if(eu!=null){
					av.setName(eu.getName());
					av.setSex(eu.getSex());
					av.setAge(eu.getAge());
					av.setId_card(eu.getId_card());
					av.setDept_id(eu.getDept_id());
					av.setPhone(eu.getPhone());
					av.setEmail(eu.getEmail());
					av.setRemarks(eu.getRemarks());
					av.setJob_id(eu.getJob_id());
					
					av.setSexVo(CodeUtil.getValue(eu.getSex(), "SEX"));
					
				}
			}
			
			aList.add(av);
		}
	
		return aList;
	}

	public static List<ErpCustomerVo> getErpCustomerVoList(List<ErpCustomer> list){
		List<ErpCustomerVo> cList = new ArrayList<ErpCustomerVo>();
		
		for(ErpCustomer e:list){
			ErpCustomerVo ecv = new ErpCustomerVo();
			
			ecv.setId(e.getId());
			ecv.setName(e.getName());
			ecv.setSex(e.getSex());
			ecv.setAge(e.getAge());
			ecv.setAddress(e.getAddress());
			ecv.setCompany(e.getCompany());
			ecv.setPhone(e.getPhone());
			ecv.setC_type(e.getC_type());
			
			ecv.setSexVo(CodeUtil.getValue(e.getSex(), "SEX"));
			ecv.setC_typeVo(CodeUtil.getValue(e.getC_type(), "C_TYPE"));
			
			cList.add(ecv);
		}
		return cList;
	}
	
	
	
	
	public static List<ErpUserVo> getErpUserVoList(List<ErpUser> list){
		List<ErpUserVo> uList = new ArrayList<ErpUserVo>();
		
		for(ErpUser u:list){
			ErpUserVo euv = new ErpUserVo();
			
			euv.setId(u.getId());
			euv.setName(u.getName());
			euv.setAge(u.getAge());
			euv.setId_card(u.getId_card());
			euv.setDept_id(u.getDept_id());
			euv.setPhone(u.getPhone());
			euv.setEmail(u.getEmail());
			euv.setRemarks(u.getRemarks());
			euv.setJob_id(u.getJob_id());
			
			euv.setSexVo(CodeUtil.getValue(u.getSex(), "SEX"));
			
			ErpDept erpd = erpDeptMapper.getById(u.getDept_id());
			euv.setDept_name(erpd.getName());
			
			ErpJob erpj = erpJobMapper.getById(u.getJob_id());
			euv.setJob_name(erpj.getJob_name());
			
			uList.add(euv);
		}
		return uList;
	}
	
	public static ErpAccountVo getAccountVo(ErpAccount a){
		
		ErpAccountVo av = new ErpAccountVo();
		String user_id = a.getUser_id();
		
		av.setId(a.getId());
		av.setUsername(a.getUsername());
		av.setPassword(a.getPassword());
		av.setuType(a.getuType());
		av.setCreate_time(a.getCreate_time());
		av.setLast_login_time(a.getLast_login_time());
		av.setUser_id(a.getUser_id());
		
		ErpCode ecode = erpCodeMapper.getByKeyAndType(a.getuType(), "UTYPE");
		av.setuTypeVo(ecode.getValue());
		
		if(user_id!=null){
		ErpUser eu = erpUserMapper.getById(a.getUser_id());
			if(eu!=null){
				av.setName(eu.getName());
				av.setSex(eu.getSex());
				av.setAge(eu.getAge());
				av.setId_card(eu.getId_card());
				av.setDept_id(eu.getDept_id());
				av.setPhone(eu.getPhone());
				av.setEmail(eu.getEmail());
				av.setRemarks(eu.getRemarks());
				av.setJob_id(eu.getJob_id());
				
				av.setSexVo(CodeUtil.getValue(eu.getSex(), "SEX"));
		
		
			}
	
		}
		return av;
	}
	
}
