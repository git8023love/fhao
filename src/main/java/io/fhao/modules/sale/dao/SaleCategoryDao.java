package io.fhao.modules.sale.dao;

import java.util.List;

import io.fhao.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import io.fhao.modules.sale.entity.SaleCategory;

@Mapper
public interface SaleCategoryDao extends BaseDao<SaleCategory> {

	List<Long> querySaleCategoryList(Long parentId);
	
}
