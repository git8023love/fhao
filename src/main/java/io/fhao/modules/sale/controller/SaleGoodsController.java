package io.fhao.modules.sale.controller;

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
import io.fhao.modules.sale.entity.SaleGoods;
import io.fhao.modules.sale.service.SaleGoodsService;

/**
 * @author hgw
 * @Description: TODO(商品表)
 * @date 2018-07-25 18:23:30
 */
@RestController
@RequestMapping("/sale/salegoods")
public class SaleGoodsController extends AbstractController {

	@Autowired
	private SaleGoodsService saleGoodsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sale:saleGoods:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SaleGoods> saleGoodsList = saleGoodsService.queryList(query);
		int total = saleGoodsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(saleGoodsList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sale:saleGoods:info")
	public Result info(@PathVariable("id") Long id){
		SaleGoods saleGoods = saleGoodsService.queryObject(id);
		
		return Result.ok().put("saleGoods", saleGoods);
	}
	
	/**
	 * 保存
	 */
	@SysLog("保存商品")
	@RequestMapping("/save")
	@RequiresPermissions("sale:saleGoods:save")
	public Result save(@RequestBody SaleGoods saleGoods){
		saleGoodsService.save(saleGoods);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@SysLog("修改商品")
	@RequestMapping("/update")
	@RequiresPermissions("sale:saleGoods:update")
	public Result update(@RequestBody SaleGoods saleGoods){
		saleGoodsService.update(saleGoods);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@SysLog("删除商品")
	@RequestMapping("/delete")
	@RequiresPermissions("sale:saleGoods:delete")
	public Result delete(@RequestBody Long[] ids){
		saleGoodsService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
