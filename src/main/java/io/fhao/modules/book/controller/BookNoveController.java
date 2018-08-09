package io.fhao.modules.book.controller;

import java.util.List;
import java.util.Map;

import io.fhao.common.annotation.SysLog;
import io.fhao.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.fhao.modules.book.entity.BookNove;
import io.fhao.modules.book.service.BookNoveService;
import io.fhao.common.utils.PageUtils;
import io.fhao.common.utils.Query;
import io.fhao.common.utils.Result;

/**
 * @author hgw
 * @Description: TODO(目录信息表)
 * @date 2018-08-08 14:04:23
 */
@RestController
@RequestMapping("/book/booknove")
public class BookNoveController extends AbstractController {

	@Autowired
	private BookNoveService bookNoveService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("book:bookNove:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<BookNove> bookNoveList = bookNoveService.queryList(query);
		int total = bookNoveService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(bookNoveList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("book:bookNove:info")
	public Result info(@PathVariable("id") Long id){
		BookNove bookNove = bookNoveService.queryObject(id);
		
		return Result.ok().put("bookNove", bookNove);
	}
	
	/**
	 * 保存
	 */
	@SysLog("保存目录信息")
	@RequestMapping("/save")
	@RequiresPermissions("book:bookNove:save")
	public Result save(@RequestBody BookNove bookNove){
		bookNoveService.save(bookNove);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@SysLog("修改目录信息")
	@RequestMapping("/update")
	@RequiresPermissions("book:bookNove:update")
	public Result update(@RequestBody BookNove bookNove){
		bookNoveService.update(bookNove);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@SysLog("删除目录信息")
	@RequestMapping("/delete")
	@RequiresPermissions("book:bookNove:delete")
	public Result delete(@RequestBody Long[] ids){
		bookNoveService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
