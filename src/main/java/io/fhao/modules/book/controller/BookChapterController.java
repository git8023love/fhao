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
import io.fhao.modules.book.entity.BookChapter;
import io.fhao.modules.book.service.BookChapterService;
import io.fhao.common.utils.PageUtils;
import io.fhao.common.utils.Query;
import io.fhao.common.utils.Result;

/**
 * @author hgw
 * @Description: TODO(章节表)
 * @date 2018-08-08 14:04:23
 */
@RestController
@RequestMapping("/book/bookchapter")
public class BookChapterController extends AbstractController {

	@Autowired
	private BookChapterService bookChapterService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("book:bookChapter:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<BookChapter> bookChapterList = bookChapterService.queryList(query);
		int total = bookChapterService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(bookChapterList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("book:bookChapter:info")
	public Result info(@PathVariable("id") Long id){
		BookChapter bookChapter = bookChapterService.queryObject(id);
		
		return Result.ok().put("bookChapter", bookChapter);
	}
	
	/**
	 * 保存
	 */
	@SysLog("保存章节")
	@RequestMapping("/save")
	@RequiresPermissions("book:bookChapter:save")
	public Result save(@RequestBody BookChapter bookChapter){
		bookChapterService.save(bookChapter);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@SysLog("保存章节")
	@RequestMapping("/update")
	@RequiresPermissions("sys:bookChapter:update")
	public Result update(@RequestBody BookChapter bookChapter){
		bookChapterService.update(bookChapter);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@SysLog("保存章节")
	@RequestMapping("/delete")
	@RequiresPermissions("book:bookChapter:delete")
	public Result delete(@RequestBody Long[] ids){
		bookChapterService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
