package io.fhao.modules.sale.service;

import java.util.List;
import java.util.Map;

import io.fhao.modules.sale.entity.SaleCategory;

/**
 * @author hgw
 * @Description: TODO(商品分类)
 * @date 2018-07-25 19:32:52
 */
public interface SaleCategoryService {
	
	SaleCategory queryObject(Long id);
	
	List<SaleCategory> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SaleCategory saleGategory);
	
	void update(SaleCategory saleGategory);
	
	void delete(Long id);
	
	void deleteBatch(Long categoryId);

	List<Long> querySaleCategoryList(Long parentId);

	String getSaleCategoryIdList(Long categoryId);

}
