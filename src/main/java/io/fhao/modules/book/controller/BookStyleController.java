package io.fhao.modules.book.controller;

import java.util.HashMap;
import java.util.List;

import io.fhao.common.annotation.SysLog;
import io.fhao.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.fhao.modules.book.entity.BookStyle;
import io.fhao.modules.book.service.BookStyleService;
import io.fhao.common.utils.Result;

/**
 * @author hgw
 * @Description: TODO(小说分类表)
 * @date 2018-08-08 14:04:23
 */
@RestController
@RequestMapping("/book/bookstyle")
public class BookStyleController extends AbstractController {

	@Autowired
	private BookStyleService bookStyleService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("book:bookStyle:list")
	public List<BookStyle> list(){
		List<BookStyle> bookStyleList = bookStyleService.queryList(new HashMap<String, Object>());
		return bookStyleList;
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("book:bookStyle:info")
	public Result info(@PathVariable("id") Long id){
		BookStyle bookStyle = bookStyleService.queryObject(id);
		
		return Result.ok().put("bookStyle", bookStyle);
	}
	
	/**
	 * 保存
	 */
	@SysLog("保存小说分类")
	@RequestMapping("/save")
	@RequiresPermissions("book:bookStyle:save")
	public Result save(@RequestBody BookStyle bookStyle){
		bookStyleService.save(bookStyle);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@SysLog("修改小说分类")
	@RequestMapping("/update")
	@RequiresPermissions("book:bookStyle:update")
	public Result update(@RequestBody BookStyle bookStyle){
		bookStyleService.update(bookStyle);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@SysLog("删除小说分类")
	@RequestMapping("/delete")
	@RequiresPermissions("book:bookStyle:delete")
	public Result delete(@RequestBody Long[] ids){
		bookStyleService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
