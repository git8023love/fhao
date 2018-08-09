package io.fhao.modules.sale.dao;

import io.fhao.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import io.fhao.modules.sale.entity.SaleSupply;

@Mapper
public interface SaleSupplyDao extends BaseDao<SaleSupply> {
	
}
