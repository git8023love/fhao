package io.fhao.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import io.fhao.modules.sys.dao.BaseDao;
import io.fhao.modules.sys.entity.SysSaleCategory;

@Mapper
public interface SysSaleCategoryDao extends BaseDao<SysSaleCategory> {

	List<Long> querySaleCategoryList(Long parentId);
	
}
