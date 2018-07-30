package io.fhao.modules.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import io.fhao.modules.sys.entity.SysDept;
import io.fhao.modules.sys.entity.SysSaleCategory;
import io.fhao.modules.sys.service.SysSaleCategoryService;

/**
 * @author hgw
 * @Description: TODO(商品分类)
 * @date 2018-07-25 19:32:52
 */
@RestController
@RequestMapping("/sys/saleCategory")
public class SysSaleCategoryController extends AbstractController{

	@Autowired
	private SysSaleCategoryService saleCategoryService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:saleCategory:list")
	/*public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SysSaleCategory> saleCategoryList = saleCategoryService.queryList(query);
		int total = saleCategoryService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(saleCategoryList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}*/
	public List<SysSaleCategory> list(){
		Map<String, Object> map = new HashMap<>();
		List<SysSaleCategory> saleCategoryList = saleCategoryService.queryList(map);
		return saleCategoryList;
	}
	/**
	 * 上级分类Id(管理员则为0)
	 */
	@RequestMapping("/info")
	@RequiresPermissions("sys:saleCategory:list")
	public Result info(){
		long categoryId = 0;
		return Result.ok().put("categoryId", categoryId);
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:saleCategory:info")
	public Result info(@PathVariable("id") Long id){
		SysSaleCategory saleCategory = saleCategoryService.queryObject(id);
		
		return Result.ok().put("saleCategory", saleCategory);
	}
	
	/**
	 * 保存
	 */
	@SysLog("保存类别")
	@RequestMapping("/save")
	@RequiresPermissions("sys:saleCategory:save")
	public Result save(@RequestBody SysSaleCategory saleCategory){
		saleCategoryService.save(saleCategory);
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@SysLog("修改类别")
	@RequestMapping("/update")
	@RequiresPermissions("sys:saleCategory:update")
	public Result update(@RequestBody SysSaleCategory saleCategory){
		saleCategoryService.update(saleCategory);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@SysLog("删除类别")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:saleCategory:delete")
	public Result delete(Long categoryId){
		saleCategoryService.deleteBatch(categoryId);
		
		return Result.ok();
	}
	
	/**
	 * 选择分类(添加、修改菜单)
	 */
	@RequestMapping("/select")
	@RequiresPermissions("sys:saleCategory:select")
	public Result select(){
		Map<String, Object> map = new HashMap<>();
		List<SysSaleCategory> saleCategoriesList = saleCategoryService.queryList(map);

		//添加一级分类
		SysSaleCategory root = new SysSaleCategory();
		root.setId(0L);
		root.setName("一级分类");
		root.setParentId(-1L);
		root.setOpen(true);
		saleCategoriesList.add(root);

		return Result.ok().put("saleCategoriesList", saleCategoriesList);
	}
	
}
