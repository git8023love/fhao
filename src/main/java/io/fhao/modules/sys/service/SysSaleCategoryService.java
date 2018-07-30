package io.fhao.modules.sys.service;

import java.util.List;
import java.util.Map;

import io.fhao.modules.sys.entity.SysSaleCategory;

/**
 * @author hgw
 * @Description: TODO(商品分类)
 * @date 2018-07-25 19:32:52
 */
public interface SysSaleCategoryService {
	
	SysSaleCategory queryObject(Long id);
	
	List<SysSaleCategory> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysSaleCategory saleGategory);
	
	void update(SysSaleCategory saleGategory);
	
	void delete(Long id);
	
	void deleteBatch(Long categoryId);

	List<Long> querySaleCategoryList(Long parentId);

	String getSaleCategoryIdList(Long categoryId);

}
