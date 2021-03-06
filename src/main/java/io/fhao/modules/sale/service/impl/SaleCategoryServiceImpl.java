package io.fhao.modules.sale.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiniu.util.StringUtils;

import io.fhao.modules.sale.dao.SaleCategoryDao;
import io.fhao.modules.sale.entity.SaleCategory;
import io.fhao.modules.sale.service.SaleCategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("saleGategoryService")
public class SaleCategoryServiceImpl implements SaleCategoryService {

	@Autowired
	private SaleCategoryDao saleCategoryDao;
	
	@Override
	public SaleCategory queryObject(Long id){
		return saleCategoryDao.queryObject(id);
	}
	
	@Override
	public List<SaleCategory> queryList(Map<String, Object> map){
		return saleCategoryDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return saleCategoryDao.queryTotal(map);
	}
	
	@Override
	public void save(SaleCategory saleGategory){
		saleCategoryDao.save(saleGategory);
	}
	
	@Override
	public void update(SaleCategory saleGategory){
		saleCategoryDao.update(saleGategory);
	}
	
	@Override
	public void delete(Long id){
		saleCategoryDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long categoryId){
		//saleCategoryDao.deleteBatch(categoryId);
	}
	
	@Override
	public List<Long> querySaleCategoryList(Long parentId) {
		return saleCategoryDao.querySaleCategoryList(parentId);
	}
	
	@Override
	public String getSaleCategoryIdList(Long categoryId){
		//部门及子部门ID列表
		List<Long> saleCategoryIdList = new ArrayList<>();

		//获取子部门ID
		List<Long> subIdList = querySaleCategoryList(categoryId);
		getSaleCategotyTreeList(subIdList, saleCategoryIdList);

		//添加本部门
		saleCategoryIdList.add(categoryId);

		String deptFilter = StringUtils.join(saleCategoryIdList, ",");
		return deptFilter;
	}

	/**
	 * 递归
	 */
	public void getSaleCategotyTreeList(List<Long> subIdList, List<Long> saleCategoryIdList){
		for(Long categoryId : subIdList){
			List<Long> list = querySaleCategoryList(categoryId);
			if(list.size() > 0){
				getSaleCategotyTreeList(list, saleCategoryIdList);
			}

			saleCategoryIdList.add(categoryId);
		}
	}
	
}
