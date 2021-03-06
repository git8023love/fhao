package io.fhao.modules.sale.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.fhao.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.fhao.common.annotation.SysLog;
import io.fhao.common.utils.PageUtils;
import io.fhao.common.utils.Query;
import io.fhao.common.utils.Result;
import io.fhao.modules.sale.entity.SaleSupply;
import io.fhao.modules.sale.service.SaleSupplyService;

/**
 * @author hgw
 * @Description: TODO(供应商)
 * @date 2018-07-26 15:18:24
 */
@RestController
@RequestMapping("/sale/salesupply")
public class SaleSupplyController extends AbstractController {

	@Autowired
	private SaleSupplyService saleSupplyService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sale:saleSupply:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SaleSupply> saleSupplyList = saleSupplyService.queryList(query);
		int total = saleSupplyService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(saleSupplyList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sale:saleSupply:info")
	public Result info(@PathVariable("id") Long id){
		SaleSupply saleSupply = saleSupplyService.queryObject(id);
		
		return Result.ok().put("saleSupply", saleSupply);
	}
	
	/**
	 * 保存
	 */
	@SysLog("保存供应商")
	@RequestMapping("/save")
	@RequiresPermissions("sys:saleSupply:save")
	public Result save(@RequestBody SaleSupply saleSupply){
		saleSupplyService.save(saleSupply);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@SysLog("修改供应商")
	@RequestMapping("/update")
	@RequiresPermissions("sale:saleSupply:update")
	public Result update(@RequestBody SaleSupply saleSupply){
		saleSupplyService.update(saleSupply);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@SysLog("删除供应商")
	@RequestMapping("/delete")
	@RequiresPermissions("sale:saleSupply:delete")
	public Result delete(@RequestBody Long[] ids){
		saleSupplyService.deleteBatch(ids);
		
		return Result.ok();
	}
	
	/**
	 * 选择供应商
	 */
	@RequestMapping("/select")
	@RequiresPermissions("sale/saleSupply:select")
	public Result select(){
		Map<String, Object> map = new HashMap<>();
		List<SaleSupply> saleSupplysList = saleSupplyService.queryList(map);
		return Result.ok().put("saleSupplysList", saleSupplysList);
	}
	
}
